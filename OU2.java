import java.util.Scanner;

class OU2
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
		double areaT = (a*h)/2;
		return areaT;
	}
	public static double circumference(double a, double b, double c)
	{
		double circumference = a + b + c;
		return circumference;
	}
	public static double median(double a, double b, double c, int nr)
	{
		double med = 0;
		double medianLength = 0;

		switch(nr)
		{
			case 1:
				med = 2*Math.pow(b, 2) + 2*Math.pow(c, 2) - Math.pow(a, 2);
				medianLength = Math.sqrt(med);
				break;
			case 2:
				med = 2*Math.pow(a, 2) + 2*Math.pow(c, 2) - Math.pow(b, 2);
				medianLength = Math.sqrt(med);
				break;
			case 3:
				med = 2*Math.pow(a, 2) + 2*Math.pow(b, 2) - Math.pow(c, 2);
				medianLength = Math.sqrt(med);
				break;
		}
		return medianLength;
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		double answer = 0;

		System.out.print("TRIANGLE\n\n");
		System.out.print("Which of the following do you want to calculate? write in lower cap\n");
		System.out.println("Area (length and height) | Bisector | Circumference | Median | a triangle and its circles (tricirc) |\n");

		String mode = in.nextLine();


		if("area".equals(mode))
		{
			System.out.println("input length and height:");
			double length = in.nextDouble();
			double height = in.nextDouble();

			answer = area(length, height);
		}
		else if("bisector".equals(mode))
		{
			System.out.println("input side b, side c and the angle:");
			double sideB = in.nextDouble();
			double sideC = in.nextDouble();
			double angle = in.nextDouble();

			answer = bisector(sideB, sideC, angle);
		}
		else if("circumference".equals(mode))
		{
			System.out.println("input side a, side b and side c:");
			double sideA = in.nextDouble();
			double sideB = in.nextDouble();
			double sideC = in.nextDouble();

			answer = circumference(sideA, sideB, sideC);
		}
		else if("median".equals(mode))
		{
			System.out.println("which median do you want to calculate? a, b or c:");
			String chooseMedian = in.nextLine();
			if("a".equals(chooseMedian))		// median nr 1
			{
				System.out.println("input side b , c and a:");
				double b = in.nextDouble();
				double c = in.nextDouble();
				double a = in.nextDouble();

				answer = median(a, b, c, 1);
			}
			else if("b".equals(chooseMedian)) 	// median nr 2
			{
				System.out.println("input side a, c and b:");
				double a = in.nextDouble();
				double c = in.nextDouble();
				double b = in.nextDouble();

				answer = median(a, b, c, 2);
			}
			else if("c".equals(chooseMedian))	// median nr 3
			{
				System.out.println("input side a, b and c:");
				double a = in.nextDouble();
				double b = in.nextDouble();
				double c = in.nextDouble();

				answer = median(a, b, c, 3);
			}
			else
			{
				System.out.println("Invalid input");
				mode = "input";
				answer = 0;
			}
		}
		else if("tricirc".equals(mode)) //a triangle and its circle
		{

		}
		else
		{
			System.out.println("input invalid");
			mode = "input";
			answer = 0;
		}

		System.out.println("The " + mode + " of the triangle is: " + answer);

	}
}