import java.util.Scanner;

class DenKortasteVagen1
{
	public static double langd(double[] a, double[][] b, double[] c)
	{
		double[] vektorLength = new double[a.length];
		double smallestBvektor = 0;
		int saveVektorName = 0;
		for(int i = 1; i <= a.length - 1; i++)			//repetera f�r alla v�gar [i]
		{
			vektorLength[i] = a[i];						//v�ljer U1 och sparar dennes vektor l�ngd i v[1]
			smallestBvektor = b[i][1];					//Definera ett tillf�lligt minsta v�rde fr�n m�ngden

			for(int j = 1; j <= a.length - 1; j++) 		//hittar minst vektor l�ngd i b[1][1, 2, 3...] och sparar den i v[1]
			{
				if(smallestBvektor >= b[i][j])			//hitta minsta v�rde
				{																//programm stannar här
					smallestBvektor = b[i][j];			//spara minsta v�rde
					saveVektorName = j;					//spara namn p� vektor tex 2 i vektorNamn, b[1][2]
				}
			}
			vektorLength[i] += smallestBvektor;			//v�ljer minst vektor och sparar denne i v[1]
			vektorLength[i] += c[saveVektorName];		//v�lj c[vektorNamn] , 2

		}
		//hitta minst totala vektorl�ngd av [i]
		double smallestTotlength = vektorLength[1];

		for(int i = 2; i <= a.length - 1; i++)
			if(smallestTotlength > vektorLength[i])
				smallestTotlength = vektorLength[i];

		return smallestTotlength;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.print("DECIDE INPUT MODE\n\n");
		System.out.print("1. RANGE | 2. MANUAL\n");
		int mode = in.nextInt();
		System.out.println("How many stations?: ");
		int numberOfstations = in.nextInt();
		double[] roadA = new double[numberOfstations + 1];
		double[][] roadB = new double[numberOfstations + 1][numberOfstations + 1];
		double[] roadC = new double[numberOfstations + 1];

		switch(mode)
		{
			case 1:														//decide range
			System.out.print("decide range. 1 <= x <= ");
			int range = in.nextInt();
			for(int i = 1; i <= numberOfstations; i++)
			{
				roadA[i] = (Math.random() * range + 1 ); 				//ger slump distanser till v�gar mellan X och U_i		a_i
				for(int j = 1; j <= numberOfstations; j++)
					roadB[i][j] = (Math.random() * range + 1 );			//ger slump distanser till v�gar mellan U_i och V_i		b_ij
				roadC[i] = (Math.random() * range + 1 ); 				//ger slump distanser till v�gar mellan V_i och Y		c_i
			}
			break;														//manual input
			case 2:
			for(int i = 1; i <= numberOfstations; i++)
				{
					System.out.println("A" + i + ": ");
					roadA[i] = in.nextInt();							//ger slump distanser till v�gar mellan X och U_i		a_i
					for(int j = 1; j <= numberOfstations; j++)
					{
						System.out.println("B" + i + "_" + j + ": ");
						roadB[i][j] = in.nextInt();						//ger slump distanser till v�gar mellan U_i och V_i		b_ij
					}
					System.out.println("C" + i + ": ");
					roadC[i] = in.nextInt(); 							//ger slump distanser till v�gar mellan V_i och Y		c_i
			}
			break;
		}

		double shortestPath = langd(roadA, roadB, roadC);

		System.out.print("The Shortest Path is: " + shortestPath + "\n");
	}
}