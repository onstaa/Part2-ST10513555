/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginandtesters;

/**
 *
 * @author Student
 */
class Login {

    private String FirstName;
    private String Surname;
    private String Username;
    private String Password;
    private String CellNo;

    public Login(String firstName, String surname, String username, String password, String cellNo) {
        this.FirstName = firstName;
        this.Surname = surname;
        this.Username = username;
        this.Password = password;
        this.CellNo = cellNo;
    }

    public boolean checkUsername() {
        return Username != null && Username.contains("_") && Username.length() <= 5;
    }

    public boolean checkUser() {
        return FirstName != null && !FirstName.isEmpty();
    }

    public boolean checkPasswordCom() {
        // Password complexity check logic
        if (Password == null || Password.length() < 8) {
            return false;
        }
        boolean hasCapital = !Password.equals(Password.toLowerCase());
        boolean hasDigit = Password.matches(".*\\d.*");
        boolean hasSpecial = Password.matches(".*[^a-zA-Z0-9].*");

        return hasCapital && hasDigit && hasSpecial;
    }

    public boolean checkCellPhoneNumber() {
        // Cell phone number validation logic
        String cellRegex = "^\\+27\\d{9}$";
        return CellNo != null && CellNo.matches(cellRegex);
    }

    public String registerUser() {
        if (!checkPasswordCom()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a captial letter, a number and a special character";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not conatin international code";
        }
        if (!checkUsername()) {
            return "Username is not correctly formatted; please ensure that your username conatins an underscore and is no more than five chaacters in length";
        }
        return "Username successfully captured. \nPassword successfully captured.\nCell phone successfully added.";
    }

    public boolean LoginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername != null 
                && enteredPassword != null
                && enteredUsername.equals(this.Username)
                && enteredPassword.equals(this.Password);
    }

    public String returnStatusForlogin(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome" + FirstName + ", " + Surname + "It is great to see you again";
        } else {
            return "Username or password inncorrect, please try again";
        }
    }
}
