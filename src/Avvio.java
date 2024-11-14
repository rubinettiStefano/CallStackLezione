import java.util.Scanner;

public class Avvio
{

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{


		System.out.println("Benvenuto inizio programma");
		try
		{
			faiCalcolo();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("Raggiunta la fine");
	}

	private static void faiCalcolo()
	{
		System.out.println("Dammi primo numero maledetto");
		int p = Integer.parseInt(sc.nextLine());
		System.out.println("Ora anche il secondo,e meglio per te che sia pari");
		int s = Integer.parseInt(sc.nextLine());

		int somma = somma(p, s);

		System.out.println("La tua somma è " + somma);
		System.out.println("Metodo finito");
	}

	private static int somma(int a, int b)
	{
		if(b%2!=0)
			throw new RuntimeException();
		int res = a+b;
		return res;
	}
}
