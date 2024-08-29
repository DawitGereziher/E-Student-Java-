
package opp.project;
import java.io.*;

class ProgrammingStudent extends Student {
    private static final long serialVersionUID = 1L;

    public ProgrammingStudent(int studentID, String studentName, int studentYear, String studentGender, int numCourses) {
        super(studentID, studentName, studentYear, studentGender, numCourses);
    }
    @Override
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Programming student data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving programming student data: " + e.getMessage());
        }
    }

    // Read programming student data from file
    public static ProgrammingStudent readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ProgrammingStudent student = (ProgrammingStudent) ois.readObject();
            System.out.println("Programming student data read from " + fileName);
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading programming student data: " + e.getMessage());
            return null;
        }
    }
}

