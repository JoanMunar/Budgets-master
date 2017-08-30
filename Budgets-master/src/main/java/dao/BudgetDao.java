package dao;
import pojo.Budget;
import pojo.Budget_line;
import pojo.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface BudgetDao {

    void createBudget(String id,String name, String units, Double price) throws SQLException;
    void deleteBudget(String id) throws SQLException;
    //List<Budget_line> budgetLine() throws SQLException;
    User getUser(String user) throws SQLException;
    List<Budget> budget(int userCode) throws SQLException;
    Date getDate(int userCode) throws SQLException;
}
