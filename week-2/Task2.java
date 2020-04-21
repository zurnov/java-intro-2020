package com.company;
import java.util.Scanner;

public class Task2 {

public static void main(String [] args){
        DaysInMonths();
}
public  static void DaysInMonths(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a month: ");
    String month = input.nextLine();
    if(month.equals("January") || month.equals("March") || month.equals("May") ||month.equals("July") ||
            month.equals("August") || month.equals("October") || month.equals("December")) {
        System.out.println(month + " has 31 days");
    }
    if(month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")){
        System.out.println(month + " has 30 days");
    }

    if(month.equals("February")){
        System.out.println(month + " has 28 days");
    }


    }

}
