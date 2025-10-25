package frontend;

import backend.ManagerRole;
import backend.Student;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ViewStudents1 extends javax.swing.JPanel {

    public ViewStudents1() {
        initComponents();
        refreshbtnActionPerformed(null); // auto-load students
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        refreshbtn = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();

        setLayout(new javax.swing.GroupLayout(this));
        javax.swing.GroupLayout layout = (javax.swing.GroupLayout) getLayout();

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Name", "Age", "Gender", "Department", "GPA"
            }
        ));
        jScrollPane1.setViewportView(studentsTable);

        jLabel1.setBackground(new java.awt.Color(102, 255, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Students");
        jLabel1.setOpaque(true);

        refreshbtn.setBackground(new java.awt.Color(0, 255, 204));
        refreshbtn.setText("Refresh");
        refreshbtn.addActionListener(evt -> refreshbtnActionPerformed(evt));

        backbtn.setBackground(new java.awt.Color(255, 51, 51));
        backbtn.setText("Back");
        backbtn.addActionListener(evt -> backbtnActionPerformed(evt));

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(backbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refreshbtn)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshbtn)
                    .addComponent(backbtn))
                .addGap(32, 32, 32))
        );
    }

    private void refreshbtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ManagerRole manager = new ManagerRole();
        Student[] students = manager.getListOfStudents();

        DefaultTableModel model = (DefaultTableModel) studentsTable.getModel();
        model.setRowCount(0); // clear old rows

        for (Student s : students) {
            Object[] row = {
                s.getId(),
                s.getFullName(),
                s.getAge(),
                s.getGender(),
                s.getDepartment(),
                String.format("%.2f", s.getGPA())
            };
            model.addRow(row);
        }

        // Center align the GPA column
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        studentsTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
    }                                          

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // Optional: hide this panel or navigate back
        SwingUtilities.getWindowAncestor(this).dispose();
    }                                       

    // Variables declaration - do not modify                     
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshbtn;
    private javax.swing.JTable studentsTable;
    // End of variables declaration                   
}