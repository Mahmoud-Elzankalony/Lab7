import java.lang.reflect.Array;
import java.util.ArrayList;

import com.google.gson.*;
import java.io.*;

public class Course {
    private static final String fileName = "src/courses.json";
    private int courseId;
    private String title;
    private String description;
    private int instructorId;

    // private ArrayList<Lesson> lessons;
    // private ArrayList<Student> students;

    public Course(int courseId, String title, String description, int instructorId) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        // this.lessons = new ArrayList<>();
        // this.students = new ArrayList<>();
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
    // public ArrayList<Lesson> getLessons() {
    //     return lessons;
    // }
    // public ArrayList<Student> getStudents() {
    //     return students;
    // }
    public void saveToJSON() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // اقرأ courses.json
            FileReader reader = new FileReader(fileName);
            JsonArray courses = JsonParser.parseReader(reader).getAsJsonArray();
            for(JsonElement course : courses) {
                JsonObject courseObj = course.getAsJsonObject();
                System.out.println("Existing Course ID: " + courseObj.get("courseId")); 
                System.out.println("Existing Course Title: " + courseObj.get("title"));
                System.out.println("Instructor ID: " + courseObj.get("instructorId"));
                for(JsonElement student : courseObj.get("students").getAsJsonArray()) {
                    System.out.println(" - Student ID: " + student.getAsJsonObject().get("userId"));
                }
            }
            
            reader.close();


            // أنشئ الكورس الجديد كـ JsonObject
            JsonObject newCourse = new JsonObject();
            newCourse.addProperty("courseId", this.courseId);
            newCourse.addProperty("title", this.title);
            newCourse.addProperty("description", this.description);
            newCourse.addProperty("instructorId", this.instructorId);

            // أضف الكورس الجديد للـ Array
            courses.add(newCourse);

            // احفظ التغييرات
            FileWriter writer = new FileWriter(fileName);
            gson.toJson(courses, writer);
            writer.flush();
            writer.close();

            System.out.println("Course saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void displayAllCourses() {
        try {
            

            // اقرأ courses.json
            FileReader reader = new FileReader(fileName);
            JsonArray courses = JsonParser.parseReader(reader).getAsJsonArray();
            for(JsonElement course : courses) {
                JsonObject courseObj = course.getAsJsonObject();
                System.out.println("Existing Course ID: " + courseObj.get("courseId")); 
                System.out.println("Existing Course Title: " + courseObj.get("title"));
                System.out.println("Instructor ID: " + courseObj.get("instructorId"));
                for(JsonElement student : courseObj.get("students").getAsJsonArray()) {
                    System.out.println(" - Student ID: " + student.getAsJsonObject().get("userId"));
                    System.out.println(" - Progress: " + student.getAsJsonObject().get("progress"));

                }
            }
            
            reader.close();


            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<> UniqeCoureStudents(int ) 


}
