import java.util.Scanner;
import java.util.Random;

class MyScanner {

    public static void main(String[] args) {
        int a = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a int number:");
        try {
            a = sc.nextInt();
        } catch (Exception ex) {
            System.out.println("Error input");
        }
        System.out.println(a);
        Random random = new Random();
        for (int i = 0; i < a; i++)
            System.out.print(random.nextInt(10) + " ");
    }
}