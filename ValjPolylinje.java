import java.util.*;

class ValjPolylinje
{
	public static final Random rand = new Random ();
	public static final int ANTAL_POLYLINJER = 10;

	public static void main (String[] args)
	{
		// skapa ett antal slumpm�ssiga polylinjer
		Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			polylinjer[i] = slumpPolylinje ();

		// visa polylinjerna
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
			System.out.println("\n" + polylinjer[i] + "\nlangd: " + polylinjer[i].langd());

		double polylangd = 0;
		int minstlinje = 0;

		// best�m den kortaste av de polylinjer som �r gula
		//lägger gul linje på sparad langd
		for(int i = 0; i < ANTAL_POLYLINJER; i++)
			if (polylinjer[i].getFarg().equals("Gul") == true)
				polylangd = polylinjer[i].langd();

		//hittar kortast linje
		for (int i = 0; i < ANTAL_POLYLINJER; i++)
		{
			if (polylinjer[i].getFarg().equals("Gul") == true)
			{
				if(polylangd >= polylinjer[i].langd())
				{
					polylangd = polylinjer[i].langd();
					minstlinje = i;
				}
			}
		}

		// visa den valda polylinjen, endast om denna ar Gul
		if (polylinjer[minstlinje].getFarg().equals("Gul") == true)
			System.out.println("\nKortast Gul Polylinje: " + polylinjer[minstlinje] + "\nlangd: " + polylinjer[minstlinje].langd());
		else
			System.out.println("\nIngen Gul linje");
	}

	// slumpPunkt returnerar en punkt med ett slumpm�ssigt namn, som �r en stor bokstav i
	// det engelska alfabetet, och slumpm�ssiga koordinater.
	public static Punkt slumpPunkt ()
	{
		String n = "" + (char) (65 + rand.nextInt (26));
		int x = rand.nextInt (11);
		int y = rand.nextInt (11);

		return new Punkt (n, x, y);
	}

	// slumpPolylinje returnerar en slumpm�ssig polylinje, vars f�rg �r antingen bl�, eller r�d
	// eller gul. Namn p� polylinjens h�rn �r stora bokst�ver i det engelska alfabetet. Tv� h�rn
	// kan inte ha samma namn.
	public static Polylinje slumpPolylinje ()
	{
		// skapa en tom polylinje, och l�gg till h�rn till den
		Polylinje polylinje = new Polylinje ();
		int antalHorn = 2 + rand.nextInt (7);
		int antalValdaHorn = 0;
		boolean[] valdaNamn = new boolean[26];

		Punkt[] p = new Punkt[antalHorn];

		// ett och samma namn kan inte f�rekomma flera g�nger
		Punkt valdPunkt = null;
		char valtChar = 0;

		while (antalValdaHorn < antalHorn)
		{
			valdPunkt = slumpPunkt();
			valtChar = valdPunkt.getNamn().charAt(0);
			if(valdaNamn[(int)valtChar - 65] == false)
			{
				p[antalValdaHorn] = valdPunkt;
				valdaNamn[(int)valtChar - 65] = true;
				antalValdaHorn++;
			}
		}
		polylinje = new Polylinje(p);

		// s�tt f�rg
		//fargvarde, 1,2,3 rod, gul, bla
		int fargvarde = rand.nextInt (3) + 1;
		if(fargvarde == 1)
			polylinje.setFarg("Rod");
		else if(fargvarde == 2)
			polylinje.setFarg("Gul");
		else if(fargvarde == 3)
			polylinje.setFarg("Bla");

		return polylinje;
	}
}