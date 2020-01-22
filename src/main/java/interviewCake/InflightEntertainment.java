package interviewCake;

import java.util.HashSet;
import java.util.Set;

public class InflightEntertainment {

	/**
	 * You've built an inflight entertainment system with on-demand movie streaming.
	 *
	 * Users on longer flights like to start a second movie right when their first one ends, but they complain that the plane usually lands before they can see the ending. So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.
	 *
	 * Write a method that takes an integer flightLength (in minutes) and an array of integers movieLengths (in minutes) and returns a boolean indicating whether there are two numbers in movieLengths whose sum equals flightLength.
	 *
	 * When building your method:
	 *
	 * Assume your users will watch exactly two movies
	 * Don't make your users watch the same movie twice
	 * Optimize for runtime over memory
	 *
	 *
	 * Bonus
	 * What if we wanted the movie lengths to sum to something close to the flight length (say, within 20 minutes)?
	 * What if we wanted to fill the flight length as nicely as possible with any number of movies (not just 2)?
	 * What if we knew that movieLengths was sorted? Could we save some space and/or time? => Binary search = logN
	 *
	 */

	public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

		// determine if two movies add up to the flight length

		Set<Integer> seenMovieSet = new HashSet<Integer>();

		for(int m1: movieLengths){
			int m2 = flightLength - m1;
			if(seenMovieSet.contains(m2))
				return true;
			seenMovieSet.add(m1);
		}
		return false;
	}

}
