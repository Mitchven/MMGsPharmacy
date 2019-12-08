
package Frames;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class PharmacistsUpdate extends javax.swing.JFrame {

    String name, bname, gname, type;

    /**
     * Creates new form JAdminUpd
     */
    public PharmacistsUpdate() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameT = new javax.swing.JLabel();
        idT = new javax.swing.JLabel();
        bnameT = new javax.swing.JLabel();
        gnameT = new javax.swing.JLabel();
        typeT = new javax.swing.JLabel();
        priceT = new javax.swing.JLabel();
        stockT = new javax.swing.JLabel();
        idF = new javax.swing.JTextField();
        bnameF = new javax.swing.JTextField();
        priceF = new javax.swing.JTextField();
        typeF = new javax.swing.JTextField();
        gnameF = new javax.swing.JTextField();
        stockF = new javax.swing.JTextField();
        nameF = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UPDATE MEDICINE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(121, 121, 121))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        nameT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nameT.setText("Name:");

        idT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        idT.setText("ID:");

        bnameT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        bnameT.setText("Brand Name:");

        gnameT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gnameT.setText("Generic Name:");

        typeT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        typeT.setText("Type:");

        priceT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        priceT.setText("Quantity:");

        stockT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stockT.setText("Price:");

        idF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFActionPerformed(evt);
            }
        });

        bnameF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnameFActionPerformed(evt);
            }
        });

        priceF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFActionPerformed(evt);
            }
        });

        gnameF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gnameFActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 255, 255));
        back.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        back.setText("BACK");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 255, 255));
        update.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        update.setText("UPDATE");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bnameT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bnameF, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(nameT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameF))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gnameT)
                            .addComponent(typeT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeF, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(gnameF))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(stockT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(priceF, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(priceT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stockF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(update)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idT)
                    .addComponent(nameT)
                    .addComponent(nameF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnameT)
                    .addComponent(bnameF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gnameF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gnameT))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(typeF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeT))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockT)
                    .addComponent(stockF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceT))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnameFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnameFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bnameFActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        PharmacistsDashboard back = new PharmacistsDashboard();
        back.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
        name = nameF.getText();
        bname = bnameF.getText();
        gname = gnameF.getText();
        type = typeF.getText();
        double price = 0;
        int stock = 0;
        String ID = idF.getText();
        try {
            int newId = Integer.parseInt(ID);
            Statement stmt = null;
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mmgspharmacy", "root", "");
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM `medicine` WHERE `Id`=" + ID);

                System.out.println("cxoonectedfs");
                if (rs.next()) {
                    System.out.println("Successfully connected");
                    if (name.length() > 0 && bname.length() > 0 && gname.length() > 0 && type.length() > 0) {
                        if (type.equals("Headache Medicine") || type.equals("Allergies Medicine") || type.equals("Body Pain Medicine")) {
                            try {
                                price = Double.parseDouble(priceF.getText());
                                priceF.requestFocusInWindow();
                                stock = Integer.parseInt(stockF.getText());
                                stockF.requestFocusInWindow();
                                if (price > 0 && stock > 0) {
                                    String sql = "UPDATE `medicine` SET `name`='" + name + "',`bname`='" + bname + "',`gname`='" + gname + "',`type`='" + type + "',`price`=" + price + ",`stock`=" + stock + " WHERE `Id` = " + ID;
                                    stmt.executeUpdate(sql);
                                    JOptionPane.showMessageDialog(rootPane, "Medicine Updated Successfully");
                                    ViewMedicine view = new ViewMedicine();
                                    view.setVisible(true);
                                    this.setVisible(false);
                                    con.close();

                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Number less than zero is not valid", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException z) {
                                JOptionPane.showMessageDialog(rootPane, "Numbers Only", "Error", JOptionPane.ERROR_MESSAGE);
                                priceF.setText("");
                                priceF.requestFocusInWindow();
                                stockF.setText("");
                                stockF.requestFocusInWindow();
                                idF.setText("");
                                idF.requestFocusInWindow();
                            }

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "For the Type\nChoose of the three 'Allergies Medicine' or 'Body Pain Medicine' or 'Headache Medicine' ", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Fill Up Everything", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    con.close();
                } else {
//                JOptionPane.showMessageDialog(rootPane, "Medicine Name already existed!\nUpdate " + name);
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_updateMouseClicked

    private void priceFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFActionPerformed

    private void idFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFActionPerformed

    private void gnameFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gnameFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gnameFActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PharmacistsUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PharmacistsUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PharmacistsUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PharmacistsUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PharmacistsUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField bnameF;
    private javax.swing.JLabel bnameT;
    private javax.swing.JTextField gnameF;
    private javax.swing.JLabel gnameT;
    private javax.swing.JTextField idF;
    private javax.swing.JLabel idT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameF;
    private javax.swing.JLabel nameT;
    private javax.swing.JTextField priceF;
    private javax.swing.JLabel priceT;
    private javax.swing.JTextField stockF;
    private javax.swing.JLabel stockT;
    private javax.swing.JTextField typeF;
    private javax.swing.JLabel typeT;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
