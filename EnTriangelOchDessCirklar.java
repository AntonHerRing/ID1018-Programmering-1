import java.util.Scanner;

class EnTriangelOchDessCirklar
{
	public static void main(String[] args)
	{
		System.out.print("EN TRIANGEL OCH DESS CIRKLAR\n\n");

		Scanner in = new Scanner(System.in);

		System.out.print("skriv in triangelns sidor. a, b och c:\n");
		double sidaA = in.nextDouble();
		double sidaB = in.nextDouble();
		double sidaC = in.nextDouble();

		double ytreTrirad = Triangel.yttriangel(sidaA, sidaB, sidaC);
		double inreTrirad = Triangel.intriangel(sidaA, sidaB, sidaC);

		System.out.println("Ytre triangelns radie: " + ytreTrirad +" | inre triangelns radie: " + inreTrirad);

	}
}