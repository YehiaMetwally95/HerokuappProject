package utils;

import com.github.javafaker.Faker;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataGenerator {

    public static String generateName()
    {
      String currentTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
      return "Test" + currentTime;
    }

    public static String generateInt()
    {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    public static String generateEmail()
    {
        String currentTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        return "Test" + currentTime + "@gmail.com";
    }

    public static String generateStrongPassword()
    {
        String currentTime = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return "Test" + "@%^" + currentTime;
    }





}
