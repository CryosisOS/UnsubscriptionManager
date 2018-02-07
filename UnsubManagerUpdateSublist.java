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
    public static List<Subscriber> updateList(List<Subscriber> unSubList, List<Subscriber> subList)
    {
        List<Integer> indexToDelete = new ArrayList<Integer>();

        for(int ii=0;ii<unSubList.size();ii++)
        {
            for(int jj=0;jj<subList.size();jj++)
            {
                if(unSubList.get(ii).getEmail().equals(subList.get(jj).getEmail()))
                {
                    indexToDelete.add(jj);
                }//ENDIF
            }//END FOR
        }//END FOR
        for(int ii=0;ii<indexToDelete.size();ii++)
        {
            subList.remove(indexToDelete.get(ii));
        }//END FOR
        return subList;
    }//END upateList
}//END class UnsubManagerUpdateSublist