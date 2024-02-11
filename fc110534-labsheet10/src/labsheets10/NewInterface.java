/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheets10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewInterface extends JFrame {

    private JTextField indexTextField;
    private final JTextArea textArea;

    public NewInterface() {
        setTitle("New Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(59, 4, 45));

        // Create the text field
        indexTextField = new JTextField(10); // Set the size of the text field

        // Create a JLabel for the text "Enter Index Number:"
        JLabel label = new JLabel("Enter Index Number: ");

        // Set the font style of the label to bold
        label.setFont(label.getFont().deriveFont(Font.BOLD));

        // Set the foreground color (text color) of the label to white
        label.setForeground(Color.WHITE);

        JButton enterButton = new JButton("Enter");
        enterButton.setFont(enterButton.getFont().deriveFont(Font.BOLD));
        enterButton.setBackground(new Color(204, 0, 204));

        // Create a JTextArea
        textArea = new JTextArea(10, 30); // 10 rows, 30 columns

        // Add components to the panel
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(label);
        topPanel.add(indexTextField);
        topPanel.add(enterButton);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Add action listener to the enter button
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the index number entered by the user
                String indexNoStr = indexTextField.getText();
                try {
                    // Convert index number to integer
                    int indexNo = Integer.parseInt(indexNoStr);

                    // Retrieve student details from the database based on the index number
                    String query = "SELECT * FROM Students WHERE index_no = ?";
                    try (Connection conn = Connect.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(query)) {
                        pstmt.setInt(1, indexNo);
                        ResultSet rs = pstmt.executeQuery();

                        // Clear text area before displaying new data
                        textArea.setText("");

                        // Display student details in the text area
                        while (rs.next()) {
                            String details = "Index Number: " + rs.getInt("index_no") +
                                    "\nName: " + rs.getString("name") +
                                    "\nSubject 1: " + rs.getString("subject1") +
                                    "\nSubject 2: " + rs.getString("subject2") +
                                    "\nSubject 3: " + rs.getString("subject3") +
                                    "\nGPA: " + rs.getDouble("gpa") + "\n";
                            textArea.append(details);
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error retrieving student details: " + ex.getMessage());
                    }
                } catch (NumberFormatException ex) {
                    // Handle invalid input for index number
                    JOptionPane.showMessageDialog(null, "Invalid input for index number. Please enter a valid integer.");
                }
            }
        });

        // Add the panel to the frame
        add(panel);

        setVisible(true);
    }
}
