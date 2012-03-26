package se.oll.ftv.oralhealth.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import se.oll.ftv.oralhealth.security.IAuthenticationProvider;

public class Home extends Activity
{
	/* Constructors - begin */

	public Home(IAuthenticationProvider authenticationProvider)
	{
		super(authenticationProvider);
	}

	/* Constructors - end */

	/* Methods - begin */

	public void journals(View view)
	{
		Intent intent = new Intent(this, Journals.class);
		intent.setAction(Intent.ACTION_MAIN);
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		this.startActivity(intent);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_default_view);
	}

	/* Methods - end */
}