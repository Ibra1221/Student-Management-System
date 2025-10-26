/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.ManagerRole;
import backend.Student;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamed Walaa
 */
public class Add_Students extends javax.swing.JPanel {

    public Add_Students() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtGPA = new javax.swing.JTextField();
        comboGender = new javax.swing.JComboBox<>();
        comboDep = new javax.swing.JComboBox<>();
        clearbtn = new javax.swing.JButton();
        savebtn = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        addStudentlabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        jLabel1.setText("Name: ");
        jLabel2.setText("ID:");
        jLabel3.setText("Age:");
        jLabel4.setText("Gender (Male/Female):");
        jLabel5.setText("Department:");
        jLabel6.setText("GPA or Grade:");

        comboGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female" }));
        comboDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select department", "Computer and Communications", "Mechatronics", "Electromechanics", "Biomedical" }));

        clearbtn.setBackground(new java.awt.Color(255, 51, 51));
        clearbtn.setText("Clear");
        clearbtn.addActionListener(evt -> clearFields());

        savebtn.setBackground(new java.awt.Color(0, 255, 51));
        savebtn.setText("Save");
        savebtn.addActionListener(evt -> saveStudent());

        jTextField5.setBackground(new java.awt.Color(0, 51, 255));
        jTextField5.setFont(new java.awt.Font("Segoe UI", 3, 24));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        addStudentlabel.setBackground(new java.awt.Color(0, 51, 255));
        addStudentlabel.setFont(new java.awt.Font("Segoe UI", 1, 24));
        addStudentlabel.setForeground(new java.awt.Color(255, 255, 255));
        addStudentlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addStudentlabel.setText("Add Student");
        addStudentlabel.setOpaque(true);

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setText("Generate ID");
        jButton2.addActionListener(evt -> generateId());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addStudentlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clearbtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtAge)
                            .addComponent(comboGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboDep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGPA))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 251, Short.MAX_VALUE)
                        .addComponent(savebtn)
                        .addGap(51, 51, 51))
                    .addComponent(jTextField5)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addStudentlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(comboGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savebtn)
                    .addComponent(clearbtn))
                .addGap(35, 35, 35)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    private void saveStudent() {
        String idText = txtId.getText().trim();
        String name = txtName.getText().trim();
        String ageText = txtAge.getText().trim();
        String gpaText = txtGPA.getText().trim();
        String gender = (String) comboGender.getSelectedItem();
        String dept = (String) comboDep.getSelectedItem();

    try {
        boolean hasNumber = false;
        boolean hasInvalidChar = false;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isDigit(c)) {
                hasNumber = true;
                break;
            } else if (!Character.isLetter(c) && c != ' ') {
                hasInvalidChar = true;
                break;
            }
        }
        if (hasNumber) throw new Exception("Name cannot contain numbers!");
        if (hasInvalidChar) throw new Exception("Name can contain only letters and spaces!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Invalid Name", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }


        int age;
        double gpa;
        int id;
        try { age = Integer.parseInt(ageText); }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be an integer", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            gpa = Double.parseDouble(gpaText);
            if (gpa < 0 || gpa > 4.0) {
                JOptionPane.showMessageDialog(this, "GPA must be between 0 and 4.0!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            gpaText = gpaText.trim().toUpperCase();
            switch(gpaText) {
                case "A+": case "A": gpa = 4.0; break;
                case "A-": gpa = 3.7; break;
                case "B+": gpa = 3.3; break;
                case "B": gpa = 3.0; break;
                case "B-": gpa = 2.7; break;
                case "C+": gpa = 2.3; break;
                case "C": gpa = 2.0; break;
                case "D+": gpa = 1.7; break;
                case "D": gpa = 1.3; break;
                case "D-": gpa = 1.0; break;
                case "F": gpa = 0.0; break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid GPA or Grade", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }
        }

        try { id = Integer.parseInt(idText); }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID must be an integer", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (age <= 0) {
            JOptionPane.showMessageDialog(this, "Age must be positive", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ManagerRole manager = new ManagerRole();
        manager.addStudent(id, name, age, gender, dept, gpa);

        JOptionPane.showMessageDialog(this, "Student Added Successfully!");
        clearFields();
    }

    private void clearFields() {
        txtName.setText("");
        txtId.setText("");
        txtAge.setText("");
        txtGPA.setText("");
        comboDep.setSelectedIndex(0);
        comboGender.setSelectedIndex(0);
        txtId.setEditable(true);
    }

    private void generateId() {
        ManagerRole manager = new ManagerRole();
        int newId = manager.generateNewStudentID();
        txtId.setText(String.valueOf(newId));
        txtId.setEditable(false);
        JOptionPane.showMessageDialog(this, "Generated new Student ID: " + newId);
    }

    // Variables declaration
    private javax.swing.JLabel addStudentlabel;
    private javax.swing.JButton clearbtn;
    private javax.swing.JComboBox<String> comboDep;
    private javax.swing.JComboBox<String> comboGender;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtGPA;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
}
