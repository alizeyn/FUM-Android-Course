import java.util.Date;

public class Client {

    private String fristName, LastName;
    private String email;
    /**
     * Gender :
     * Male
     * Female
     * Other
     */
    private String gender;
    private int age;

    public Client(String fristName, String lastName, String email, String gender, int age) {
        this.fristName = fristName;
        LastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Form fillFrom(int seatNumber, Date date) {
        /*
        this method should return from
         */
        return null;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
