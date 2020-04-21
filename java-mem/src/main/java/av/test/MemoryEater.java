package av.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

// derived from: https://alvinalexander.com/blog/post/java/java-program-consume-all-memory-ram-on-computer

public class MemoryEater
{
  public static void main(String[] args)
  {
    Runtime rt = Runtime.getRuntime();
    int cpus = rt.availableProcessors();
    long totMem = rt.totalMemory();
    long maxMem = rt.maxMemory();
    long freeMem = rt.freeMemory();
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    Date date = new Date();
	System.out.println("Starting MemoryEater Run @ " + dateFormat.format(date));
	System.out.println("-----------------");
	System.out.println("CPUs available: " + cpus);
	System.out.println("-----------------");
	System.out.println("Initial memory values");
	System.out.println("total memory (from Runtime): " + totMem);
	System.out.println("max memory (from Runtime):   " + maxMem);
	System.out.println("free memory (from Runtime):  " + freeMem);
	System.out.println("-----------------");
	
    Vector<byte[]> memVector = new Vector<byte[]>();
    long iteration = 0;
    while (true)
    {
      byte b[] = new byte[10485760];
      memVector.add(b);
      System.out.println("iteration[" + ++iteration + "] - free memory: " + rt.freeMemory());
      System.out.flush();
    }
  }
}

