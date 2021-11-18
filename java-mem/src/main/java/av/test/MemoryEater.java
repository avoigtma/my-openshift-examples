package av.test;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

// derived from: https://alvinalexander.com/blog/post/java/java-program-consume-all-memory-ram-on-computer

public class MemoryEater {
	
	static int ALLOC_SIZE_DEFAULT = 10485760; // 10 MB
	
	public static String getMemSize(long value) {
		DecimalFormat bytesFormatter = new DecimalFormat("#,###,###");
		DecimalFormat mbFormatter = new DecimalFormat("#,###,###.00");
		return new StringBuilder().append(bytesFormatter.format(value)).append(" bytes / ").append(mbFormatter.format(value/(1024*1024))).append(" MB)").toString();
	}

	public static void main(String[] args) {
		String allocSizeEnvVar = System.getenv("ALLOC_SIZE");
		int allocSize = ALLOC_SIZE_DEFAULT;
		
		System.out.println("MemoryEater - this process will consume all memory available for the JVM");
		System.out.println();
		try {
			allocSize = Integer.parseInt(allocSizeEnvVar);
			System.out.println("Using " + allocSize + " for memory allocation");
		} catch (NumberFormatException nfe) {
			System.out.println("No 'ALLOC_SIZE' environment variable found. Using default value " + allocSize + " for memory allocation");
		}

		Runtime rt = Runtime.getRuntime();
		int cpus = rt.availableProcessors();
		long totMem = rt.totalMemory();
		long maxMem = rt.maxMemory();
		long freeMem = rt.freeMemory();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		Date date = new Date();
		System.out.println("Starting MemoryEater Run @ " + dateFormat.format(date));
		System.out.println();
		System.out.println("Information from Java Runtime:");
		System.out.println("-----------------");
		System.out.println("CPUs available: " + cpus);
		System.out.println("-----------------");
		System.out.println("Initial memory values");
		System.out.println("total memory (from Runtime): " + getMemSize(totMem));
		System.out.println("max memory (from Runtime):   " + getMemSize(maxMem));
		System.out.println("free memory (from Runtime):  " + getMemSize(freeMem));
		System.out.println("-----------------");
		System.out.println();

		Vector<byte[]> memVector = new Vector<byte[]>();
		long iteration = 0;
		while (true) {
			byte b[] = new byte[allocSize];
			memVector.add(b);
			System.out.println("iteration[" + ++iteration + "] - free memory: " + getMemSize(rt.freeMemory()));
			System.out.flush();
		}
	}
}
