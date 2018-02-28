package example01;

public class Student {
    private String firstName;
    private String lastName;
    private Address homeAdress;
    private Address schoolAdress;
    private double courseScore;

    public Student(String firstName, String lastName, Address homeAdress, Address schoolAdress, double courseScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAdress = homeAdress;
        this.schoolAdress = schoolAdress;
        this.courseScore = courseScore;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(Address homeAdress) {
        this.homeAdress = homeAdress;
    }

    public Address getSchoolAdress() {
        return schoolAdress;
    }

    public void setSchoolAdress(Address schoolAdress) {
        this.schoolAdress = schoolAdress;
    }

    public double getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(double courseScore) {
        this.courseScore = courseScore;
    }

    //toString
    @Override
    public String toString() {
        return "Student is " + firstName + " " + lastName;
    }
}
