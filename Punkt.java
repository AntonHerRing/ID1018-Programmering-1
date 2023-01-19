import java.util.*;

public class Punkt
{
	//instansvariabler
	private String bokstav = "";
	private int x = 0;
	private int y = 0;

	//konstruktor
	public Punkt(String bokstav, int x, int y)
	{
		this.bokstav = bokstav;
		this.x = x;
		this.y = y;
	}

	//kopierings konstruktor
	public Punkt(Punkt annan)
	{
		this.x = annan.x;
		this.y = annan.y;
		this.bokstav = annan.bokstav;
	}

	//returnerar namn pa punkt
	public String getNamn()
	{
		return this.bokstav;
	}

	//returnerar x pa punkt
	public int getX()
	{
		return this.x;
	}

	//returerar y pa punkt
	public int getY()
	{
		return this.y;
	}

	//ger ut avstand mellan tva punkter
	public double avstand(Punkt p)		//this.x and this.y represent Object1 i Object1.Punkt(Object2), p = Object2
	{
		int x2 = p.getX();
		int y2 = p.getY();

		double a = Math.pow((x2 - this.x), 2);
		double b = Math.pow((y2 - this.y), 2);
		double langd = Math.sqrt(a + b);

		return langd;
	}

	//bestam x varde
	public void setX(int x)
	{
		this.x = x;
	}

	//bestam y varde
	public void setY(int y)
	{
		this.y = y;
	}

	//ovandlar till String
	public String toString()
	{
		return "(" + this.bokstav + ", " + this.x + ", " + this.y + ")";
	}


}
