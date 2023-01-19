import java.util.Scanner;

class OU2m2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		double answer = 0;

		System.out.print("TRIANGLE\n\n");
		System.out.print("Which of the following do you want to calculate? write in lower cap\n");
		System.out.println("Area (length and height) | Bisector | Circumference | Median |\n");

		String mode = in.nextLine();


		if("area".equals(mode))
		{
			System.out.println("input length and height:");
			double length = in.nextDouble();
			double height = in.nextDouble();

			answer = Triangel.area(length, height);
		}
		else if("bisector".equals(mode))
		{

			System.out.println("input side 1, side 2 and the angle:");
			double sideB = in.nextDouble();
			double sideC = in.nextDouble();
			double angle = in.nextDouble();
			answer = Triangel.bisectorBC(sideB, sideC, angle);
		}
		else if("circumference".equals(mode))
		{
			System.out.println("input side a, side b and side c:");
			double sideA = in.nextDouble();
			double sideB = in.nextDouble();
			double sideC = in.nextDouble();

			answer = Triangel.circumference(sideA, sideB, sideC);
		}
		else if("median".equals(mode))
		{

			System.out.println("input side 1 and 2");
			double b = in.nextDouble();
			double c = in.nextDouble();
			double a = in.nextDouble();

			answer = Triangel.median(a, b, c, 1);
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