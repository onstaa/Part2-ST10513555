/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.loginandtesters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
    // Username testers
    @Test
    public void testCheckUsername_FormatIsValid_ReturnsTrue() {
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "+27787429138");
        assertTrue(user.checkUsername()); 
    }
    
    @Test
    public void testCheckUsername_FormatIncorrect_ReturnFalse() {
        Login user = new Login("Ona", "Mmatli", "Ona!!!!!!!!!!!", "Onalerona!12", "+27787429138");
        assertFalse(user.checkUsername()); 
    }
    
    @Test
    public void testRegisterUser_UsernameIncorrect_ReturnsErrorMessage() {
        Login user = new Login("Ona", "Mmatli", "Ona!!!!!!!!!", "Onalerona!12", "+27787429138");
        String expected = "Username is not correctly formatted; please ensure that your username conatins an underscore and is no more than five chaacters in length";
        assertEquals(expected, user.registerUser()); 
    }
    
    // Password testers
    @Test
    public void testCheckPasswordCom_ValidPassword_ReturnTrue() {
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "+27787429138");
        assertTrue(user.checkPasswordCom());  
    }
    
    @Test
    public void testCheckPasswordCom_ValidPassword_ReturnFalse() {
        Login user = new Login("Ona", "Mmatli", "Ona_1", "simple", "+27787429138");
        assertFalse(user.checkPasswordCom());  
    }
    
    @Test
    public void testCheckPasswordCom_ValidPassword_ReturnErrorMessage() {
        Login user = new Login("Ona", "Mmatli", "Ona_1", "simple", "+27787429138");
        String expected = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a captial letter, a number and a special character";
        assertEquals(expected, user.registerUser());  
    }
    
    // Cell phone no tester
    @Test
    public void testcheckCellNo_ValidNo_ReturnTrue() {
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "+27787429138");
        assertTrue(user.checkCellPhoneNumber());  
    }
    
    @Test
    public void testcheckCellNo_ValidNo_ReturnFalse() {
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "0787429138");
        assertFalse(user.checkCellPhoneNumber());  
    }    
    
    @Test
    public void testcheckCellNo_ValidNo_ReturnErrorMessage() {
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "0787429138");
        String expected = "Cell phone number incorrectly formatted or does not conatin international code";
        assertEquals(expected, user.registerUser());  
    }
    
    // Registration tester
    @Test
    public void testRegisterUser_ValidInputs_ReturnSuccesMessage() {
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "+27787429138");
        String expected = "Username successfully captured. \nPassword successfully captured.\nCell phone successfully added.";
        assertEquals(expected, user.registerUser());  
    }
    
    @Test 
    public void testRegisterUser_CorrectDetials_ReturnTrue(){
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "+27787429138");
        assertTrue(user.LoginUser("Ona_1", "Onalerona!12")); 
    }
    
    @Test 
    public void testStatusLoginUser_CorrectDetials_ReturnFalse(){
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "+27787429138");
        assertFalse(user.LoginUser("Ona_1", "WrongPassword!")); 
    }
    
    @Test 
    public void testStatusLoginUser_SuccessFulDetials_ReturnWelcomeMessage(){
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "+27787429138");
        String expected = "Welcome" + "Ona" + ", " + "Mmatli" + "It is great to see you again"; 
        assertEquals(expected, user.returnStatusForlogin(true)); 
    }
    
    @Test 
    public void testStatusLoginUser_IncorrectDetials_ReturnWelcomeMessage(){
        Login user = new Login("Ona", "Mmatli", "Ona_1", "Onalerona!12", "+27787429138");
        String expected = "Username or password inncorrect, please try again";
        assertEquals(expected, user.returnStatusForlogin(false)); 
    }
}