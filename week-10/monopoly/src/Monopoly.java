import java.util.Random;

public class Monopoly {
    public static void main(String[] args) {
        int currentPosition = 0;
        final int maxTileSize = 20;
        int whitePlayerPosition = 0;
        int blackPlayerPosition = 0;

        Random random = new Random();
        String[] gameBoard = {"|*|", "|X|", "|X|", "|X|", "|X|",
                "|X|", "|X|", "|X|", "|X|", "|X|",
                "|X|", "|X|", "|X|", "|X|", "|X|",
                "|X|", "|X|", "|X|", "|X|", "|X|"};


        gameBoard = investTilePlacer(gameBoard, random, maxTileSize);
        gameBoard = partyHardTilePlacer(gameBoard, random, maxTileSize);
        gameBoard = chanceTilePlacer(gameBoard, random, maxTileSize);
        gameBoard = stealTilePlacer(gameBoard, random, maxTileSize);
        gameBoard = trapTilePlacer(gameBoard, random, maxTileSize);
        gameBoardRender(gameBoard);



    }

    public static void gameBoardRender(String[] gameBoard) {
        System.out.println(gameBoard[10] + gameBoard[11] + gameBoard[12] + gameBoard[13] + gameBoard[14] + gameBoard[15] + gameBoard[16] + gameBoard[17]);
        System.out.println(gameBoard[9] + "                  " + gameBoard[18]);
        System.out.println(gameBoard[8] + "                  " + gameBoard[19]);
        System.out.println(gameBoard[7] + gameBoard[6] + gameBoard[5] + gameBoard[4] + gameBoard[3] + gameBoard[2] + gameBoard[1] + gameBoard[0]);
    }

    public static int generatingDice(Random random) {

        int dice = random.nextInt(2);
        dice += 1;
        return dice;
    }

    public static String[] trapTilePlacer(String[] gameBoard, Random random, int maxTileSize) {
        for (int i = 1; i < maxTileSize; i++) {
            if (gameBoard[i].equalsIgnoreCase("|X|")) {
                gameBoard[i] = "|T|";

            }
        }
        return gameBoard;
    }

    public static String[] investTilePlacer(String[] gameBoard, Random random, int maxTileSize) {
        int randomTile;
        for (int i = 0; i < 3; ) {
            randomTile = random.nextInt(maxTileSize - 1);
            if (gameBoard[randomTile].equalsIgnoreCase("|X|")) {
                gameBoard[randomTile] = "|I|";
                i++;
            }

        }
        return gameBoard;
    }

    public static String[] partyHardTilePlacer(String[] gameBoard, Random random, int maxTileSize) {
        int randomTile;
        for (int i = 0; i < 3; ) {
            randomTile = random.nextInt(maxTileSize - 1);
            if (gameBoard[randomTile].equalsIgnoreCase("|X|")) {
                gameBoard[randomTile] = "|P|";
                i++;
            }
        }
        return gameBoard;
    }

    public static String[] chanceTilePlacer(String[] gameBoard, Random random, int maxTileSize) {
        int randomTile;
        for (int i = 0; i < 3; ) {
            randomTile = random.nextInt(maxTileSize - 1);
            if (gameBoard[randomTile].equalsIgnoreCase("|X|")) {
                gameBoard[randomTile] = "|C|";
                i++;
            }
        }
        return gameBoard;
    }

    public static String[] stealTilePlacer(String[] gameBoard, Random random, int maxTileSize) {
        int randomTile;
        for (int i = 0; i < 3; ) {
            randomTile = random.nextInt(maxTileSize - 1);
            if (gameBoard[randomTile].equalsIgnoreCase("|X|")) {
                gameBoard[randomTile] = "|S|";
                i++;
            }
        }
        return gameBoard;
    }


    }


