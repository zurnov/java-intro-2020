import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// Това е "подобрена" домашна работа, като има някой добавени неща като 50% да се зареди батерията или пък да продължиш напред само
// акоси написал правилния отоговор Nothing ще трябва да напишете Forward.
//Реших да предам тази домашна защото казахте, че нямате нищо напротив да сме креативни стига да сме изпълнили вашите условия.
// Другата домашна може да намерите под наименованието RoboticMouseKiller v1.
public class RoboticMouseKiller {
    public static void main(String[] args) {

        boolean isRobotOn = true;
        int batteryLeft = 1;


        while (isRobotOn) {

            PrintActions();
            AnsweringFurniture(getRandomFurniture());

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
    public static String getRandomFurniture(){ // Generating Random Furniture
        int random = (int) (Math.random()*3);
        String objects = new String[] {"Wall", "Chair", "Nothing",}[random];
        return objects;
    }
    public static void AnsweringFurniture(String furniture){
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        while (true) {
            if (answer.equals("Jump") && getRandomFurniture().equals("Chair")) {
                System.out.println("Passed successfully");
                break;
            }
            if (answer.equals("Forward") && getRandomFurniture().equals("Nothing")) {
                System.out.println("Passed successfully");
                break;
            }
            if (answer.equals("Go sideways") && getRandomFurniture().equals("Wall")) {
                System.out.println("Passed successfully");
                break;
            }
        }
    }
    public static int chargingBattery(int batteryLeft){
        while(batteryLeft == 0){
        Random random = new Random();
        int n = random.nextInt(2);
        if(n == 1){
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
    public static void PrintActions(){
        System.out.println("You got " + getRandomFurniture() +" in front of you");
        System.out.println("You can choose between Jump / Forward / Go sideways");
    }

}
