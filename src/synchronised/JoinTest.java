package synchronised;

import java.util.Random;

public class JoinTest extends Thread{

	private int start;
	private int end;
	private long result;
	private int []array;
	
	public JoinTest(int start, int end, int[] array) {
		super();
		this.start = start;
		this.end = end;
		this.array = array;
	}
	
	public void run(){
		for(int i=start; i<end; i++){
			result += array[i];
			if(result<0)
				result&=Integer.MAX_VALUE;
		}
	}
	
	public long getResult() {
		return result;
	}
	
	private final static int COUNTER=10;//000000
	
	public static void main(String[] args) throws InterruptedException {
		int []array = new int[COUNTER];
		Random random = new Random();
		for(int i=0;i<COUNTER;i++){
			array[i]=Math.abs(random.nextInt());
			System.out.println(array[i]);
		}
		
		long start = System.currentTimeMillis();
		JoinTest t1 = new JoinTest(0, COUNTER, array);
		JoinTest t2 = new JoinTest(0, COUNTER/2, array);
		JoinTest t3 = new JoinTest(COUNTER/2, COUNTER, array);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		long end = System.currentTimeMillis();
		
		System.out.println("耗时："+(end-start));
		System.out.println("t1 = "+t1.getResult());
		System.out.println("t2 = "+t2.getResult());
		System.out.println("t3 = "+t3.getResult());
		System.out.println("t3+t2 = "+((t2.getResult()+t3.getResult())));
	}
	
}
