public class Syntax {
    public static void main(String[] args) {
        String[] phrases = {"hello", "goodbye", "good morning"};

        System.out.println(phrases.length); // should print "3"

        for (int i = 0; i < phrases.length; ++i) {
            System.out.println(phrases[i]);
        }

        for (String phrase : phrases) {
            System.out.println(phrase);
        }
    }
}
