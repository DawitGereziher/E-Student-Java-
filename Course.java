
package opp.project;

import java.io.*;

abstract class Course implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public abstract void addStudentScore(Student student, double score, int creditHours);

    // Save course data to file
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Course data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving course data: " + e.getMessage());
        }
    }

    // Read course data from file
    public static Course readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Course course = (Course) ois.readObject();
            System.out.println("Course data read from " + fileName);
            return course;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading course data: " + e.getMessage());
            return null;
        }
    }
}






