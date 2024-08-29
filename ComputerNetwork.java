
package opp.project;

import java.io.*;

class ComputerNetwork extends Course implements Serializable {
    private static final long serialVersionUID = 1L;

    public ComputerNetwork(String courseCode, String courseName) {
        super(courseCode, courseName);
    }

    @Override
    public void addStudentScore(Student student, double score, int creditHours) {
        int index = -1;
        Course[] courses = student.getCourses();
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] instanceof ComputerNetwork) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            student.addScoreForCourse(index, score, creditHours);
        } else {
            System.out.println("Student not enrolled in Computer Network course.");
        }
    }

    // Save course data to file
    @Override
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Computer Network course data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving Computer Network course data: " + e.getMessage());
        }
    }

    // Read course data from file
    public static ComputerNetwork readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ComputerNetwork course = (ComputerNetwork) ois.readObject();
            System.out.println("Computer Network course data read from " + fileName);
            return course;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading Computer Network course data: " + e.getMessage());
            return null;
        }
    }
}


