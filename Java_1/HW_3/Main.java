import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }

    //Задание № 1
    static void task1(){
        System.out.println("Задание № 1.");
        Random random = new Random();
        int c;
        int b = 1;
        Scanner sc = new Scanner(System.in);
        do {
            if (b == 1) {
                c = random.nextInt(10);
                startGame(c);
            }
                System.out.println("«Повторить игру еще раз? 1 – да / 0 – нет».");
                try {
                    b = sc.nextInt();
                } catch (Exception er) {
                    sc = new Scanner(System.in); // к сожадению не нашёл другой способ очистки объекта Scanner
                    b = -1;
                }
                if (b != 0 && b != 1){
                System.out.print("Входная строка имела неверный формат. Допустимые символы 0 и 1.\n");
            }

        }while (b != 0);
        System.out.println("Игра окончена.");
    }

    static void startGame(int c){
        Scanner scan = new Scanner(System.in); //Добавил второй Scaner для нормального обхода ошибки ввода недопустимых символов в блоке try catch.
        int a = 0;
        int n = 1;
        for (int i = 0; i < 3; i++) {
             a = 0;
            System.out.println("Введите число: 0 до 9");
            try {
                a = scan.nextInt();
            } catch (Exception ex) {
                System.out.printf("Входная строка имела неверный формат. Допустимые символы от 0 до 9. Попытка №%d неудачная. \n", n+i);
                scan = new Scanner(System.in);  // к сожадению не нашёл другой способ очистки объекта Scanner
                continue;
            }
            if (a > 0 && a < 10){
                if (a == c) {
                    System.out.printf("Попытка №%d успешная, ответ %d - верный. Поздравляем Вы победили!.\n", n + i, a);
                    break;
                } else if (a < c) {
                    System.out.printf("Попытка №%d неудачная, загаданое число больше %d.\n", n + i, a);
                } else if (a > c) {
                    System.out.printf("Попытка №%d неудачная, загаданое число меньше %d.\n", n + i, a);
                }
            }else{
                System.out.printf("Входная строка имела неверный формат. Допустимые символы от 0 до 9. Попытка №%d неудачная. \n", n+i);
            }
        }
        if (a != c)
           System.out.println(" Вы проиграли.\n");
    }


    //Задание № 2
    static void task2(){
        System.out.println("Задание № 2.");
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("`");
        Random random = new Random();
        int c = random.nextInt(26);
        String word = wordsArray[c];
        String strAnswer = "";
        char[] arrayOut = new char[15];
        do {
            for (int i = 0; i < arrayOut.length; i++) {
                arrayOut[i] = '#';
            }
            System.out.println("Отгадайте слово: ");
            try {
                strAnswer = sc.nextLine().toLowerCase().trim();
            } catch (Exception er) {
                System.out.print("Входная строка имела неверный формат. \n");
                sc = new Scanner(System.in);
                strAnswer = "";
                continue;
            }

            if (!word.equals(strAnswer)) {
                for (int i = 0; i < word.length(); i++) {
                    for (int j = 0; j < strAnswer.length(); j++) {
                        if (word.charAt(i) == strAnswer.charAt(j)) {
                            arrayOut[i] = word.charAt(i);
                        }
                    }
                }
                System.out.println("Ответ не верный. ");
                for (int i = 0; i < arrayOut.length; i++) {
                    System.out.print(arrayOut[i]);
                }
                System.out.print("\n");
            }
        }while (!word.equals(strAnswer));
        System.out.println("Ответ верный. Поздравляем вы победили!");
    }

}