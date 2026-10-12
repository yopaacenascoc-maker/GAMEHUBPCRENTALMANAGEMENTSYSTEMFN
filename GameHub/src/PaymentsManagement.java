/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.math.BigDecimal;
import javax.swing.JPanel;
/**
 *
 * @author Admin
 */
public class PaymentsManagement extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PaymentsManagement.class.getName());

    /**
     * Creates new form PaymentsManagement
     */
    public PaymentsManagement() {
         initComponents();

    setTitle("GameHub - Payments Management");
    setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    setMinimumSize(new java.awt.Dimension(900, 600));

    // Read-only fields
    txtRentalID.setEditable(false);
    txtTotal1.setEditable(false);

    // Payment options
    cmbPaymentMethod.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[]{"GCash", "Cash", "Bank Transfer"}
        )
    );

    cmbPaymentStatus.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[]{"Pending", "Paid", "Cancelled"}
        )
    );

    // Payment table
    tblRental.setModel(new DefaultTableModel(
        new Object[][] {},
        new String[]{
            "Payment ID", "Rental ID", "Amount",
            "Payment Method", "Payment Status", "Payment Date"
        }
    ));

    tblRental.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS
    );

    // Main layout
    jPanel8.setLayout(new java.awt.BorderLayout(15, 15));
    jPanel8.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(20, 24, 20, 24)
    );

    jPanel8.remove(jLabel4);
    jPanel8.remove(jPanel9);

    jPanel8.add(jLabel4, java.awt.BorderLayout.NORTH);
    jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

    // Form layout
    jPanel9.setLayout(new java.awt.BorderLayout(15, 15));

    JPanel formPanel = new JPanel(
        new java.awt.GridLayout(6, 2, 10, 12)
    );
    formPanel.setBackground(new java.awt.Color(18, 24, 38));

    formPanel.add(jLabel8);
    formPanel.add(txtRentalID);

    formPanel.add(jLabel9);
    formPanel.add(cmbRentalID);

    formPanel.add(jLabel10);
    formPanel.add(txtPCID);

    formPanel.add(jLabel11);
    formPanel.add(cmbPaymentMethod);

    formPanel.add(jLabel12);
    formPanel.add(cmbPaymentStatus);

    formPanel.add(jLabel13);
    formPanel.add(txtTotal1);

    // Table area
    JPanel tablePanel = new JPanel(new java.awt.BorderLayout());
    tablePanel.setBackground(new java.awt.Color(18, 24, 38));
    tablePanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // Buttons
    JPanel buttonPanel = new JPanel(
        new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 12, 10)
    );
    buttonPanel.setBackground(new java.awt.Color(18, 24, 38));
    buttonPanel.add(btnAdd);
    buttonPanel.add(btnUpdate);
    buttonPanel.add(btnDelete);
    buttonPanel.add(btnClear);
    buttonPanel.add(btnBack);

    // Arrange form and table
    JPanel contentPanel = new JPanel(
        new java.awt.BorderLayout(20, 15)
    );
    contentPanel.setBackground(new java.awt.Color(18, 24, 38));
    contentPanel.add(formPanel, java.awt.BorderLayout.WEST);
    contentPanel.add(tablePanel, java.awt.BorderLayout.CENTER);

    jPanel9.add(contentPanel, java.awt.BorderLayout.CENTER);
    jPanel9.add(buttonPanel, java.awt.BorderLayout.SOUTH);

    loadRentalIDs();
    loadPayments();

    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);
    }
private void loadPayments() {
    DefaultTableModel model =
        (DefaultTableModel) tblRental.getModel();

    model.setRowCount(0);

    String sql = "SELECT id, rental_id, amount, "
               + "payment_method, payment_status, payment_date "
               + "FROM payments ORDER BY id DESC";

    try (Connection conn = DataStore.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            Timestamp date = rs.getTimestamp("payment_date");

            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getInt("rental_id"),
                rs.getBigDecimal("amount"),
                rs.getString("payment_method"),
                rs.getString("payment_status"),
                date == null ? "" : date.toString()
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(
            this,
            "Failed to load payments:\n" + e.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtRentalID = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPCID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRental = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtTotal1 = new javax.swing.JTextField();
        cmbRentalID = new javax.swing.JComboBox<>();
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        cmbPaymentStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel8.setBackground(new java.awt.Color(30, 40, 60));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PAYMENTS MANAGEMENT");

        jPanel9.setBackground(new java.awt.Color(18, 24, 38));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Payment ID:");

        txtRentalID.addActionListener(this::txtRentalIDActionPerformed);

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnAdd.setText("ADD");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnClear.setText("CLEAR");
        btnClear.addActionListener(this::btnClearActionPerformed);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Rental ID:");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Amount (₱):");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Payment Method:");

        tblRental.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Payment ID ", "Rental ID", "Amount", "Payment Method", "Payment Status", "Payment Date"
            }
        ));
        tblRental.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRentalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRental);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Payment Status:");

        btnBack.setText("Back to Dashboard");
        btnBack.addActionListener(this::btnBackActionPerformed);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Payment Date:");

        txtTotal1.addActionListener(this::txtTotal1ActionPerformed);

        cmbRentalID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbPaymentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(btnAdd)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnClear))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtRentalID, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                            .addComponent(txtPCID, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                            .addComponent(txtTotal1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                            .addComponent(cmbRentalID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbPaymentStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRentalID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRentalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtPCID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbPaymentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel8, "card2");

        setBounds(0, 0, 851, 566);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         int row = tblRental.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this,
            "Select a payment from the table first.");
        return;
    }

    try {
        int paymentID = Integer.parseInt(
            tblRental.getValueAt(row, 0).toString()
        );
        int rentalID = Integer.parseInt(
            cmbRentalID.getSelectedItem().toString()
        );
        BigDecimal amount = new BigDecimal(txtPCID.getText().trim());
        String method = cmbPaymentMethod.getSelectedItem().toString();
        String status = cmbPaymentStatus.getSelectedItem().toString();

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(this,
                "Amount must be greater than zero.");
            return;
        }

        String sql = "UPDATE payments SET rental_id=?, amount=?, "
            + "payment_method=?, payment_status=? WHERE id=?";

        try (Connection conn = DataStore.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, rentalID);
            pst.setBigDecimal(2, amount);
            pst.setString(3, method);
            pst.setString(4, status);
            pst.setInt(5, paymentID);
            pst.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Payment updated successfully!");
        loadPayments();
        clearFields();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Failed to update payment: " + e.getMessage());
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

private void loadRentalIDs() {
    cmbRentalID.removeAllItems();

    String sql = "SELECT id FROM rentals ORDER BY id";

    try (Connection conn = DataStore.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            cmbRentalID.addItem(String.valueOf(rs.getInt("id")));
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Failed to load Rental IDs: " + e.getMessage());
    }
}

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       try {
        if (cmbRentalID.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a Rental ID.");
            return;
        }

        int rentalID = Integer.parseInt(
            cmbRentalID.getSelectedItem().toString()
        );

        BigDecimal amount = new BigDecimal(txtPCID.getText().trim());
        String method = cmbPaymentMethod.getSelectedItem().toString();
        String status = cmbPaymentStatus.getSelectedItem().toString();

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(this,
                "Amount must be greater than zero.");
            return;
        }

        String sql = "INSERT INTO payments "
            + "(rental_id, amount, payment_method, payment_status) "
            + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DataStore.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, rentalID);
            pst.setBigDecimal(2, amount);
            pst.setString(3, method);
            pst.setString(4, status);
            pst.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Payment added successfully!");
        loadPayments();
        clearFields();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Enter a valid amount.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Failed to add payment: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int row = tblRental.getSelectedRow();

    if (row == -1) {
        JOptionPane.showMessageDialog(this,
            "Select a payment to delete.");
        return;
    }

    int choice = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to delete this payment?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
    );

    if (choice != JOptionPane.YES_OPTION) {
        return;
    }

    try {
        int paymentID = Integer.parseInt(
            tblRental.getValueAt(row, 0).toString()
        );

        String sql = "DELETE FROM payments WHERE id=?";

        try (Connection conn = DataStore.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, paymentID);
            pst.executeUpdate();
        }

        JOptionPane.showMessageDialog(this,
            "Payment deleted successfully!");
        loadPayments();
        clearFields();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Failed to delete payment:\n" + e.getMessage());
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblRentalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRentalMouseClicked
        int row = tblRental.getSelectedRow();

    if (row != -1) {
        txtRentalID.setText(tblRental.getValueAt(row, 0).toString());
        cmbRentalID.setSelectedItem(tblRental.getValueAt(row, 1).toString());
        txtPCID.setText(tblRental.getValueAt(row, 2).toString());
        cmbPaymentMethod.setSelectedItem(tblRental.getValueAt(row, 3).toString());
        cmbPaymentStatus.setSelectedItem(tblRental.getValueAt(row, 4).toString());
        txtTotal1.setText(tblRental.getValueAt(row, 5).toString());
    }
    }//GEN-LAST:event_tblRentalMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtRentalIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRentalIDActionPerformed
      txtRentalID.setEditable(false);
    }//GEN-LAST:event_txtRentalIDActionPerformed

    private void txtTotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new PaymentsManagement().setVisible(true));
    }
private void clearFields() {
     txtRentalID.setText("");
    txtPCID.setText("");
    txtTotal1.setText("");

    if (cmbRentalID.getItemCount() > 0) {
        cmbRentalID.setSelectedIndex(0);
    }

    cmbPaymentMethod.setSelectedIndex(0);
    cmbPaymentStatus.setSelectedIndex(0);
    tblRental.clearSelection();
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JComboBox<String> cmbPaymentStatus;
    private javax.swing.JComboBox<String> cmbRentalID;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRental;
    private javax.swing.JTextField txtPCID;
    private javax.swing.JTextField txtRentalID;
    private javax.swing.JTextField txtTotal1;
    // End of variables declaration//GEN-END:variables
}
