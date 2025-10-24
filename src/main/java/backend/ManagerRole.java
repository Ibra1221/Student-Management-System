/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package backend;
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

    public void addStudent(int studentID, String fullName, int age, String gender,String department, double GPA) {
        Student student = new Student(studentID, fullName, age, gender,department ,GPA);
        System.out.println("Adding Student to the database...");
        database.insertRecord(student);
        
    }
    
    public void deleteStudent(int key){
        System.out.println("Removing Student from the database...");
        database.deleteRecord(key);
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
    public void updateStudent(int studentID, String fullName, int age, String gender,String department, double GPA){
        System.out.println("Updating Student data..."); 
        database.updateStudent(studentID, fullName, age, gender, department, GPA);            
    }
    public Student searchStudentByID(int key){
        System.out.println("Searching for Student by ID...");
        return database.searchStudent(key);
    }
    public Student searchStudentByName(String name){
        System.out.println("Searching for Student by name...");
        return database.searchStudent(name);
    }

    public void sortByGPA(){
        System.out.println("Sorting Students by GPA...");
        database.sortByGPA();
    }
    
    public void sortByName(){
        System.out.println("Sorting Students by GPA...");
        database.sortByName();
    }
    
    public void sortByID(){
        System.out.println("Sorting Students by GPA...");
        database.sortByID();
    }
}


