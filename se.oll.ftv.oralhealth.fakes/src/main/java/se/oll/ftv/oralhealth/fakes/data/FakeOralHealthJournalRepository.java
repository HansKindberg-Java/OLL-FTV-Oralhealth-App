package se.oll.ftv.oralhealth.fakes.data;

import se.hanskindberg.lang.extensions.StringExtension;
import se.hanskindberg.validation.IValidationResult;
import se.hanskindberg.validation.ValidationResult;
import se.oll.ftv.oralhealth.data.IOralHealthJournal;
import se.oll.ftv.oralhealth.data.IOralHealthJournalRepository;

import java.util.ArrayList;
import java.util.List;

public class FakeOralHealthJournalRepository implements IOralHealthJournalRepository
{
	/* Fields - begin */

	private final List<FakeOralHealthJournal> m_oralHealthJournals;
	private static FakeOralHealthJournalRepository s_instance;

	/* Fields - end */

	/* Constructors - begin */

	public FakeOralHealthJournalRepository()
	{
		this.m_oralHealthJournals = new ArrayList<FakeOralHealthJournal>();

		this.m_oralHealthJournals.add(new FakeOralHealthJournal(1, "12345678-0001", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(2, "12345678-0002", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(3, "12345678-0003", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(4, "12345678-0004", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(5, "12345678-0005", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(6, "12345678-0006", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(7, "12345678-0007", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(8, "12345678-0008", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(9, "12345678-0009", 10, 10));
		this.m_oralHealthJournals.add(new FakeOralHealthJournal(10, "12345678-0000", 10, 10));
	}

	/* Constructors - end */

	/* Methods - begin */

	@Override
	public IOralHealthJournal create(String socialSecurityNumber)
	{
		int newID = 1;

		for (FakeOralHealthJournal oralHealthJournal : this.getOralHealthJournals())
		{
			if (newID <= oralHealthJournal.getID())
				newID = oralHealthJournal.getID() + 1;
		}

		return new FakeOralHealthJournal(newID, socialSecurityNumber, null, null);
	}

	@Override
	public Boolean delete(IOralHealthJournal oralHealthJournal)
	{
		if (this.m_oralHealthJournals == null || this.m_oralHealthJournals.size() == 0)
			return false;

		for (int i = this.m_oralHealthJournals.size() - 1; i >= 0; i--)
		{
			if (oralHealthJournal.getID() == this.m_oralHealthJournals.get(i).getID())
			{
				this.m_oralHealthJournals.remove(i);
				return true;
			}
		}

		return false;
	}

	@Override
	public IOralHealthJournal[] get()
	{
		return this.getOralHealthJournals().toArray(new IOralHealthJournal[0]);
	}

	@Override
	public IOralHealthJournal get(int id)
	{
		for (IOralHealthJournal oralHealthJournal : this.getOralHealthJournals())
		{
			if (oralHealthJournal.getID() == id)
				return oralHealthJournal;
		}

		return null;
	}

	@Override
	public IOralHealthJournal[] get(String socialSecurityNumber)
	{
		ArrayList<IOralHealthJournal> oralHealthJournals = new ArrayList<IOralHealthJournal>();

		for (IOralHealthJournal oralHealthJournal : this.getOralHealthJournals())
		{
			if (oralHealthJournal.getSocialSecurityNumber().equals(socialSecurityNumber))
				oralHealthJournals.add(oralHealthJournal);
		}

		return oralHealthJournals.toArray(new IOralHealthJournal[0]);
	}

	public static FakeOralHealthJournalRepository getInstance()
	{
		if (s_instance == null)
			s_instance = new FakeOralHealthJournalRepository();

		return s_instance;
	}

	private List<FakeOralHealthJournal> getOralHealthJournals()
	{
		if (this.m_oralHealthJournals == null)
			return new ArrayList<FakeOralHealthJournal>();

		return this.m_oralHealthJournals;
	}

	@Override
	public void save(IOralHealthJournal oralHealthJournal)
	{
		FakeOralHealthJournal fakeOralHealthJournal = new FakeOralHealthJournal(oralHealthJournal.getID(), oralHealthJournal.getSocialSecurityNumber(), oralHealthJournal.getNumberOfTeethInLowerJaw(), oralHealthJournal.getNumberOfTeethInUpperJaw());

		for (int i = 0; i < this.m_oralHealthJournals.size(); i++)
		{
			if (oralHealthJournal.getID() == this.m_oralHealthJournals.get(i).getID())
			{
				this.m_oralHealthJournals.set(i, fakeOralHealthJournal);
				return;
			}
		}

		this.m_oralHealthJournals.add(fakeOralHealthJournal);
	}

	@Override
	public IValidationResult validate(IOralHealthJournal oralHealthJournal)
	{
		ValidationResult validationResult = new ValidationResult();
		List<Exception> exceptions = new ArrayList<Exception>();

		if (oralHealthJournal == null)
		{
			exceptions.add(new NullPointerException("The journal can not be null."));
		}
		else
		{
			if (StringExtension.isNullOrEmpty(oralHealthJournal.getSocialSecurityNumber()))
				exceptions.add(new IllegalArgumentException("The social security number can not be null or empty."));

			if (oralHealthJournal.getNumberOfTeethInLowerJaw() == null)
				exceptions.add(new IllegalArgumentException("The number of teeth in the lower jaw can not be null."));

			if (oralHealthJournal.getNumberOfTeethInUpperJaw() == null)
				exceptions.add(new IllegalArgumentException("The number of teeth in the upper jaw can not be null."));
		}

		validationResult.setValid(exceptions.size() == 0);
		validationResult.setExceptions(exceptions.toArray(new Exception[0]));
		validationResult.setValidatedObject(oralHealthJournal);

		return validationResult;
	}

	/* Methods - end */
}