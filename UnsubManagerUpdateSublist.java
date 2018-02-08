/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-07
 * Date Last Modified: 2018-02-07
 */

//IMPORTS
import java.util.List;
import java.util.ArrayList;

public class UnsubManagerUpdateSublist
{
    public static void updateList(List<Subscriber> unSubList, List<Subscriber> subList)
    {
        int [] indexToDelete = new int[unSubList.size()];
        Subscriber [] sublist = new Subscriber[subList.size()];

        for(int ii=0;ii<sublist.length;ii++)
        {
            sublist[ii] = subList.get(ii);
        }//ENDFOR

        for(int ii=0;ii<unSubList.size();ii++)
        {
            for(int jj=0;jj<sublist.length;jj++)
            {
                if(unSubList.get(ii).getEmail().equals(subList.get(jj).getEmail()))
                {
                    indexToDelete[ii] = jj;
                }//ENDIF
            }//END FOR
        }//END FOR
        for(int ii=0;ii<indexToDelete.length;ii++)
        {
            sublist[indexToDelete[ii]] = null;
        }//END FOR
        System.out.print("Files being processed to write.\n");
        UnsubManagerWriteNewCSVFiles.sortListToWrite(sublist);
    }//END upateList
}//END class UnsubManagerUpdateSublist