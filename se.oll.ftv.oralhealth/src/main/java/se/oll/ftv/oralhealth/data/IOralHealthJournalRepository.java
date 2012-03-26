package se.oll.ftv.oralhealth.data;

import se.hanskindberg.validation.IValidationResult;

public interface IOralHealthJournalRepository
{
	/* Methods - begin */

	IOralHealthJournal create(String socialSecurityNumber);
	Boolean delete(IOralHealthJournal oralHealthJournal);
	IOralHealthJournal[] get();
	IOralHealthJournal get(int id);
	IOralHealthJournal[] get(String socialSecurityNumber);
	void save(IOralHealthJournal oralHealthJournal);
	IValidationResult validate(IOralHealthJournal oralHealthJournal);

	/* Methods - end */
}