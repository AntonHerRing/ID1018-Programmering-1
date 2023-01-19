import java.util.Scanner;

class DenKortasteVagen2
{
	public static int[] mellanstationer(double[] a, double[][] b, double[] c)
	{
		double SparaStation = 0;
		int[] minstStationer = new int[3];						//array f�r att f�rvara mellanstationerna
		minstStationer[0] = a[0] + b[0][0] + c[0];		//s�tter baslinje f�r minst vektorstorlek
		for(int i = 0; i <= a.length - 1; i++)
		{
			for(int j = 0; j <= c.length - 1; j++)
			{
				SparaStation = a[i] + b[i][j] + c[j];	//sparar vektorstorleken
				if(SparaStation <= minstStationer[0])			//hittar minst vektor och spara denna
				{
					minstStationer[0] = SparaStation;
					minstStationer[1] = i;						//sparar v�rde p� i
					minstStationer[2] = j;						//sparar v�rde p� j
				}
			}
		}
		return minstStationer;
	}

	public static double langd(double[] a, double[][] b, double[] c)
	{
		double SparaStation = 0;
		double MinstVektorLangd = 0;
		MinstVektorLangd = a[0] + b[0][0] + c[0];		//s�tter baslinje f�r minst vektorstorlek
		for(int i = 0; i <= a.length - 1; i++)
		{
			for(int j = 0; j <= c.length - 1; j++)
			{
				SparaStation = a[i] + b[i][j] + c[j];
				if(SparaStation <= MinstVektorLangd)			//hittar minst vektor och spara denna
					MinstVektorLangd = SparaStation;			//Sparar minsta l�ngden
			}
		}
		return MinstVektorLangd;
	}
}