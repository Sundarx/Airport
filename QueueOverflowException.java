// SUNDAR RAJ
public class QueueOverflowException extends QueueException
{
	public QueueOverflowException()
	{
		super("Error: Queue Overflow");
	}

	public QueueOverflowException(String message)
	{
		super(message);
	}
}