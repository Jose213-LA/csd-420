// Name: Jose Flores
// Date: 10/5/2025
// Assignment: M-10
/* Purpose: This program lets you see and change fan information 
            saved in a database using buttons and text boxes.*/

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FanDatabaseApp extends JFrame {

    // GUI Components
    private JTextField idField, firstnameField, lastnameField, teamField;
    private JButton displayButton, updateButton;

    // Database credentials
    private final String DB_URL = "jdbc:postgresql://localhost:5432/databasedb";
    private final String DB_USER = "student1";
    private final String DB_PASS = "pass";

    public FanDatabaseApp() {
        setTitle("Fan Database Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLayout(null);

        // Labels and Fields
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 20, 100, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 20, 200, 25);
        add(idField);

        JLabel firstnameLabel = new JLabel("First Name:");
        firstnameLabel.setBounds(20, 60, 100, 25);
        add(firstnameLabel);

        firstnameField = new JTextField();
        firstnameField.setBounds(120, 60, 200, 25);
        add(firstnameField);

        JLabel lastnameLabel = new JLabel("Last Name:");
        lastnameLabel.setBounds(20, 100, 100, 25);
        add(lastnameLabel);

        lastnameField = new JTextField();
        lastnameField.setBounds(120, 100, 200, 25);
        add(lastnameField);

        JLabel teamLabel = new JLabel("Favorite Team:");
        teamLabel.setBounds(20, 140, 100, 25);
        add(teamLabel);

        teamField = new JTextField();
        teamField.setBounds(120, 140, 200, 25);
        add(teamField);

        // Buttons
        displayButton = new JButton("Display");
        displayButton.setBounds(50, 180, 120, 30);
        add(displayButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(200, 180, 120, 30);
        add(updateButton);

        // Action Listeners
        displayButton.addActionListener(e -> displayFan());
        updateButton.addActionListener(e -> updateFan());

        setVisible(true);
    }

    private void displayFan() {
        String idText = idField.getText().trim();

        if (!idText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "ID must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "SELECT firstname, lastname, favoriteteam FROM fans WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(idText));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                firstnameField.setText(rs.getString("firstname"));
                lastnameField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "Fan not found.", "Not Found", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error accessing database:\n" + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateFan() {
        String idText = idField.getText().trim();
        String firstname = firstnameField.getText().trim();
        String lastname = lastnameField.getText().trim();
        String team = teamField.getText().trim();

        if (!idText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "ID must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, team);
            stmt.setInt(4, Integer.parseInt(idText));

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Record updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No record found to update.", "Update Failed", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating database:\n" + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Ensure PostgreSQL driver is loaded
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "PostgreSQL JDBC Driver not found. Include it in your library path.", "Driver Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Launch app
        SwingUtilities.invokeLater(FanDatabaseApp::new);
    }
}