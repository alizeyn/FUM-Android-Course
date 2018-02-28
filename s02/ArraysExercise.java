import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ArraysExercise {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        byte[] byteArray = new byte[2048];


        /**
         * List Concept
         */

        ArrayList<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("Ruby");
        programmingLanguages.add("Php");
        programmingLanguages.add("Python");

        System.out.println(programmingLanguages.get(0));

        ArrayList<Animal> animals = new ArrayList<>();
        Animal cat = new Animal();
        Animal dog = new Animal();
        animals.add(cat);
        animals.add(dog);


        HashMap<Integer, String> godsMap = new HashMap<>();
        godsMap.put(1556565679, "Richard Stallman");
        godsMap.put(1287459225, "Linux Torvalds");

        System.out.println(godsMap.get(1556565679));

    }
}
