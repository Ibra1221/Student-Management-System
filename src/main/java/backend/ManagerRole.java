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
 final private String[] admins  = {"Ibrahim", "Walaa", "Pola", "Youssef"}; 
 final private String[] passwords  = {"123", "456", "789", "101112"}; 
 
    public ManagerRole() {
        database = new StudentDatabase("Students.txt"); 
        database.readFromFile();
    }

    public int getIndex(String[] arr, String word){
        for(int i =0; i< arr.length; i++){
            if(arr[i].equals(word)){
                return i;
            }
        }
        return -1;
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
    public boolean updateStudent(int studentID, int newId, String fullName, int age, String gender,String department, double GPA){
        System.out.println("Updating Student data..."); 
        return database.updateStudent(studentID, newId,fullName, age, gender, department, GPA);            
    }
    public Student searchStudent(int id){
        System.out.println("Searching for Student by ID...");
        return database.searchStudent(id);
    }
    public Student searchStudent(String name){
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
    
    public String[] getPasswords(){
        return this.passwords;
    }
    
    public String[] getUsernames(){
        return this.admins;
    }
    public int generateNewStudentID() {
    return database.generateNewID();
    }}


