package dao;


import com.mysql.jdbc.PreparedStatement;
import dbc.ConnectionFactory;
import pojo.Budget;
import pojo.Budget_line;
import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BudgetDaoImplements implements BudgetDao{

    private ConnectionFactory dbc;


    public void createBudget( String id, String name, String units, Double price) throws SQLException {

        String sql = "INSERT into pfinal.budget VALUES(?,?)";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ps.setString(2, name);
        ps.setString(3,units);
        ps.setString(4, String.valueOf(price));

        ps.execute();

        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
    }
    public void deleteBudget(String name) throws SQLException {

        String sql = "DELETE FROM pfinal.budget WHERE name=?";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ps.execute();

        sql = "DELETE FROM pfinal.budget WHERE name = ?";
        ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ps.execute();

        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }

    }


/*    public List<Budget_line> budgetLine() throws SQLException {

        String sql = "SELECT * FROM pfinal.budget_line";
        List<Budget_line> budgetLines = new ArrayList<Budget_line>();
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int budgetId = rs.getInt("budget_line.code");
            String budgetName = rs.getString("budget_line.name");
            double budgetUnits = rs.getDouble("budget_line.units");
            double budgetPrice = rs.getDouble("budget_line.price");

            Budget_line budget = new Budget_line(budgetId, budgetName,budgetUnits, budgetPrice);
            budgetLines.add(budget);

        }
        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            *//* Ignore *//*
            }
        }
        return budgetLines;

    }*/

    public User getUser(String user) throws SQLException {
        String sql = "SELECT * FROM pfinal.user where user='" + user +"'";

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        if (rs.next() ) {

            int id = rs.getInt("user.id_user");
            String username = rs.getString("user.user");
            String pass = rs.getString("user.password");
            String phone = rs.getString("user.phone");

            User usuari = new User(id,username,pass,phone);


            return usuari;
        }
        return null;
    }



    public List<Budget> budget(int userCode) throws SQLException {
        String sql = "SELECT id_budget FROM pfinal.budget,pfinal.user WHERE budget.id_user=user.id_user and user.id_user=?";
        List<Budget> budgetList = new ArrayList<Budget>();

        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setInt(1,userCode);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int budgetCode = rs.getInt("budget.id_budget");

            Budget budget = new Budget(budgetCode);
            budgetList.add(budget);

        }
        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
        return budgetList;
    }

    public Date getDate(int id_budget) throws SQLException {
        String sql = "SELECT * FROM pfinal.budget WHERE budget.id_budget=?";
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setInt(1,id_budget);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            Date budgetDate = rs.getDate("budget.date");

            return budgetDate;
        }
        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
        return null;
    }


    public List<Budget_line> budgetLineId(int id_budget) throws SQLException {
        String sql = "SELECT * FROM pfinal.budget_line WHERE budget_line.id_budget=?";
        List<Budget_line> budgetLine = new ArrayList<Budget_line>();
        PreparedStatement ps = (PreparedStatement) dbc.getConnection().prepareStatement(sql);
        ps.setInt(1,id_budget);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int budgetCode = rs.getInt("budget_line.code");
            String budgetName = rs.getString("budget_line.name");
            double budgetUnits = rs.getDouble("budget_line.units");
            double budgetPrice = rs.getDouble("budget_line.price");
            int budgetId = rs.getInt("budget_line.id_budget");

            Budget_line budget_line = new Budget_line(budgetCode, budgetName,budgetUnits, budgetPrice, budgetId);
            budgetLine.add(budget_line);

        }
        if (dbc != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            /* Ignore */
            }
        }
        return budgetLine;
    }


    public void setDbc(ConnectionFactory dbc) {
        this.dbc = dbc;
    }

}

