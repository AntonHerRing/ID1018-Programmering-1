import java.util.*;

class VNPolytest2
{
	public static void main(String[] args)
	{
		Punkt[] p = {new Punkt("A", 1, 2),
					new Punkt("B", 3, 4),
					new Punkt("C", 5, 6)};

		Polylinje2 polylinje = null;
		//polylinje = new VPolylinje(p);
		polylinje = new NPolylinje(p);

		System.out.println(polylinje+"\n");

		System.out.println(polylinje.langd());

		Punkt G = new Punkt("G", 6, 9);

		polylinje.laggTill(G);

		System.out.println("laggtill: " + polylinje +"\n");

		Punkt D = new Punkt("D", 8, 2);

		polylinje.laggTillFramfor(D, "A");

		System.out.println("laggtillFramfor: " + polylinje +"\n");

		polylinje.taBort("A");

		System.out.println("taBort: " + polylinje +"\n");

		System.out.println("Iterator1");

		Iterator<Punkt> it1 = polylinje.iterator();

		while(it1.hasNext())
		{
			System.out.print(it1.next() + " ");
		}
		System.out.println();
		System.out.println();

		Punkt[] p1 = polylinje.getHorn();

		for(int i = 0; i < p1.length; i++)
		{
			System.out.print(p1[i]+" ");
		}
		System.out.println();
		System.out.println();



		//Kan man iterera en polylinje s� h�r: varf�r?
		for(Punkt horn: polylinje)
			System.out.print(horn);
		System.out.println();



		//del 2 Polylinjer
		Punkt[] p2 = {new Punkt("D", 5, 2),
					new Punkt("G", 8, 2),
					new Punkt("E", 5, 8)};

		Punkt[] p3 = {new Punkt("H", 1, 1),
					  new Punkt("J", 1, 1),
					  new Punkt("L", 1, 1)};

		Polylinje2[] linjer = {new NPolylinje(p2),	//p2 �r gul
							new NPolylinje(p),		//p1 �r gul
							new NPolylinje(p3)};	//p3 �r minst
	linjer[0].setFarg("gul");
	linjer[1].setFarg("gul");
	linjer[2].setFarg("bl�");


	Polylinje2[] linjer2 = {new VPolylinje(p2),		//p2 �r gul
							new VPolylinje(p),		//p1 �r gul
							new VPolylinje(p3)};	//p3 �r minst

	linjer2[0].setFarg("bl�");
	linjer2[1].setFarg("gul");
	linjer2[2].setFarg("bl�");

	Polylinje2[] linjer3 = {new VPolylinje(p2),		//p2 �r gul
							new VPolylinje(p),		//p1 �r gul
							new VPolylinje(p3),	//p3 �r minst
							new NPolylinje(p2),	//p2 �r gul
							new NPolylinje(p),		//p1 �r gul
							new NPolylinje(p3)};	//p3 �r minst

		linjer3[0].setFarg("bl�");
		linjer3[1].setFarg("gul");
		linjer3[2].setFarg("gul");
		linjer3[3].setFarg("bl�");
		linjer3[4].setFarg("gul");
		linjer3[5].setFarg("bl�");

		System.out.println("minst gula linje Npoly: " + Polylinjer(linjer));
		System.out.println("minst gula linje:Vpoly: " + Polylinjer(linjer2));
		System.out.println("minst gula linje:b�da : " + Polylinjer(linjer3));
	}

	public static Polylinje2 Polylinjer(Polylinje2[] poly)
	{
		double minstlangd = 0;
		Polylinje2 minst = null;

		for(int i = 0; i < poly.length; i++)
			if(poly[i].getFarg().equals("gul"))
				{
					minstlangd = poly[i].langd();
					break;
				}

		System.out.println();
		for(int i = 0; i < poly.length; i++)
			if(poly[i].getFarg().equals("gul"))
				if(minstlangd >= poly[i].langd())
				{
					minstlangd = poly[i].langd();
					minst = poly[i];
				}

		return minst;
	}
}