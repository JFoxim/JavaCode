package Lesson_5;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("RecPOW: " + RecPow.pow(5, 4));
        HanoiTowers.moveDisk(3, 'A', 'B', 'C');

    }
}

class Backpack{
    public static int getCost(int cost, int weight){
        int i = 0;

        return i;
    }
}

class RecPow{
    public static int pow(int x, int n){
        int res = x;
        if (n == 0) return 1;
        else if(n >= 0) {
              res *= pow(x, --n);
            }
        return  res;
    }
}

class HanoiTowers
{
    public static void moveDisk(int num, char first, char second, char third)
    {
        if(num == 1)
            System.out.println("Диск 1 из " + first + " в "+  third);
        else
        {
            moveDisk(num-1, first,  third, second);
            System.out.println("Диск " + num + " из " + first + " в "+  third);
            moveDisk(num-1, second, first,  third);
        }
    }
}




