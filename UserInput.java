/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-06
 * Date Last Modified: 2018-02-06
 */

//IMPROTS
import java.util.InputMismatchException;
import static java.lang.System.out;

public class UserInput
{
    public static int getInteger(String prompt)
    {
        int input;
        boolean cont = true;
        Scanner sc = new Scanner(System.in);

        do
        {
            cont = true;
            try
            {
                out.print(prompt);
                input = sc.nextInt();
                cont = false;
            }//END TRY
            catch(InputMismatchException imex)
            {
                out.print("That was an invalid input please try again.");
                sc.reset();
                sc.next();
                cont = true;
            }

        }while(cont)
        return input;
    }//END getInteger

    public static String getString(String prompt)
    {
        String input;
        Scanner sc = new Scanner(System.in);

        out.print(prompt);
        sc.reset();
        input = sc.nextLine();
        return input;
    }//END getString
}//END class UserInput