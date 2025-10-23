/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.student_management_system;
/**
 *
 * @author Ibrahim
 */

import java.util.ArrayList;
public class ManagerRole {
 private StudentDatabase database;

    public ManagerRole() {
        database = new StudentDatabase("Students.txt"); 
        database.readFromFile();
    }

    public void addStudent(String studentID, String fullName, int age, String gender, float GPA) {
        Student student = new Student(studentID, fullName, age, gender, GPA);
        System.out.println("Adding Student to the database...");
        database.insertRecord(student);
        database.saveToFile();
        
    }
    
    public void deleteStudent(String key){
        System.out.println("Removing Student from the database...");
        database.deleteRecord(key);
        database.saveToFile();
    }
    
    public Student[] getListOfStudents(){
        System.out.println("Fetching the list of Students...");
        ArrayList<Student> records = database.returnAllRecords();
        if(records.size() == 0){
        System.out.println("Database is empty");
                }
        return records.toArray(new Student[records.size()]);
    }
    public void logout(){
        System.out.println("Logging out. Saving...");
        database.saveToFile();
    }
    public void updateStudent(){
        // Implementation for updating a student record probably after GUI
    }
    public Student searchStudent(String key){
        System.out.println("Searching for Student...");
        Student student = database.getRecord(key);
        if(student == null){
            System.out.println("Student not found!");
        }
        return student;
    }
}


