// WordCountApp.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountApp extends JFrame {

    private JTextArea textArea;
    private JLabel resultLabel;

    public WordCountApp() {
        super("Word Count Application");

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create components
        textArea = new JTextArea();
        JButton countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word count will be displayed here.");

        // Set layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Add components to the frame
        add(new JScrollPane(textArea));
        add(countButton);
        add(resultLabel);

        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
    }

    private void countWords() {
        String text = textArea.getText();
        String[] words = text.split("\\s+"); // Split by whitespace

        int wordCount = words.length;
        resultLabel.setText("Word count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCountApp().setVisible(true);
            }
        });
    }
}
