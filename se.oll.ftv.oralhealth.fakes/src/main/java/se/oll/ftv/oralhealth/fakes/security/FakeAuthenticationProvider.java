package se.oll.ftv.oralhealth.fakes.security;

import se.hanskindberg.lang.extensions.StringExtension;
import se.oll.ftv.oralhealth.security.IAuthenticationProvider;
import se.oll.ftv.oralhealth.security.IUser;

public class FakeAuthenticationProvider implements IAuthenticationProvider
{
	/* Fields - begin */

	private IUser m_currentUser;
	private static FakeAuthenticationProvider s_instance;

	/* Fields - end */

	/* Methods - begin */

	@Override
	public Boolean authenticate(String username, String password)
	{
		this.m_currentUser = null;

		if (StringExtension.isNullOrEmpty(username) || StringExtension.isNullOrEmpty(password))
			return false;

		if (username.equals("Username") && password.equals("password"))
		{
			this.m_currentUser = new FakeUser(username, password);
			return true;
		}

		return false;
	}

	@Override
	public IUser getCurrentUser()
	{
		return this.m_currentUser;
	}

	public static FakeAuthenticationProvider getInstance()
	{
		if (s_instance == null)
			s_instance = new FakeAuthenticationProvider();

		return s_instance;
	}

	@Override
	public void reset()
	{
		this.m_currentUser = null;
	}

	/* Methods - end */
}