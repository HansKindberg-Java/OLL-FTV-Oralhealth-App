package se.oll.ftv.oralhealth.fakes.data;

import se.oll.ftv.oralhealth.data.IOralHealthJournal;

public class FakeOralHealthJournal implements IOralHealthJournal
{
	/* Fields - begin */

	private int m_id;
	private Integer m_numberOfTeethInLowerJaw;
	private Integer m_numberOfTeethInUpperJaw;
	private String m_socialSecurityNumber;

	/* Fields - end */

	/* Constructors - begin */

	public FakeOralHealthJournal()
	{
	}

	public FakeOralHealthJournal(int id, String socialSecurityNumber, Integer numberOfTeethInLowerJaw, Integer numberOfTeethInUpperJaw)
	{
		this.m_id = id;
		this.m_socialSecurityNumber = socialSecurityNumber;
		this.m_numberOfTeethInLowerJaw = numberOfTeethInLowerJaw;
		this.m_numberOfTeethInUpperJaw = numberOfTeethInUpperJaw;
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

	public void setID(int id)
	{
		this.m_id = id;
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

	public void setSocialSecurityNumber(String socialSecurityNumber)
	{
		this.m_socialSecurityNumber = socialSecurityNumber;
	}

	/* Methods - end */
}