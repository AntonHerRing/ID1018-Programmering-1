import java.util.*;

public class NPolylinje implements Polylinje2
{
	private static class Nod
	{
		public Punkt horn;
		public Nod nastaNod;

		public Nod (Punkt horn)
		{
			this.horn = horn;
			nastaNod = null;
		}

		//vet inte hur man får ut punkten ur fake noden
		//så jag gjorde en egen
		public Punkt getPunkt()
		{
			Punkt p = new Punkt(this.horn);
			return p;
		}
	}

	private Nod dennaHorn;
	private String farg = "Noder";
	private int bredd = 1; // pixlar

	public NPolylinje ()
	{
		this.dennaHorn = null;
	}

	public NPolylinje (Punkt[] horn)
	{
		if (horn.length > 0)
		{
			Nod nod = new Nod (new Punkt (horn[0]));
			this.dennaHorn = nod;
			int pos = 1;
			while (pos < horn.length)
			{
				nod.nastaNod = new Nod (new Punkt (horn[pos++]));
				nod = nod.nastaNod;
			}
		}
	}

	public Punkt[] getHorn ()
	{
		Nod n = this.dennaHorn;
		int pos = 0;
		while(n != null)
		{
			pos++;
			n = n.nastaNod;
		}

		n = this.dennaHorn;
		Punkt[] p = new Punkt[pos];
		pos = 0;
		while(n != null)
		{
			p[pos++] = n.horn;
			n = n.nastaNod;
		}

		return p;
	}

	public String getFarg ()
	{
		return this.farg;
	}

	public int getBredd ()
	{
		return this.bredd;
	}

	public double langd ()
	{
		double linjelangd = 0.0;
		Nod n = this.dennaHorn;
		while(n.nastaNod != null)
		{
			linjelangd += n.horn.avstand(n.nastaNod.horn);
			n = n.nastaNod;
		}

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
		Nod n = this.dennaHorn;
		while(n.nastaNod != null)
			n = n.nastaNod;
		n.nastaNod = new Nod(horn);
	}

	public void laggTillFramfor (Punkt horn, String hornNamn)
	{

		Nod n = this.dennaHorn;
		Nod temp = null;
		if(!n.horn.getNamn().equals(hornNamn))
		{
			while(!n.nastaNod.horn.getNamn().equals(hornNamn))
				n = n.nastaNod;
			temp = n.nastaNod;
			n.nastaNod = new Nod(horn);
			n.nastaNod.nastaNod = temp;
		}
		else
		{
			temp = n;
			n = new Nod(horn);
			n.nastaNod = temp;
			this.dennaHorn = n;
		}
	}

	public void taBort (String hornNamn)
	{
		Nod n = this.dennaHorn;
		if(!n.horn.getNamn().equals(hornNamn))
		{
			while(!n.nastaNod.horn.getNamn().equals(hornNamn))
			{
				n = n.nastaNod;
			}
			if(n.nastaNod.nastaNod != null)
				n.nastaNod = n.nastaNod.nastaNod;
			else
				n = null;
		}
		else
		{
			this.dennaHorn = n.nastaNod;

		}
	}

	public String toString()
	{
		Nod n = this.dennaHorn;
		String s = "{[";
		while(n != null)
		{

			s += n.horn;
			n = n.nastaNod;
		}
		s += "], " + this.farg + ", " + this.bredd + "}";
		return s;
	}

	public java.util.Iterator<Punkt> iterator ()
	{
		Iterator<Punkt> itPunkt = new Iterator<Punkt>()
		{
			private Nod n = dennaHorn;
			private boolean fe = false;

			public boolean hasNext()
			{
				return (n.nastaNod != null);
			}

			public Punkt next()
			{
				n = (fe == false)? n:n.nastaNod;
				fe = true;
				return n.horn;
			}
		};
		return itPunkt;
	}
}