package ui;

import javax.swing.*;


import service.UserService;
import model.User;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private UserService userService;

    public RegisterFrame() {
        setTitle("Register");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        userService = new UserService();

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        panel.add(confirmPasswordField);

        JButton registerButton = new JButton("Register");
        panel.add(registerButton);

        JButton cancelButton = new JButton("Cancel");
        panel.add(cancelButton);

        add(panel);

        registerButton.addActionListener(e -> register());
        cancelButton.addActionListener(e -> dispose());
    }

    private void register() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        User user = new User(username, password);
        boolean success = userService.registerUser(user);
        if (success) {
            JOptionPane.showMessageDialog(this, "Registration successful! You can now log in.");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegisterFrame frame = new RegisterFrame();
            frame.setVisible(true);
        });
    }
}
