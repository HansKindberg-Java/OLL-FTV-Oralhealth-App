package se.oll.ftv.oralhealth.fakes.security;

import se.hanskindberg.lang.ArgumentNullException;
import se.hanskindberg.lang.extensions.StringExtension;
import se.oll.ftv.oralhealth.security.IRole;
import se.oll.ftv.oralhealth.security.IUser;

public class FakeUser implements IUser
{
	/* Fields - begin */

	private final String m_password;
	private IRole[] m_roles;
	private final String m_username;

	/* Fields - end */

	/* Constructors - begin */

	public FakeUser(String username, String password)
	{
		if (StringExtension.isNullOrEmpty(username))
			throw new ArgumentNullException("username");

		this.m_password = password;
		this.m_username = username;
	}

	/* Constructors - end */

	/* Methods - begin */

	protected String getPassword()
	{
		return this.m_password;
	}

	@Override
	public IRole[] getRoles()
	{
		if (this.m_roles == null)
			return new IRole[0];

		return this.m_roles;
	}

	@Override
	public String getUsername()
	{
		return this.m_username;
	}

	protected void setRoles(IRole[] roles)
	{
		this.m_roles = roles;
	}

	/* Methods - end */
}