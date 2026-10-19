/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginandtesters;

import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Student
 */
public class Message {

    private String MessageID;
    private int MessageNo;
    private String Recipient;
    private String MessageText;
    private String MessageHash;

    public String storeMessage() {
        java.nio.file.Path file = java.nio.file.Path.of(
        System.getProperty("user.dir"), "messages.json");

        try {
            String json;

            if (java.nio.file.Files.exists(file)) {
                json = java.nio.file.Files.readString(file);
            } else {
                json = "{\n \"messages\": []\n}";
            }

            String message = "     {\n"
                    + "      \"MessagesID\": \"" + escapeJson(MessageID) + "\",\n"
                    + "      \"MessagesNo\": " + MessageNo + ",\n"
                    + "      \"messageHash\": \"" + escapeJson(MessageHash) + "\",\n"
                    + "      \"recipient\": \"" + escapeJson(Recipient) + "\",\n"
                    + "      \"messageText\": \"" + escapeJson(MessageText) + "\"\n"
                    + "    }";

            int position = json.lastIndexOf("]");

            if (position == -1) {
                return "Error: Invalid Json FILE";
            }
            String before = json.substring(0, position).trim();
            boolean empty = before.endsWith("[");

            String updateJson = json.substring(0, position)
                    + (empty ? "\n" : ",\n")
                    + message + "\n  "
                    + json.substring(position);

            java.nio.file.Files.writeString(file, updateJson);
            System.out.println("JSON saved at: " + file.toAbsolutePath());

            return "Message successfully stored.";
        } catch (java.io.IOException e) {
            return "Error storing message: " + e.getMessage();
        }
    }

    private String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    public Message(int MessageNo, String recipient, String MessageText) {
        this.MessageNo = MessageNo;
        this.Recipient = recipient;
        this.MessageText = MessageText;
        this.MessageID = generateMessageID();
    }

    private String generateMessageID() {
        Random random = new Random();
        Long id = 1000000000L + random.nextInt(90000000);
        return String.valueOf(id);
    }

    public boolean CheckMessageID() {
        return MessageID.length() <= 10;
    }

    public String checkRecipientPhone() {
        if (Recipient != null && Recipient.matches("^\\+27\\d{9}$")) {
            return "Cell phone number has been successfully captured.";
        }
        return "Cell phone nymber has been incorrectly formatted or does not contain an international code, please correct this error and try again";
    }

    public String createMessgaeHash() {
        String[] words = MessageText.trim().split("\\s+");

        String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "");
        MessageHash = MessageID.substring(0, 2) + ":" + MessageNo + ":" + firstWord + lastWord;
        return MessageHash.toUpperCase();
    }

    public String SentMessage() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Send a message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store message to send later");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return "Mesage successfully sent";
            case 2:
                return "Press 0 to delete the message";
            case 3:
                return storeMessage();
            default:
                return "Invalid option";
        }
    }

    public String printMessage() {
        return "Message ID: " + MessageID + "\nMessage Hash: " + MessageHash + "\nRecipient: " + Recipient + "\nMessage: " + MessageText;
    }

    public int returnTotalMessage() {
        return MessageNo;
    }

    public String getMessageID() {
        return MessageID;
    }

    public String getRecipient() {
        return Recipient;
    }

    public String getMessageText() {
        return MessageText;
    }

    public String getMessageHash() {
        return MessageHash;
    }
    public boolean CheckMessageLength() {
        return MessageText !=null
                && !MessageText.isEmpty()
                && MessageText.length() < 250;
    }
}
