
package opp.project;
import java.io.*;

abstract class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int studentID;
    private String studentName;
    private int studentYear;
    private String studentGender;
    private Course[] courses;
    private double[] courseScores;
    private int[] courseCreditHours;
    private double[] GPA;

    public Student(int studentID, String studentName, int studentYear, String studentGender, int numCourses) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentYear = studentYear;
        this.studentGender = studentGender;
        this.courses = new Course[numCourses];
        this.courseScores = new double[numCourses];
        this.courseCreditHours = new int[numCourses];
        GPA = new double[studentYear];
    }
    public double[] getGPA(){
        return GPA;
    }
    public void setGPA(double[] gpa){
        GPA = gpa;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(int studentYear) {
        this.studentYear = studentYear;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public void addCourse(Student student, Course course,int index) {
        this.courses[index] = course;
    }

    public double[] getCourseScores() {
        return courseScores;
    }

    public void setCourseScores(double[] courseScores) {
        this.courseScores = courseScores;
    }

    public int[] getCourseCreditHours() {
        return courseCreditHours;
    }

    public void setCourseCreditHours(int[] courseCreditHours) {
        this.courseCreditHours = courseCreditHours;
    }

    public void addScoreForCourse(int courseIndex, double score, int creditHours) {
        try {
            if (courseIndex < 0 || courseIndex >= courseScores.length)
                throw new IllegalArgumentException("Invalid course index");
            if (score < 0 || score > 100)
                throw new IllegalArgumentException("Invalid score");
            if (creditHours <= 0)
                throw new IllegalArgumentException("Credit hours must be positive");

            courseScores[courseIndex] = score;
            courseCreditHours[courseIndex] = creditHours;
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding score for course: " + e.getMessage());
        }
    }

    public double calculateGPA() {
        double totalScore = 0;
        int totalCreditHours = 0;
        for (int i = 0; i < courseScores.length; i++) {
            totalScore += courseScores[i] * courseCreditHours[i];
            totalCreditHours += courseCreditHours[i];
        }
        try {
            if (totalCreditHours == 0)
                throw new ArithmeticException("No credit hours found for GPA calculation");
            GPA[studentYear-1] = ((totalScore / totalCreditHours)*4)/100;
            return ((totalScore / totalCreditHours)*4)/100;
        } catch (ArithmeticException e) {
            System.out.println("Error calculating GPA: " + e.getMessage());
            return 0.0;
        }
    }

    public double calculateCGPA() {
        double totalGPA = 0;
        for(int i=0;i<studentYear;i++){
            totalGPA += GPA[i]; 
        }
        return totalGPA/studentYear;
    }

    // Save student data to file
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Student data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }

    // Read student data from file
    public static Student readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student student = (Student) ois.readObject();
            System.out.println("Student data read from " + fileName);
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading student data: " + e.getMessage());
            return null;
        }
    }
}
