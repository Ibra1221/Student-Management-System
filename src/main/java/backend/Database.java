/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author pola-nasser13
 * @param <D>
 */
public abstract class Database<D extends Info> {

    private ArrayList<D> records;
    private String filename;

    public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<D>();
    }

    protected void setRecords(ArrayList<D> records) {
        this.records = records;
    }

    protected void setFilename(String filename) {
        this.filename = filename;
    }

    public abstract D createRecordFrom(String line);

    public void readFromFile() {
        records.clear();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    records.add(createRecordFrom(line));
                }
            }
            System.out.println("Successfully read records from file: " + filename);
        } catch (Exception e) {
            System.out.println("Failed to read from file: " + filename);
            System.out.println(e);
        }
    }

    public boolean contains(int key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getId() == key) {
                return true;
            }
        }
        return false;
    }


    public abstract void insertRecord(D record);

    public void deleteRecord(int key) {
        boolean deleted = false;
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getId() == key) {
                records.remove(i);
                deleted = true;
                i--;
            }
        }
        if (deleted) {
            saveToFile();
            System.out.println("Successfully deleted record with ID: " + key);
        } else {
            System.out.println("No record found to delete with ID: " + key);
        }
    }

    protected String recordToLine(D record) {
        return record.lineRepresentation();
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < records.size(); i++) {
                pw.println(recordToLine(records.get(i)));
            }
            System.out.println("Successfully saved records to file: " + filename);
        } catch (Exception e) {
            System.out.println("Failed to save records to file: " + filename);
            System.out.println(e);
        }
    }
    
    public ArrayList<D> returnAllRecords() {
        return records;
    }

    public ArrayList<D> getRecords() {
        return records;
    }

    public String getFilename() {
        return filename;
    }

    public D getRecord(int key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getId() == key) {
                System.out.println("Record found for ID: " + key);
                return records.get(i);
            }
        }
        System.out.println("Record not found for ID: " + key);
        return null;
    }
}
