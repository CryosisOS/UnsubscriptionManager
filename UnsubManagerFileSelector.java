/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-06
 * Date Last Modified: 2018-02-06
 */

//IMPORTS
import static java.lang.System.out;

public class UnsubManagerFileSelector
{
    public static String chooseUnsubList()
    {
        String unsubList;
        String prompt = "Please enter in the name of the list that contains the list of unsubscribers: ";

        unsubList = UserInput.getString(prompt);
        return unsubList;
    }

    public static String [] chooseSubList()
    {
        int numberOfFiles;
        String [] subscriberFileList;
        String promptOne = "Please enter in the number of files that make up the subcriber list: ";
        String promptTwo = "Please enter in a filename that contains a part of the current subscriber list: ";


        numberOfFiles = UserInput.getInteger(promptOne);
        subscriberFileList = new String[numberOfFiles];
        for(int ii=0;ii<subscriberFileList.length;ii++)
        {
            subscriberFileList[ii] = UserInput.getString(promptTwo+ii);
            out.println(subscriberFileList[ii]);
        }//ENDFOR
        return subscriberFileList;
    }//END chooseSubList
}//END class UnsubManagerFileSelector