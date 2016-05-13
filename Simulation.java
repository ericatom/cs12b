public class Simulation{

   public static void main(String[] args) throws IOException{
      
      //Variables
      String numJ = null; //number of jobs - first line in inputfile
      Job[] storage;
      Queue<Job>[] processorQueues;
      int completedJobs;   //keeps track of all finished jobs
      int jobCount;   //number of jobs aka variable m in instrustctions
      int numP;       //number of processors
      int time=0;
      int counter = 0;
      int minValue;
      int minIndex;

      //check arg length before entering job simulation
      if(args.length < 1){
         System.out.println("Usage: Simulation infile");
         System.exit(1);
      }
     
      //input files
      Scanner in = new Scanner(new File(args[0]));
      PrintWriter report = new PrintWriter(new FileWriter(args[0] + ".rpt"));
      PrintWriter trace = new PrintWriter(new FileWriter(args[0] + ".trc"));
     
      //start reading from input file and assigning variables
     
      numJ = in.nextLine();
      jobCount = Integer.parseInt(numJ); //change string to int
      storage = new Job[jobCount];
      while (in.hasNext()){
         j = getJob(in);           //intaking jobs from in file
         storage[counter] = j;
         counter++;
      }
      //output for two files - report and trace
      report.println("Report file: " + (args[0] + ".rpt"));
      report.println(m + " Jobs:");
      report.println(processorQueues[0].toString());
      report.println();
      report.print("***********************************************************");
      
      trace.println("Trace file: " + (args[0] + ".trc"));
      trace.println(m + " Jobs:");
      trace.println(processorQueues[0].toString());
      trace.println();      

      //for loop that runs m-1 simulations
      for(numP = 1; numP <= (m-1); numP++){
         int totalWait = 0;
         int maxWait = 0;
         double averageWait = 0;

         processorQueues = new Queue[numP+1];

         for(int i=0;i<=numP;i++){                   //assigning empty queues to each index in processorQueue array
            processorQueues[i] = new Queue<Job>();
         }
         
         for(int i=0;i<=jobCount;i++){
            Job k = new Job(storage[i].arrival,storage[i].duration);
            processorQueues[0].enqueue(k); 
         }

         trace.println("*****************************"); 
         if(processors==1){
            trace.println(processors + " processor:");
         }else{
            trace.println(processors + " processors:");
         }
         trace.println("*****************************");


         while(completedJobs != jobCount){     
            trace.println("time="+time);
            for(int processorID=0; processorID<=numP; processorID++){   //processorsID is the number of "cashiers" inside the main for loop that keeps track of processors
               trace.print(processorID + ": ");
               for(Job j: processorQueues[i]){            //same as for loop that contains array length
                  for(int p = 1; p <=numP; p++){                  //iterating through processors to see if any finish times == time
                     Job r = processorQueues[p].peek();
                     (if r.getFinish() == UNDEF) {
                        j.computeFinishTime(time);
                     }
                     if(j.getFinish()== time){
                        processorQueues[0].enqueue(j);
                     }
                  }


                  if(j.getArrival() == time) {
                     if(numP==1){                          //if one processor then just add to first processor
                        processorQueues[i].enqueue(j);
                     }else{
                        minValue = processorQueues[1].size;     //set minValue to first queue 
                        minIndex = 1
                        for(int p = 1; p <=numP; p++){                 //search for shortest length queue
                           if(processorQueues[p].size < processorQueues[minIndex].size){    
                              minValue = processorQueues[p].size;
                              minIndex = p;
                           }
                        }
                        processorQueues[minIndex].enqueue(j);     //add job to the queue with the shortest line and smallest index
                     }
                  }
                  trace.print(j);
               }                             
            }                  
            

         time++;
         }  
          


      //taken from SimulationStub - helps split two integers per line
      


      }

      public static Job getJob(Scanner in) {
         String[] s = in.nextLine().split(" ");
         int a = Integer.parseInt(s[0]);
         int d = Integer.parseInt(s[1]);
         return new Job(a, d);
      }
      
      
      
      

    
