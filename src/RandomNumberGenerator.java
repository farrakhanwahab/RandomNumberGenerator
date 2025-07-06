import java.awt.*;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

public class RandomNumberGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final Set<String> generatedNumbers = new HashSet<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RandomNumberGenerator::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Random Number Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new BorderLayout());

        JLabel resultLabel = new JLabel("Select a number system to generate a 6-digit random number.", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        frame.add(resultLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton binaryButton = new JButton("Binary");
        JButton octalButton = new JButton("Octal");
        JButton hexButton = new JButton("Hexadecimal");

        buttonPanel.add(binaryButton);
        buttonPanel.add(octalButton);
        buttonPanel.add(hexButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        binaryButton.addActionListener(e -> {
            String number = generateRandom("binary");
            resultLabel.setText("Binary: " + number);
        });
        octalButton.addActionListener(e -> {
            String number = generateRandom("octal");
            resultLabel.setText("Octal: " + number);
        });
        hexButton.addActionListener(e -> {
            String number = generateRandom("hex");
            resultLabel.setText("Hexadecimal: " + number);
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static String generateRandom(String system) {
        String randomNumber = "";
        int maxAttempts = 1000;
        int attempts = 0;
        do {
            randomNumber = switch (system) {
                case "binary" -> String.format("%6s", Integer.toBinaryString(random.nextInt(64))).replace(' ', '0');
                case "octal"  -> String.format("%06o", random.nextInt(262144));
                case "hex"    -> String.format("%06X", random.nextInt(0x1000000));
                default       -> throw new IllegalArgumentException("Unknown system: " + system);
            };
            attempts++;
        } while (generatedNumbers.contains(system + ":" + randomNumber) && attempts < maxAttempts);

        if (attempts >= maxAttempts) {
            return "Unable to generate a unique number. Restart the program.";
        }
        generatedNumbers.add(system + ":" + randomNumber);
        return randomNumber;
    }
} 