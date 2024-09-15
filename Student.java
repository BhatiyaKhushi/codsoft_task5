package com.codsoft.studentmanagement;

public class Student {
    private String name;
    private String rollNumber;
    private String grade;
    private String email;
    private String phoneNo;
    private String city;
    private int age;

    public Student(String name, String rollNumber, String grade, String email, String phoneNo, String city, int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        setEmail(email);
        setPhoneNo(phoneNo);
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public void setEmail(String email) {
        if (email != null && email.endsWith("@gmail.com")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email must be a valid Gmail address.");
        }
    }

    public void setPhoneNo(String phoneNo) {
        if (phoneNo != null && phoneNo.matches("\\d{10}")) {
            this.phoneNo = phoneNo;
        } else {
            throw new IllegalArgumentException("Phone number must be 10 digits.");
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Student Details:\n" +
                "=====================\n" +
                " %-15s : %s\n" +
                " %-15s : %s\n" +
                " %-15s : %s\n" +
                " %-15s : %s\n" +
                " %-15s : %s\n" +
                " %-15s : %s\n" +
                " %-15s : %d\n",
                "Name", name,
                "Roll Number", rollNumber,
                "Grade", grade,
                "Email", email,
                "Phone number",phoneNo,
                "City",city,
                "Age", age
        );
    }

}
