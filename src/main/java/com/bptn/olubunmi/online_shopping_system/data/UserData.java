package com.bptn.olubunmi.online_shopping_system.data;

/*
  The user data for the Online Shopping System.
 */
public class UserData {
    private String username;
    private String password;
    private String email;
    private String address;

    /*
      Constructor to initialize UserData object with username, password, email, and address.
      username The username of the user.
      password The password of the user.
     Email The email address of the user.
     address The shipping address of the user.
     */
    public UserData(String username, String password, String email, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    /*
      Retrieves the username of the user.
     @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    
//      A string representation of the UserData object.

  
    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
