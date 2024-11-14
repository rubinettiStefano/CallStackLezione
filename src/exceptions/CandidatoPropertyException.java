package exceptions;

public class CandidatoPropertyException extends RuntimeException
{
	private String nomeProprieta;
	private String motivoErrore;

	public CandidatoPropertyException(){}


	public CandidatoPropertyException(String nomeProprieta, String motivoErrore)
	{
		this.nomeProprieta = nomeProprieta;
		this.motivoErrore = motivoErrore;
	}

	public String getNomeProprieta()
	{
		return nomeProprieta;
	}

	public void setNomeProprieta(String nomeProprieta)
	{
		this.nomeProprieta = nomeProprieta;
	}

	public String getMotivoErrore()
	{
		return motivoErrore;
	}

	public void setMotivoErrore(String motivoErrore)
	{
		this.motivoErrore = motivoErrore;
	}

	@Override
	public String getMessage()
	{
		return "Eccezione su proprietà "+nomeProprieta+": "+motivoErrore;
	}
}
