public class JavaBasis {

    //------- PRIMITIVE DATA TYPES ------
    /**
     * 8-bit
     * [-128, 127]
     */
    byte byteValue;
    /**
     * [-32768, 32767]
     */
    short shortValue;
    /**
     * [ - 2,147,483,648, 2,147,483,647]
     */
    int intValue;

    long longValue;

    float floatValue;

    double doubleValue;

    boolean booleanValue;

    char charValue;



    {


        Animal animal = new Animal();
//        animal.name ="cat";
        animal.setName("Cat");

        String name = animal.getName();

        Animal.TAG = "Animal  Version 2";




    }











    /**
     *  Autoboxing
     *
     */

//    int a = 1;
//    Integer b = a;

    /**
     * Polymorphism
     */
    Animal wolfy = new Wolf();
    Human lucy = new Human("Lucy", "Rey", 28);
    Farm farm = new Farm(lucy, wolfy);


}
