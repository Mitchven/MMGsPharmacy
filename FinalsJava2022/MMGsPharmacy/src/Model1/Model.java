
package Model1;

import Frames.*;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

 
public class Model {

    public boolean register(String user, String pass, int age) {
        JRegister r = new JRegister();
        boolean success = false;
        try {
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            stmt = con.createStatement();
            String sql = "INSERT INTO `account`(`username`, `password`, `age`) VALUES ('" + user + "','" + "','" + pass + "'," + age + ")";
            stmt.executeUpdate(sql);
            con.close();
            success = true;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(r, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public int login(String username, String password) {
        JLogin l = new JLogin();
        int success = 400;
        boolean loggedIn = false;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM `user` where username = '" + username + "' and password = '" + password + "'");

            if (rs1.next()) {
                loggedIn = true;
                return success = 500;
            } else {
                ResultSet rs = stmt.executeQuery("SELECT * FROM `user` where username = '" + username + "'");
                if (rs.next()) {
                    if (rs.getString("password").equals(password)) {
                        loggedIn = true;
                        return success = 600;
                    }
                }
            }
            if (loggedIn == false) {
                return success;
            }
            con.close();
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(l, "Error while connecting!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public boolean addMedicine(String name, String bname, String gname, String type, double price, int quantity) {
        JAdminAdd a = new JAdminAdd();
        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO `medicine`( `name`, `bname`, `gname`, `type`, `price`, `quantity`) VALUES ('" + name + "','" + bname + "','" + gname + "','" + type + "','" + price + "'," + quantity + ")";
            stmt.executeUpdate(sql);
            success = true;
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(a, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public boolean removeMedicine(int ID) {
        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/luciferpharmacy", "root", "");
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM `medicine` WHERE Id='" + ID + "'";
            stmt.executeUpdate(sql);
            success = true;
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }
        return success;
    }

    public boolean order(String uname, String id, int qty) {

        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicine` WHERE id=" + id);
            System.out.println("nakasulod");
            while (rs.next()) {
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                if (rs.getString("id").equals(id)) {
                    ResultSet rs1 = stmt.executeQuery("SELECT * FROM `account`");
                    while (rs1.next()) {
                        int age = rs1.getInt("age");
                        if (rs1.getString("username").equals(uname)) {
                            if (rs1.getString("id").equals(id)) {

                                if (quantity < qty) {
                                    JOptionPane.showMessageDialog(null, "Insufficient quantity!");
                                } else if (quantity == qty) {
                                    if (age >= 18 && age <= 59) {
                                        System.out.println(age);
                                        System.out.println(" equal then " + (qty * price));
                                        JOptionPane.showMessageDialog(null, "The amount is: " + (qty * price));
                                        String sql = "DELETE FROM `medicine` WHERE id='" + id + "'";
                                        stmt.addBatch(sql);
                                        stmt.executeBatch();
                                        con.close();
                                        return success = true;
                                    } else {
                                        System.out.println(age);
                                        System.out.println(" equal then senior " + ((qty * price) * .80));
                                        JOptionPane.showMessageDialog(null, "The amount is: " + ((qty * price) * .80));
                                        String sql = "DELETE FROM `medicine` WHERE id='" + id + "'";
                                        stmt.addBatch(sql);
                                        stmt.executeBatch();
                                        con.close();
                                        return success = true;
                                    }
                                }

                            } else {
                                if (age >= 18 && age <= 59) {
                                    System.out.println(age);
                                    System.out.println(" not equal then " + (qty * price));
                                    JOptionPane.showMessageDialog(null, "The amount is: " + (qty * price));
                                    String sql = "UPDATE `medicine` SET `quantity`=" + (quantity - qty) + " WHERE id='" + id + "'";
                                    stmt.addBatch(sql);
                                    stmt.executeBatch();
                                    con.close();
                                    return success = true;
                                } else {
                                    System.out.println(age);
                                    System.out.println(" not equal then senior " + ((qty * price) * .80));
                                    JOptionPane.showMessageDialog(null, "The amount is: " + ((qty * price) * .80));
                                    String sql = "UPDATE `medicine` SET `quantity`=" + (quantity - qty) + " WHERE id='" + id + "'";
                                    stmt.addBatch(sql);
                                    stmt.executeBatch();
                                    con.close();
                                    return success = true;
                                }
                            }

                        }
                       
                    }
 break;
                }
                con.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }
        return success;

    }

}
