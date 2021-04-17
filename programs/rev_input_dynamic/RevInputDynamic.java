import java.util.Scanner;
import java.util.ArrayList;

public class RevInputDynamic {
    public static void revInputWithArray() {
        String[] words = new String[0];
        int wordsRead = 0; // keep track of number of words read

        Scanner input = new Scanner(System.in);

        while (true) {
            String nextWord = input.next(); // read next word
            if (nextWord.equals("STOP")) {
                break; // stop reading
            } else {
                if (words.length <= wordsRead) {
                    String[] newWords = new String[wordsRead + 5]; // create a new array of Strings with a larger capacity
                    for (int i = 0; i < wordsRead; ++i) {
                        newWords[i] = words[i]; // copy over all the words
                    }
                    words = newWords; // replace the old words array with the new array
                }
                words[wordsRead] = nextWord; // append nextWord to words
                ++wordsRead;
            }
        }
        for (int i = wordsRead - 1; i >= 0; --i) {
            System.out.print(words[i] + ' ');
        }
        System.out.println();
    }

    public static void revInputWithArrayList() {
        ArrayList<String> words = new ArrayList<String>();

        Scanner input = new Scanner(System.in);

        while (true) {
            String nextWord = input.next(); // read next word
            if (nextWord.equals("STOP")) {
                break; // stop reading
            } else {
                words.add(nextWord); // add nextWord to words
            }
        }
        for (int i = words.size() - 1; i >= 0; --i) {
            System.out.print(words.get(i) + ' ');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        revInputWithArrayList();
    }
}
