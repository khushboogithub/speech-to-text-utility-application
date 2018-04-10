
//package utility;

//Imports
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.io.InputStream;
import static java.nio.channels.AsynchronousFileChannel.open;
import static java.nio.channels.AsynchronousFileChannel.open;
import static javafx.scene.input.KeyCode.F;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
//import static java.nio.channels.AsynchronousFileChannel.open;
 
/**
 *
 * @author ex094
 */
/*
 class LiveSpeechRecognizerExtention1 extends AbstractSpeechRecognizer {

   // private final MicrophoneExtention microphone;
private final MicrophoneExtention1 microphone1;
    /**
     * Constructs new live recognition object.
     *
     * @param configuration common configuration
     * @throws IOException if model IO went wrong
     */
  /*  public LiveSpeechRecognizerExtention1(Configuration configuration) throws IOException
    {
        super(configuration);
        //microphone = speechSourceProvider.getMicrophone();
      
       //if(microphone.line.available()) 
       //{
       //} else {
           
      // }
        microphone1 =new  MicrophoneExtention1(16000, 16, true, false);
        context.getInstance(StreamDataSource.class).setInputStream(microphone1.getStream());
    }

    /**
     * Starts recognition process.
     *
     * @param clear clear cached microphone data
     * @see         LiveSpeechRecognizer#stopRecognition()
     */
    /*public void startRecognition(boolean clear) {
        recognizer.allocate();
        microphone1.startRecording();
    }

    /**
     * Stops recognition process.
     *
     * Recognition process is paused until the next call to startRecognition.
     *
     * @see LiveSpeechRecognizer#startRecognition(boolean)
     */
  /*  public void stopRecognition() {
        microphone1.stopRecording();
        recognizer.deallocate();
    }
    
      public void closeRecognitionLine(){
      microphone1.closeLine();
    }
    
}
*/
/*
class MicrophoneExtention1 {

    public final TargetDataLine line;
    private final InputStream inputStream;

    public MicrophoneExtention1(
            float sampleRate,
            int sampleSize,
            boolean signed,
            boolean bigEndian) {
        AudioFormat format =
            new AudioFormat(sampleRate, sampleSize, 1, signed, bigEndian);
        try {
            line = AudioSystem.getTargetDataLine(format);
            if(line.isOpen())
            {
                line.close();
            }
        line.open();
            line.open();
        } catch (LineUnavailableException e) {
            throw new IllegalStateException(e);
        }
        inputStream = new AudioInputStream(line);
    }

    public void startRecording() {
        line.start();
    }

    public void stopRecording() {
        line.stop();
    }

    public InputStream getStream() {
        return inputStream;
    }
    
    
     public void closeLine(){
       line.close();
    }
    
    
   
}

*/

public class VoiceLauncher {
    
     public void func() throws IOException
     {
         System.out.println("WELCOME TO OUR VOICELAUNCHER");
         System.out.println("1.OPEN BROWSER");
        System.out.println("2.CLOSE BROWSER");
        System.out.println("3.OPEN FILE MANAGER");
        System.out.println("4.CLOSE FILE MANAGER");
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
         System.out.println("START SPEAKING NOW");
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
            else if (command.equalsIgnoreCase("exit"))
            {
                System.out.println("Exit");
                
               break;
               

            }
        
            //In case command recognized is none of the above hence work might be null
            if(work != null) {
                //Execute the command
                p = Runtime.getRuntime().exec(work);
            }
            System.out.println("YOU CAN SPEAK NOW");
        }
     }
    public static void main(String[] args) throws IOException {
        VoiceLauncher v=new VoiceLauncher();
        v.func();
    }
}
