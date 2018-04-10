
package voicelauncher;

//Imports
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import static java.nio.channels.AsynchronousFileChannel.open;
import static java.nio.channels.AsynchronousFileChannel.open;
import static javafx.scene.input.KeyCode.F;
//<editor-fold defaultstate="collapsed" desc="comment">
//import static jdk.nashorn.internal.objects.NativeArray.some(Object, Object, Object).package.Baseclass.*;
//</editor-fold>
//import static java.nio.channels.AsynchronousFileChannel.open;
 
/**
 *
 * @author ex094
 */
public class VoiceLauncher extends Thread
{
    public static void main(String[] args) throws IOException {
        //Configuration Object
        Configuration configuration = new Configuration();
 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the dictionary.
        configuration.setDictionaryPath("3043.dic");
        // Set path to the language model.
        configuration.setLanguageModelPath("3043.lm");
 
        //Recognizer object, Pass the Configuration object
       LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
 
        //Start Recognition Process (The bool parameter clears the previous cache if true)
        recognize.startRecognition(true);
 
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognize.getResult()) != null)
        {
 
            //Get the recognized speech
            String command = result.getHypothesis();
            String work = null;
            Process p;
            
           // String a=;
             //String a1 = ;
            
 
            if(command.equalsIgnoreCase("open file manager"))
            {
                System.out.println("open file manager");
                    work = "explorer" ;
            }
            else if (command.equalsIgnoreCase("close file manager"))
            {
                System.out.println("close file manager");
            work = "Taskkill /IM explorer.exe /F";
             } 
            else if (command.equalsIgnoreCase("open browser"))
            {
                System.out.println("open browser!");
               work = "C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe";
             }
            else if (command.equalsIgnoreCase("close browser"))
            {
                System.out.println("close browser");
               work = "Taskkill /IM chrome.exe /F";

            }
        
            //In case command recognized is none of the above hence work might be null
            if(work != null)
            {
                //Execute the command
                p = Runtime.getRuntime().exec(work);
            }
        }
    }
}
