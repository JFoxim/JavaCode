/**
 * Java. Level 2  Lesson 2.
 *
 * @author Shangareev Rinat
 * @version dated 25.11.2017
 */

import java.util.Arrays;
import java.util.ArrayList;

public class MainClass {
   final static int NUMBER_COLUMNS = 4;
   final static int NUMBER_ROWS = 4;
   final static Boolean CHAR_CONTAINS = false;

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        String[][] strArray = new String[NUMBER_COLUMNS][NUMBER_ROWS];
        for (int i = 0; i < NUMBER_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_ROWS; j++) {
                if (CHAR_CONTAINS)
                    strArray[i][j] = String.format("%c", (char)(65+i+j));
                else
                    strArray[i][j] = String.format("%d%d", i, j);
                System.out.print(strArray[i][j] + " ");
            }
            System.out.println();
        }
        try {
              System.out.format("Результат суммирования массива: %d", mainClass.checkArray(strArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }


    private int checkArray(String[][] strArray) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (strArray.length != 4 ||
                strArray[0].length != 4 ||
                strArray[1].length != 4 ||
                strArray[2].length != 4 ||
                strArray[3].length != 4)
            throw new MyArraySizeException("Размер массива не отвечает требуемому размеру 4x4");


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (char ch : strArray[i][j].toCharArray()){
                  if (!Character.isDigit(ch))  {
                      throw new MyArrayDataException("Данные массива содержат нечисловые значения");
                  }
                  else {
                      sum += Integer.parseInt(strArray[i][j]);
                  }
                }
            }

        }
     return sum;
    }
}

class MyArraySizeException extends Exception {
    private String message;
    public String getMessage(){
        return message;
    }
    MyArraySizeException(String message) {
        super(message);
        this.message = message;
    }
}

class MyArrayDataException extends Exception{
    private String message;
    public String getMessage(){
        return message;
    }
    MyArrayDataException(String message){
        super(message);
        this.message = message;
    }
}