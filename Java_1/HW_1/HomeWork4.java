public class HomeWork4 {

    public static void main(String[] args){
        int a = -15, b =13;
        System.out.println(checkSumm(a, b));
    }

    private static boolean checkSumm(int a, int b){
        if (a+b>=10 && a+b<=20)
            return true;
        else
            return false;
    }
}