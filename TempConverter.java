import java.text.DecimalFormat;
import javax.swing.*;

public class TempConverter extends JFrame {
    private JTextField fahrenheitInputField;
    private JTextField celsiusOutputField;

    public TempConverter() {
        setTitle("Fahrenheit to Celsius Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        fahrenheitInputField = new JTextField(20);
        fahrenheitInputField.setMaximumSize(fahrenheitInputField.getPreferredSize()); 
        
        JLabel celsiusLabel = new JLabel("Celsius:");
        celsiusOutputField = new JTextField(20);
        celsiusOutputField.setMaximumSize(celsiusOutputField.getPreferredSize()); 
        celsiusOutputField.setEditable(false);
        
        JButton convertButton = new JButton("Convert");
        convertButton.setAlignmentX(LEFT_ALIGNMENT);
        
        convertButton.addActionListener(e -> convertTemperature());
        
        mainPanel.add(fahrenheitLabel);
        mainPanel.add(fahrenheitInputField);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(celsiusLabel);
        mainPanel.add(celsiusOutputField);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(convertButton);
        
        add(mainPanel);
        
        setLocationRelativeTo(null);
    }
    
    private void convertTemperature() {
        try {
            double fahrenheitValue = Double.parseDouble(fahrenheitInputField.getText());
            double celsiusValue = (fahrenheitValue - 32) * 5 / 9;
            celsiusOutputField.setText(new DecimalFormat("#0.0").format(celsiusValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid temperature in Fahrenheit.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TempConverter().setVisible(true));
    }
}