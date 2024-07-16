package com.pvsbackend.pvs.DTO;

public class LoginRequest {

    private String phonenumberOrEmail;
    private String password;

    LoginRequest(){}

    public LoginRequest(String phonenumberOrEmail, String password){
        this.phonenumberOrEmail = phonenumberOrEmail;
        this.password = password;
    }
//getters
    public String getphonenumberOrEmail() {
        return phonenumberOrEmail;
    }

    public String getPassword() {
        return password;
    }
//setters
    public void setPhonenumberOrEmail(String phonenumberOrEmail) {
        this.phonenumberOrEmail = phonenumberOrEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getPhonenumberOrEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPhonenumberOrEmail'");
    }

    


}
