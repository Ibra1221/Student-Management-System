/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author pola-nasser13
 */
public class Student implements Info {

    private int id;
    private String fullName;
    private int age;
    private String gender;
    private String department;
    private double GPA;

    public Student(int id, String fullName, int age, String gender, String department, double GPA) {
        setId(id);
        setFullName(fullName);
        setAge(age);
        setGender(gender);
        setDepartment(department);
        setGPA(GPA);
    }

    public Student(String fullName, int age, String gender, String department, double GPA) {
        this.id = 0;
        setFullName(fullName);
        setAge(age);
        setGender(gender);
        setDepartment(department);
        setGPA(GPA);
    }

    public Student() {
        this.id = 0;
        this.fullName = "UnKnown";
        this.gender = "Male";
        this.department = "Unknown";
        this.age = 18;
        this.GPA = 3.0;
    }

    public void setId(int id) {
        if (id < 0) {
            System.out.println("Student ID must be Positive.");
            return;
        }
        this.id = id;
    }

   public void setFullName(String fullName) {
    try {
        if (fullName == null || fullName.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        Double.parseDouble(fullName.trim());  // this will throw  NumberFormatException if not a number

        System.out.println("Name cannot be a number.");
    } 
    catch (NumberFormatException e) {

        this.fullName = fullName.trim();
    }
}

    public void setAge(int age) {
        if (age < 6 || age > 100) {
            System.out.println("Age must be between 6 and 100.");
            return;
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            System.out.println("Gender cannot be empty.");
            return;
        }
        gender = gender.trim().toLowerCase();
        if (!gender.equals("male") && !gender.equals("female")) {
            System.out.println("Gender must be either Male or Female.");
            return;
        }
        this.gender = Character.toUpperCase(gender.charAt(0)) + gender.substring(1);
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            System.out.println("Department cannot be empty.");
            return;
        }
        this.department = department.trim();
    }

    public void setGPA(double GPA) {
        if (GPA < 0.0 || GPA > 4.0) {
            System.out.println("GPA must be between 0.0 and 4.0.");
            return;
        }
        this.GPA = GPA;
    }

    @Override
    public String lineRepresentation() {
        return id + "," + fullName + "," + age + "," + gender + "," + department + "," + GPA;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getGPA() {
        return GPA;
    }
}
