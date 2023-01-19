import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
 	public static void main (String[] args)
	 {
 		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
 		// mata in tv� naturliga heltal

 		Scanner in = new Scanner (System.in);
 		out.println ("tv� naturliga heltal:");
 		String tal1 = in.next ();
 		String tal2 = in.next ();
 		out.println ();

 		// addera heltalen och visa resultatet
 		String summa = addera (tal1, tal2);
 		visa (tal1, tal2, summa, '+');

 		out.println("\n");

 		// subtrahera heltalen och visa resultatet
 		summa = subtrahera (tal1, tal2);
 		visa (tal1, tal2, summa, '-');
 	}

 	// addera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar deras
	// summa som en teckenstr�ng.
	public static String addera (String tal1, String tal2)
	{
		int length = tal1.length();
		char save1 = ' ';
		char save2 = ' ';
		String Addition = " ";
		String rightAddition = " ";
		boolean keep1 = false;
		String Answer = " ";

		if(tal2.length() < tal1.length())					//om tal2 är mindre än tal1, fyll upp det utrymmet i tal2 med 0or '009'
		{
			int dif = tal1.length() - tal2.length();
			String temp = tal2;
			tal2 = "";
			for(int i = 1; i <= dif; i++)
				tal2 += '0';
			tal2 += temp;
			length = tal2.length();
		}

		for(int i = length - 1; i >= 0; i--)				// String "HEJ" , H = position 0, E is position 1, J is position 2
		{
			char number1 = tal1.charAt(i);					//plockar ut siffran på tal 1
			char number2 = tal2.charAt(i);					//plockar ut siffran på tal 2
			if(keep1 == true)								//lägger till carry-over ettan till additionen
			{
				Addition = String.valueOf((number1 - '0') + (number2 - '0') + 1);
				keep1 = false;
			}
			else if(keep1 == false)							//standard addition
			{
				Addition = String.valueOf((number1 - '0') + (number2 - '0'));		//lägger ihop sparade numren och konverterar till string
			}
			if(Integer.parseInt(Addition) > 9)				//addition där svaret blir större än 9, spara carry-over ettan
			{
				save1 = Addition.charAt(1); 				//saves 2 out of "12"
				save2 = Addition.charAt(0); 				// saves 1 out of "12"
				keep1 = true;
				Answer += save1;
			}
			else
			{
				Answer += Addition;
			}
		}
		if(keep1 == true)									//om första siffran får en över, lägg till 1
			Answer += save2;

		for (int i=0; i < Answer.length(); i++)				//v�nder p� talet
		{
			char ch = Answer.charAt(i); 					//extracts each character
			rightAddition= ch + rightAddition;
		}
 		return rightAddition;
 	}

 	// subtrahera tar emot tv� naturliga heltal givna som teckenstr�ngar, och returnerar
 	// deras differens som en teckenstr�ng.
 	// Det f�rsta heltalet �r inte mindre �n det andra heltalet.

	public static String subtrahera (String tal1, String tal2)
	{
		int length = tal1.length();
		char save1 = ' ';
		char save2 = ' ';
		String Subtraktion = " ";
		String rightsubtraktion = " ";
		String tiotal = " ";
		boolean Remove1 = false;
		String Answer = " ";

		if(tal2.length() < tal1.length())										//om tal2 är mindre än tal1, fyll upp det utrymmet i tal2 med 0or '009'
		{
			int dif = tal1.length() - tal2.length();
			String temp = tal2;
			tal2 = "";
			for(int i = 1; i <= dif; i++)
				tal2 += '0';
			tal2 += temp;
			length = tal2.length();
		}

		for(int i = length - 1; i >= 0; i--)									// String "HEJ" , H = position 0, E is position 1, J is position 2
		{
			char number1 = tal1.charAt(i);										//plockar ut siffran på tal 1
			char number2 = tal2.charAt(i);										//plockar ut siffran på tal 2
			char numberNext = ' ';
			if((number1 - '0') < (number2 - '0'))								//kollar om tal1 är större än tal 2 och lånar från siffran framför
			{
				tiotal = String.valueOf((number1 - '0') + 10);
				Subtraktion = String.valueOf(Integer.parseInt(tiotal) - (number2 - '0'));
				Answer += Subtraktion;
				Remove1 = true;
			}
			else if(Remove1 == true && ((number1 - '0') - 1) > (number2 - '0'))			//subtraherar tal med 1 stryken då den fortfarande är större
			{
				Subtraktion = String.valueOf(((number1 - '0') - 1) - (number2 - '0'));	//subtraherar nummer från varandra		(problem när num1 - 1 mindre än num2)
				if(Integer.parseInt(Subtraktion) != 0)
					Answer += Subtraktion;
				Remove1 = false;
			}
			else if(Remove1 == true && ((number1 - '0') - 1) < (number2 - '0'))			//subtrahera tal med 1 stryken då den är mindre
			{
				tiotal = String.valueOf(((number1 - '0') - 1) + 10);
				Subtraktion = String.valueOf(Integer.parseInt(tiotal) - (number2 - '0'));
				if(Integer.parseInt(Subtraktion) != 0)
					Answer += Subtraktion;
			}
			else if((number1 - '0') >= (number2 - '0'))									//subtraherar numer från varandra
			{
				Subtraktion = String.valueOf((number1 - '0') - (number2 - '0'));
				Answer += Subtraktion;
			}
		}

		for (int i = 0; i < Answer.length(); i++)		//v�nder p� talet
		{
			char ch = Answer.charAt(i); 			//extracts each character
			rightsubtraktion= ch + rightsubtraktion;
		}

 		return rightsubtraktion;
 	}

 	// visa visar tv� givna naturliga heltal, och resultatet av en aritmetisk operation
 	// utf�rd i samband med hetalen

	public static void visa (String tal1, String tal2, String resultat, char operator)
 	{

 		// s�tt en l�mplig l�ngd p� heltalen och resultatet

 		int len1 = tal1.length ();
 		int len2 = tal2.length ();
 		int len = resultat.length ();
 		int maxLen = Math.max (Math.max (len1, len2), len);
 		tal1 = sattLen (tal1, maxLen - len1);

 		tal2 = sattLen (tal2, maxLen - len2);
 		resultat = sattLen (resultat, maxLen - len);

 		// visa heltalen och resultatet

 		out.println (" " + tal1);
 		out.println ("" + operator + "" + tal2);
 		for (int i = 0; i < maxLen + 2; i++)
 			out.print ("-");
 		out.println (); 	//skriver ut precis under
 		out.print ("   " + resultat + "\n");
	}

	 // sattLen l�gger till ett angivet antal mellanslag i b�rjan av en given str�ng

	public static String sattLen (String s, int antal)
	{
		 StringBuilder sb = new StringBuilder (s);
		 for (int i = 0; i < antal; i++)
		 sb.insert (0, " ");
		 return sb.toString ();
	}
}
