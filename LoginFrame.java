package ui;

import javax.swing.*;


import service.UserService;
import model.User;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserService userService;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        userService = new UserService();

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        panel.add(registerButton);

        add(panel);

        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> openRegister());
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        User user = userService.loginUser(username, password);
        if (user != null) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            new DashboardFrame().setVisible(true); // Open dashboard only after successful login
            dispose(); // Close login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openRegister() {
        new RegisterFrame().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });
    }
}
