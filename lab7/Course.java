import java.lang.reflect.Array;
import java.util.ArrayList;

public class Course {
    private int courseId;
    private String title;
    private String description;
    private int instructorId;
    private ArrayList<Lesson> lessons;
    private ArrayList<Student> students;

    public Course(int courseId, String title, String description, int instructorId) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public int getCourseId() {
        return courseId;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getInstructorId() {
        return instructorId;
    }
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }
    public void SaveJsonFile()
    {
        

    }

}
