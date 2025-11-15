public class User {
  private int userId ;
  private String role ;
  private String username ;
  private String email ;
  private String passwordHash ;

    public User(int userId, String role, String username, String email, String passwordHash) {
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public int getUserId() {
        return userId;
    }
    public String getRole() {
        return role;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPasswordHash() {
        return passwordHash;
    }



}
