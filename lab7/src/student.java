import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class student
{
    String userId ;
    String role ;
    String username ;
    String email ;
    String passwordHash ;
    ArrayList <Integer> enrolledCourses ;
    double progress ;

    public student(String userId, String role, String username, String email, String passwordHash , double progress)
    {
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
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
                if ( array.getString("title").toString().toLowerCase().contains(word.toLowerCase()) )
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

    public void enroll ( JSONObject course )
    {
        enrolledCourses.add(Integer.valueOf(course.getString("id")))  ;
    }
}



