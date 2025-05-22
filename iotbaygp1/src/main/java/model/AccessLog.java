package model;

import java.time.LocalDateTime;

public class AccessLog {
    private int logID;
    private int userID;
    private String userEmail;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;

    public AccessLog(int logID, int userID, String userEmail, LocalDateTime loginTime, LocalDateTime logoutTime){
        this.logID = logID;
        this.userID = userID;
        this.userEmail = userEmail;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    public int getLogID(){
        return this.logID;
    }
    public int getUserID(){
        return this.userID;
    }
    public String getUserEmail(){
        return this.userEmail;
    }
    public LocalDateTime getLoginTime(){
        return this.loginTime;
    } 
    public LocalDateTime getLogoutTime(){
        return this.logoutTime;
    }
}
