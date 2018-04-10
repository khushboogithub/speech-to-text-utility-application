import edu.cmu.sphinx.api.AbstractSpeechRecognizer;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.frontend.util.StreamDataSource;
import java.io.IOException;
import java.io.InputStream;
import static java.nio.channels.AsynchronousFileChannel.open;
import static java.nio.channels.AsynchronousFileChannel.open;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.F;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;


/*class LiveSpeechRecognizerExtention2 extends AbstractSpeechRecognizer {

   // private final MicrophoneExtention microphone;
private final MicrophoneExtention2 microphone2;
    /**
     * Constructs new live recognition object.
     *
     * @param configuration common configuration
     * @throws IOException if model IO went wrong
     */
/*
    public LiveSpeechRecognizerExtention2(Configuration configuration) throws IOException
    {
        super(configuration);
        //microphone = speechSourceProvider.getMicrophone();
      
       //if(microphone.line.available()) 
       //{
       //} else {
           
      // }
        microphone2 =new  MicrophoneExtention2(16000, 16, true, false);
        context.getInstance(StreamDataSource.class).setInputStream(microphone2.getStream());
    }

    /**
     * Starts recognition process.
     *
     * @param clear clear cached microphone data
     * @see         LiveSpeechRecognizer#stopRecognition()
     */
/*
    public void startRecognition(boolean clear) {
        recognizer.allocate();
        microphone2.startRecording();
    }

    /**
     * Stops recognition process.
     *
     * Recognition process is paused until the next call to startRecognition.
     *
     * @see LiveSpeechRecognizer#startRecognition(boolean)
     */
/*
    public void stopRecognition() {
        microphone2.stopRecording();
        recognizer.deallocate();
    }
    
      public void closeRecognitionLine(){
      microphone2.closeLine();
    }
    
}

class MicrophoneExtention2 {

    public final TargetDataLine line;
    private final InputStream inputStream;

    public MicrophoneExtention2(
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


public class Calculator {

        public void calc() throws IOException
        {
            // Configuration Object
            System.out.println("WELCOME TO OUR CALCULATOR");
        Configuration configuration = new Configuration();
 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the dictionary.
        configuration.setDictionaryPath("1814.dic");
        // Set path to the language model.
        configuration.setLanguageModelPath("1814.lm");
 
        //Recognizer object, Pass the Configuration object
        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
        //Start Recognition Process (The bool parameter clears the previous cache if true)
         recognize.startRecognition(true);
 
        //Creating SpeechResult object
        SpeechResult result;
            int com_res=0,result1=0,result2=1;
            String prev_com="xyz";
            int prev_num=-99;
            int after_com=-99;
        //Check if recognizer recognized the speech
             System.out.println("START SPEAKING");
        while ((result = recognize.getResult()) != null)
        {
 
            //Get the recognized speech
            String command = result.getHypothesis();
            //String work = null;
            //Process p;
            //String com=null;
           
          //if(command.equalsIgnoreCase("exit"))
          //{
            //  System.out.println("exit");
              //break;
          //}
          
            if(command.equalsIgnoreCase("one"))
            {
                
                System.out.println("one");
                
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide")) || (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=1;
                           
                   }
                   else
                   {
                           com_res= 1 + (com_res*10);       
                   }
                    after_com= 1;
                }
                else if(prev_num == -99) 
                   {
                           com_res=1;
                           
                   }
                   else
                   {
                           com_res= 1 + (com_res*10);
                           
                   }
                  
                   System.out.println("com_res = " + com_res);
                   prev_num=1;
                   //break;
            }
            else if (command.equalsIgnoreCase("two"))
            {
                System.out.println("two");
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide"))|| (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=2;
                           
                   }
                   else
                   {
                           com_res= 2 + (com_res*10);
                           
                   }
                    after_com= 2;
                }
                else if(prev_num == -99)
                   {
                       com_res=2;
                   }
                else
                   {
                           com_res= 2 + (com_res*10);
                           
                   }
                prev_num=2;
                
            System.out.println("com_res = " + com_res);
             } 
            else if (command.equalsIgnoreCase("three"))
            {
                System.out.println("three");
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide"))|| (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=3;
                           
                   }
                   else
                   {
                           com_res= 3 + (com_res*10);
                           
                   }
                    after_com= 3;
                }
                 else if(prev_num == -99)
                   {
                       com_res=3;
                   }
                else
                   {
                           com_res= 3 + (com_res*10);
                           
                   }
                prev_num=3;
                System.out.println("com_res = " + com_res);
             }
            else if (command.equalsIgnoreCase("four"))
            {
                System.out.println("four");
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide"))|| (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=4;
                           
                   }
                   else
                   {
                           com_res= 4 + (com_res*10);
                           
                   }
                    after_com= 4;
                }
                else
                if(prev_num == -99)
                   {
                        com_res=4;
                   }
               else
                   {
                           com_res= 4 + (com_res*10);
                           
                   }
                prev_num=4;
                  System.out.println("com_res = " + com_res);
            }
             else if (command.equalsIgnoreCase("five"))
            {
                System.out.println("five");
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide"))|| (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=5;
                           
                   }
                   else
                   {
                           com_res= 5 + (com_res*10);
                           
                   }
                    after_com= 5;
                }
                else
                if(prev_num == -99)
                   {
                       com_res=5;
                   }
                else
                   {
                           com_res= 5 + (com_res*10);
                           
                   }
                prev_num=5;
                System.out.println("com_res = " + com_res);
            }
             else if (command.equalsIgnoreCase("six"))
            {
                System.out.println("six");
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide"))|| (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=6;
                           
                   }
                   else
                   {
                           com_res= 6 + (com_res*10);
                           
                   }
                    after_com= 6;
                }
                else
                if(prev_num == -99)
                   {
                        com_res=6;
                   }
               else
                   {
                           com_res= 6 + (com_res*10);
                           
                   }
                prev_num=6;
                  System.out.println("com_res = " + com_res);
            }
             else if (command.equalsIgnoreCase("seven"))
            {
                System.out.println("seven");
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide"))|| (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=7;
                           
                   }
                   else
                   {
                           com_res= 7 + (com_res*10);
                           
                   }
                    after_com= 7;
                }
                else
                if(prev_num == -99)
                   {
                        com_res=7;
                   }
               else
                   {
                           com_res= 7 + (com_res*10);
                           
                   }
                prev_num=7;
                  System.out.println("com_res = " + com_res);
            }
             else if (command.equalsIgnoreCase("eight"))
            {
                System.out.println("eight");
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide"))|| (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=8;
                           
                   }
                   else
                   {
                           com_res= 8 + (com_res*10);
                           
                   }
                    after_com= 8;
                }
                else
                if(prev_num == -99)
                   {
                        com_res=8;
                   }
               else
                   {
                           com_res= 8 + (com_res*10);
                           
                   }
                prev_num=8;
                  System.out.println("com_res = " + com_res);
            }
             else if (command.equalsIgnoreCase("nine"))
            {
                System.out.println("nine");
                if((prev_com.equalsIgnoreCase("plus")) || (prev_com.equalsIgnoreCase("minus"))|| (prev_com.equalsIgnoreCase("multiply"))|| (prev_com.equalsIgnoreCase("divide"))|| (prev_com.equalsIgnoreCase("add"))||(prev_com.equalsIgnoreCase("multiply"))||(prev_com.equalsIgnoreCase("subtract")))
                {
                    
                    if(after_com == -99) 
                   {
                           com_res=9;
                           
                   }
                   else
                   {
                           com_res= 9 + (com_res*10);
                           
                   }
                    after_com= 9;
                }
                else
                if(prev_num == -99)
                   {
                        com_res=9;
                   }
               else
                   {
                           com_res= 9 + (com_res*10);
                           
                   }
                prev_num=9;
                  System.out.println("com_res = " + com_res);
            }
             else if(command.equalsIgnoreCase("clear"))
             {
                    com_res=0;
                    result1=0;
                    prev_com="xyz";
                    prev_num=-99;
                    System.out.println("clear");
             }
             else if (command.equalsIgnoreCase("plus")||command.equalsIgnoreCase("add"))
            {
                System.out.println("+");
                prev_com="plus";
                System.out.println("in plus loop com_res is =" + com_res);
                result1 = result1+com_res;
                System.out.println("result 1 = " + result1);
                com_res=0;

            }
              else if (command.equalsIgnoreCase("minus")||command.equalsIgnoreCase("subtract"))
            {
                System.out.println("-");
                prev_com="minus";
                System.out.println("in minus loop com_res is =" + com_res);
                result1 = com_res-result1;
                System.out.println("result 1 = " + result1);
                com_res=0;

            }
              else if (command.equalsIgnoreCase("multiply")||command.equalsIgnoreCase("into"))
            {
                System.out.println("*");
                prev_com="multiply";
                System.out.println("in multiply loop com_res is =" + com_res);
                result2 = result2*com_res;
                System.out.println("result 2 = " + result2);
                com_res=0;

            }
              else if (command.equalsIgnoreCase("divide"))
            {
                System.out.println("/");
                prev_com="divide";
                System.out.println("in divide loop com_res is =" + com_res);
                result2 = com_res/result2;
                System.out.println("result 2 = " + result2);
                com_res=0;

            }
              
             else if ((command.equalsIgnoreCase("equal")) ||(command.equalsIgnoreCase("gives")) )
            {
                System.out.println("=");
                
                //result1 = 0 ;
                 
                 if(prev_com.equalsIgnoreCase("plus")||command.equalsIgnoreCase("add"))
                 {
                     result1 += com_res;
                     System.out.println("result is = " + result1);
                     result1=0;
                 }
                 if(prev_com.equalsIgnoreCase("minus")||command.equalsIgnoreCase("subtract"))
                 {
                     result1 -= com_res;
                     System.out.println("result is = " + result1);
                     result1=0;
                 }
                 if(prev_com.equalsIgnoreCase("multiply")||command.equalsIgnoreCase("into"))
                 {
                     result2 *= com_res;
                     System.out.println("result is = " + result2);
                     result2=1;
                 }
                 if(prev_com.equalsIgnoreCase("divide"))
                 {
                     result2=result2/com_res;
                     System.out.println("result is = " + result2);
                     result2=1;
                   
                 }
                 else if(prev_com.equalsIgnoreCase(null))
                 {
                     System.out.println("say some operation");
                 }
                     

            }
            else
             {
                 System.out.println("say something !!!");
             }
          
        System.out.println("YOU CAN SPEAK  NOW");
            //In case command recognized is none of the above hence work might be null
           // if(work != null) {
                //Execute the command
                //p = Runtime.getRuntime().exec(work);
               
            //}
    }
        }
    public static void main(String[] args)  {
       Calculator c=new Calculator();
            try {
                c.calc();
            } catch (IOException ex) {
                Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}

