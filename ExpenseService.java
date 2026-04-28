package service;

import dao.ExpenseDAO;
import model.Expense;
import java.util.List;

public class ExpenseService {
    private ExpenseDAO expenseDAO;

    public ExpenseService() {
        this.expenseDAO = new ExpenseDAO();
    }

    public boolean addExpense(Expense expense) {
        return expenseDAO.insertExpense(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseDAO.getAllExpenses();
    }

    public boolean updateExpense(Expense expense) {
        return expenseDAO.updateExpense(expense);
    }

    public boolean deleteExpense(String name) {
        return expenseDAO.deleteExpense(name);
    }
}
