import java.util.*;
import java.lang.*;
import java.io.File;

public class WgtIntScheduler
{

	public static int[] getOptSet(int[] sTime, int[] fTime, int[] weight)
	{
		Interval[] intervals = new Interval[sTime.length];

		for(int i = 0; i < sTime.length; ++i)
		{
			intervals[i] = new Interval(i + 1, sTime[i], fTime[i], weight[i]);
		}

		/* Sort the array by finish times */
		Arrays.sort(intervals, new CompareIntervals());

		/* Calculate the closest compareable jobs in the array */
		int[] closestJobs = new int[sTime.length];

		/* Iterate through the array */
		for(int i = 0; i < sTime.length; ++i)
		{
			closestJobs[i] = 0;

			for(int j = i - 1; j >= 0; --j)
			{
				if(intervals[i].startTime >= intervals[j].finishTime)
				{
					closestJobs[i] = j + 1;
					j = 0;
				}
			}
		}

		int[] times = new int[sTime.length + 1];
		for(int i = 1; i < sTime.length; ++i)
		{
			times[i] = Math.max(intervals[i - 1].weight + times[closestJobs[i - 1]], times[i - 1]);
		}

		String[] steps = new StringBuilder(traceBack(sTime.length, intervals, times, 
			closestJobs)).reverse().toString().split(" ");

		int[] optimalSchedule = new int[steps.length - 1];

		for(int i = 0; i < optimalSchedule.length; ++i)
		{
			optimalSchedule[i] = Integer.parseInt(steps[i + 1]);
		}

		Arrays.sort(optimalSchedule);
		return optimalSchedule;
	}

	private static String traceBack(int step, Interval[] intervals, int[] times, int[] closestJobs)
	{
		if(step > 0)
		{
			int closestJob = closestJobs[step - 1];

			if((intervals[step - 1].weight + times[closestJob]) >= times[step - 1])
			{
				return (intervals[step - 1].job + " " + traceBack(closestJob, intervals, times, closestJobs));
			}
			else
			{
				return "" + traceBack(step - 1, intervals, times, closestJobs);
			}
		}
		return "";
	}


	private static class Interval
	{
		int job;
		int startTime;
		int finishTime;
		int weight;

		Interval(int job, int startTime, int finishTime, int weight)
		{
			this.job = job;
			this.startTime = startTime;
			this.finishTime = finishTime;
			this.weight = weight;
		}
	}

	public static class CompareIntervals implements Comparator<Interval>
	{
		public int compare(Interval i1, Interval i2)
		{
			if(i1.finishTime > i2.finishTime)
			{
				return 1;
			}
			else if(i1.finishTime < i2.finishTime)
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
	}
} 