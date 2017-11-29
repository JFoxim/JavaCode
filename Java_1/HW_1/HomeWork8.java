import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class HomeWork8 {
      public static void main(String[] args) {
         Calendar calendar = new GregorianCalendar();
         Date myDay = calendar.getTime();
         int  year = calendar.get(Calendar.YEAR);
         checkLeapYear(year);
    }
   
   private static void checkLeapYear(int year){

        boolean isLeap = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

        if (isLeap)
        {   
            System.out.println(year + " высокосный год.");
        }
         else
        {
            System.out.println(year + " не высокосный год.");        
        }
   }
}