import java.util.*;

class VPolylinje implements Polylinje2
{
	private String farg = "Vektor";
	private int bredd = 1;
	private Punkt[] horn;

	//kopierings konstruktor
	public VPolylinje (VPolylinje annan)
	{
		this.horn = new Punkt[annan.horn.length];
		for (int i = 0; i < this.horn.length; i++)
			this.horn[i] = annan.horn[i];
	}

	//konstruktor
	public VPolylinje (Punkt[] horn)
	{
		this.horn = new Punkt[horn.length];
		for (int i = 0; i < horn.length; i++)
			this.horn[i] = new Punkt (horn[i]);
	}

	public VPolylinje()
	{
		this.horn = new Punkt[0];
	}

	public Punkt[] getHorn()
	{
		Punkt[] h = new Punkt[this.horn.length];
			for(int i = 0; i <= this.horn.length - 1; i++)
				h[i] = new Punkt(horn[i]);
		return h;
	}

	public String getFarg()
	{
		return this.farg;
	}

	public int getBredd ()
	{
		return this.bredd;
	}

	public double langd ()
	{
		double linjelangd = 0;
		for(int i = 0; i <= this.horn.length - 2; i++)
			linjelangd += horn[i].avstand(horn[i + 1]);
		return linjelangd;
	}

	public void setFarg (String farg)
	{
		this.farg = farg;
	}

	public void setBredd (int bredd)
	{
		this.bredd = bredd;
	}

	public void laggTill (Punkt horn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for (i = 0; i < this.horn.length; i++)
			h[i] = this.horn[i];
		h[i] = new Punkt (horn);
		this.horn = h;
		}

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

	public String toString()
	{
		String polylinje = "{[";
		for(int i = 0; i <= horn.length - 1; i++)
			polylinje += this.horn[i];
		polylinje += "], "+ this.farg + ", " + this.bredd + "}";
		return polylinje;
	}

	public Iterator<Punkt> iterator ()
	{
		Iterator<Punkt> itPunkt = new Iterator<Punkt>()
		{
			private int index = 0;

			public boolean hasNext()
			{
				if(index >= VPolylinje.this.horn.length)
					index = -1;
				return (index != -1);
			}

			public Punkt next()
			{
				return horn[index++];
			}

			public void remove()
			{

				int length = VPolylinje.this.horn.length - 1;
				index -= 1;
				Punkt[] h = new Punkt[length];
				for(int i = 0; i < length; i++)
				{
					if(i < index)
						h[i] = horn[i];
					else
						h[i] = horn[i + 1];
				}
				horn = h;
			}
		};
		return itPunkt;
	}
}
