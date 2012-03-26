package se.oll.ftv.oralhealth.app;

import com.google.inject.AbstractModule;
import se.oll.ftv.oralhealth.data.IOralHealthJournalRepository;
import se.oll.ftv.oralhealth.fakes.data.FakeOralHealthJournalRepository;
import se.oll.ftv.oralhealth.fakes.security.FakeAuthenticationProvider;
import se.oll.ftv.oralhealth.security.IAuthenticationProvider;

public class InjectionModule extends AbstractModule
{
	/* Methods - begin */

	@Override
	protected void configure()
	{
		bind(IAuthenticationProvider.class).toInstance(FakeAuthenticationProvider.getInstance());
		bind(IOralHealthJournalRepository.class).toInstance(FakeOralHealthJournalRepository.getInstance());
	}

	/* Methods - end */
}