package ui;

import javax.swing.*;


import java.awt.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame() {
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel panel = new JPanel(new GridLayout(2, 2, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JButton addExpenseButton = new JButton("Add Expense");
        JButton viewExpensesButton = new JButton("View Expenses");
        JButton reportButton = new JButton("Report");
        JButton logoutButton = new JButton("Logout");

        panel.add(addExpenseButton);
        panel.add(viewExpensesButton);
        panel.add(reportButton);
        panel.add(logoutButton);

        add(panel);

        addExpenseButton.addActionListener(e -> new AddExpenseFrame().setVisible(true));
        viewExpensesButton.addActionListener(e -> new ViewExpenseFrame().setVisible(true));
        reportButton.addActionListener(e -> new ReportFrame().setVisible(true));
        logoutButton.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DashboardFrame frame = new DashboardFrame();
            frame.setVisible(true);
        });
    }
}
