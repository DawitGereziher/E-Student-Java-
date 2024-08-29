
package opp.project;
import java.io.*;
import java.util.Scanner;

public class StudentGradingSystem {
    private Student[] students;
    private Course[] courses;
    private int studentCount;
    private int courseCount;
    private final int MAX_STUDENTS = 100;
    private final int MAX_COURSES = 4; // Limiting to four courses
    public StudentGradingSystem() {
        students = new Student[MAX_STUDENTS];
        courses = new Course[MAX_COURSES];
        studentCount = 0;
        courseCount = 0;
        courses[0] = new ProgrammingCourse("P101", "Introduction to Programming");
        courses[1] = new ComputerNetwork("CN101", "Computer Networks");
        courses[2] = new CoaCourse("COA101", "Computer Organization and Architecture");
        courses[3] = new OperatingSystemCourse("OS101", "Operating Systems");
        courseCount = 4; // Update course count
    }

    public void addStudent(Student student, int numCourses, int year) {
        if (studentCount < MAX_STUDENTS) {
            students[studentCount++] = student;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Maximum number of students reached.");
        }
        if(year>1){
            double[] gpa = new double[year];
            Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter GPA");
        for(int i=0;i<year-1;i++){
        System.out.println("Enter the year " + (i+1) + " GPA");
        gpa[i] = scanner.nextDouble();
            if(gpa[i]>4 || gpa[i]<0)
            while(gpa[i]>4 || gpa[i]<0){
            System.out.println("Enter a Valid Grade Between 0-4");
            gpa[i] = scanner.nextDouble();
            }
        }
            student.setGPA(gpa);
        }
        if (studentCount < MAX_STUDENTS) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding Courses to Student:");
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter course code for course " + (i + 1) + ": ");
            String courseCode = scanner.next();
            Course course = findCourseByCode(courseCode);
            if (course != null) {
                student.addCourse(student, course, i);
                System.out.println("Course " + course.getCourseName() + " added successfully to the student.");
            } else {
                System.out.println("Course with code " + courseCode + " not found.");
            }
        }
        students[studentCount++] = student;
        System.out.println("Student added successfully.");
    } else {
        System.out.println("Maximum number of students reached.");
    }
    }

    // Add course method
    public void addCourse(Course course) {
        if (courseCount < MAX_COURSES) {
            courses[courseCount++] = course;
            System.out.println("Course added successfully.");
        } else {
            System.out.println("Maximum number of courses reached.");
        }
    }

    // Add student score method
    public void addStudentScore(Student student,int creditHour, Course course, double score) {
        if(student!=null){
        course.addStudentScore(student, score, creditHour);
        
        System.out.println("Score added successfully.");
    }
    }
    
    public double calculateGPA(Student student) {
        return student.calculateGPA();
    }

    
    public double calculateCGPA(Student student) {
        return student.calculateCGPA();
    }

    
    public void saveStudentToFile(Student student) {
        String fileName = "student_" + student.getStudentID() + ".dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(student);
            System.out.println("Student data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }

    public Student readStudentFromFile(int studentID) {
        String fileName = "student_" + studentID + ".dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student student = (Student) ois.readObject();
            System.out.println("Student data read from " + fileName);
            return student;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading student data: " + e.getMessage());
            return null;
        }
    }

    // Save course to file method
    public void saveCourseToFile(Course course) {
        String fileName = "course_" + course.getCourseCode() + ".dat";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(course);
            System.out.println("Course data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving course data: " + e.getMessage());
        }
    }

    // Read course from file method
    public Course readCourseFromFile(String courseCode) {
        String fileName = "course_" + courseCode + ".dat";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Course course = (Course) ois.readObject();
            System.out.println("Course data read from " + fileName);
            return course;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading course data: " + e.getMessage());
            return null;
        }
    }

    // Display menu method
    public void displayMenu() {
        System.out.println("Welcome to Student Grading System!");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Add Student Score");
        System.out.println("4. Calculate GPA");
        System.out.println("5. Calculate CGPA");
        System.out.println("6. Search a Student");
        System.out.println("7. Update Student Detail");
        System.out.println("8. Update Course Detail");
        System.out.println("9. Display all Student Detail");
        System.out.println("10. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Grading grading = new Grading(students, courses);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    boolean x=false;
                    while(!x){
                    try {
                      
                        System.out.print("Enter an Integer student ID: ");
                        
                        int studentID = scanner.nextInt();
                        System.out.print("Enter student name: ");
                        String studentName = scanner.next();
                        System.out.print("Enter student year: ");
                        int studentYear = scanner.nextInt();
                        if(studentYear > 5 || studentYear<0)
                        while(studentYear > 4 || studentYear<1){
                        System.out.println("Invalid Year Try To Enter 1-4");
                        studentYear = scanner.nextInt();
                        }
                        System.out.print("Enter student gender: ");
                        boolean y = false;
                        while(!y){
                        String studentGender = scanner.next();
                        if(studentGender.equalsIgnoreCase("male") || studentGender.equalsIgnoreCase("female")){
                            y = true;
                        
                        System.out.println("Enter Number Of Courses: ");
                        int numCourses = scanner.nextInt();
                        if(numCourses > 5 || numCourses<0)
                            while(numCourses > 5 || numCourses<0){
                            System.out.println("Maximum Number Of Courses are 4 Try to Enter Betweeen 1-4");
                            numCourses = scanner.nextInt();
                            }
                        
                        System.out.println("Which Department Student Do You want To Create");
                        System.out.println("1. Programming Student: ");
                         System.out.println("2. Networking Student");
                          System.out.println("3. CoaStudent");
                           System.out.println("4. Operating System: ");
                           int n = scanner.nextInt(); 
                        
                        
                        switch (n){
                            case 1:Student newStudent = new ProgrammingStudent(studentID, studentName, studentYear, studentGender, numCourses);
                            addStudent(newStudent, numCourses, studentYear);
                        saveStudentToFile(newStudent);
                            break;
                            case 2:Student newStudent1 = new NetworkingStudent(studentID, studentName, studentYear, studentGender, numCourses);
                            addStudent(newStudent1, numCourses, studentYear);
                            saveStudentToFile(newStudent1);
                            break;
                            case 3:Student newStudent2 = new CoaStudent(studentID, studentName, studentYear, studentGender, numCourses);
                            addStudent(newStudent2, numCourses, studentYear);
                            saveStudentToFile(newStudent2);
                            break;
                            case 4: Student newStudent3 = new OperatingSystemStudent(studentID, studentName, studentYear, studentGender, numCourses);
                            addStudent(newStudent3, numCourses, studentYear);
                            saveStudentToFile(newStudent3);
                            break;
                            default: System.out.println("error try to enter a number from 1 to 4");
                        }
}
                        else
                            System.out.println("Try to enter a valid Gender Either Male or Female");
                        }
                        
                        x = true;
                    } catch (Exception e) {
                        System.out.println("Error adding student: " + e.getMessage());
                        x = false;
                        scanner.nextLine();
                    }}
                    break;
                case 2:
                    
                    try {
                        System.out.print("Enter course code: ");
                        String courseCode = scanner.next();
                        System.out.print("Enter course name: ");
                        String courseName = scanner.next();
                        Course newCourse = new ProgrammingCourse(courseCode, courseName);
                        addCourse(newCourse);
                        saveCourseToFile(newCourse);
            
                    } catch (Exception e) {
                        System.out.println("Error adding course: " + e.getMessage());
                        
                    }
                    break;
                case 3:
                    boolean id = false;
                    while(!id){
                    try {
                        System.out.print("Enter student ID: ");
                        int studentIDScore = scanner.nextInt();
                        System.out.print("Enter course code: ");
                        String courseCodeScore = scanner.next();
                        System.out.print("Enter score: ");
                        double score = scanner.nextDouble();
                        System.out.println("Enter Credit Hour");
                        int creditHour = scanner.nextInt();

                        Student studentScore = findStudentByID(studentIDScore);
                        Course courseScore = findCourseByCode(courseCodeScore);
                           
                        if (studentScore == null || courseScore == null) {
                            System.out.println("Student or course not found!");
                        } else {
                            
                            addStudentScore(studentScore, creditHour, findCourseByCode(courseCodeScore), score);
                            grading.addStudentScore(studentScore, findCourseByCode(courseCodeScore), score);
                            saveStudentToFile(studentScore);
                            saveCourseToFile(courseScore);
                        }
                        id = true;
                    } catch (Exception e) {
                        System.out.println("Error adding score: " + e.getMessage());
                        scanner.next();
                    }}
                    break;
                case 4:
                    boolean id1 = false;
                    while(!id1){
                    try {
                        System.out.print("Enter student ID: ");
                        int studentIDGPA = scanner.nextInt();
                        Student studentGPA = findStudentByID(studentIDGPA);
                        if (studentGPA == null) {
                            System.out.println("Student not found!");
                        } else {
                             double gpa = calculateGPA(studentGPA);
            System.out.println("GPA: " + gpa);

            // Demonstrate calculating GPA using Grading
            double gpaFromGrading = calculateGPA(studentGPA);
            System.out.println("GPA (Calculated using Grading): " + gpaFromGrading);
                        }
                        id1 = true;
                    } catch (Exception e) {
                        System.out.println("Error calculating GPA: " + e.getMessage());
                        scanner.next();
                    }}
                    break;
                case 5:
                    boolean id2 = false;
                    while(!id2){
                    try {
                        System.out.print("Enter student ID: ");
                        int studentIDCGPA = scanner.nextInt();
                        Student studentCGPA = findStudentByID(studentIDCGPA);
                        if (studentCGPA == null) {
                            System.out.println("Student not found!");
                        } else {
                            double cgpa = calculateCGPA(studentCGPA);
                            System.out.println("CGPA: " + cgpa);
                        }
                        id2 = true;
                    } catch (Exception e) {
                        System.out.println("Error calculating CGPA: " + e.getMessage());
                        scanner.next();
                    }}
                    break;
                case 6:
                    boolean id3 = false;
                    while(!id3){
                    try {
                        System.out.print("Enter student ID to search: ");
                        int searchID = scanner.nextInt();
                        Student foundStudent = findStudentByID(searchID);
                        if (foundStudent != null) {
                            System.out.println("Student found:");
                            System.out.println("STUDENT ID: " + foundStudent.getStudentID());
                            System.out.println("STUDENT Name: " + foundStudent.getStudentName());
                            System.out.println("STUDENT Year: " + foundStudent.getStudentYear());
                            System.out.println("STUDENT Gender: " + foundStudent.getStudentGender());
                            System.out.println();
                            System.out.println("This Student Takes The Following COURSES");
                            System.out.println();
                            for(int i=0;i<foundStudent.getCourses().length;i++){
                                if(foundStudent.getCourses()[i]!=null){
                                System.out.println("COURSE NAME: " + foundStudent.getCourses()[i].getCourseName());
                    System.out.println("GRADE: " + scoreToGrade(foundStudent.getCourseScores()[i]));
                    System.out.println("CREDIT HOUR: " + foundStudent.getCourseCreditHours()[i]);}
                                System.out.println();
                            }
                        } else {
                            System.out.println("Student with ID " + searchID + " not found.");
                        }
                        id3 = true;
                    } catch (Exception e) {
                        System.out.println("Error searching student: " + e.getMessage());
                        scanner.next();
                    }}
                    break;
                case 7:
                    boolean id4 = false;
                    while(!id4){
                    try {
                        System.out.print("Enter student ID to update: ");
                        int updateID = scanner.nextInt();
                        Student studentToUpdate = findStudentByID(updateID);
                        if (studentToUpdate != null) {
                            System.out.print("Enter new student name: ");
                            String newName = scanner.next();
                            System.out.print("Enter new student year: ");
                            int newYear = scanner.nextInt();
                            System.out.print("Enter new student gender: ");
                            String newGender = scanner.next();
                            studentToUpdate.setStudentName(newName);
                            studentToUpdate.setStudentYear(newYear);
                            studentToUpdate.setStudentGender(newGender);
                            saveStudentToFile(studentToUpdate);
                            System.out.println("Student details updated successfully.");
                        } else {
                            System.out.println("Student with ID " + updateID + " not found.");
                        }
                        id4 = true;
                    } catch (Exception e) {
                        System.out.println("Error updating student detail: " + e.getMessage());
                        scanner.next();
                    }}
                    break;
                case 8:
                    // Update Course Detail
                    try {
                        System.out.print("Enter course code to update: ");
                        String updateCode = scanner.next();
                        Course courseToUpdate = findCourseByCode(updateCode);
                        if (courseToUpdate != null) {
                            System.out.print("Enter new course name: ");
                            String newName = scanner.next();
                            courseToUpdate.setCourseName(newName);
                            saveCourseToFile(courseToUpdate);
                            System.out.println("Course details updated successfully.");
                        } else {
                            System.out.println("Course with code " + updateCode + " not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error updating course detail: " + e.getMessage());
                    }
                    break;
                case 9:displayAllStudents();
                        break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 10);
        scanner.close();
    }

   private Student findStudentByID(int studentID) {
    for (int i = 0; i < studentCount; i++) {
        if (students[i] != null && students[i].getStudentID() == studentID) {
            return students[i];
        }
    }
    return readStudentFromFile(studentID);
}


    private Course findCourseByCode(String courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseCode().equals(courseCode)) {
                return courses[i];
            }
        }
        return readCourseFromFile(courseCode);
    }
    public char scoreToGrade(double score){
        if(score<100 && score>80)
          return 'A';
        else if(score>70 && score<80)
          return 'B';
        else if(score>60 && score<70)
            return 'C';
        else if(score>50 && score<60)
           return 'D';
        else if(score>0 &&score<50)
            return 'F';
        else 
            return 'X';
    }

    public void displayAllStudents() {
    System.out.println("All Student Details:");
    for (Student student : students) {
        if(student!=null)
        System.out.println(student);
    }

    try {
        File folder = new File(".");
        File[] files = folder.listFiles((dir, name) -> name.startsWith("student_") && name.endsWith(".dat"));
        if (files != null && files.length > 0) {
            for (File file : files) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    Student studentFromFile = (Student) ois.readObject();
                    if(studentFromFile!=null){
                    System.out.println("STUDENT NAME:" + studentFromFile.getStudentName());
                    System.out.println("STUDENT ID: " + studentFromFile.getStudentID());
                    System.out.println("STUDENT GENDER: " + studentFromFile.getStudentGender());
                    System.out.println("STUDENT YEAR: " + studentFromFile.getStudentYear());
                    System.out.println();
                            System.out.println("This Student Takes The Following COURSES");
                            System.out.println();
                    for(int i=0;i<studentFromFile.getCourses().length;i++){
                        if(studentFromFile.getCourses()[i]!=null){
                    System.out.println("COURSE NAME: " + studentFromFile.getCourses()[i].getCourseName());
                    System.out.println("GRADE: " + scoreToGrade(studentFromFile.getCourseScores()[i]));
                    System.out.println("CREDIT HOUR:" + studentFromFile.getCourseCreditHours()[i]);
                        System.out.println();
                        }}}
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Error reading student data from file: " + file.getName() + ", " + e.getMessage());
                }
                System.out.println();
                System.out.println();
                System.out.println();
            }
        } else {
            System.out.println("No student data found in files.");
        }
    } catch (Exception e) {
        System.out.println("Error searching student data in files: " + e.getMessage());
    }
}

    public static void main(String[] args) {
        StudentGradingSystem system = new StudentGradingSystem();
        system.run();
    }
}