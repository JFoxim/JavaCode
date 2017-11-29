import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        int[] array = {1, 1, 1, 1, 3, 1};
        task6(array);
    }

    static void task1() {
        System.out.println("Задание 1");
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Массив до:     ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.print("\n\rМассив после:  ");
        for (int arr : array) {
            if (arr == 1) {
                arr = 0;
            } else {
                arr = 1;
            }
            System.out.print(arr + " ");
        }
    }

    static void task2() {
        System.out.println("\n\rЗадание 2");
        int[] array = new int[8];
        int[] array2 = {0, 3, 6, 9, 12, 15, 18, 21};
        for (int i = 0; i < array.length; i++) {
            array[i] = array2[i];
        }
        System.out.print(Arrays.toString(array));
    }

    static void task3() {
        System.out.println("\n\rЗадание 3");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Массив до:      ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
        int i = 0;
        System.out.print("\n\rМассив после:  ");
        while (i < array.length) {
            if (array[i] < 6) {
                array[i] = (array[i] * 2);
            }
            System.out.print(array[i] + " ");
            i++;
        }
    }

    static void task4() {
        System.out.println("\n\rЗадание 4");
        int[][] arrSquare = new int[4][4];
        for (int i = 0; i < arrSquare.length; i++) {
            for (int j = 0; j < arrSquare.length; j++){
                if (i == j)
                    arrSquare[i][j] = 1;
                System.out.print(arrSquare[i][j] +" ");
            }
            System.out.println();
        }
    }

    static void task5() {
        System.out.println("Задание 5");
        int[] array = new int[10];
        fillRandomArray(array);
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] < min)
                min = array[i];
            if (array[i]> max)
                max = array[i];
        }
        System.out.print(Arrays.toString(array));
        System.out.println("\n\rМинимальное значение:  "+min);
        System.out.println("Максимальное значение: "+max);
    }

    //Заполнение одномерного массива случайными значениями от -10 до 100
    static void fillRandomArray(int[] array){
        Random random = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100)-10;
        }
    }

    static boolean task6(int[] array) {
        System.out.println("Задание 6");
        boolean res = false;
        int l;
        for (int i = 0, f = 0; i < array.length; i++) {
            f = array[i] + f;
            l = 0;
            for (int j = array.length - 1; j > i; j--) {
                l = array[j] + l;
            }
            if (f == l)
                res = true;
        }
        System.out.print(Arrays.toString(array));
        System.out.println("\n\r"+res);
        return res;
    }
}