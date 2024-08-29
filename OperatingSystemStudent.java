
package opp.project;
import java.io.*;

class OperatingSystemStudent extends Student {
    private static final long serialVersionUID = 1L;

    public OperatingSystemStudent(int studentID, String studentName, int studentYear, String studentGender, int numCourses) {
        super(studentID, studentName, studentYear, studentGender, numCourses);
    }

    @Override
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Operating system student data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving operating system student data: " + e.getMessage());
        }
    }

    // Read operating system student data from file
    public static OperatingSystemStudent readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            OperatingSystemStudent student = (OperatingSystemStudent) ois.readObject();
            System.out.println("Operating system student data read from " + fileName);
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading operating system student data: " + e.getMessage());
            return null;
        }
    }
}

