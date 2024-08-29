
package opp.project;
public class Grading {
    private Student[] students;
    private Course[] courses;
    private double[][] scores;

    public Grading(Student[] students, Course[] courses) {
        this.students = students;
        this.courses = courses;
        this.scores = new double[students.length][courses.length];
    }

    public void addStudentScore(Student student, Course course, double score) {
        
        int studentIndex = findStudentIndex(student);
        int courseIndex = findCourseIndex(course);

        if (studentIndex != -1 && courseIndex != -1) {
            scores[studentIndex][courseIndex] = score;
        }
    }

    public double getStudentScore(Student student, Course course) {
        int studentIndex = findStudentIndex(student);
        int courseIndex = findCourseIndex(course);

        if (studentIndex != -1 && courseIndex != -1) {
            return scores[studentIndex][courseIndex];
        }
        return -1; // Score not found
    }

    public void displayAllScores() {
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student ID: " + students[i].getStudentID() + ", Name: " + students[i].getStudentName());
            for (int j = 0; j < courses.length; j++) {
                System.out.println("\tCourse: " + courses[j].getCourseName() + ", Score: " + scores[i][j]);
            }
            System.out.println();
        }
    }

    private int findStudentIndex(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null && students[i].equals(student)) {
                return i;
            }
        }
        return -1;
    }

    private int findCourseIndex(Course course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].equals(course)) {
                return i;
            }
        }
        return -1;
    }
}

