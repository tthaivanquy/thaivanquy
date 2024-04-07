package baitap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextView {
    private JFrame frame;
    private JTextArea textArea;
    private TextEditorController controller;

    public TextView(TextEditorController controller) {
        this.controller = controller;
    }

    public void display() {
        frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mở file
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    controller.loadFile(filePath);
                    updateTextArea();
                }
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lưu file
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showSaveDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    controller.saveFile(filePath);
                }
            }
        });

        JButton removeEmptyLinesButton = new JButton("Remove Empty Lines");
        removeEmptyLinesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.removeEmptyLines();
                updateTextArea();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(removeEmptyLinesButton);

        frame.getContentPane().add(BorderLayout.NORTH, buttonPanel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        frame.setVisible(true);
    }

    private void updateTextArea() {
        textArea.setText("");
        for (String line : controller.getDocument().getLines()) {
            textArea.append(line + "\n");
        }
    }
}