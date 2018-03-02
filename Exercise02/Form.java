import java.util.Date;

public class Form {

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
    private int seatNumber;
    private Date date;

    public Form(String fristName, String lastName, String email, String gender, int age, int seatNumber, Date date) {
        this.fristName = fristName;
        LastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.seatNumber = seatNumber;
        this.date = date;
    }
}
