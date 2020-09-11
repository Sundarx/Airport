// SUNDAR RAJ
import java.util.Random;
import java.text.DecimalFormat;

public class MCCAirport
{
	public static void main(String[] args)
	{
		final double LANDING_TIME = 3;
		final double TAKE_OFF_TIME = 2;
		final double LANDING_RATE  = 10;
		final double TAKE_OFF_RATE = 10;
		final int ITERATIONS = 1440;

		ArrayQueue<Integer> landingQueue = new ArrayQueue<Integer>();
		ArrayQueue<Integer> takeOffQueue = new ArrayQueue<Integer>();

		Random generator = new Random(System.currentTimeMillis());

		int landQueueTime = 0;
		int planesLanded = 0;
		int takeOffQueueTime = 0;
		int planesTakenOff = 0;

		for(int i = 0; i < ITERATIONS; i++)
		{
			//If first random number < landingRate/60,
			//"landing arrival" has occurred, add to the landing queue
			if(generator.nextDouble() < ((double)LANDING_RATE/60))
			{
				landingQueue.enqueue(i);
				planesLanded += landingQueue.count();
			}

			//If second random number < takeOffRate/60,
			//"takeoff arrival" has occurred, add to the takeoff queue
			if(generator.nextDouble() < ((double)TAKE_OFF_RATE/60))
			{
				takeOffQueue.enqueue(i);
				planesTakenOff += takeOffQueue.count();
			}

			//Landing queue is prioritized
			while(!landingQueue.isEmpty())
			{
				//Check whether the runway is free
				boolean free = false;
				if(landingQueue.peek() - i > LANDING_RATE)
				{
					free = true;
				}

				while(free)
				{
					landingQueue.dequeue();
				}


				//Allow the first airplane to land
				int land = landingQueue.peek();
				landingQueue.dequeue();

				landQueueTime += (i - land);
				planesLanded++;

				//Add to queues
				int j;
//				for(j = i; j < (LANDING_TIME + i) && j < ITERATIONS; j++)
				{
					if(generator.nextDouble() < ((double)LANDING_RATE/60))
					{
						landingQueue.enqueue(j);

					}
					if(generator.nextDouble() < ((double)TAKE_OFF_RATE/60))
					{
						takeOffQueue.enqueue(j);
					}
				}
				i = j;

			}

			//Consider take-off queue when landing queue is empty
			if(!takeOffQueue.isEmpty())
			{
				//Allow first airplane to take off
				int takeO = takeOffQueue.peek();
				takeOffQueue.dequeue();

				takeOffQueueTime += (i - takeO);
				planesTakenOff++;

				//Add to queues
				int k;
//				for(k = i; k < (TAKE_OFF_TIME + i) && k < ITERATIONS; k++)
				{
					if(generator.nextDouble() < ((double)LANDING_RATE/60))
					{
						landingQueue.enqueue(k);
					}
					if(generator.nextDouble() < ((double)TAKE_OFF_RATE/60))
					{
						takeOffQueue.enqueue(k);
					}
				}
				i = k;
			}
		}

		double pl = (double)planesLanded;
		double pt = (double)planesTakenOff;

		DecimalFormat form = new DecimalFormat("#0.000000");

		System.out.println("Average landing queue length: "
						  + form.format(pl / ITERATIONS));
		System.out.println("Average take off queue length: "
						  + form.format(pt / ITERATIONS));
		System.out.println("Average landing queue time: "
						  + form.format(landQueueTime / pl)
						  + " min");
		System.out.println("Average take off queue time: "
						  + form.format(takeOffQueueTime / pt)
						  + " min");
	}

	//Checks if queue is free
/*	public static boolean queueFree(int val, int it, double rate)
	{
		return (val - it > rate);
	}*/
}