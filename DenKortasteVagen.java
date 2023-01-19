import java.util.Scanner;

class DenKortasteVagen
{
	public static int[] mellanstationer(double[] a, double[][] b, double[] c)
	{
		int numberof = (a.length - 1) * (c.length - 1);
		double[] vektorLength = new double[numberof];				// summan för en total längd
		double[][] SparaStation = new double[a.length][3 + 1]; 		//1. värde, 2. i, 3. j
		int[] minstStationer = new int[3 + 1];						//spara vektorerna för minst längd och dess namn
		int saveVektorName = 0;										//temporär variabel för att spara variabler
		double smallestBvektor = 0;									//temporär variabel för att spara b variabeln för att hitta minsta
		for(int i = 1; i <= numberof - 1; i++)						//repetera f�r alla v�gar [i]
		{
			vektorLength[i] = a[i];									//v�ljer U1 och sparar dennes vektor l�ngd i v[1]
			smallestBvektor = b[i][1];								//Definera ett tillf�lligt minsta v�rde fr�n m�ngden

			for(int j = 1; j <= c.length - 1; j++) 					//hittar minst vektor l�ngd i b[1][1, 2, 3...] och sparar den i v[1]
			{
				if(smallestBvektor >= b[i][j])						//hitta minsta v�rde
				{
					smallestBvektor = b[i][j];						//spara minsta v�rde
					saveVektorName = j;								//spara namn p� vektor tex 2 i vektorNamn, b[1][2]
				}
			}
			vektorLength[i] += smallestBvektor;						//v�ljer minst vektor och sparar denne i v[1]
			vektorLength[i] += c[saveVektorName];					//v�lj c[vektorNamn] , 2
			SparaStation[i][1] = vektorLength[i];					//spara mellanstationernas namn tillsammans med dess längd
			SparaStation[i][2] = i;
			SparaStation[i][3] = saveVektorName;
		}
		for(int n = 1; n <= 3; n++)									//transfererar 2D array till 1D array
			minstStationer[n] = (int)SparaStation[langd(vektorLength)][n];
		return minstStationer;
	}

	public static int langd(double[] minstlangd)
	{
		int temp = 0;
		double smallestTotlength = minstlangd[1];					//hitta minst totala vektorl�ngd av [i]
		for(int i = 1; i <= minstlangd.length - 1; i++)
			if(smallestTotlength >= minstlangd[i])					//Hämtar ut positionen på vektorn
			{
				smallestTotlength = minstlangd[i];
				temp = i;
			}
		return temp;												//skickar tillbaks positionen på vektorn
	}
}