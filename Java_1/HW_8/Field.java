
/*
 * Java 1. Lesson 8. Game Tic Tac Toe
 * Class: Field
 *
 * @author Shangareev Rinat
 * @version 0.3.1 dated Oct 23, 2017
 */
import java.awt.*;
import java.awt.geom.*; // for Graphics2D

class Field {
    private final int FIELD_SIZE;
    private final int CELL_SIZE;
    private final char HUMAN_DOT = 'x';
    private final char AI_DOT = 'o';
    private final char EMPTY_DOT = '.';
    private final String MSG_DRAW = "Draw, sorry...";
    private final String MSG_HUMAN_WON = "YOU WON!";
    private final String MSG_AI_WON = "AI WON!";
    private char[][] map;
    private String gameOverMsg;

    Field(int field_size, int cell_size) {
        FIELD_SIZE = field_size;
        CELL_SIZE = cell_size;
        map = new char[FIELD_SIZE][FIELD_SIZE];
        init();
    }

    void init() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                map[i][j] = EMPTY_DOT;
        gameOverMsg = null;
    }

    int getSize() { return FIELD_SIZE; }

    char[][] getMap() {return map;}

    char getHumanDot() { return HUMAN_DOT; }

    char getAIDot() { return AI_DOT; }

    boolean isGameOver() { return gameOverMsg != null; }

    String getGameOverMsg() { return gameOverMsg; }

    void setDot(int x, int y, char dot) { // set dot and check fill and win
        map[x][y] = dot;
        if (isMapFull())
            gameOverMsg = MSG_DRAW;
        if (checkWin(HUMAN_DOT))
            gameOverMsg = MSG_HUMAN_WON;
        if (checkWin(AI_DOT))
            gameOverMsg = MSG_AI_WON;
    }

    boolean isMapFull() {
        for (int i = 0; i < FIELD_SIZE; i++)
            for (int j = 0; j < FIELD_SIZE; j++)
                if (map[i][j] == EMPTY_DOT) return false;
        return true;
    }

    boolean checkWin(char dot) {
        // checking horizontals / verticals
        int g = 0;
        int v = 0;
        int d1 = 0;
        int d2 = 0;
        int s = FIELD_SIZE;

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

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1) return false;
        if (map[x][y] == EMPTY_DOT) return true;
        return false;
    }

    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE, i*CELL_SIZE);
            g.drawLine(i*CELL_SIZE, 0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE);
        }
        Graphics2D g2 = (Graphics2D) g; // use Graphics2D
        g2.setStroke(new BasicStroke(5));
        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (map[x][y] == HUMAN_DOT) {
                    g.setColor(Color.blue);
                    g2.draw(new Line2D.Float(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, (x+1)*CELL_SIZE-CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4));
                    g2.draw(new Line2D.Float(x*CELL_SIZE+CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4, (x+1)*CELL_SIZE-CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4));
                }
                if (map[x][y] == AI_DOT) {
                    g.setColor(Color.red);
                    g2.draw(new Ellipse2D.Float(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, CELL_SIZE/2, CELL_SIZE/2));
                }
            }
        }
    }
}