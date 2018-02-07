/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-07
 * Date Last Modified: 2018-02-07
 */

//IMPORTS
import java.util.List;

public class UnsubManagerUpdateSublist
{
    public static List<Subscriber> updateList(List<Subscriber> unSubList, List<Subscriber> subList) implements Iterator
    {
        for(Iterator<Subscriber> iterator = subList.iterator();iterator.hasNext();)
        {
            if(iterator.next().getEmail().equals(unSubList.getEmail))
            {
                iterator.remove();
            }//ENDIF
        }//END FOR
        return subList;
    }//END upateList
}//END class UnsubManagerUpdateSublist