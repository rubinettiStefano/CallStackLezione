import exceptions.ValoreNegativoException;

import java.util.Scanner;

public class SoluzioneEs6
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		try
		{
			processaDati();
		}catch (ValoreNegativoException | NumberFormatException e)
		{
			System.out.println("Non sono in grado di lavorare, metti i dati meglio");
		}
	}

	public static void verificaDati(int valore)
	{
		if(valore < 0)
			throw new ValoreNegativoException();
	}

	public static void processaDati()
	{
		System.out.println("Inserisci numero positivo");
		try
		{
			verificaDati(Integer.parseInt(sc.nextLine()));
		}catch (ValoreNegativoException e)
		{
			System.out.println("Mannaggina non è negativo");
			throw new ValoreNegativoException();
		}

	}
}
