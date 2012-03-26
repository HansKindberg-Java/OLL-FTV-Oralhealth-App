package se.oll.ftv.oralhealth.app;

import android.content.Intent;
import android.os.Bundle;
import se.hanskindberg.lang.ArgumentNullException;
import se.oll.ftv.oralhealth.security.IAuthenticationProvider;

public abstract class Activity extends android.app.Activity
{
	/* Fields - begin */

	private final IAuthenticationProvider m_authenticationProvider;

	/* Fields - end */

	/* Constructors - begin */

	public Activity(IAuthenticationProvider authenticationProvider)
	{
		super();

		if (authenticationProvider == null)
			throw new ArgumentNullException("authenticationProvider");

		this.m_authenticationProvider = authenticationProvider;
	}

	/* Constructors - end */

	/* Methods - begin */

	protected void authorizeRequest()
	{
		if (this.m_authenticationProvider.getCurrentUser() == null)
		{
			Intent intent = new Intent(this, Authenticate.class);
			intent.setAction(Intent.ACTION_MAIN);
			intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS | Intent.FLAG_ACTIVITY_CLEAR_TOP);
			this.startActivity(intent);
		}
	}

	protected IAuthenticationProvider getAuthenticationProvider()
	{
		return this.m_authenticationProvider;
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.authorizeRequest();
	}

	/* Methods - end */
}