import java.sql.Connection;

import ui.LoginFrame;
import util.DatabaseConnection;

public class Main
{
  public static void main(String[] args) 
  {
    try {
      javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    new DatabaseConnection(); // Initialize the connection
    new LoginFrame().setVisible(true);
    try 
    {
      Connection conn = DatabaseConnection.getConnection();
      System.out.println("DB connected: " + (conn != null && !conn.isClosed()));
      System.out.println("connected");
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}