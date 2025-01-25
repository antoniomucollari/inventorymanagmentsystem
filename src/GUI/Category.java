package GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Category extends javax.swing.JFrame {
     private DefaultTableModel tableModel;

    public Category() {
        initComponents();
        setLocationRelativeTo(null);

        // Initialize table model for JTable
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name"}, 0);
        jTable1.setModel(tableModel); // Set model for JTable

        // Load categories into the table
        loadCategories();

        // Add listener for row selection in JTable
        jTable1.getSelectionModel().addListSelectionListener(e -> populateFieldsFromSelection());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Name = new javax.swing.JLabel();
        CategoryName = new javax.swing.JTextField();
        SaveBTN = new javax.swing.JButton();
        UpdateBTN = new javax.swing.JButton();
        ResetBTN = new javax.swing.JButton();
        CloseBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 580));

        Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Name.setText("Name");
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 108, 40));
        getContentPane().add(CategoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 298, -1));

        SaveBTN.setText("Save");
        SaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBTNActionPerformed(evt);
            }
        });
        getContentPane().add(SaveBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, -1, -1));

        UpdateBTN.setText("Update");
        UpdateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTNActionPerformed(evt);
            }
        });
        getContentPane().add(UpdateBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, -1, -1));

        ResetBTN.setText("Reset");
        ResetBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBTNActionPerformed(evt);
            }
        });
        getContentPane().add(ResetBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, -1, -1));

        CloseBTN.setText("Close");
        CloseBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBTNActionPerformed(evt);
            }
        });
        getContentPane().add(CloseBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBTNActionPerformed

        String name = CategoryName.getText().trim();

        if (id.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add new category to the table
        tableModel.addRow(new String[]{id, name});

        // Save categories to file
        saveCategoriesToFile();
        JOptionPane.showMessageDialog(this, "Category added successfully!");

        clearForm();
    }//GEN-LAST:event_SaveBTNActionPerformed

    private void UpdateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTNActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a category to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = CategoryID.getText().trim();
        String name = CategoryName.getText().trim();

        if (id.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update selected row in the table
        tableModel.setValueAt(id, selectedRow, 0);
        tableModel.setValueAt(name, selectedRow, 1);

        // Save updated categories to file
        saveCategoriesToFile();
        JOptionPane.showMessageDialog(this, "Category updated successfully!");

        clearForm();
    }//GEN-LAST:event_UpdateBTNActionPerformed
private void loadCategories() {
        String filePath = "data/categories.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            tableModel.setRowCount(0); // Clear existing rows
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    tableModel.addRow(parts);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading categories!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
// Save all table data to the file
    private void saveCategoriesToFile() {
        String filePath = "data/categories.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String id = (String) tableModel.getValueAt(i, 0);
                String name = (String) tableModel.getValueAt(i, 1);
                writer.write(id + "," + name);
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving categories!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Populate input fields from selected table row
    private void populateFieldsFromSelection() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            CategoryID.setText((String) tableModel.getValueAt(selectedRow, 0));
            CategoryName.setText((String) tableModel.getValueAt(selectedRow, 1));
        }
    }

    // Clear input fields and deselect the table
    private void clearForm() {
        CategoryName.setText("");
        jTable1.clearSelection();
    }
    private void ResetBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBTNActionPerformed
        clearForm();
    }//GEN-LAST:event_ResetBTNActionPerformed

    private void CloseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseBTNActionPerformed
        this.dispose(); // Close the window
    }//GEN-LAST:event_CloseBTNActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CategoryName;
    private javax.swing.JButton CloseBTN;
    private javax.swing.JLabel Name;
    private javax.swing.JButton ResetBTN;
    private javax.swing.JButton SaveBTN;
    private javax.swing.JButton UpdateBTN;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
