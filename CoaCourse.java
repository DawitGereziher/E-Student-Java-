
package opp.project;
import java.io.*;

class CoaCourse extends Course implements Serializable {
    private static final long serialVersionUID = 1L;

    public CoaCourse(String courseCode, String courseName) {
        super(courseCode, courseName);
    }

    @Override
    public void addStudentScore(Student student, double score, int creditHours) {
        int index = -1;
        Course[] courses = student.getCourses();
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] instanceof CoaCourse) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            student.addScoreForCourse(index, score, creditHours);
        } else {
            System.out.println("Student not enrolled in COA course.");
        }
    }

    // Save course data to file
    @Override
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("COA course data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving COA course data: " + e.getMessage());
        }
    }

    // Read course data from file
    public static CoaCourse readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            CoaCourse course = (CoaCourse) ois.readObject();
            System.out.println("COA course data read from " + fileName);
            return course;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading COA course data: " + e.getMessage());
            return null;
        }
    }
}
