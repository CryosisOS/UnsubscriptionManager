/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-07
 * Date Last Modified: 2018-02-07
 */

//IMPORTS
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList<E>;
import java.util.List;

import static java.lang.System.out;

public class UnsubManagerWriteNewCSVFiles
{
    public static void sortListToWrite(List<Subscriber> newSubList)
    {
        int length = newSubList.size();
        int numFiles = 1;
        int newLength = newSubList.size();
        String filename;
        ArrayList<Subscriber>[] = (ArrayList<Subscriber>[])new ArrayList[numFiles];

        if(newSubList.size() < 5300)
        {
            numFiles = length / 5300;
            newLength = length / numFiles;
            ArrayList<Subscriber>[] subLists = (ArrayList<Subscriber>[])new ArrayList[numFiles];
        }//ENDIF

        while(newSubList.size() != 0)
        {
            if(newLength <= newSubList.size())
            {
                for(int ii=0;ii<=subLists.length;ii++)
                {
                    if(subLists[ii].length < newLength)
                    {
                        if(newSubList.size() == 0)
                        {
                            break;
                        }//ENDIF
                        subLists[ii].add(newSubList.get(0));
                        newSubList.remove(0);
                    }//ENDIF
                }//END FOR
            }//ENDIF
        }//END WHILE
        for (int ii=0;ii<subLists.length;ii++)
        {
            filename = "OutputFile"+ii+".csv";
            writeListToFile((List<Subscriber>)subLists[ii], filename);
        }//ENDFOR
    }//END writeNewFiles

    public static void WriteListToFile(List<Subscriber> inList, String filename)
    {
        BufferedWriter bufWtr = null;
        FileWriter fileWtr = null;

        try
        {
            fileWtr = new FileWriter(filename);
            bufWtr = new BufferedWriter(fileWtr);
            for(int ii=0;ii<inList.size();ii++)
            {
                bufWtr.write(inList.get(ii).toString);
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
        }//END CATCH
    }//END writeListToFile
}//END class UnsubManagerWriteNewCSVFiles