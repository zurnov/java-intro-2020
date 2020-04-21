package com.company;

import java.util.Scanner;

public class Task3 {

    public  static  void main(String[] args){
    Lover();
    }
    public static void Lover(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a floor level between 0 and 8: ");
        int floor = input.nextInt();
        switch (floor){
            case 0:
                System.out.println("Шшшш как си ма Цвети");
            case 1:
                System.out.println("О лельо Цоне как са децата?");
            case 2:
                System.out.println("Как си Марче?");
            case 3:
                System.out.println("Мераба Ванче");
            case 4:
                System.out.println("ОООООО Грозданке ");
            case 5:
                System.out.println("Стефи кажи на мъжа ти да ми върне зимните гуми!");
            case 6:
                System.out.println("Хелоу Мими");
            case 7:
                System.out.println("Ванчо предай много поздрави на майка ти");
            case 8:
                System.out.println("*Зъбите в асфалта* Ауч");

        }
    }
}
