import exceptions.MannagginaException;
import exceptions.PaperinoException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class CheckedUnchecked
{
	static String s;

	public static void main(String[] args)
	{


		String a = null;
		try
		{
			pandora();
		}
		catch (MannagginaException e)
		{
			System.out.println("U file nun l'agg' trovatu");
		}
		catch (PaperinoException | NumberFormatException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			//throw new RuntimeException();
		}
		catch (RuntimeException e)
		{
			System.out.println("eccezione generica unchecked catturata");
		}
		catch (Exception e)
		{
			System.out.println("Eccezione generica checked catturata");
		}
		finally
		{
			System.out.println("ESEGUITO SEMPRE");
		}

	}

	public static void metodoChePropagaChecked() throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("aaaa"));

	}

	public static void metodoChePropagaUnchecked()throws NumberFormatException
	{
		String partenza = "paperino";
//		for(Character c : partenza.toCharArray())
//			if(!Character.isDigit(c))
//			{
//				System.out.println("Zio abbiamo una lettera, non la possiamo convertire");
//				return;
//			}

		int a = Integer.parseInt(partenza);
	}

	public static void pandora() throws NumberFormatException,NullPointerException, MannagginaException
	{
		double rand = Math.random();

		if(rand<0.33)
			throw new NumberFormatException();

		if(rand<0.66)
			throw new PaperinoException("qua qua");

		throw new MannagginaException();
	}
}
