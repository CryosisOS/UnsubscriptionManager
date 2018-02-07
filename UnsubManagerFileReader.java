/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-06
 * Date Last Modified: 2018-02-07
 */

//IMPORTS
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UnsubManagerFileReader
{
    public static List<Subscriber> readUnsubscribeFile(String inFilename)
    {
        List<Subscriber> subscribers = new ArrayList<>();
        Path pathToFile = Paths.get(inFilename);
        BufferedReader bufRdr = null;

        //Create an instance of BufferedReader
        //Using try with resource, Java 7 feature to close resources is being used.
        try
        {
            bufRdr = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            //Read the first line of the csv file
            String line = bufRdr.readLine();//Skip the first line.
            line = bufRdr.readLine();

            //Loop until all lines in the file are read
            while(line != null)
            {
                String email = cleanUpEmail(line);
                Subscriber newSubscriber = new Subscriber(email);
                subscribers.add(newSubscriber);
                line = bufRdr.readLine();
            }//END WHILE
            bufRdr.close();
        }//END TRY
        catch(IOException ioex)
        {
            if(bufRdr != null)
            {
                try
                {
                    bufRdr.close();
                }//END TRY
                catch(IOException ioex2)
                {
                    //Can't do anything more
                }//END CATCH
            }//ENDIF
            System.out.println("There was an error with reading the Unsubscription File.");
        }//END CATCH
        return subscribers;
    }//END readUnsubscribeFile


    public static List<Subscriber> readStringsFromFile(String inFilename)
    {
        List<Subscriber> subscribers = new ArrayList<>();
        Path pathToFile = Paths.get(inFilename);
        BufferedReader bufRdr = null;

        //Create an instance of BufferedReader
        //Using try with resource, Java 7 feature to close resources is being used.
        try
        {
            bufRdr = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            //Read the first line of the csv file
            String line = bufRdr.readLine();
            line = bufRdr.readLine();//Skip the first line.
            
            //Loop until all lines in the file are read
            while(line != null)
            {
                String [] subDetails = line.split(",");
                Subscriber newSubscriber = new Subscriber(subDetails);
                subscribers.add(newSubscriber);
                line = bufRdr.readLine();
            }//END WHILE
            bufRdr.close();
        }//END TRY
        catch(IOException ioex)
        {
            if(bufRdr != null)
            {
                try
                {
                    bufRdr.close();
                }//END TRY
                catch(IOException ioex2)
                {
                    //Can't do anything more
                }//END CATCH
            }//ENDIF
            System.out.println("There was an error with reading the Subscription list: "+inFilename);
        }//END CATCH
        return subscribers;
    }//END readStringsFromFile

    private static String cleanUpEmail(String inString)
    {
        StringBuilder cleanEmail = new StringBuilder(inString);
        String email = cleanEmail.toString().replace("\"","");
        return email;
    }//END cleanUpEmail

    private static boolean validateFileName(String inFilename)
    {
        boolean isValid = false;
        Path pathToFile = Paths.get(inFilename);
        File file = new File(pathToFile.toString());
        if(file.exists() && !file.isDirectory())
        {
            isValid = true;
        }//ENDIF
        return isValid;
    }//END validateFileName

}//END class FileReader