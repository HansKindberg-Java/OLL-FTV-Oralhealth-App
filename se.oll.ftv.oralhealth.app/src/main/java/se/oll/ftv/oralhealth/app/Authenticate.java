package se.oll.ftv.oralhealth.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import se.oll.ftv.oralhealth.security.IAuthenticationProvider;

public class Authenticate extends Activity
{
	/* Constructors - begin */

	public Authenticate(IAuthenticationProvider authenticationProvider)
	{
		super(authenticationProvider);
	}

	/* Constructors - end */

	/* Methods - begin */

	@Override
	protected void authorizeRequest()
	{

	}

	public void login(View view)
	{
		EditText usernameEditText = (EditText) this.findViewById(R.id.username_edittext);
		EditText passwordEditText = (EditText) this.findViewById(R.id.password_edittext);

		if (this.getAuthenticationProvider().authenticate(usernameEditText.getText().toString(), passwordEditText.getText().toString()))
		{
			Intent intent = new Intent();
			setResult(RESULT_OK, intent);
			finish();
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.authenticate_default_view);
	}

	/* Methods - end */
}
