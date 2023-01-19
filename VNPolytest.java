import java.util.*;

class VNPolytest
{
	public static void main(String[] args)
	{
		Punkt[] p = {new Punkt("A", 1, 2),
					new Punkt("B", 3, 4),
					new Punkt("C", 5, 6)};

		VPolylinje pol1 = new VPolylinje(p);
		NPolylinje pol2 = new NPolylinje(p);

		System.out.print(pol1+"\n");
		System.out.println(pol2+"\n");

		Punkt G = new Punkt("G", 6, 9);

		pol1.laggTill(G);
		pol2.laggTill(G);

		System.out.print("laggtill: " + pol1 +"\n");
		System.out.println("laggtill: " + pol2 +"\n");

		Punkt D = new Punkt("D", 8, 2);

		pol1.laggTillFramfor(D, "A");
		pol2.laggTillFramfor(D, "A");

		System.out.print("laggtillFramfor: " + pol1 +"\n");
		System.out.println("laggtillFramfor: " + pol2 +"\n");

		pol1.taBort("A");
		pol2.taBort("A");

		System.out.print("taBort: " + pol1 +"\n");
		System.out.println("taBort: " + pol2 +"\n");


		System.out.println("Iterator1");

		Iterator<Punkt> it1 = pol1.iterator();

		while(it1.hasNext())
		{
			System.out.print(it1.next() + " ");
		}
		System.out.println();

		System.out.println("Iterator2");

		Iterator<Punkt> it2 = pol2.iterator();

		while(it2.hasNext())
		{
			System.out.print(it2.next() + " ");
		}
		System.out.println();
		System.out.println();

		Punkt[] p1 = pol1.getHorn();
		Punkt[] p2 = pol2.getHorn();

		for(int i = 0; i < p1.length; i++)
		{
			System.out.print(p1[i]+" ");
		}
		System.out.println("\nnästa");
		for(int i = 0; i < p2.length; i++)
		{
					System.out.print(p2[i]+" ");
		}
	}
}