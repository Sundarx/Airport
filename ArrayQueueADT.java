// SUNDAR RAJ
public interface ArrayQueueADT<T>
{
    //Returns true if empty queue, false if not empty
	public abstract boolean isEmpty();

	//Returns number of planes
	public abstract int count();

	//Retrieves T item from the front of queue
	public abstract T peek();

	//Removes T item to the front of queue
	public abstract void dequeue();

	//Adds T item to the rear of queue
	public abstract void enqueue(T item);
}