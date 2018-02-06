/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-06
 * Date Last Modified: 2018-02-06
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
    //CLASS FIELDS
    private String filename;
    private List<Subscriber> subscribers;


    // DEFAULT CONSTRUCTOR
    public FileReader()
    {
        //Just to defeat instantiation
    }//END DEFAULT CONSTRUCTOR


    //ALTERNATE CONSTRUCTOR
    public FileReader(String inFilename) throws IOException
    {
        if(validateFileName(inFilename))
        {
            filename = inFilename;
            emails = readStringsFromFile(filename);
        }
        else
        {
            throw new IOException("The file does not exists");
        }//ENDIF
    }//END ALTERNATE CONSTRUCTOR


    public List<Subscriber> readUnsubscribeFile(String inFilename) throws IOException
    {
        List<Subscriber> subscribers = new ArrayList<>();
        Path pathToFile = Paths.get(inFilename);

        //Create an instance of BufferedReader
        //Using try with resource, Java 7 feature to close resources is being used.
        try(BufferedReader bufRdr = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
        {
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
        }//END TRY
        catch(IOException ioex)
        {
            throw ioex;
        }//END CATCH
        return subscribers;
    }//END readUnsubscribeFile


    public List<Subscriber> readStringsFromFile(String inFilename) throws IOException
    {
        List<Subscriber> subscribers = new ArrayList<>();
        Path pathToFile = Paths.get(inFilename);

        //Create an instance of BufferedReader
        //Using try with resource, Java 7 feature to close resources is being used.
        try(BufferedReader bufRdr = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
        {
            //Read the first line of the csv file
            String line = bufRdr.readLine();

            //Loop until all lines in the file are read
            while(line != null)
            {
                String [] subDetails = line.split(",");
                Subscriber newSubscriber = new Subscriber(subDetails);
                subscribers.add(newSubscriber);
                line = bufRdr.readLine();
            }//END WHILE
        }//END TRY
        catch(IOException ioex)
        {
            throw ioex;
        }//END CATCH
        return subscribers;
    }//END readStringsFromFile


    private boolean validateFileName(String inFilename)
    {
        boolean isValid = false;
        Path pathToFile = Paths.get(inFilename)
        File file = new File(pathToFile);
        if(file.exists() && !file.isDirectory())
        {
            isValid = true;
        }//ENDIF
        return isValid
    }

}//END class FileReader