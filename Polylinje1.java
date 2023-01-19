public class Polylinje1
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;

	//tom konstruktor
	public Polylinje1 ()
	{
		this.horn = new Punkt[0];
	}

	//kopierings konstruktor
	public Polylinje1 (Polylinje1 annan)
	{
		this.horn = annan.horn;
	}

	//konstruktor
	public Polylinje1 (Punkt[] horn)
	{
		this.horn = horn;
	}

	//konvertera objektet till f?rbest?mmt String format
	public String toString ()
	{
		String polylinje = "{[";
		for(int i = 0; i <= horn.length - 1; i++)
			polylinje += this.horn[i];
		polylinje += "], "+ this.farg + ", " + this.bredd + "}";
		return polylinje;
	}

	//I metoden getHorn ska en vektor som inneh?ller kopior av polylinjens h?rn skapas, och en referens till denna vektor ska returneras.
	public Punkt[] getHorn ()
	{
		Punkt[] h = new Punkt[this.horn.length];
		for(int i = 0; i <= this.horn.length - 1; i++)
			h[i] = this.horn[i];
		return h;
	}

	//ger tillbaka f?rgen
	public String getFarg ()
	{
		return this.farg;
	}

	//ger tillbaka bredd
	public int getBredd ()
	{
		return this.bredd;
	}

	//s?tt f?rgen
	public void setFarg (String farg)
	{
		this.farg = farg;
	}

	//s?tt bredden
	public void setBredd (int bredd)
	{
		this.bredd = bredd;
	}

	//ger tillbaka total l?ngd
	public double langd ()
	{
		double linjelangd = 0;
		for(int i = 0; i <= this.horn.length - 2; i++)
			linjelangd += horn[i].avstand(horn[i+1]);

		return linjelangd;
	}

	// l?gger till horn
	public void laggTill (Punkt horn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt (horn);
		this.horn = h;
	}

	//I metoden laggTillFramfor ska det h?rn som parameterreferensen refererar till kopieras.
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
			else if(korrektion == true)
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

}