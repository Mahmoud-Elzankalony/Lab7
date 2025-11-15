import com.google.gson.*;
import java.io.FileReader;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to SkillFrog!");
        // إنشاء كورس جديد وحفظه في JSON
        Course newCourse = new Course(106, "Java Programming", "Learn the basics of Java.", 6);
        newCourse.displayAllCourses();
        
        
    }
}
