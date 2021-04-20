import java.util.Scanner;

public class RevInput {
    public static void revInputNoArray() {
        String w1, w2, w3, w4, w5, w6;
        Scanner input = new Scanner(System.in);
        w1 = input.next();
        w2 = input.next();
        w3 = input.next();
        w4 = input.next();
        w5 = input.next();
        w6 = input.next();
        System.out.println(w6 + ' ' + w5 + ' ' + w4 + ' ' + w3 + ' ' + w2 + ' ' + w1);
    }

    public static void revInputWithArray() {
        String[] words = new String[6];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 6; ++i) {
            words[i] = input.next();
        }
        for (int i = 5; i >= 0; --i) {
            System.out.print(words[i] + ' ');
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean array_version = true;
        if (array_version) {
            revInputWithArray();
        } else {
            revInputNoArray();
        }
    }
}
