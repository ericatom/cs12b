import java.io.*;
import java.util.Scanner;

public class Simulation {
   public static void main(String[] args) throws IOException {

      /* Initializing Variables*/
      Scanner sc = null;
      PrintWriter report = null;
      PrintWriter trace = null;
      Queue extraCopy = new Queue();
      Queue extraStorage = new Queue();
      Queue finished = new Queue();
      Queue[] processorQueues = null;
      String numJ;                      //first line in txt file
      int m = 0;                        //number of jobs
      Job j = null;
      int time = 0;

      /*check arg length before entering job simulation */
      if(args.length < 1){
         System.out.println("Usage: Simulation infile");
         System.exit(1);
      }
 
        /*input files */
      sc = new Scanner(new File(args[0]));
      report = new PrintWriter(new FileWriter(args[0] + ".rpt"));
      trace = new PrintWriter(new FileWriter(args[0] + ".trc"));

      numJ = sc.nextLine();
      m = Integer.parseInt(numJ);

      while(sc.hasNextLine()) {
	     j = getJob(sc);
		 extraCopy.enqueue(j);
	  }

		/*output for two files - trace and report */

	  report.println("Report file: " + (args[0] + ".rpt"));
	  report.println(m + " Jobs:");
	  report.println(extraCopy.toString());
	  report.println();
	  report.println("***********************************************************");

	  trace.println("Trace file: " + (args[0] + ".trc"));
	  trace.println(m + " Jobs:");
	  trace.println(extraCopy.toString());
	  trace.println();

		

        /*for loop that runs m-1 simulations aka how many processors */
	  for(int n = 1; n < m; n++) { //Creates one less proccessor than jobs
	     int totalWait = 0;
		 int maxWait = 0;
		 double avgWait = 0.0;
		 int processors = n;

		 for(int i = 1; i < extraCopy.length()+1; i++) {
		    j = (Job)extraCopy.dequeue();
		    j.resetFinishTime();
		    extraStorage.enqueue(j);
			extraCopy.enqueue(j);
		 }

		 processorQueues = new Queue[n+2];
		 processorQueues[0] = extraStorage;
		 processorQueues[n+1] = finished;
		 for(int k = 1; k < n+1; k++) {
		    processorQueues[k] = new Queue();
		 }

		 trace.println("*****************************");
		 if(processors != 1){trace.println(processors + " processors:");}
		 else{trace.println(processors + " processor:");}
				
		 trace.println("*****************************");

	     trace.println("time=" + time);
		 trace.println("0: " + extraStorage.toString());
		 for(int l = 1; l < processors+1; l++) {
		    trace.println(l + ": " + processorQueues[l]);
		 }

            /*checks for more jobs */
		 while(finished.length() != m) {
	        int compareFinal = Integer.MAX_VALUE;
			int minIndex = 1;
			int minValue = -1;
			int length = -1;
			int tempCompare = -1;
			Job compare = null;

				/* Checks arrival time*/
			if (!extraStorage.isEmpty()) {
			   compare = (Job)extraStorage.peek();
			   compareFinal = compare.getArrival();
			   minIndex = 0;
			}

			for(int p = 1; p < processors+1; p++) {
			   if (processorQueues[p].length() != 0) {
			      compare = (Job)processorQueues[p].peek();
				  tempCompare= compare.getFinish();
			   }
			   if (tempCompare == -1) {
			   } else if (tempCompare < compareFinal) {
			      compareFinal = tempCompare;
				  minIndex = p;
			   }
			      time = compareFinal;
			   }

			   if (minIndex == 0) {
			      int tempIndex = 1;
				  
				  minValue = processorQueues[tempIndex].length();
			      
			      for (int q = 1; q < processors+1; q++) {
				     length = processorQueues[q].length();
				  	 if (length < minValue) {
					    minValue = length;
					    tempIndex = q;
					 }
				  }

				   compare = (Job)extraStorage.dequeue();
				   processorQueues[tempIndex].enqueue(compare);
				   if (processorQueues[tempIndex].length() == 1) {
				      compare = (Job)processorQueues[tempIndex].peek();
					  compare.computeFinishTime(time);
				   }
			   } else {
			      compare = (Job)processorQueues[minIndex].dequeue();
				  finished.enqueue(compare);
				  int tempWait = compare.getWaitTime();
				  if (tempWait > maxWait){maxWait = tempWait;}
				     totalWait += tempWait;

					 if (processorQueues[minIndex].length() >= 1) {
					    compare = (Job)processorQueues[minIndex].peek();
						compare.computeFinishTime(time);
					 }
				}

				trace.println();
				trace.println("time=" + time);
				trace.println("0: " + extraStorage.toString());
				for(int r = 1; r < processors+1; r++){
				   trace.println(r + ": " + processorQueues[r]);
				}
			}

			avgWait = ((double)totalWait/m);
			avgWait = (double)Math.round(avgWait*100)/100;
			trace.println();

			if (processors != 1){
		    	report.println(processors + " processors: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + avgWait);
			}else{
				report.println(processors + " processor: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + avgWait);
			}
			time = 0;
			finished.dequeueAll();
		}

        trace.close();
		sc.close();
		report.close();
		

	}

    /* splits pairs of numbers in file into arrival and duration*/
	public static Job getJob(Scanner in) {  
		String[] s = in.nextLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int d = Integer.parseInt(s[1]);
		return new Job(a, d);
	}
}
