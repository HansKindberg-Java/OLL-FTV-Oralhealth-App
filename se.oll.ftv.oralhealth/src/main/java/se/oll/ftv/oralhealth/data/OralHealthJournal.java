package se.oll.ftv.oralhealth.data;

public class OralHealthJournal implements IOralHealthJournal
{
	/* Fields - begin */

	private final int m_id;
	private Integer m_numberOfTeethInLowerJaw;
	private Integer m_numberOfTeethInUpperJaw;
	private final String m_socialSecurityNumber;

	/* Fields - end */

	/* Constructors - begin */

	public OralHealthJournal(int id, String socialSecurityNumber)
	{
		this.m_id = id;
		this.m_socialSecurityNumber = socialSecurityNumber;
	}

	/* Constructors - end */

	/* Methods - begin */

	@Override
	public int getID()
	{
		return this.m_id;
	}

	@Override
	public Integer getNumberOfTeethInLowerJaw()
	{
		return this.m_numberOfTeethInLowerJaw;
	}

	@Override
	public Integer getNumberOfTeethInUpperJaw()
	{
		return this.m_numberOfTeethInUpperJaw;
	}

	@Override
	public String getSocialSecurityNumber()
	{
		return this.m_socialSecurityNumber;
	}

	@Override
	public void setNumberOfTeethInLowerJaw(Integer numberOfTeethInLowerJaw)
	{
		this.m_numberOfTeethInLowerJaw = numberOfTeethInLowerJaw;
	}

	@Override
	public void setNumberOfTeethInUpperJaw(Integer numberOfTeethInUpperJaw)
	{
		this.m_numberOfTeethInUpperJaw = numberOfTeethInUpperJaw;
	}

	/* Methods - end */
}