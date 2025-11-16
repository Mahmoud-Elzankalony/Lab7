import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
public class User {
    
    private static ArrayList<Student> students;
    private static ArrayList<Instructor> instructors;
    private String filename;
    
    public User(String filename) {
        this.filename=filename;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }
    
    
     public void load() {
        try (FileReader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            User loaded = gson.fromJson(reader, User.class);

            this.students = loaded.students;
            this.instructors = loaded.instructors;

        } catch (Exception e) {
            System.out.println("Error Loading File OR file doesn't exist: " + e.getMessage());
        }
    }

      public void save() {
        try (FileWriter writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
        } catch (Exception e) {
            System.out.println("Error Saving File: " + e.getMessage());
        }
    }
}
