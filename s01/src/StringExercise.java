public class StringExercise {
    public static void main(String[] args) {

        String string = "java Programming is fun";
        String concat = string + " " + "but I prefer Python :/";

        System.out.println(concat);

        /**
         * note : Strings are immutable.
         */

        String trimNeeded = "a really bad input    ";

        System.out.println(trimNeeded);
        System.out.println(trimNeeded.trim());
        System.out.println(trimNeeded);

        System.out.println("Android is Great OS".contains("Android"));
        System.out.println("Android is Great OS".contains("android"));
        System.out.println("Android is Great OS".toLowerCase().contains("android"));

        /**
         * [0,2)
         */
        System.out.println("We have to respect Freedom".substring(0,2));
    }
}
