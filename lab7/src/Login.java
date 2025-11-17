import java.util.ArrayList;

public class Login {
      private ArrayList<Student> allStudents;
    private ArrayList<Instructor> allInstructors;
    private User user;
    
    


    public Login() {
        this.user = new User("src/users.json");
        user.load();
        this.allStudents = user.getStudents() ;
        this.allInstructors = user.getInstructors() ;
       
    }

    public int search(String email, String password) {
        for ( Student student : allStudents) {
            if (student.getEmail().equals(email) && student.getPasswordHash().equals(password)) {
                return 1;
            }

        }
        for ( Instructor instructor : allInstructors) {
            if (instructor.getEmail().equals(email) && instructor.getPasswordHash().equals(password)) {
                return 2;
            }
        }
        return 0;
    }
  


}
