
package opp.project;

import java.io.*;

class CoaStudent extends Student {
    private static final long serialVersionUID = 1L;

    public CoaStudent(int studentID, String studentName, int studentYear, String studentGender, int numCourses) {
        super(studentID, studentName, studentYear, studentGender, numCourses);
    }

    @Override
    public double calculateGPA() {
        double totalScore = 0;
        int totalCreditHours = 0;
        for (int i = 0; i < getCourseScores().length; i++) {
            totalScore += getCourseScores()[i] * getCourseCreditHours()[i];
            totalCreditHours += getCourseCreditHours()[i];
        }
        try {
            if (totalCreditHours == 0)
                throw new ArithmeticException("No credit hours found for GPA calculation");
            return totalScore / totalCreditHours;
        } catch (ArithmeticException e) {
            System.out.println("Error calculating GPA: " + e.getMessage());
            return 0.0;
        }
    }

    @Override
    public double calculateCGPA() {
        return calculateGPA(); // Assuming same calculation for GPA and CGPA
    }

    // Save COA student data to file
    @Override
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("COA student data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving COA student data: " + e.getMessage());
        }
    }

    // Read COA student data from file
    public static CoaStudent readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            CoaStudent student = (CoaStudent) ois.readObject();
            System.out.println("COA student data read from " + fileName);
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading COA student data: " + e.getMessage());
            return null;
        }
    }
}
