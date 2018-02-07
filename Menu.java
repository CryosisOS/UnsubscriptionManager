/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-07
 * Date Last Modified: 2018-02-07
 */

//IMPORTS
import java.util.List;
import java.util.ArrayList;

import static java.lang.System.out;

public class Menu
{
    public static void mainMenu()
    {
        out.print("------------------------------------------------------------------------------\n");
        out.print("                         Author: Nathan van der Velde                         \n");
        out.print("                     Lakes Networking - Internal Software                     \n");
        out.print("------------------------------------------------------------------------------\n");
        out.print("            This software is used for managing the subscriber list            \n");
        out.print("                   by removing un-subscribers from the list                   \n");
        out.print("\n\n");
        sortLists();
    }//END mainMenu

    private static void sortLists()
    {
        String unSubFile;
        String [] subFiles;
        List<Subscriber> unSubList;
        List<Subscriber> subList;
        ArrayList<Subscriber>[] subLists;

        unSubFile = UnsubManagerFileSelector.chooseUnsubList();
        subFiles = UnsubManagerFileSelector.chooseSubList();
        unSubList = UnsubManagerFileReader.readUnsubscribeFile(unSubFile);
        subLists = new ArrayList[subFiles.length];
        for(int ii=0;ii<subFiles.length;ii++)
        {
            subLists[ii] = UnsubManagerFileReader.readStringsFromFile(subFiles[ii]);
        }//END FOR
        subList = UnsubManagerSubList.createSubList(subLists);
        subList = UnsubManagerUpdateSublist.updateList(unSubList, subList);
        UnsubManagerWriteNewCSVFiles.sortListToWrite(subList);

    }//END getLists
}//END class Menu