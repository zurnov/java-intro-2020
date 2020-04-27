import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RoboticMouseKiller {
    public static void main(String[] args) {

        boolean isRobotOn = true;
        int batteryLeft = 4;


        while (isRobotOn) {
            PrintObjects();
            ChooseObject();
            if(batteryLeft!=0){
               if(isMouseDected() && isFurnitureDestroyed()){
                    batteryLeft--;
                    System.out.println("Nice shot! \n You killed the mouse");
                }
                else {
                   System.out.println ("The mouse is still alive!");
                }
            }
            else{
                System.out.println("There is no charge left! \nGoing to the nearest wall socket. ");
                chargingBattery(batteryLeft);
            }
            isRobotOn=!TurnOffRobot();
        }
        Communicate();

    }


//    static String getRandomFurniture(){ // Generating Random Furniture
//        int random = (int) (Math.random()*3);
//        String objects = new String[] {"Wall", "Chair", "Nothing",}[random];
//        return objects;
//    }

    static void PrintObjects() {
        System.out.println("Choose object:\n" +
                "Chair [1]" +
                " / Wall [2]" +
                " / Nothing [3]");
        System.out.print("Enter the object you choose: ");
    }

    static void ChooseObject() {
        Scanner input = new Scanner(System.in);
        int object = input.nextInt();

        switch (object) {
            case 1:
                System.out.println("Jump");
                break;
            case 2:
                System.out.println("Go sideways");
                break;
            case 3:
                System.out.println("Forward");
                break;
            default:
                System.out.println("Invalid input!\n Try again.");
                ChooseObject();

        }
    }
//    public static boolean isBatteryCharged(int batteryLeft){
//        return  batteryLeft>0;
//    }

    public static int chargingBattery(int batteryLeft){
    while(batteryLeft == 0){
        if(batteryLeft== 0){
            batteryLeft=4;
            System.out.println("Battery charging completed successfully");
        }else {
            System.out.println("Error x03b4d! \nTrying again");
        }

    }
    return batteryLeft;
    }
    public static int NearbyPixels(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount of the nearby pixels: ");
        int pixels = input.nextInt();
        return pixels;
    }
    public static boolean isMouseDected(){
        if(NearbyPixels()%2 == 0){
            System.out.println("Mouse Detected! \nPreparing for extermination...");
            return true;
        }
        else {
            System.out.println("Mouse NOT Detected!");
            return false;
        }

    }
    public static boolean isFurnitureDestroyed(){
        int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
        if(randomNum != 5){
            System.out.println("Your Furniture will be fine :)");
            return true;
        }
        else {
            System.out.println("Oops the furniture got destroyed ");
            return false;
        }

    }
    public static boolean TurnOffRobot(){
        System.out.print("\nStop the robot now ? \n " +
                "[YES] = 1 \n " +
                "[NO] = 0 \n" +
                "Enter your response: " );
        Scanner input = new Scanner(System.in);
        int response = input.nextInt();
        return response == 1;


    }
    public static void Communicate(){
        for(int i = 10; i > 1; i-=2){
            System.out.println("Im a Robot " + i);
        }
    }

}
