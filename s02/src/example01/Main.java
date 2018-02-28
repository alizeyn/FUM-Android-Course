package example01;

public class Main {
    public static void main(String[] args) {

        Course java = new Course("java");
        Address jeraldsHome = new Address("NYC", "Flower", 9816896);
        Address jeraldsSchool = new Address("NYC", "Pink Floyd", 2457552);
        Student jerald = new Student("Jerald", "Joash",
                jeraldsHome, jeraldsSchool, 19.9);
        java.addStudent(jerald);

        Address sarasHome = new Address("Mexico", "Tennesy", 9816896);
        Address sarasSchool = new Address("Mexico", "Johnny Cash", 2457552);
        Student sara = new Student("Sara", "Sonakoa",
                sarasHome, sarasSchool, 13);
        java.addStudent(sara);


        java.roll();
        System.out.println(java.getAverage());
    }
}
