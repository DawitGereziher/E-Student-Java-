
package opp.project;
import java.io.*;

class ProgrammingCourse extends Course {
    private static final long serialVersionUID = 1L;

    public ProgrammingCourse(String courseCode, String courseName) {
        super(courseCode, courseName);
    }

    @Override
    public void addStudentScore(Student student, double score, int creditHours) {
        int courseIndex = -1;
        for (int i = 0; i < student.getCourses().length; i++) {
            if (student.getCourses()[i].getCourseCode().equals(getCourseCode())) {
                courseIndex = i;
                break;
            }
        }
        if (courseIndex != -1) {
            student.addScoreForCourse(courseIndex, score, creditHours);
        } else {
            System.out.println("Course not found for student.");
        }
    }

    // Save course data to file
    @Override
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Programming course data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving programming course data: " + e.getMessage());
        }
    }

    // Read course data from file
    public static ProgrammingCourse readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ProgrammingCourse course = (ProgrammingCourse) ois.readObject();
            System.out.println("Programming course data read from " + fileName);
            return course;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading programming course data: " + e.getMessage());
            return null;
        }
    }
}


