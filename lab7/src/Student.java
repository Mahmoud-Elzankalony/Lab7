import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Student
{
    String userId ;
    String role ;
    String username ;
    String email ;
    String passwordHash ;
    ArrayList <String> enrolledCourses ;
    double progress ;

    public Student(String userId, String role, String username, String email, String passwordHash , double progress)
    {
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;

        //super(userId,role,username,email,passwordHash);
        this.enrolledCourses = new ArrayList<>() ;
        this.progress = progress;
    }

    public JSONObject search ( String word )
    {
        try
        {
            String content = new String(Files.readAllBytes(Paths.get("courses.json")));
            JSONArray array = new JSONArray(content);

            int flag = 0 ;
            int index = 0 ;

            for ( int i = 0 ; i < array.length() ; i ++ )
            {
                JSONObject object = array.getJSONObject(i);
                if ( object.getString("title").toLowerCase().contains(word.toLowerCase()) )
                {
                    flag = 1 ;
                    index = i ;
                    break ;
                }
            }
            if ( flag == 1 )
            {
                return array.getJSONObject(index) ;
            }
            else
            {
                return null ;
            }
        }
        catch ( Exception e )
        {
            return null ;
        }
    }

    public void enroll ( Course course )
    {
        enrolledCourses.add(String.valueOf(course.getCourseId()))  ;
        UpdateProgressAndEnrolledCourses();

        course.AddStudent(this);
        Courses.SaveToJsonCourses() ;
    }

    public void UpdateProgressAndEnrolledCourses()
    {
        try
        {
            String content = new String(Files.readAllBytes(Paths.get("users.json")));
            JSONArray data = new JSONArray(content);

            for ( int i = 0 ; i < data.length() ; i ++ )
            {
                JSONObject obj = data.getJSONObject(i);
                if (obj.getString("userId").equals(String.valueOf(super.getUserId())))
                {
                    obj.put("progress", progress ) ;
                    obj.put("enrolledCourses", enrolledCourses) ;

                    break ;
                }
            }
            Files.write(Paths.get("users.json"), data.toString().getBytes());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}




