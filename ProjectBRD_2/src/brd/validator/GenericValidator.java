/**

 *@Class GenericValidator
 * @version 3.0 23.11.2018 
 * @author Lakshmi Narayanan
 */
package brd.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenericValidator
{
	static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args)
	{
		System.out.println("Data type Validator");
		System.out.println(validateDataTyoe(10.225));
		System.out.println("Data length validator");
		System.out.println(validateDataLength("Lana", (short) 4));
		System.out.println("Special character Validator");
		System.out.println(validateSpecialCharacter("Lana@"));
		System.out.println("Domain Validator");
		System.out.println(validateDomainField());
		System.out.println("Email validator");
		System.out.println(validateEmail("mailme.narayaan96@gmail.com"));
		System.out.println("Date validator");
		System.out.println(day(dateFormatter, "24/44/2018"));
	}
	public static boolean validateDataTyoe(Object numeric)
	{
//	getClass().getSimpleName() return the data-type
		if (numeric.getClass().getSimpleName().equals("Integer"))
		{
			return true;
		} else if (numeric.getClass().getSimpleName().equals("String"))
		{
			return true;
		} else if (numeric.getClass().getSimpleName().equals("Character"))
		{
			return true;
		} else if (numeric.getClass().getSimpleName().equals("Double"))
		{
			return true;
		}
		return false;
	}

	public static boolean validateDataLength(String object, short length)
	{
		if (object.length() <= length)
		{
			return true;
		}
		return false;
	}

	public static boolean validateSpecialCharacter(String character)
	{
		if (character.contains("@") || character.contains("#") || character.contains("$") || character.contains("%")
				|| character.contains("^"))
		{
			return false;
		}

		return true;
	}

	public static boolean validateDomainField()
	{
		ArrayList<String> daylist = new ArrayList<String>();
		daylist.add("Monday");
		daylist.add("Tuesday");
		daylist.add("Wednesday");
		daylist.add("Thursday");
		daylist.add("Friday");
		daylist.add("Saturday");

		if (daylist.contains("Sunday"))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public static boolean validateEmail(String email)
	{
		if (email.contains("@") || email.contains("."))
		{
			if (!email.contains(" "))
			{
				return true;
			}
		}
		return false;
	}

	public static Boolean day(SimpleDateFormat formatter, String datevalue)
	{
		formatter.setLenient(false);
		try
		{
			formatter.parse(datevalue);
			return true;

		} catch (ParseException e)
		{
			return false;
		}
	}

}
