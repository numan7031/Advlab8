package thread;

import java.util.Scanner;

class test extends Thread {
	long start, end, result = 0, count = 0;

	public test(long start, long end, int count) {
		this.start = start;
		this.end = end;
		this.count = count;
	}

	public void run() {
		long i;

		for (i = start; i <= end; i++) {
			result = result + i;
		}

		System.out.printf("Result of Thread%d = %d\n", count + 1, result);
	}

}

public class Command3 {

	public static void main(String args[]) {
		long max, start = 0, end = 0, total = 0;
		int i, thread;
		long startTime = System.currentTimeMillis();

		Scanner in = new Scanner(System.in);

		System.out.print("Enter the Number (N) : ");
		max = in.nextLong();
		System.out.print("Enter the Amount of Thread (M) : ");
		thread = in.nextInt();

		test[] a = new test[thread];

		for (i = 0; i < a.length; i++) {
			start = end + 1;
			end += (max / thread);

			a[i] = new test(start, end, i);

			a[i].start();
		}
		int j;

		for (j = 0; j < thread; j++) {
			try {
				a[j].join();
				total += a[j].result;
			} catch (InterruptedException ie) {
				System.out.printf("Error = " + ie + "\n");
			}
			// System.out.printf("Total Result = %d\n",total);
		}

		System.out.printf("Total Result = %d\n", total);

		long endtime = System.currentTimeMillis();

		long totaltime = endtime - startTime;

		System.out.println("Time = " + totaltime + "  MilliSeconds!!");

	}

}
