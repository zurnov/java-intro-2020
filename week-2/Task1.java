package com.company;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        RectanglePerimeter();
        RectangleFace();
    }
    public static void RectanglePerimeter(){
        Scanner input = new Scanner(System.in);

        System.out.println("Rectangle Perimeter \nEnter values for a and b");

        System.out.println("Enter value for a: ");
        int a = input.nextInt();

        System.out.println("Enter value for b: ");
        int b = input.nextInt();
        System.out.println("Perimeter: " + (2 * a + 2 * b) );
    }

    public  static  void RectangleFace(){
        Scanner input = new Scanner(System.in);

        System.out.println("Rectangle Face \nEnter values for a and b");

        System.out.println("Enter value for a: ");
        int a = input.nextInt();

        System.out.println("Enter value for b: ");
        int b = input.nextInt();
        System.out.println("Face: " + (a*b) );
    }
}
