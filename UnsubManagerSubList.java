/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-07
 * Date Last Modified: 2018-02-07
 */

//IMPORTS
import java.util.ArrayList;
import java.util.List;

public class UnsubManagerSubList
{
    public static List<Subscriber> createSubList(ArrayList<Subscriber>[] inSubscriberFileLists)
    {
        List<Subscriber> subscriberList = new ArrayList<Subscriber>();

        for(int ii=0;ii<inSubscriberFileLists.length;ii++)
        {
            subscriberList.addAll(inSubscriberFileLists[ii]);
        }//ENDFOR
        return subscriberList;
    }//END createSubList
}//END class UnsubManagerSubList