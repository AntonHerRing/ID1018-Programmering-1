import java.util.Scanner;

class Triangel
{
	public static double bisector(double b, double c, double angle)
	{
			double alfa = (Math.PI * 2)/(360 / angle);	//calculates radian from angle
			double p = 2 * b * c * Math.cos(alfa / 2);
			double bis = p / (b + c);

			return bis;
	}

	public static double area(double a, double h)
	{
		double areaT = (a * h) / 2;
		return areaT;
	}

	public static double semiparam(double a, double b, double c)
	{
		double circumference = a + b + c;
		double semiparam = circumference/2;
		return semiparam;
	}

	public static double circumference(double a, double b, double c)
	{
		double cirfer = a + b + c;
		return cirfer;
	}

	public static double median(double a, double b, double c, int nr)
	{
		double med = 0;
		double medianLength = 0;

		med = 2*Math.pow(b, 2) + 2*Math.pow(c, 2) - Math.pow(a, 2);
		medianLength = Math.sqrt(med);

		}
		return medianLength;
	}

	public static double yttriangel(double a, double b , double c)
		{
			double s = Triangel.semiparam(a, b, c);
			double ekvationRoot =  s * (s - a)*(s - b)*(s - c);
			double radie = a*b*c/(4 * Math.sqrt(ekvationRoot));

			return radie;
		}

		public static double intriangel(double a, double b, double c)
		{
			double s = Triangel.semiparam(a, b, c);
			double division = ((s - a)*(s - b)*(s - c))/s;
			double radie = Math.sqrt(division);

		return radie;
	}
}