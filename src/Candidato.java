import exceptions.CandidatoPropertyException;
import exceptions.CrimineException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Candidato
{

	private String nome,cognome;
	private LocalDate dob;//date of birth
	private int livelloEmotivo; //0 a 10
	private TipologieCrimine crimineMaggiore;

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		if(nome==null)
		{
			throw new CandidatoPropertyException("nome","nullo");
		}

		if(nome.contains(" "))
			throw new CandidatoPropertyException("nome","non voglio spazi");

		if(nome.isBlank())
			throw new CandidatoPropertyException("nome","vuoto");

		if(nome.length()<3)//si arrangia
			throw new CandidatoPropertyException("nome","troppo corto");

		if(nome.length()>12)
			throw new CandidatoPropertyException("nome","troppo lungo");

		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{

		if(cognome==null)
			throw new CandidatoPropertyException("cognome","nullo");

		if(cognome.isBlank())
			throw new CandidatoPropertyException("cognome","vuoto");

		if(cognome.length()<3)//si arrangia
			throw new CandidatoPropertyException("cognome","troppo corto");

		if(cognome.toLowerCase().endsWith("g"))
			throw new CandidatoPropertyException("cognome","non voglio cognomi con la g");


		this.cognome = cognome;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public void setDob(String dob)
	{
		try
		{
			LocalDate parsata =LocalDate.parse(dob);

			//se la data che mi è arrivata è successiva a oggi-18anni
			if(parsata.isAfter(LocalDate.now().minusYears(18)))
				throw new CandidatoPropertyException("dob","minorenne");
			//isAfter che da true se this è maggiore del parametro
			if(parsata.isBefore(LocalDate.now().minusYears(43)))
				throw new CandidatoPropertyException("dob","troppo vecchio");

			this.dob = parsata;
		}
		catch(DateTimeParseException e)
		{
			throw new CandidatoPropertyException("dob","data non valida");
		}
	}

	public int getLivelloEmotivo()
	{
		return livelloEmotivo;
	}

	public void setLivelloEmotivo(int livelloEmotivo)
	{
		if(livelloEmotivo<0)
			throw new CandidatoPropertyException("livelloEmotivo","negativo");
		if(livelloEmotivo>10)
			throw new CandidatoPropertyException("livelloEmotivo","maggiore 10");
		this.livelloEmotivo = livelloEmotivo;
	}

	public TipologieCrimine getCrimineMaggiore()
	{
		return crimineMaggiore;
	}

	public void setCrimine(TipologieCrimine crimine) throws CrimineException
	{
		switch (crimine)
		{
			case INSURREZIONE, EVASIONE_FISCALE, RAPINA, FURTO_INFORMATICO, CODICE_NON_INDENTATO ->
			{
				throw new CrimineException();
			}
		}
		crimineMaggiore = crimine;
	}
}
