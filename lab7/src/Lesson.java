
import java.util.ArrayList;

public class Lesson {
    
    private int lessonId;
    private String title;
    private String description;
    private ArrayList<String> resources;

    public Lesson(int lessonId, String title, String description) {
        this.lessonId = lessonId;
        this.title = title;
        this.description = description;
        this.resources = new ArrayList<>();
    }
    
    
    public int getLessonId() {
        return lessonId; 
    }
    
    public String getTitle() {
        return title; 
    }
    
    public String getContent() {
        return description; 
    }
    
    public ArrayList<String> getResources() {
        return resources; 
    }
    
}

