package example01;

public class Course {
    private String courseName;
    private Student[] students;
    private int studentsNumber;  // default value == 0
    public static int MAX_STUDENTS_NUMBER = 5;


    public Course(String courseName) {
        this.courseName = courseName;
        //create an array;
        this.students = new Student[MAX_STUDENTS_NUMBER];

    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students[studentsNumber++] = student;
    }

    public double getAverage() {
        double sum =0;
        for (int i = 0; i < studentsNumber; i++) {
            sum += students[i].getCourseScore();
        }
        return sum / studentsNumber;
    }

    public void roll() {
        for (int i =0 ; i < studentsNumber ; i++) {
            System.out.println(students[i]);
        }
    }
}
