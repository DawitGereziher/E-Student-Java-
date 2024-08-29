package opp.project;

import java.io.*;

class NetworkingStudent extends Student {
    private static final long serialVersionUID = 1L;

    public NetworkingStudent(int studentID, String studentName, int studentYear, String studentGender, int numCourses) {
        super(studentID, studentName, studentYear, studentGender, numCourses);
    }



    // Save networking student data to file
    @Override
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Networking student data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving networking student data: " + e.getMessage());
        }
    }

    // Read networking student data from file
    public static NetworkingStudent readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            NetworkingStudent student = (NetworkingStudent) ois.readObject();
            System.out.println("Networking student data read from " + fileName);
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading networking student data: " + e.getMessage());
            return null;
        }
    }
}


