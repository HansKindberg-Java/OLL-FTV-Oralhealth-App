package se.oll.ftv.oralhealth.fakes.security;

import se.hanskindberg.lang.ArgumentNullException;
import se.oll.ftv.oralhealth.security.IRole;

public class FakeRole implements IRole
{
	/* Fields - begin */

	private final String m_name;

	/* Fields - end */

	/* Constructors - begin */

	public FakeRole(String name)
	{
		if (name == null)
			throw new ArgumentNullException("name");

		this.m_name = name;
	}

	/* Constructors - end */

	/* Methods - begin */

	@Override
	public String getName()
	{
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	/* Methods - end */
}