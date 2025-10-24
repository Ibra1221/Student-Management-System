/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.student_management_system;

import java.util.ArrayList;

/**
 *
 * @author pola-nasser13
 */
public class StudentDatabase extends Database<Student> {

    public StudentDatabase(String filename) {
        super(filename);
    }

    @Override
    public Student createRecordFrom(String line) {
        try {
            String[] parts = line.split(",");
            if (parts.length == 6) {
                return new Student(
                        Integer.parseInt(parts[0].trim()),
                        parts[1].trim(),
                        Integer.parseInt(parts[2].trim()),
                        parts[3].trim(),
                        parts[4].trim(),
                        Float.parseFloat(parts[5].trim()));
            }
        } catch (Exception e) {
            System.out.println("Error parsing line: " + line);
        }
        return null;
    }

    @Override
    public void insertRecord(Student record) {
        if (record.getId() == 0) {
            record = new Student(generateNewID(), record.getFullName(), record.getAge(),
                    record.getGender(), record.getDepartment(), record.getGPA());
        }
        if (!contains(record.getId())) {
            getRecords().add(record);
            saveToFile();
            System.out.println("Student added successfully with ID: " + record.getId());
        } else {
            System.out.println("Student with ID " + record.getId() + " already exists.");
        }
    }

    private int generateNewID() {
        ArrayList<Student> all = returnAllRecords();
        int maxId = 0;
        for (int i = 0; i < all.size(); i++) {
            int id = all.get(i).getId();
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId + 1;
    }

    public void sortByID() {
        ArrayList<Student> list = getRecords();
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int id1 = list.get(j).getId();
                int id2 = list.get(j + 1).getId();
                if (id1 > id2) {
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        saveToFile();
        System.out.println("Students sorted by ID successfully.");
    }

    public void sortByName() {
        ArrayList<Student> students = getRecords();
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - i - 1; j++) {
                String name1 = students.get(j).getFullName();
                String name2 = students.get(j + 1).getFullName();
                if (name1.compareToIgnoreCase(name2) > 0) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        saveToFile();
        System.out.println("Students sorted by name successfully.");
    }

    public void updateStudent(int studentId, String newName, int newAge, String newGender, String newDepartment, double newGPA) {
        ArrayList<Student> students = getRecords();
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getId() == studentId) {
                s.setFullName(newName);
                s.setAge(newAge);
                s.setGender(newGender);
                s.setDepartment(newDepartment);
                s.setGPA(newGPA);
                saveToFile();
                System.out.println("Student with ID " + studentId + " updated successfully.");
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
        System.out.println(" Failed to Update!!.");

    }

    public Student searchStudent(int id) {
        Student s = getRecord(id);
        if (s != null) {
            System.out.println("Student found with ID: " + id);
        } else {
            System.out.println("No student found with ID: " + id);
        }
        return s;
    }

    public Student searchStudent(String name) {
        for (int i = 0; i < getRecords().size(); i++) {
            Student s = getRecords().get(i);
            if (s.getFullName().equalsIgnoreCase(name)) {
                System.out.println("Student found with name: " + name);
                return s;
            }
        }
        System.out.println("No student found with name: " + name);
        return null;
    }

    public void sortByGPA() {
        ArrayList<Student> records = getRecords();
        int n = records.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (records.get(j).getGPA() > records.get(j + 1).getGPA()) {
                    Student temp = records.get(j);
                    records.set(j, records.get(j + 1));
                    records.set(j + 1, temp);
                }
            }
        }
        saveToFile();
        System.out.println("Students sorted by GPA successfully.");
    }
}
