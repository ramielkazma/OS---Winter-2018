package myExceptions;

public class StackException extends Exception 
{
	/**
	 * default constructor.
	 */
	public StackException()
	{
		super("Could not perform operation");
	}
	/**
	 * parameterized constructor.
	 * @param message, a String
	 */
	public StackException(String message)
	{
		super(message);
	}
	/**
	 * Accessor for message attribute.
	 * @return message, a String
	 */
	public String getMessage()
	{
		return super.getMessage();
	}
}
