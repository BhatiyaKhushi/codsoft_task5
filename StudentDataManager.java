package com.codsoft.studentmanagement;

import java.io.*;
import java.util.List;

public class StudentDataManager {

    public static void saveStudentsToFile(List<Student> students, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade() + "," + student.getEmail() + "," + student.getPhoneNo() + "," + student.getCity() + "," + student.getAge());
                writer.newLine();
            }
        }
    }

    public static void loadStudentsFromFile(List<Student> students, String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    try {
                        Student student = new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], Integer.parseInt(parts[6]));
                        students.add(student);
                    } catch (IllegalArgumentException e) {
                        
                    }
                }
            }
        }
    }
}
