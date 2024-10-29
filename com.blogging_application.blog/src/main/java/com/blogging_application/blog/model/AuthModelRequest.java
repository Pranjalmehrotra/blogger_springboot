package com.blogging_application.blog.model;

public class AuthModelRequest {
    private String email;
    private String password;


    public AuthModelRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthModelRequest [email=" + email + ", password=" + password + "]";
    }

    public AuthModelRequest(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }


}
