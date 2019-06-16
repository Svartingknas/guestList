package com.company;
import java.util.Scanner;

public class Main {

    static String[] guests = new String[10];
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        insertTestNames();

        do {
            displayGuests();
            displayMenu();
            int option = getOption();
            if (option == 1){
                addGuest();
            } else if(option == 2){
                renameGuest();
            } else if (option == 3){
                insertGuest();
            } else if(option == 4){
                removeGuest();
            }
            else if (option == 5){
                System.out.println("Exiting...");
                break;
            }

        } while (true);

    }
    static void displayGuests(){

        System.out.println("______________________________\n - Guests - \n");
        boolean isEmpty = true;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                System.out.println((i + 1) + ". " + guests[i]);
                isEmpty = false;
            }
        }
        if (isEmpty){
            System.out.println("The guest list is empty");
        }
    }

    static void displayMenu(){
        System.out.println();
        System.out.println("______________________________ \n -Menu-\n");
        System.out.println("1 - Add Guest");
        System.out.println("2 - Rename Guest");
        System.out.println("3 - insert Guest");
        System.out.println("4 - Remove Guest");
        System.out.println("5 - Exit");

    }
    static int getOption(){
        System.out.print("Option: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }


    static void addGuest(){
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                System.out.print("Name: ");
                guests[i] = scanner.nextLine();
                break;
            }
        }

    }

    static void renameGuest(){
        System.out.println("Enter number of guest to rename: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num >= 1 && num <= 10 && guests[num -1] != null) {

            System.out.print("Name: ");
            String name = scanner.nextLine();
            guests[num - 1] = name;
        }else {
            System.out.println("\n Error, no guest exists with that number. ");
        }
    }

    static void insertGuest(){
        System.out.println("Enter number of guest to insert: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num >= 1 && num <= 10 && guests[num -1] != null) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            for (int i = guests.length -1; i > num-1; i--){
                guests[i] = guests[i - 1];
            }
            guests[num - 1] = name;
        }  else {
            System.out.println("\n Error, no guest exists with that number. ");
        }

    }

    static void removeGuest() {
//        System.out.print("Name: ");
//        String name = scanner.next();
//        for (int i = 0; i < guests.length; i++) {
//            if (guests[i] != null && guests[i].equals(name)) {
//                guests[i] = null;
//                break;
//            }
//        }
        System.out.print("Enter number of guest to remove: ");
        int num = scanner.nextInt();
        if (num >= 1 && num <= 10 && guests[num -1] != null) {
            guests[num - 1] = null;
            String[] temp = new String[guests.length];
            int ti = 0;
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null) {
                    temp[ti] = guests[i];
                    ti++;
                }
            }
            guests = temp;
        } else {
            System.out.println("\n Error, no guest exists with that number. ");
        }
    }


    static void insertTestNames(){
        guests[0] = "Jacob";
        guests[1] = "Edward";
        guests[2] = "Rose";
        guests[3] = "Molly";
        guests[4] = "Christopher";
    }


}