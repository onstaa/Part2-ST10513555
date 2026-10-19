/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.loginandtesters;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registration and login");
        System.out.println("                                           ");

        //Gathering Users information
        System.out.println("Please enter your first name");
        String FirstName = scanner.nextLine();
        System.out.println("Please enter your Last name");
        String Surname = scanner.nextLine();
        System.out.println("Please enter your username");
        String Username = scanner.nextLine();
        System.out.println("Please enter a password");
        String Password = scanner.nextLine();
        System.out.println("Please enter your Cell Phone number");
        String CellNo = scanner.nextLine();

        //Creating an object for registration 
        Login registration = new Login(FirstName, Surname, Username, Password, CellNo);

        //resigstering the user
        String registrationMessage = registration.registerUser();

        System.out.println("");
        System.out.println(registrationMessage);

        //Continues onces the login was a success
        if (registration.checkUser()
                && registration.checkPasswordCom()
                && registration.checkCellPhoneNumber()) {
            System.out.println();
            System.out.println("\n=====================================");
            System.out.println("                Login                  ");
            System.out.println("=======================================");

            System.out.println("Please enter your username:");
            String loginUsername = scanner.nextLine();

            System.out.println("Please enter your password:");
            String loginPassword = scanner.nextLine();

            boolean LoginSuccesFul = registration.LoginUser(loginUsername, loginPassword);

            System.out.println();
            System.out.println(registration.returnStatusForlogin(LoginSuccesFul));

            if (LoginSuccesFul) {
                System.out.println();
                System.out.println("Welcome to QuickChat.");
                System.out.println("How many messages would you like to send?");
                int NoOfMessages = scanner.nextInt();
                scanner.nextLine();

                boolean running = true;
                int TotalMessages = 0;

                while (running) {
                    System.out.println();
                    System.out.println("Please pick a option:");
                    System.out.println("1. Send Message");
                    System.out.println("2. Show recenetly sent messages");
                    System.out.println("3. Quit");

                    int option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            if (TotalMessages < NoOfMessages) {
                                System.out.println("Please enter recipient cell number: ");
                                String Recipient = scanner.nextLine();

                                System.out.println("Enter your message here:");
                                String MessageText = scanner.nextLine();

                                if (MessageText.isEmpty() || MessageText.length() >= 250) {
                                    System.out.println(
                                            "Please enter a message of less than 250 characters.");
                                    break;
                                }
                                Message newMessage = new Message(TotalMessages + 1, Recipient, MessageText);

                                System.out.println(newMessage.checkRecipientPhone());
                                System.out.println(newMessage.createMessgaeHash());
                                System.out.println(newMessage.SentMessage());

                                TotalMessages++;
                            } else {
                                System.out.println("You have reached the maximum number of message.");
                            }
                            break;

                        case 2:
                            System.out.println("Coming soon");
                            break;
                        case 3:
                            System.out.println("Goodbye");
                            running = false;
                            break;

                        default:
                            System.out.println("Invalid option. Please select option 1 , 2 or 3");
                    }
                }
            }
        }
        scanner.close();
    }
}
