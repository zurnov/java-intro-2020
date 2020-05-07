import java.util.Random;
import java.util.Scanner;

public class NumbersSorting {
    static boolean isProgramOn = true;
    static boolean isProgramOff = false;
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the wanted size of your array: ");
        int arraySize = input.nextInt();


        int[] array = new int[arraySize];

        while(isProgramOn){
            PrintUserMenu();
            ChooseAction(arraySize,array);
        }

}

public static void FillingArray(int arraySize, int [] array) {


    for (int i = 0; i < arraySize; i++) {
        Scanner input = new Scanner(System.in);
        int currentNum;
        do {
            System.out.println("Enter value for [" + i + "]: ");
            array[i] = input.nextInt();
            currentNum = array[i];
        } while (currentNum < 0 || currentNum > 100);

    }

}
public static void PrintingArray(int[] array){
    for (int element : array) {
        System.out.print(element);
    }
}
public static void HighestToLowest(int[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 0; j < array.length-i-1;j++){
                if(array[j]> array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

}
    public static void LowestToHighest(int[] array){
        for(int i = 0; i < array.length-1; i++){
            for(int j = 0; j < array.length-i-1;j++){
                if(array[j]< array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

    }
    public static void FindIndex(int[] array){
        System.out.println("Enter the value of your number: ");
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        int k=0;
        for(int i=0;i<array.length;i++){

            if(array[i]==value){
                k=i;
                break;
            }
        }
        System.out.println("The index of you number is ["+k+"]");
    }
    public static void RandomizeArray(int[] array){
        Random random = new Random();
        for(int i = 0; i < array.length;i++){
            int randomPosition = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        PrintingArray(array);
    }
    public static void SumAllNumbers(int[] array){
        int sum=0;
        for(int i = 0 ; i < array.length;i++){
            sum += array[i];
        }
        System.out.println("The sum of all numbers is: " + sum);
    }
    public static void BiggestNumber(int [] array){
        int big=0;
        for (int i = 0; i < array.length;i++){
            if(big < array[i]) big = array[i];
        }
        System.out.println("The biggest number is: "+big);
    }
    public static void SmallestNumber(int [] array){
        int big=100;
        for (int i = 0; i < array.length;i++){
            if(big > array[i]) big = array[i];
        }
        System.out.println("The biggest number is: "+big);
    }
    public static void AvgOfAllNumbers(int[] array){
        double sum=0;
        for(int i = 0 ; i < array.length;i++){
            sum += array[i];
        }
        System.out.println("The average of all numbers is: " + sum/array.length);
    }
    public static void isArraySymmetrical(int[] array){
        for(int i = 0; i < array.length; i++){
            if(i > array.length/2) {
                System.out.println("The array is Symmetrical!");
                break;
            }
            else if(array[i] != array[array.length-1-i]) {
                System.out.println("The array is NOT Symmetrical!");
                break;
            }
        }
    }
    public static void ReverseArray(int[] array){

        for(int i = 0; i < array.length/2;i++){
        int temp = array[i];
            array[i] = array[array.length -i -1];
            array[array.length -i -1] = temp;
        }
        PrintingArray(array);
    }
    public static void PrintUserMenu(){
        System.out.println("\nChoose what you want to do:");
        System.out.println("Filling array [0]");
        System.out.println("Sort the array from highest to lowest [1]");
        System.out.println("Sort the array from lowest to highest [2]");
        System.out.println("Find the index of a number from the array [3]");
        System.out.println("Randomize the array [4]");
        System.out.println("Sum all numbers [5]");
        System.out.println("Find biggest number from the array [6]");
        System.out.println("Find lowest number from the array [7]");
        System.out.println("Find the average number [8]");
        System.out.println("Check the array if its symmetrical [9]");
        System.out.println("Reverse the array [10]");
        System.out.println("Print the array [11]");
        System.out.println("Exit the program [12]");

    }
    public static void ChooseAction(int arraySize, int[] array){
       Scanner input = new Scanner(System.in);
       int action = input.nextInt();
        switch (action) {
            case 0:
                FillingArray(arraySize, array);
                break;
            case 1:
                LowestToHighest(array);
                break;
            case 2:
                HighestToLowest(array);
                break;
            case 3:
                FindIndex(array);
                break;
            case 4:
                RandomizeArray(array);
                break;
            case 5:
                SumAllNumbers(array);
                break;
            case 6:
                BiggestNumber(array);
                break;
            case 7:
                SmallestNumber(array);
                break;
            case 8:
                AvgOfAllNumbers(array);
                break;
            case 9:
                isArraySymmetrical(array);
                break;
            case 10:
                ReverseArray(array);
                break;
            case 11:
                PrintingArray(array);
                break;
            case 12:
                isProgramOn = isProgramOff;
                break;
            default:
                PrintUserMenu();
        }

    }
}
//FillingArray(arraySize,array);
//LowestToHighest(arraySize,array);
//HighestToLowest(arraySize,array);
//PrintingArray(array);
//FindIndex(arraySize,array);
//PrintingArray(array);
//RandomizeArray(arraySize,array);
//SumOfAllNumbers(array);
//BiggestNumber(array);
//SmallestNumber(array);
//AvgOfAllNumbers(array);
//isArraySymmetrical(array);
//ReverseArray(array);
//TODO Working user menu!