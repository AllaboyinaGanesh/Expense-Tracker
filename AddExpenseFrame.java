package ui;

import javax.swing.*;


import service.ExpenseService;
import model.Expense;
import java.awt.*;

public class AddExpenseFrame extends JFrame {
    private JTextField nameField;
    private JTextField amountField;
    private JTextField dateField;
    private ExpenseService expenseService;

    public AddExpenseFrame() {
        setTitle("Add Expense");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        expenseService = new ExpenseService();

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        panel.add(amountField);

        panel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        panel.add(dateField);

        JButton addButton = new JButton("Add");
        panel.add(addButton);

        JButton cancelButton = new JButton("Cancel");
        panel.add(cancelButton);

        add(panel);

        addButton.addActionListener(e -> addExpense());
        cancelButton.addActionListener(e -> dispose());
    }

    private void addExpense() {
        String name = nameField.getText();
        String amountText = amountField.getText();
        String date = dateField.getText();
        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Expense expense = new Expense(name, amount, date);
        boolean success = expenseService.addExpense(expense);
        if (success) {
            JOptionPane.showMessageDialog(this, "Expense added successfully!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add expense.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddExpenseFrame frame = new AddExpenseFrame();
            frame.setVisible(true);
        });
    }
}
