// SUNDAR RAJ
public class QueueException extends RuntimeException
{
	public QueueException()
	{
		super("Error: Queue Exception");
	}

	public QueueException(String message)
	{
		super(message);
	}
}