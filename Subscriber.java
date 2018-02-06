/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-06
 * Date Last Modified: 2018-02-06
 */

//IMPORTS

public class Subscriber
{
	//CLASS FIELDS
	private String email;

	// DEFAULT CONSTRUCTOR
	public Subscriber()
	{
		//To defeat instantiation
	}//END DEFAULT CONSTRUCTOR

	// ALTERNATE CONSTRUCTOR #1
	public Subscriber(String inEmail)//COULD POSSIBLY NEED TO ADD VALIDATION IN THE FUTURE.
	{
		email = inEmail;
	}//END ALTERNATE CONSTRUCTOR #1


	// ALTERNATE CONSTRUCTOR #2
	public Subscriber(String [] inDetails)
	{
		email = inDetails[9];
	}//END ALTERNATE CONSTRUCTOR #2

	public String getEmail()
	{
		String outEmail = email;
		return outEmail;
	}//END getEmail
}//END class Subscriber