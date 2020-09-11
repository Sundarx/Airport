# Airport

Program uses queues to simulate an Airport's operation. Assume a simulated clock that advances in one-minute intervals.

There are 2 types of queues: a queue of airplanes waiting to land AND a queue of airplanes waiting to take off.

Since it is more expensive to keep a plane airborne than to have one waiting on the ground, we assume that the airplanes in the landing queue have priority over those in the takeoff queue.

For each minute, 2 random numbers are generated: If the first is less than landingRate/60 where landingRate is the rate of planes that land each hour, a "landing arrival" has occured and is added to the landing queue; if the second is less than takeOffRate/60 where takeOffRate is the rate of planes that take off each hour, a "takeoff arrival" has occured and is added to the takeoff queue.

We must also check if the runway is free. If it is free, first we check whether the landing queue is nonempty and if it is, we allow the first plane to land. Otherwise, we consider the take takeoff queue.

The program also calculates the average queue length and the average time that an airplane spends in a queue.
