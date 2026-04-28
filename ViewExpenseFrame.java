package ui;

import javax.swing.*;


import service.ExpenseService;
import model.Expense;
import java.util.List;

public class ViewExpenseFrame extends JFrame {
    private ExpenseService expenseService;

    public ViewExpenseFrame() {
        setTitle("View Expenses");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        expenseService = new ExpenseService();

        List<Expense> expenses = expenseService.getAllExpenses();
        String[] columnNames = {"Name", "Amount", "Date"};
        String[][] data = new String[expenses.size()][3];
        for (int i = 0; i < expenses.size(); i++) {
            Expense exp = expenses.get(i);
            data[i][0] = exp.getName();
            data[i][1] = String.valueOf(exp.getAmount());
            data[i][2] = exp.getDate();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewExpenseFrame frame = new ViewExpenseFrame();
            frame.setVisible(true);
        });
    }
}
