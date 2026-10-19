package com.mycompany.loginandtesters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class MessageTest {
   
     @Test
    public void testCheckMessageID_Valid_ReturnsTrue() {
        Message message = new Message(
                1,
                "+27787429138",
                "Hi mom, how you doing"
        );

        assertTrue(message.CheckMessageID());
        assertEquals(8, message.getMessageID().length());
    }

    @Test
    public void testCheckRecipientPhone_ValidNumber_ReturnsSuccess() {
        Message message = new Message(
                1,
                "+27787429138",
                "Hi Ona"
        );

        assertEquals(
                "Cell phone number has been successfully captured.",
                message.checkRecipientPhone()
        );
    }

    @Test
    public void testCheckRecipientPhone_InvalidNumber_ReturnsError() {
        Message message = new Message(
                1,
                "27787429138",
                "Hi Mom"
        );

        assertTrue(
                message.checkRecipientPhone()
                        .contains("incorrectly formatted")
        );
    }

    @Test
    public void testCheckMessageLength_Under250Characters_ReturnsTrue() {
        Message message = new Message(
                1,
                "+27787429138",
                "Hi Mom, see you later"
        );

        assertTrue(message.CheckMessageLength());
    }

    @Test
    public void testCheckMessageLength_250Characters_ReturnsFalse() {
        String longMessage = "A".repeat(250);

        Message message = new Message(
                1,
                "+27787429138",
                longMessage
        );

        assertFalse(message.CheckMessageLength());
    }

    @Test
    public void testCreateMessageHash_CreatesCorrectFormat() {
        Message message = new Message(
                1,
                "+27787429138",
                "Hi there, see you later!"
        );

        String hash = message.createMessgaeHash();

        assertTrue(hash.matches("\\d{2}:1:HILATER"));
    }

    @Test
    public void testReturnTotalMessage_ReturnsMessageNumber() {
        Message message = new Message(
                2,
                "+27787429138",
                "Hi Mom"
        );

        assertEquals(2, message.returnTotalMessage());
    }
}
