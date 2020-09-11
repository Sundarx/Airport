// SUNDAR RAJ
public class ArrayQueue<T> implements ArrayQueueADT<T>
{
	private int count;
	private int queueFront;
	private int queueRear;
	private T[] list;

	public ArrayQueue()
	{
		queueFront = 0;
		queueRear = 99;
		count = 0;
		list = (T[]) new Object[100];
	}

    //Returns true if empty queue, false if not empty
	public boolean isEmpty()
	{
		return (count == 0);
	}

	//Returns number of planes
	public int count()
	{
		return count;
	}

	//Retrieves T item from the front of queue
	public T peek() throws QueueUnderflowException
	{
		if (isEmpty())
		{
			throw new QueueUnderflowException();
		}

		return (T)list[queueFront];
	}

	//Removes T item to the front of queue
	public void dequeue() throws QueueUnderflowException
	{
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}

		count--;
		list[queueFront] = null;
		queueFront = (queueFront + 1) % list.length;
	}

	//Adds T object to the rear of queue
	public void enqueue(T item) throws QueueOverflowException
	{
		if(count == list.length)
		{
			throw new QueueOverflowException();
		}

		queueRear = (queueRear + 1) % list.length;
		count++;
		list[queueRear] = item;
	}
}