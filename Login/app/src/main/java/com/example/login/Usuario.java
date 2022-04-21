package com.example.login;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String email;
    private String password;
    public Usuario(String email,String password){
        this.email=email;
        this.password=password;
    }
    public Usuario(){
        this.email=" ";
        this.password=" ";
    }
    public void setemail(String emai){
        this.email=emai;
    }
    public void setpassword(String emai){
        this.password=emai;
    }
    public String getemail(){
        String result=this.email;
        return result;
    }
    public String getpassword(){
        String result=this.password;
        return result;
    }
}
