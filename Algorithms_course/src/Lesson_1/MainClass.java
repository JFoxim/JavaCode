package Lesson_1;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("POW: " + MyPow.pow(2, 3));
        System.out.println("POW (log): "+ LogPow.power(2,3));
        System.out.println("Min value array: " + ArrayMinValue.search(new double[]{2, 4, 9, 6, 1}));
        System.out.println("Average value array: " + AverageArray.search(new double[]{2, 0, 9, 6, 1}));

    }
}

//Сложность O(n)
//Применил правило 1 - алгоритм выполняет действий n раз
class MyPow{
    public static int pow(int x, int n){
     int res = x;
     if (n == 0) return 1;
     for (int i = 1; i < n; i++) {
         res = res * x;
     }
      return  res;
    }
}

class LogPow{
    public static int power(int b, int s) {
        int res = 1;
        while (s != 0){
            if (s % 2 ==0){
                b*=b;
                s/=2;
            }else{
               s--;
               res*=b;
            }
        }
        return res;
    }
}

// Сложность O(n)
// Применил правило 1 - алгоритм выполняет действий n раз
 class ArrayMinValue{
    public static double search(double[] arr) {
        double res = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
           if (res > arr[i+1]) {
               res = arr[i+1];
           }
        }
        return res;
    }
 }

// Сложность O(n)
// Применил правила 1 и 5 (константами можно принебречь)
 class AverageArray{
    public static double search(double[] arr){
        double res = arr[0];
        for (int i = 1; i < arr.length; i++){
            res = res + arr[i];
        }
        return res/arr.length;
    }
 }
