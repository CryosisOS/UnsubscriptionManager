/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-07
 * Date Last Modified: 2018-02-07
 */

//IMPORTS
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class UnsubManagerWriteNewCSVFiles
{
    public static void sortListToWrite(Subscriber[] newSubList)
    {
        String filename;
        filename = "OutputFile.csv";
        writeListToFile(newSubList, filename);
    }//END writeNewFiles

    public static void writeListToFile(Subscriber [] inSubList, String filename)
    {
        BufferedWriter bufWtr = null;
        FileWriter fileWtr = null;

        try
        {
            fileWtr = new FileWriter(filename);
            bufWtr = new BufferedWriter(fileWtr);
            for(int ii=0;ii<inSubList.length;ii++)
            {
                if(inSubList[ii]!=null)
                {
                    bufWtr.write(inSubList[ii].toString()+"\n");
                }//ENDIF
            }//END FOR
            bufWtr.close();
        }//END TRY
        catch(IOException ioex)
        {
            if(fileWtr != null)
            {
                try
                {
                    fileWtr.close();
                }//END TRY
                catch(IOException ioex2)
                {
                    //can't do anything more
                }//END CATCH
            }//END IF
            out.print("There was a problem with writing to the file.\n");
            ioex.printStackTrace();
        }//END CATCH
    }//END writeListToFile
}//END class UnsubManagerWriteNewCSVFiles