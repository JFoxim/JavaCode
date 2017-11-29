
/**
 * Java. Level 1  Lesson 4.
 *
 * @author Shangareev Rinat
 * @version dated 07.10.2017
 */

import java.util.Random;
import java.util.Scanner;

public class TicTackToe {

    final int SIZE = 3;
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';

    char[][] map = new char[SIZE][SIZE];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public static void main(String[] args) {
        new TicTackToe();
    }

    TicTackToe(){
        initMap();
        while (true){
            humanTurn();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("YOU WIN");
                break;
            }
            if (isMapFull()){
                System.out.println("Sorry, DRAW!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)){
                System.out.println("AI WIN");
                break;
            }
            if (isMapFull()){
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER.");
    }

    void initMap(){
        for (int i= 0; i < SIZE; i++)
            for (int j=0; j< SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    void humanTurn(){
        int x, y;
        System.out.printf("Enter X and Y {1..%d}:\n", SIZE);
        do {
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
        }while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    void aiTurn() {
        int x = 0, y = 0, a = 0, b = 0, d1 = 0, d2 = 0;
         for (int i = 0; i < SIZE; i++){
            for (int j = 0, k = map.length -1; j < map.length; j++, k--){
                if (map[i][j] == DOT_X && ++a == map.length-2){
                    x = i;
                    for (y = j; y < map.length; y++) {
                        if (isCellValid(x, y) && a > b) {
                            break;
                        }
                    }
                }
                if (map[j][i] == DOT_X && ++b == map.length-2){
                    y = j;
                    for (x = i; x < map.length; x++) {
                        if (isCellValid(x, y)) {
                             break;
                        }
                    }
                }
                if (map[j][j] == DOT_X && ++d1 == map.length-2){
                    for (y = j; y < map.length; y++) {
                        if (isCellValid(y, y)) {
                            break;
                        }
                    }
                }
                if (map[k][j] == DOT_X && ++d2 == map.length-2){
                    y = j;
                    for (x = k; x < map.length; x++) {
                        if (isCellValid(x, y)) {
                            break;
                        }
                    }
                }
            }
            a = 0;
            b = 0;
        }

        if ((!isCellValid(x, y)) || (x == 0 && y == 0)) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        System.out.println("AI made torn:");
        map[y][x] = DOT_O;
    }


    //Универсальная проверка победы
    boolean checkWin(char dot){
        int g = 0;
        int v = 0;
        int d1 = 0;
        int d2 = 0;
        int s = SIZE;
//         if (SIZE < 4)
//             s = map.length;
//         else
//             s = 4; // Для условия  4-х фишек
        for (int i = 0, k = map.length-1; i < map.length; i++, k--){
            for (int j = 0; j < map.length; j++){
                if (map[i][j] == dot && ++g == s){
                    return true;
                }
                if (map[j][i] == dot && ++v == s){
                    return true;
                }
            }
            g = 0;
            v = 0;
            if (map[i][i] == dot && ++d1 == s){
                return  true;
            }
            if (map[k][i] == dot && ++d2 == s){
                return  true;
            }
        }
        return false;
    }

    boolean isMapFull(){
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return  false;
        return true;
    }

    boolean isCellValid(int x, int y){
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return  false;
    }

}