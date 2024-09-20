package guiTest;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class Main {

    // The folder where files will be saved
    public String folderPath = System.getProperty("user.dir") + File.separator + "outputs";

    JTextArea textArea = null;

    public Main() {
        // Initialize JTextArea for writing content
        textArea = new JTextArea();
    }

    // Create the output folder if it doesn't exist
    public boolean createOutputFolder() {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            return folder.mkdirs();
        }
        return true;
    }

    // Method to create a file in the "outputs" folder
    public boolean createFile(String fileName) {
        createOutputFolder(); // Ensure the folder exists

        File newFile = new File(folderPath + File.separator + fileName);
        try {
            if (newFile.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to write text to the file
    public void writeToFile(String fileName, String text) {
        if (createFile(fileName)) {
            try (FileWriter writer = new FileWriter(folderPath + File.separator + fileName)) {
                writer.write(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists or cannot be created.");
        }
    }

    public static void main(String[] args) {
        // Create the main JFrame
        JFrame jframe = new JFrame("GUI Screen");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(600, 400);

        // Create the main panel
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Please Enter File Name:");
        JTextField textField = new JTextField(20); // Field for file name input
        JLabel contentLabel = new JLabel("Please Enter Content:");
        JTextArea textArea = new JTextArea(10, 40); // Area for file content input

        JButton sendButton = new JButton("Save File");
        JButton resetButton = new JButton("Reset");

        Main te = new Main();

        // Add action to the "Save File" button
        sendButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String fileName = textField.getText(); // Get file name from the textField
                String fileContent = textArea.getText(); // Get content from the textArea
                if (!fileName.isEmpty()) {
                    te.writeToFile(fileName + ".txt", fileContent); // Save file with provided name
                } else {
                    JOptionPane.showMessageDialog(jframe, "Please enter a valid file name.");
                }
            }
        });

        // Add action to the "Reset" button to clear fields
        resetButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                textField.setText("");
                textArea.setText("");
            }
        });

        // Add components to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(contentLabel);
        panel.add(new JScrollPane(textArea)); // Add scroll to textArea
        panel.add(sendButton);
        panel.add(resetButton);
        
        // Add components to the JFrame
        jframe.getContentPane().add(BorderLayout.CENTER, panel);

        // Make the JFrame visible
        jframe.setVisible(true);
    }
}
