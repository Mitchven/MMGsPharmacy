package Controller;

import Model.Model;
import Frames.*;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class Controller {

    Model acc = new Model();

    // For Registratin Verification
    public boolean verifyRegister(String user, String pass, String age1) {
        Register r = new Register();
        boolean success = false;
        if (user.length() > 0 && pass.length() >= 8) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `user` WHERE username='" + user + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(r, "Username is already taken!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int age = Integer.parseInt(age1);
                        if (age >= 18 && age <= 130) {
                            success = acc.register(user, pass, age);
                            return success;
                        } else {
                            JOptionPane.showMessageDialog(r, "Minor is not ALLOWED", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(r, "Age should be number!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(r, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(r, "Fill Up Everything & Password must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    // For LogIN Verification
    public int logInVerification(String username, String password) {
        int success = 400;
        return acc.login(username, password);
    }

    // For Admin Add Medicine
    public boolean addMedicine(String gname, String bname, String type, String price1, String quantity) {
        PharmacistsAdd a = new PharmacistsAdd();
        boolean success = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicine` WHERE Generic_Name='" + gname + "'");

            if (rs.next()) {
                JOptionPane.showMessageDialog(a, "Medicine Name already existed!\nUpdate " + gname, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (gname.length() > 0 && bname.length() > 0 && type.length() > 0) {
                    if (type.matches("Medicine for Allergies") || type.matches("Medicine for Body Pain") || type.matches("Medicine for Cough") || type.matches("Medicine for Headache")) {
                        try {
                            int price = Integer.parseInt(price1);
                            try {
                                int stock = Integer.parseInt(quantity);
                                success = acc.addMedicine(gname, bname, type, price, stock);
                                return success;

                            } catch (HeadlessException | NumberFormatException e) {
                                JOptionPane.showMessageDialog(a, "Quantity should be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        } catch (HeadlessException | NumberFormatException e) {
                            JOptionPane.showMessageDialog(a, "Price should be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(a, "For Type\nChoose of the four 'Medicine for Allergies' or 'Medicine for Body Pain' or 'Medicine for Headache' or 'Medicine for Cough' ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(a, "Fill Up Everything", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(a, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }

    // For Admin Remove Medicine
    public boolean removeMedicine(String ID) {
        PharmacistsDelete r = new PharmacistsDelete();
        boolean success = false;
        boolean exist = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `medicine` WHERE ID='" + ID + "'");

            while (rs.next()) {
                try {
                    int id = Integer.parseInt(ID);
                    if (rs.getString("ID").equals(ID)) {
                        try {
                            exist = true;
                            return success = acc.removeMedicine(id);
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(r, "Error Removing", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(r, "ID should be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (exist == false) {
                JOptionPane.showMessageDialog(r, "Medicine ID Number does not Exist", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(r, "Error connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }


      public boolean purchase(String uname, String id2, String quantity) {
        boolean success = false;
        boolean exist = false;

        try {

            int qty = Integer.parseInt(quantity);
            try {
                int id = Integer.parseInt(id2);
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM `medicine` WHERE ID='" + id + "'");

                    while (rs.next()) {
                        int stock = rs.getInt("Quantity");
                        double price = rs.getDouble("Price");
                        if (rs.getInt("ID") == id) {
                            exist = true;
                            return success = acc.purchase(uname, id, qty);
                        }
                        break;
                    }
                    if (exist == false) {
                        JOptionPane.showMessageDialog(null, "Medicine do not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ID should be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantity should be a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return success;
    }
}
