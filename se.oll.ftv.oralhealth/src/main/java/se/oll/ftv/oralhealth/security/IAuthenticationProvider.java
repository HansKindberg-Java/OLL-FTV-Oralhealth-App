package se.oll.ftv.oralhealth.security;

public interface IAuthenticationProvider
{
	/* Methods - begin */

	Boolean authenticate(String username, String password);
	IUser getCurrentUser();
	void reset();

	/* Methods - end */
}
