// SUNDAR RAJ
public class QueueUnderflowException extends QueueException
{
	public QueueUnderflowException()
	{
		super("Error: Queue Underflow");
	}

	public QueueUnderflowException(String message)
	{
		super(message);
	}
}