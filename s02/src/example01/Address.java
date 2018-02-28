package example01;

public class Address {
    private String city, streetAddress; //default values
    private long zipCode;

    /*
    explain constructors *****
     */
    //Constructor to initialize values;
    public Address(String city, String streetAddress, long zipCode) {
        this.city = city;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address is " + city + " " + streetAddress;
    }
}
