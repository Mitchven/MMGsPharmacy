package Model;

import Frames.*;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class Model {

    public boolean register(String user, String pass, int age) {
        Register r = new Register();
        boolean success = false;
        try {
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            stmt = con.createStatement();
            String sql = "INSERT INTO `user`(`username`,  `password`, `age`) VALUES ('" + user + "','" + pass + "'," + age + ")";
            stmt.executeUpdate(sql);
            con.close();
            success = true;
            System.out.println("naprint");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(r, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    public int login(String username, String password) {
        Login l = new Login();
        int success = 400;
        boolean loggedIn = false;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM `userpharm` where username = '" + username + "' and password = '" + password + "'");

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

    public boolean addMedicine(String gname, String bname, String type, int price, int quantity) {
        PharmacistsAdd a = new PharmacistsAdd();
        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO `medicine`( Generic_Name`, `Brand_Name`, `MedicineType`, `Price`, `Quantity`) VALUES ('" + gname + "','" + bname + "','" + type + "','" + price + "'," + quantity + ")";
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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM `medicine` WHERE ID='" + ID + "'";
            stmt.executeUpdate(sql);
            success = true;
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }
        return success;
    }

    public boolean purchase(String uname, int id, int qty) {

        boolean success = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicine` WHERE ID=" + id);
            System.out.println("nakasulod");
            while (rs.next()) {
                int stock = rs.getInt("Quantity");
                double price = rs.getDouble("Price");
                if (rs.getInt("ID") == id) {
                    String gname = rs.getString("Generic_Name");
                    String bname = rs.getString("Brand_Name");
                    String medType = rs.getString("MedicineType");
                    System.out.println(price+10);
                    
                    ResultSet rs1 = stmt.executeQuery("SELECT * FROM `user`");
                    while (rs1.next()) {
                        int age = rs1.getInt("age");
                        if (rs1.getString("username").equals(uname)) {
                            System.out.println("hi there");
                            if (rs1.getString("ID").equals(id)) {
                                if (stock < qty) {
                                    JOptionPane.showMessageDialog(null, "Insufficient stock!");
                                } else if (stock == qty) {
                                    if (age >= 18 && age <= 59) {
                                        System.out.println(age);
                                        System.out.println(" equal then " + (qty * price));
                                        JOptionPane.showMessageDialog(null, "The amount is: " + (qty * price));
                                        String sql1 = "INSERT INTO `orderline`(`username`, `genericName`, `brandName`, `medicineType`, `price`, `quantity`) VALUES ('" + uname + "','" + gname + "','" + bname + "','" + medType + "'," + (qty*price) + "," + stock+")";
                                        String sql = "DELETE FROM `medicine` WHERE ID='" + id + "'";
                                        stmt.addBatch(sql);
                                        stmt.addBatch(sql1);
                                        stmt.executeBatch();
                                        return success = true;
                                    } else {
                                        System.out.println(age);
                                        System.out.println(" equal then senior " + ((qty * price) * .80));
                                        JOptionPane.showMessageDialog(null, "The amount is: " + ((qty * price) * .80));
                                        String sql1 = "INSERT INTO `orderline`(`username`, `genericName`, `brandName`, `medicineType`, `price`, `quantity`) VALUES ('" + uname + "','" + gname + "','" + bname + "','" + medType + "'," + ((qty*price)*80) + "," + stock+")";
                                        String sql = "DELETE FROM `medicine` WHERE ID='" + id + "'";
                                        System.out.println("Nagbasa siya dito");
                                        stmt.addBatch(sql);
                                        stmt.addBatch(sql1);
                                        stmt.executeBatch();
                                        return success = true;
                                    }
                                } } else {

                                if (age >= 18 && age <= 59) {
                                    System.out.println(age);
                                    System.out.println(" not equal then " + (qty * price));
                                    JOptionPane.showMessageDialog(null, "The amount is: " + (qty * price));
                                    String sql1 = "INSERT INTO `orderline`(`username`, `genericName`, `brandName`, `medicineType`, `price`, `quantity`) VALUES ('" + uname + "','" + gname + "','" + bname + "','" + medType + "'," + (qty*price) + "," + stock+")";
                                    System.out.println("nagread siya!");
                                    String sql = "UPDATE `medicine` SET `Quantity`=" + (stock - qty) + " WHERE ID='" + id + "'";
                                    stmt.addBatch(sql);
                                    stmt.addBatch(sql1);
                                    stmt.executeBatch();
                                    return success = true;
                                } else {
                                    System.out.println(age);
                                    System.out.println(" not equal then senior " + ((qty * price) * .80));
                                    JOptionPane.showMessageDialog(null, "The amount is: " + ((qty * price) * .80));
                                    String sql1 = "INSERT INTO `orderline`(`username`, `genericName`, `brandName`, `medicineType`, `price`, `quantity`) VALUES ('" + uname + "','" + gname + "','" + bname + "','" + medType + "'," + ((qty*price)*80) + "," + stock+")";
                                    String sql = "UPDATE `medicine` SET `Quantity`=" + (stock - qty) + " WHERE ID='" + id + "'";
                                    System.out.println("DITO SIYA NAGBASA");
                                    stmt.addBatch(sql);
                                    stmt.addBatch(sql1);
                                    stmt.executeBatch();
                                    return success = true;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error connecting to database!");
        }
        return success;

    }

}
