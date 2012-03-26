package se.oll.ftv.oralhealth.data;

public interface IOralHealthJournal
{
	/* Methods - begin */

	int getID();
	Integer getNumberOfTeethInLowerJaw();
	Integer getNumberOfTeethInUpperJaw();
	String getSocialSecurityNumber();
	void setNumberOfTeethInLowerJaw(Integer numberOfTeethInLowerJaw);
	void setNumberOfTeethInUpperJaw(Integer numberOfTeethInUpperJaw);

	/* Methods - end */
}