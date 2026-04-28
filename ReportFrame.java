package ui;

import javax.swing.*;


import service.ExpenseService;
import model.Expense;

import java.awt.GridLayout;
import java.util.List;

public class ReportFrame extends JFrame {
    private ExpenseService expenseService;

    public ReportFrame() {
        setTitle("Report");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        expenseService = new ExpenseService();

        List<Expense> expenses = expenseService.getAllExpenses();
        double total = 0;
        for (Expense exp : expenses) {
            total += exp.getAmount();
        }

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.add(new JLabel("Total Expenses: " + total));
        panel.add(new JLabel("Number of Expenses: " + expenses.size()));
        JButton closeButton = new JButton("Close");
        panel.add(closeButton);
        closeButton.addActionListener(e -> dispose());
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReportFrame frame = new ReportFrame();
            frame.setVisible(true);
        });
    }
}
