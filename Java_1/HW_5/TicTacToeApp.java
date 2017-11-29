/**
 * Java. Level 1  HomeWork 5. TicTacToe 
 *
 * @author Shangareev Rinat
 * @version dated 13.10.2017
 */

import java.util.*;

class TicTacToeApp{

    public static void main(String[] args) {
        TicTacToe ticTackToe = new TicTacToe(3, 'x', 'o', '.');
        ticTackToe.startGame();
    }

}

class TicTacToe {

   private int size;
   private char dot_x;
   private char dot_0;
   private char dot_empty;
   private Scanner sc = new Scanner(System.in);

    TicTacToe(int size, char dot_x, char dot_0, char dot_empty) {
        this.size = size;
        this.dot_x = dot_x;
        this.dot_0 = dot_0;
        this.dot_empty = dot_empty;
    }

    public void startGame(){
        Map map = new Map(size, dot_empty);
        AI ai = new AI(map);
        map.initMap();
        while (true) {
            humanTurn(map);
            map.printMap();
            if (checkWin(dot_x, map.getArray())) {
                System.out.println("YOU WON!");
                break;
            }
            if (map.isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
            ai.aiTurn(dot_0);
            map.printMap();
            if (checkWin(dot_0, map.getArray())) {
                System.out.println("AI WON!");
                break;
            }
            /*if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }*/
        }
        System.out.println("GAME OVER.");
    }

   private void humanTurn(Map map) {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!map.isCellValid(x, y));
        map.getArray()[y][x] = dot_x;
    }

   private boolean checkWin(char dot, char[][] map) {
        // check horizontals
        if (map[0][0] == dot && map[0][1] == dot && map[0][2] == dot) return true;
        if (map[1][0] == dot && map[1][1] == dot && map[1][2] == dot) return true;
        if (map[2][0] == dot && map[2][1] == dot && map[2][2] == dot) return true;
        // check verticals
        if (map[0][0] == dot && map[1][0] == dot && map[2][0] == dot) return true;
        if (map[0][1] == dot && map[1][1] == dot && map[2][1] == dot) return true;
        if (map[0][2] == dot && map[1][2] == dot && map[2][2] == dot) return true;
        // check diagonals
        if (map[0][0] == dot && map[1][1] == dot && map[2][2] == dot) return true;
        if (map[2][0] == dot && map[1][1] == dot && map[0][2] == dot) return true;
        return false;
    }
}

//Artificial Intelligence
class AI{

    private Map map;
    private Random rand = new Random();

    public AI(Map map) {
       this.map = map;
    }

   public void aiTurn(char dot_o) {
        int x, y;
        do {
            x = rand.nextInt(map.getSize());
            y = rand.nextInt(map.getSize());
        } while (!map.isCellValid(x, y));
        map.getArray()[y][x] = dot_o;
    }
}

class Map {
   private int size;
   private char[][] map;
   private char dot_empty;

   public char[][] getArray(){
       return  map;
   }

   public int getSize(){
       return size;
   }

   Map(int size, char dot_empty){
       this.size = size;
       this.dot_empty = dot_empty;
       this.map = new char[size][size];
   }

   public void initMap() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                map[i][j] = dot_empty;
    }

   public void printMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

   public boolean isMapFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (map[i][j] == dot_empty)
                    return false;
        return true;
    }

   public boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size)
            return false;
        if (map[y][x] == dot_empty)
            return true;
        return false;
    }
}