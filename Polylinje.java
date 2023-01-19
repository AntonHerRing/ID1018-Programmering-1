public class Polylinje
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	//tom konstruktor
	public Polylinje ()
	{
		this.horn = new Punkt[0];
	}

	//kopierings konstruktor
	public Polylinje (Polylinje annan)
	{
		this.horn = new Punkt[annan.horn.length];
		for (int i = 0; i < this.horn.length; i++)
			this.horn[i] = annan.horn[i];
	}

	//konstruktor
	public Polylinje (Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}

	//konvertera objektet till f�rbest�mmt String format
	public String toString ()
	{
		String polylinje = "{[";
		for(int i = 0; i <= horn.length - 1; i++)
			polylinje += this.horn[i];
		polylinje += "], "+ this.farg + ", " + this.bredd + "}";
		return polylinje;
	}

	//I metoden getHorn ska en vektor som inneh�ller kopior
	//av polylinjens h�rn skapas och en referens till
	//denna vektor ska returneras.
	public Punkt[] getHorn ()
	{
		Punkt[] h = new Punkt[this.horn.length];
		for(int i = 0; i <= this.horn.length - 1; i++)
			h[i] = new Punkt(horn[i]);
		return h;
	}

	//ger tillbaka f�rgen
	public String getFarg ()
	{
		return this.farg;
	}

	//ger tillbaka bredd
	public int getBredd ()
	{
		return this.bredd;
	}

	//s�tt f�rgen
	public void setFarg (String farg)
	{
		this.farg = farg;
	}

	//s�tt bredden
	public void setBredd (int bredd)
	{
		this.bredd = bredd;
	}

	//ger tillbaka total l�ngd
	public double langd ()
	{
		double linjelangd = 0;
		for(int i = 0; i <= this.horn.length - 2; i++)
			linjelangd += horn[i].avstand(horn[i + 1]);

		return linjelangd;
	}

	// l�gger till horn
	public void laggTill (Punkt horn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt (horn);
		this.horn = h;
	}

	//I metoden laggTillFramfor ska det h�rn som parameterreferensen refererar till kopieras.
	public void laggTillFramfor (Punkt horn, String hornNamn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		String correktnamn = "";
		boolean korrektion = false;
		for(int i = this.horn.length - 1; i >= 0; i--)
		{
			correktnamn = this.horn[i].getNamn();
			if(hornNamn.equals(correktnamn))
			{
				h[i + 1] = this.horn[i];
				h[i] = new Punkt(horn);
				korrektion = true;
			}
			else if(korrektion)
			{
				h[i] = this.horn[i];
			}
			else
			{
				h[i + 1] = this.horn[i];
			}
		}
		this.horn = h;
	}

	//ta bort
	public void taBort (String hornNamn)
	{
		Punkt[] h = new Punkt[this.horn.length - 1];
		String correktnamn = "";
		boolean korrektion = false;
		for(int i = this.horn.length - 1; i >= 0; i--)
		{
			correktnamn = this.horn[i].getNamn();
			if(hornNamn.equals(correktnamn))
			{
				korrektion = true;
			}
			else if(korrektion == true)
			{
				h[i] = this.horn[i];
			}
			else
			{
				h[i - 1] = this.horn[i];
			}
		}
		this.horn = h;
	}

	//Del-Uppgift D

	public class PolylinjeIterator
	{
	 	private int aktuell = -1;

	 	public PolylinjeIterator ()
	 	{
	 		if (Polylinje.this.horn.length > 0)
	 			aktuell = 0;
	 	}

	 	public boolean finnsHorn ()
	 	{
	 		return aktuell != -1;
	 	}

	 	public Punkt horn () throws java.util.NoSuchElementException
	 	{
	 		if (!this.finnsHorn ())
	 			throw new java.util.NoSuchElementException (
	 									"slut av iterationen");
			 Punkt horn = Polylinje.this.horn[aktuell];

			 return horn;
		 }

		 public void gaFram ()
		 {
			if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
		 		aktuell++;
		 	else
		 		aktuell = -1;
		 }
	 }
}
