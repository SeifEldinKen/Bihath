package com.eldinstudio.bihath.data.model;

import java.util.List;

public class UserProfile {

    private String userId, username, email, phoneNumber, password, rePassword;
    private boolean isAdmin;
    private List<String> favoriteListQuotesId, createdListQuotesId;

    

    // --> Constructor
    public UserProfile() {

    }

    public UserProfile(String userId, String username, String email, String password, String rePassword, boolean isAdmin) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
        this.isAdmin = isAdmin;
    }

    public UserProfile(String userId, String username, String email, String phoneNumber, String password, String rePassword, boolean isAdmin) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.rePassword = rePassword;
        this.isAdmin = isAdmin;
    }



    // --> Setter Methods
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setFavoriteListQuotesId(List<String> favoriteListQuotesId) {
        this.favoriteListQuotesId = favoriteListQuotesId;
    }

    public void setCreatedListQuotesId(List<String> createdListQuotesId) {
        this.createdListQuotesId = createdListQuotesId;
    }


    // --> Getter Methods
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public List<String> getFavoriteListQuotesId() {
        return favoriteListQuotesId;
    }

    public List<String> getCreatedListQuotesId() {
        return createdListQuotesId;
    }

}