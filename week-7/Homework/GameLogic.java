import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic{
    Scanner scanner = new Scanner(System.in);
    private Pole[][] gameBoard;
    private int playerHeight;
    private int playerWidth;
    private int playerState =0;
    private int scans;
    private int defuses;

    private int boardWidth;
    private int boardHeight;
    private int mines;

    public void createField(){
        setData();
        placeTiles();
    }

    private void setData(){
        FileReader fileReader = new FileReader();
        ArrayList<Integer> data = fileReader.ReadFromFile("configurations.txt");
        this.scans=data.get(0);
        this.defuses=data.get(1);
        data = fileReader.ReadFromFile("enemy_teritory.txt");
        this.boardWidth =data.get(0);
        this.boardHeight =data.get(1);
        this.mines=data.get(2);
        this.gameBoard = new Pole[boardHeight][boardWidth];
        if(boardWidth<4 || boardHeight<4 || mines<5) System.exit(-1);
    }
    private void placeTiles(){
        int height1;
        int width1;
        Random random = new Random();
        height1= random.nextInt(boardHeight);
        width1= random.nextInt(boardWidth);
        int toChange=random.nextInt(2);
        int side = random.nextInt(2);
        if(toChange==0){
            if (side==0) height1=0;
            else height1=boardHeight-1;
        }else{
            if (side==0) width1=0;
            else width1=boardWidth-1;
        }
        gameBoard[height1][width1] = new Pole(1);
        playerHeight=height1;
        playerWidth=width1;

        int height2;
        int width2;
        do{

            height2= random.nextInt(boardHeight);
            width2 = random.nextInt(boardWidth);
            toChange=random.nextInt(2);
            side = random.nextInt(2);
            if(toChange==0){
                if (side==0) height2=0;
                else height2=boardHeight-1;
            }else{
                if (side==0) width2=0;
                else width2=boardWidth-1;
            }
        }while (height1 ==height2 || width1==width2);
        gameBoard[height2][width2] = new Pole(2);

        for (int i=0;i<boardHeight;i++){
            for(int j=0;j<boardWidth;j++){
                if(gameBoard[i][j]==null) gameBoard[i][j] = new Pole(60);
            }
        }

        while (mines>0){
            height1= random.nextInt(boardHeight);
            width1 = random.nextInt(boardWidth);
            if(gameBoard[height1][width1].getID()==60) gameBoard[height1][width1].changeID(50);
            mines--;
        }
    }
    public void printField(){
        for(int i=0;i<boardHeight;i++){
            System.out.print(i);
            for (int j=0;j<boardWidth;j++){
                System.out.printf(" %c",gameBoard[i][j].getSymbol());
            }
            System.out.println();
        }
        System.out.print(" ");
        for (int i = 0; i < boardWidth; i++)  System.out.printf(" %d",i);
        System.out.printf("\nScans: %d Defuses: %d\n",scans,defuses);
    }

    public void loop(){
         while (playerState==0){
             printField();
             System.out.println("Insert position:");
             int[] newPos = getPosition();
             System.out.println("1. Scan for mines\n2.Defuse mine\n3.Move");

             int option = scanner.nextInt();
             startOption(option,newPos);
         }
    }

    private void startOption(int chosenOption,int[] newPos){
        switch (chosenOption){
            case 1: scan(newPos); break;
            case 2: defuse(newPos); break;
            case 3: move(newPos); break;
        }
    }
    private void scan(int[] newPos){
        if (scans<=0) return;
        if(playerHeight == newPos[0] && playerWidth+1 == newPos[1]){
            //right
            scans--;
            for(int i=newPos[0]-1;i<=newPos[0]+1;i++){
                for(int j=newPos[1];j<=newPos[1]+1;j++){
                    revealMine(i,j);
                }
            }
        }
        if(playerHeight == newPos[0] && playerWidth == 1+ newPos[1]){
            //left
            scans--;
            for(int i=newPos[0]-1;i<=newPos[0]+1;i++){
                for(int j=newPos[1]-1;j<=newPos[1];j++){
                    revealMine(i,j);
                }
            }
        }
        if(playerHeight +1== newPos[0] && playerWidth == newPos[1]){
            //down
            scans--;
            for(int i=newPos[0];i<=newPos[0]+1;i++){
                for(int j=newPos[1]-1;j<=newPos[1]+1;j++){
                    revealMine(i,j);
                }
            }
        }
        if(playerHeight ==1+ newPos[0] && playerWidth == newPos[1]){
            //up
            scans--;
            for(int i=newPos[0]-1;i<=newPos[0];i++){
                for(int j=newPos[1]-1;j<=newPos[1]+1;j++){
                    revealMine(i,j);
                }
            }
        }

    }

    private void defuse(int[] newPos){
        defuseMine(newPos[0],newPos[1]);
    }

    private void move(int[] newPos){
        int newPosID =gameBoard[newPos[0]][newPos[1]].getID();
        if( newPosID ==5 || newPosID ==50){
            playerState=2;
            return;
        }
        if (newPosID==2){
            playerState=1;
            return;
        }
        gameBoard[playerHeight][playerWidth].changeID(4);
        gameBoard[newPos[0]][newPos[1]].changeID(3);
        playerHeight=newPos[0];
        playerWidth=newPos[1];

    }

    private void revealMine(int height,int width){
        if((height<boardHeight && height>=0) &&((width<boardWidth && width>=0))){
            int id=gameBoard[height][width].getID();
            if(id>10)
            gameBoard[height][width].changeID(id/10);
        }
    }
    private void defuseMine(int height,int width){
        if (defuses<=0) return;
        if((height<boardHeight && height>=0) &&((width<boardWidth && width>=0))){
            int id=gameBoard[height][width].getID();
            if(id==5 || id==50){
                gameBoard[height][width].changeID(3);
                gameBoard[playerHeight][playerWidth].changeID(4);
                playerHeight=height;
                playerWidth=width;
                defuses--;
            }
        }
    }

    private int[] getPosition(){
        String input =scanner.next();
        String[] halves = input.split(":");
        int[] toReturn = new int[2];
        toReturn[0] = Integer.parseInt(halves[0]);
        toReturn[1] = Integer.parseInt(halves[1]);
        if((toReturn[0]== playerHeight+1 ||toReturn[0]== playerHeight-1) && toReturn[1]==playerWidth) {
            return toReturn;
        }
        if((toReturn[1]== playerWidth+1 ||toReturn[1]== playerWidth-1) && toReturn[0]==playerHeight) {
            return toReturn;
        }
        return new int[]{0,0};
    }

    public void endResult(){
        switch (playerState){
            case 1: System.out.print("Victory!"); break;
            case 2:  System.out.print("Defeat!"); break;
        }
    }
}
