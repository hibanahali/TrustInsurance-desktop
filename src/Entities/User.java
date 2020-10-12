/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Camilia
 */
public class User {
    private int id;
    private String username;
    private String username_canonical;
    private String email;
    private String email_canonical;
    private boolean enabled;
    private String salt;
    private String password;
    private Date last_login;
    private String confirmation_token;
    private Date password_requested_at;
    private String roles;
   

    

    public User(int id, String username, String username_canonical, String email, String email_canonical, boolean enabled, String salt, String password, Date lastLogin, String confirmationToken, Date passwordRequestedAt, String roles, String photo_membre, String genre, int phone_number, String country, int age, String Stripe_id) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = lastLogin;
        this.confirmation_token = confirmationToken;
        this.password_requested_at = passwordRequestedAt;
        this.roles = roles;
        
    }

    
    public User(String nom, String email) {
            this.username=nom;
            this.email=email;
            
    }

   

  

  

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", username_canonical=" + username_canonical + ", email=" + email + ", email_canonical=" + email_canonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", lastLogin=" + last_login + ", confirmationToken=" + confirmation_token + ", passwordRequestedAt=" + password_requested_at + ", roles=" + roles +'}';
    }
    
    
    public User() {
    }
//     public User(Integer id) {
//        this.id = id;
//    }
      public User(int id, String username, String username_canonical, String email, String email_canonical, boolean enabled, String salt, String password, Date lastLogin, String confirmationToken, Date passwordRequestedAt, String roles, String photo_membre, String genre,int phone_number,String country,int age) {
        this.id= id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = lastLogin;
        this.confirmation_token = confirmationToken;
        this.password_requested_at = passwordRequestedAt;
        this.roles = roles;
       
    }

    



   
    public User(String username, String username_canonical, String email, String email_canonical, boolean enabled, String salt, String password, Date lastLogin, String confirmationToken, Date passwordRequestedAt, String roles, String photo_membre, String genre,int phone_number,String country,int age) {
    
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = lastLogin;
        this.confirmation_token = confirmationToken;
        this.password_requested_at = passwordRequestedAt;
        this.roles = roles;
       
    }

    public User(String name) {
        this.username= name;                           
    }
    public User(Boolean enabled){
        this.enabled=enabled;
    };

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getlast_login() {
        return last_login;
    }

    public void setlast_login(Date lastLogin) {
        this.last_login = lastLogin;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmationToken) {
        this.confirmation_token = confirmationToken;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date passwordRequestedAt) {
        this.password_requested_at = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


  

    


    
    
    
}
