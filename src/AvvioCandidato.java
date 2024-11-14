import exceptions.CandidatoPropertyException;
import exceptions.CrimineException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvvioCandidato
{

	static List<Candidato> candidatosValidos = new ArrayList<Candidato>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{

		while(true)
			candidati();
	}

	public static void candidati()
	{
		System.out.println("Inserisci i tuoi dati, candidato");
		//nel caso di nome o cognome richiedo l' input
		//se la data non è valida gliela richiedo
		//se il candidato è minorenne o troppo vecchio gli chiedo di mentire sulla sua data di nascita
		//per i crimini nel momento in cui sono troppo lievi, chiudo il programma e chiedo
		//di commettere qualcosa di più serio e tornare
		//se passa tutti i controlli lo aggiungo alla lista
		Candidato candidato = new Candidato();
		try
		{
			impostaProprieta(candidato,"nome");
			impostaProprieta(candidato,"cognome");
			impostaProprieta(candidato,"data di nascita");
			impostaProprieta(candidato,"livello emotivo");
			impostaProprieta(candidato,"crimine maggiore");
		}catch (CrimineException e)
		{
			System.out.println("Passiamo al prossimo dai, lui no");
			return;
		}

		if(candidato.getLivelloEmotivo()!=0)
			System.out.println("Troppo emotivo, non possiamo prenderti");
		else
		{
			System.out.println("YYEEEE,puoi fare il colloquio");
			candidatosValidos.add(candidato);
		}

		System.out.println("Ne abbiamo un altro?");
		if(sc.nextLine().equalsIgnoreCase("no"))
			System.exit(0);
	}

	public static void impostaProprieta(Candidato candidato, String nomeProprieta) throws CrimineException
	{
		boolean proprietaValida = false;
		System.out.println("Inserisci " + nomeProprieta);//1
		do
		{
			try
			{
				switch (nomeProprieta)
				{
					case "nome" ->
					{
						candidato.setNome(sc.nextLine());
					}
					case "cognome" ->
					{
						candidato.setCognome(sc.nextLine());
					}
					case "data di nascita" ->
					{
						candidato.setDob(sc.nextLine());
					}
					case "livello emotivo" ->
					{
						candidato.setLivelloEmotivo(Integer.parseInt(sc.nextLine()));
					}
					case "crimine maggiore" ->
					{
						TipologieCrimine commesso = TipologieCrimine.valueOf(sc.nextLine().toUpperCase());
						candidato.setCrimine(commesso);
					}
				}

				proprietaValida = true;
			} catch (CandidatoPropertyException e)
			{
				System.out.println("Valore di " + e.getNomeProprieta() + " sbagliato poichè " + e.getMotivoErrore());
				System.out.println("Reinseriscilo");
			} catch (NumberFormatException e)
			{
				System.out.println("Non è un numero, mannaggina");
				System.out.println("Reinseriscilo");
			} catch (IllegalArgumentException e)
			{
				System.out.println("Non è nel nostro database dei crimini");
				System.out.println("Reinseriscilo");
			} catch (CrimineException e)
			{
				System.out.println("Ma per piacere, fai qualcosa di peggio");
				throw new CrimineException();
			}

		} while (!proprietaValida);//3
	}



}
