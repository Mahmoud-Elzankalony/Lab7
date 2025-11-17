package lab7;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mahmoud-elzankalony
 */
public class Instructor{
    private String userId ;
    private String role ;
    private String username ;
    private String email ;
    private String passwordHash ;

    ArrayList<Course> createdCourses = new ArrayList<>();
    Courses courses = new Courses("courses.json");
      User user=new User("users.json");
    public Instructor(String userId, String role, String username, String email, String passwordHash) throws IOException
    {
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        courses.load();
        user.load();
    }

    public void Createcourse(String courseId, String title, String description) throws IOException
    {
        Course course = new Course(courseId,title,description,this.userId);
        Courses courses = new Courses("courses.json");
        User user=new User("users.json");
                user.load();
                courses.load();
        courses.addCourse(course);
        this.createdCourses.add(course);
        courses.SaveToJsonCourses(); 
    user.save();           }

    public void Editcourse(Course course, String courseId, String title, String description, String instructorId) throws IOException
    {
        Courses courses = new Courses("courses.json");
        Course cu = null;
        User user=new User("users.json");
                user.load();
                courses.load();
          for(Course c: this.createdCourses)
              if(c.getCourseId().equals(course.getCourseId()))
                   cu=c;
          
        if(courseId != null) // Check against String instead of int
        {course.setCourseId(courseId);
        cu.setCourseId(courseId);
        }
        if(!title.equals("")){
            course.setTitle(title);
            cu.setTitle(title);}
        if(!description.equals("")){
            course.setDescription(description);
            cu.setDescription(description);}
        
        courses.SaveToJsonCourses();
        user.save();
        courses.load();
        user.load();
    }
    public void deleteCourse(String courseId) throws IOException
    {Courses courses = new Courses("courses.json");
    User user=new User("users.json");
courses.load();
user.load();
        for(Course course : courses.getCourses()){
            if(course.getCourseId().equals(courseId)){
                courses.deleteCourse(course);
                createdCourses.remove(course);
                break;}
        }
        for(Course course : this.createdCourses){
            if(course.getCourseId().equals(courseId))
        this.createdCourses.remove(course);
        for(Student student:user.getStudents())
            for(Course cours : student.getEnrolledCourses())
                if(cours.getCourseId().equals(courseId))
                    student.getEnrolledCourses().remove(cours);
         user.save();
        courses.SaveToJsonCourses();
        courses.load();
        user.load();
        
    }}

    public void Createlesson(Course course,String lessonId, String title, String content) throws IOException
    {
        Lesson lesson = new Lesson(lessonId,title,content);
        course.getLessons().add(lesson);
        courses.SaveToJsonCourses();
        courses.load();
    }


    public void Editlesson(Course course,Lesson lesson,String lessonId, String title, String content) throws IOException
    {
        if(lessonId != null)
            lesson.setLessonId(lessonId);
        if(!title.equals(""))
            lesson.setTitle(title);
        if(!content.equals(""))
            lesson.setContent(content);
        courses.SaveToJsonCourses();
        courses.load();
    }


    public void Deletelesson(Course course,String lessonId) throws IOException
    {
        for(Lesson lesson : course.getLessons())
        {
            if (lesson.getLessonId().equals(lessonId))
                course.getLessons().remove(lesson);
            break;
        }
        courses.SaveToJsonCourses();
        courses.load();
    }

    public Object getUserId()
    {
        return userId;
    }

    public Object getEmail()
    {
        return email;
    }

    public Object getPasswordHash()
    {
        return passwordHash;
    }
}
