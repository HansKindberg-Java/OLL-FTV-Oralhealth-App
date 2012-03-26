package se.oll.ftv.oralhealth.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import se.hanskindberg.lang.ArgumentNullException;
import se.hanskindberg.lang.extensions.StringExtension;
import se.oll.ftv.oralhealth.data.IOralHealthJournal;
import se.oll.ftv.oralhealth.data.IOralHealthJournalRepository;
import se.oll.ftv.oralhealth.security.IAuthenticationProvider;

public class Journals extends Activity
{
	/* Fields - begin */

	private final IOralHealthJournalRepository m_oralHealthJournalRepository;

	/* Fields - end */

	/* Constructors - begin */

	public Journals(IAuthenticationProvider authenticationProvider, IOralHealthJournalRepository oralHealthJournalRepository)
	{
		super(authenticationProvider);

		if (oralHealthJournalRepository == null)
			throw new ArgumentNullException("oralHealthJournalRepository");

		this.m_oralHealthJournalRepository = oralHealthJournalRepository;
	}

	/* Constructors - end */

	/* Methods - begin */

	public void close(View view)
	{
		this.finish();
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.journals_default_view);

		String journals = "";
		for (IOralHealthJournal oralHealthJournal : this.m_oralHealthJournalRepository.get())
		{
			if (!StringExtension.isNullOrEmpty(journals))
				journals += ", ";

			journals += oralHealthJournal.getSocialSecurityNumber();
		}

		TextView informationTextView = (TextView) this.findViewById(R.id.informationTextView);
		informationTextView.setText(journals);
	}

	/* Methods - end */
}
