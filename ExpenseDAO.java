package dao;

import model.Expense;
import util.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class ExpenseDAO {
    public boolean insertExpense(Expense expense) {
        String sql = "INSERT INTO expenses (name, amount, date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, expense.getName());
            stmt.setDouble(2, expense.getAmount());
            stmt.setString(3, expense.getDate());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                expenses.add(new Expense(
                    rs.getString("name"),
                    rs.getDouble("amount"),
                    rs.getString("date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public boolean updateExpense(Expense expense) {
        String sql = "UPDATE expenses SET amount=?, date=? WHERE name=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, expense.getAmount());
            stmt.setString(2, expense.getDate());
            stmt.setString(3, expense.getName());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteExpense(String name) {
        String sql = "DELETE FROM expenses WHERE name=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
