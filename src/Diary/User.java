package Diary;

public class User {
    private String firstName;
    private String Id;
    private String userName;
    private final Gender gender;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }

    public User(String Id, String firstName, String userName, Gender gender, String email, String password) {
        this.Id = Id;
        this.firstName = firstName;
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
