/**
 * Author: Nathan van der Velde
 * Date Created: 2018-02-06
 * Date Last Modified: 2018-02-07
 */

//IMPORTS

public class Subscriber
{
	//CLASS FIELDS
	private String company;
	private String street;
	private String suburb;
	private String state;
	private String postcode;
	private String phone;
	private String fax;
	private String cellphone;
	private String freecall;
	private String email;
	private String abn;
	private String industry;

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
		company = inDetails[0];
		street = inDetails[1];
		suburb = inDetails[2];
		state =  = inDetails[3];
		postcode = inDetails[4];
		phone = inDetails[5];
		fax = inDetails[6];
		cellphone = inDetails[7];
		freecall = inDetails[8];
		email = inDetails[9];
		abn = inDetails[9];
		industry = inDetails[10];
	}//END ALTERNATE CONSTRUCTOR #2

	public String getEmail()
	{
		String outEmail = email;
		return outEmail;
	}//END getEmail

	public String toString()
	{
		String outString;
		outString = company+","+street+","+suburb+","+state+","+postcode+","+phone+","+fax+","+cellphone+","+freecall+","+email+","+abn+","+industry;
		return outString;
	}//END toString
}//END class Subscriber