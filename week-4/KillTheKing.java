import java.util.Scanner;

public class KillTheKing {

    public static void main(String[] args) {
        // 0. Data Structures
        String[][] gameBoard = new String[6][6];
        GamePreparation(gameBoard);
        boolean KingDead;
        float turnCnt = 1;
        do {
            System.out.println("Current Turn "+ (int)turnCnt);
            boardRender(gameBoard);
            KingDead = TakingCoordinates(gameBoard, turnCnt);
            turnCnt += 0.5;

        } while (!KingDead);
        printWinner(turnCnt);


    }
    public static void printWinner(float turn){
        System.out.println("Game Over");
        System.out.print("Winner: ");
        if ((turn*10)%10==0) System.out.print("Black");
        else System.out.print("White");
    }

    public static void boardRender(String[][] gameBoard) {
        for (int i = 0; i < 6; i++) {
            DrawLine();
            for (int k = 0; k < 6; k++) {

                System.out.print("|" + gameBoard[i][k]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static void DrawLine() {
        System.out.println("-------------------------");
    }

    public static void GamePreparation(String[][] gameBoard) {
        String[] figuresW = new String[]{"wDw", "wD ", "wQ ", "wK ", "wM ", "wDw"};
        String[] figuresB = new String[]{"bDw", "bD ", "bQ ", "bK ", "bM ", "bDw"};

        System.arraycopy(figuresW, 0, gameBoard[0], 0, 6);
        System.arraycopy(figuresB, 0, gameBoard[5], 0, 6);
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                gameBoard[i][j] = "   ";
            }
        }
    }

    public static boolean TakingCoordinates(String[][] gameBoard, float turns) {
        Scanner coordinatesInput = new Scanner(System.in);
        boolean isPosOurs=false;
        int x;
        int y;
        do {
            System.out.print("Choose a figure: ");
            String Coordinates = coordinatesInput.next();

            x = (Coordinates.charAt(0) - 65);
            y = (Coordinates.charAt(1) - 65);
            if (turns%3!=0 && gameBoard[x][y].contains("D ")) continue;
            isPosOurs = isPositionFree(x, y, gameBoard, turns);
        }
        while (!isPosOurs);
        return NewCoordinates(gameBoard, x, y);
    }

    // Mobility Validation
    public static boolean isPositionFree(int x, int y, String[][] gameBoard, float turns) {
        if (turns == (int)turns) return gameBoard[x][y].contains("w");
        if (turns != (int)turns) return gameBoard[x][y].contains("b");
        return false;
    }

    public static boolean NewCoordinates(String[][] gameBoard, int oldX, int oldY) {
        boolean isMovePossible;
        Scanner coordinatesInput = new Scanner(System.in);
        String Coordinates;
        int x;
        int y;
        do {
            System.out.println("Insert new pos");
            Coordinates = coordinatesInput.next();
            x = (Coordinates.charAt(0) - 65);
            y = (Coordinates.charAt(1) - 65);
            isMovePossible = isMovePossible(x, y, oldX, oldY, gameBoard);

        } while (!isMovePossible);
        return UpdatingPosition(x, y, oldX, oldY, gameBoard);

    }

    public static boolean isMovePossible(int x, int y, int oldX, int oldY, String[][] gameBoard) {
        String figure = gameBoard[oldX][oldY].substring(1);
        if (gameBoard[x][y].substring(0, 1).equals(gameBoard[oldX][oldY].substring(0, 1))) return false;
        switch (figure) {
            case "Dw":
                return movesDwarf(x, y, oldX, oldY);
            case "D ":
                return movesDonkey(x, y, oldX, oldY);
            case "Q ":
                return movesQueen(x, y, oldX, oldY);
            case "K ":
                return movesKing(x, y, oldX, oldY);
            case "M ":
                return movesMachineGun(x, y, oldX, oldY);

        }
        return false;
    }

    // Figures Mobility
    public static boolean movesDwarf(int x, int y, int oldX, int oldY) {
        int[][] Dwarf = new int[2][1];
        Dwarf[0][0] = 1;
        Dwarf[1][0] = 0;

        return (Math.abs(oldX - x) == Dwarf[0][0] && Math.abs(oldY - y) == Dwarf[1][0]);

    }

    public static boolean movesMachineGun(int x, int y, int oldX, int oldY) {
        int[][] MachineGun = new int[2][2];
        MachineGun[0][0] = 1;
        MachineGun[1][0] = 0;
        MachineGun[0][1] = 0;
        MachineGun[1][1] = 1;
        if (Math.abs(oldX - x) == MachineGun[0][0] && Math.abs(oldY - y) == MachineGun[1][0]) return true;
        return (Math.abs(oldX - x) == MachineGun[0][1] && Math.abs(oldY - y) == MachineGun[1][1]);



    }

    public static boolean movesKing(int x, int y, int oldX, int oldY) {
        int[][] King = new int[2][3];
        King[0][0] = 1;
        King[1][0] = 0;
        King[0][1] = 0;
        King[1][1] = 1;
        King[0][2] = 1;
        King[1][2] = 1;
        if (Math.abs(oldX - x) == King[0][0] && Math.abs(oldY - y) == King[1][0]) return true;
        if (Math.abs(oldX - x) == King[0][1] && Math.abs(oldY - y) == King[1][1]) return true;
        return (Math.abs(oldX - x) == King[0][2] && Math.abs(oldY - y) == King[1][2]);

    }

    public static boolean movesQueen(int x, int y, int oldX, int oldY) {
        int[][] Queen = new int[2][1];
        Queen[0][0] = 1;
        Queen[1][0] = 1;
        return  (Math.abs(oldX - x) == Queen[0][0] && Math.abs(oldY - y) == Queen[1][0]);
    }

    public static boolean movesDonkey(int x, int y, int oldX, int oldY) {
        int[][] Donkey = new int[2][3];
        Donkey[0][0] = 2;
        Donkey[1][0] = 0;
        Donkey[0][1] = 0;
        Donkey[1][1] = 2;
        Donkey[0][2] = 2;
        Donkey[1][2] = 2;
        if (Math.abs(oldX - x) == Donkey[0][0] && Math.abs(oldY - y) == Donkey[1][0]) return true;
        if (Math.abs(oldX - x) == Donkey[0][1] && Math.abs(oldY - y) == Donkey[1][1]) return true;
        return (Math.abs(oldX - x) == Donkey[0][2] && Math.abs(oldY - y) == Donkey[1][2]);
    }

    public static boolean UpdatingPosition(int x, int y, int oldX, int oldY, String[][] gameBord) {
        String newPosPawn= gameBord[x][y].substring(1);
        gameBord[x][y] = gameBord[oldX][oldY];
        gameBord[oldX][oldY] = "   ";
        return (newPosPawn.equals("K "));
    }

}
