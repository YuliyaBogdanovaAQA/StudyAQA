/* Работае не только для SIZE = 5, DOTS_TO_WIN =4 (Выставлен по условиям задания).
Для других значений SIZE b DOTS_TO_WIN код тоже рабочий.
 */


package school.lesson2;


import java.util.Random;
import java.util.Scanner;

public class TaskTwelveOverOne {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        boolean a = false, b = false, c = false, d = false;
        int counterHorizon, counterVertical, toRightDawn, toLeftDawn;
        for (int i = 0; i < SIZE; i++) {
            counterHorizon = 0;
            counterVertical = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    counterHorizon++;
                } else if (map[i][j] == DOT_EMPTY) {
                    counterHorizon = 0;
                }
                if (map[j][i] == symb) {
                    counterVertical++;
                } else if (map[i][j] == DOT_EMPTY) {
                    counterVertical = 0;
                }
            }
            if (counterHorizon == DOTS_TO_WIN || counterVertical == DOTS_TO_WIN) {
                b = true;
            }
        }

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            counterHorizon = 0;
            counterVertical = 0;
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                if (map[i][j] == symb) {
                    counterHorizon++;
                }
                if (map[j][i] == symb) {
                    counterVertical++;
                }
            }
            if (counterHorizon == DOTS_TO_WIN || counterVertical == DOTS_TO_WIN) {
                a = true;
            }
        }

        toRightDawn = 0;
        toLeftDawn = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                toRightDawn++;
            } else if (map[i][i] == DOT_EMPTY) {
                toRightDawn = 0;
            }
            if (map[i][SIZE - i - 1] == symb) {
                toLeftDawn++;
            } else if (map[i][SIZE - i - 1] == DOT_EMPTY) {
                toLeftDawn = 0;
            }
        }
        if (toRightDawn == DOTS_TO_WIN || toLeftDawn == DOTS_TO_WIN) {
            c = true;
        }

        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                toRightDawn++;
                if (map[i][SIZE - i - 1] == symb) {
                    toLeftDawn++;
                }
            }
            if (toRightDawn == DOTS_TO_WIN || toLeftDawn == DOTS_TO_WIN) {
                d = true;
            }
        }

        if (a || b || c || d) {
            return true;
        } else
            return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) +
                " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}