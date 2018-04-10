
//package database;
//package utility;

//Imports
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import static java.nio.channels.AsynchronousFileChannel.open;
import static java.nio.channels.AsynchronousFileChannel.open;
import static javafx.scene.input.KeyCode.F;
import java.sql.*;
import java.util.*;


public class Database {
    public void func() throws IOException
    {
        System.out.println("WELCOME TO OUR DATABASE IN DB");
        Configuration configuration = new Configuration();
 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the dictionary.
        configuration.setDictionaryPath("stud_emp.dic");
        // Set path to the language model.
        configuration.setLanguageModelPath("stud_emp.lm");
 
        //Recognizer object, Pass the Configuration object
        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
        
        //Start Recognition Process (The bool parameter clears the previous cache if true)
        recognize.startRecognition(true);
 
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        System.out.println("START SPEAKING");
        while ((result = recognize.getResult()) != null)
        {
 
            //Get the recognized speech
            String command = result.getHypothesis();
            String work = null;
            Process p;
            try{
                
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
           Connection conn=DriverManager.getConnection("jdbc:derby://localhost:1527/project","project","project"); 
           
       
 
            if(command.equalsIgnoreCase("all student"))
            {
                System.out.println("select details of all student from database");
                Statement stat=conn.createStatement();
                ResultSet rs=stat.executeQuery("select * from student");
                while(rs.next())
                    System.out.println("Student name : " + rs.getString(1)  + "Student class : " + rs.getString(2));
           
                    
            }
            else if(command.equalsIgnoreCase("name student"))
            {
                System.out.println("select name of all student from database");
                   Statement stat=conn.createStatement();
                ResultSet rs=stat.executeQuery("select name from student");
                while(rs.next())
                    System.out.println("Student name : " + rs.getString(1));
            }
            else if(command.equalsIgnoreCase("class student"))
            {
                System.out.println("select class of all student from database");
                    Statement stat=conn.createStatement();
                ResultSet rs=stat.executeQuery("select class from student");
                while(rs.next())
                    System.out.println("Student class : " + rs.getString(1));
            }
            else if(command.equalsIgnoreCase("all employee"))
            {
                System.out.println("select details of all employee from database");
                Statement stat=conn.createStatement();
                ResultSet rs=stat.executeQuery("select * from employee");
                while(rs.next())
                    System.out.println("Employee name : " + rs.getString(1)  + "Employee department : " + rs.getString(2));
           
                    
            }
            else if(command.equalsIgnoreCase("name employee"))
            {
                System.out.println("select name of all employee from database");
                   Statement stat=conn.createStatement();
                ResultSet rs=stat.executeQuery("select name from employee");
                while(rs.next())
                    System.out.println("Employee name : " + rs.getString(1));
            }
            else if(command.equalsIgnoreCase("department employee"))
            {
                System.out.println("select department of all employee from database");
                    Statement stat=conn.createStatement();
                ResultSet rs=stat.executeQuery("select dpt from employee");
                while(rs.next())
                    System.out.println("Employee department : " + rs.getString(1));
            }
            else
            {
                System.out.println("SORRY..!! SIRI  CAN'T RECOGNISE YOUR VOICE. PLEASE TRY AGAIN");
            }
            conn.close();
            }
            catch(ClassNotFoundException | SQLException ex)
            {
                System.out.println(ex);
            }
        }
        
    }
    public static void main(String[] args) throws IOException {
       Database d=new Database();
       d.func();
}
}
