import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Courses
{
    static ArrayList<Course> courses;
    String FileName;

    public Courses(String FileName)
    {
        this.FileName = FileName;
        this.courses =  new ArrayList<>();
    }

    public ArrayList<Course> getCourses()
    {
        return courses;
    }

    public String getFileName()
    {
        return FileName;
    }

    public void setFileName(String FileName)
    {
        this.FileName = FileName;
    }

    public static void SaveToJsonCourses()
    {
        JSONArray arr = new JSONArray();

        for (Course c : courses)
        {
            arr.put(new JSONObject(c));
        }
        try (FileWriter file = new FileWriter(FileName))
        {
            file.write(arr.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
