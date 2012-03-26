package se.oll.ftv.oralhealth.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import se.hanskindberg.android.app.ActivityBuilder;

public class Application extends android.app.Application
{
	/* Methods - begin */

	@Override
	public void onCreate()
	{
		super.onCreate();

		Injector injector = Guice.createInjector(new InjectionModule());

		try
		{
			ActivityBuilder.getInstance().setFactory(new se.hanskindberg.android.ioc.guice.ActivityFactory(injector));
		}
		catch (Exception exception)
		{
			throw new RuntimeException("onCreate", exception);
		}
	}

	/* Methods - end */
}