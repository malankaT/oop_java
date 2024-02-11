/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheets10;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Malanka Tharula
 */
class NewInterface2 extends JFrame  {
private JTextArea textArea;

    public NewInterface2() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Student Names");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

            // Set background color for the content pane
        getContentPane().setBackground(new Color(204, 51, 255));
        
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);

        textArea.setEditable(false);
          textArea.setBackground(new Color(126, 18, 126));
        textArea.setForeground(Color.BLACK); 
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new NewInterface2().setVisible(true);
        });
    }
}
