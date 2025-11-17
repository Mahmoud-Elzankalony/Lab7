package lab7;
import java.util.ArrayList;

public class Course {
    //private static final String fileName = "D:\\programming\\java\\lab7\\lab7_IJ\\courses.json";
    private String courseId;
    private String title;
    private String description;
    private String instructorId;
    private ArrayList<Lesson> lessons = new ArrayList<>();;
    private ArrayList<Student> studentsIncourse ;

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstructorId(String instructorId) { // Changed argument type
        this.instructorId = instructorId;
    }

    public Course(String courseId, String title, String description, String instructorId)
    {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        studentsIncourse = new ArrayList<>();

//        this.studentsIncourse = new ArrayList<>();
//        this.lessons = new ArrayList<>();
    }

    public Course()
    {
        this.studentsIncourse = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
    public ArrayList<Student> getStudentsIncourse() {
        return studentsIncourse;
    }
    public String getCourseId() {
        return courseId;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getInstructorId() {return instructorId;}

    public void AddStudent(Student student)
    {
        studentsIncourse.add(student);
    }

    // In Course.java

    // ... (after your other methods, before the final '}')
    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return java.util.Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(courseId);
    }
     */
}





