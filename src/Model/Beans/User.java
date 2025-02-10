package Model.Beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author TUF_Heat_
 */
public class User {

    private String username = "";
    private String password = "";
    private String registeredDate = "";
    private String loginDateTime = "";
    private String userType = "";
    private String userGender = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime() {
        this.loginDateTime = String.valueOf("" + LocalDate.now() + "_" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm")) + "");
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}
