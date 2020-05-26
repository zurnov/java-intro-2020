
public class Maina {
    public static void main(String[] args) {
        System.out.println("Use *:* to separate ne numbers. Example: 4:3");
        GameLogic gameLogic = new GameLogic();
        gameLogic.createField();
        gameLogic.loop();
        gameLogic.endResult();
    }

}
