package se.oll.ftv.oralhealth.security;

public interface IUser
{
	/* Methods - begin */

	IRole[] getRoles();
	String getUsername();

	/* Methods - end */
}