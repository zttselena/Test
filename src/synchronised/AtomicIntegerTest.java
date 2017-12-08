package synchronised;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public final static AtomicInteger TEST_INTEGER = new AtomicInteger(1);
	private static volatile int index = 1;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final CountDownLatch startCountDown = new CountDownLatch(1);//保证线程几乎同时开始有机会去征用CPU
		final Thread []threads = new Thread[10];
		
		for(int i=0; i<10; i++){
			threads[i] = new Thread(){
				public void run() {
					try {
						startCountDown.await();
					} catch (Exception e) {
						// TODO: handle exception
					}
					for(int j=0; j<100; j++){
						index++;
						TEST_INTEGER.incrementAndGet();
					}
				}
			};
			threads[i].start();
		}
		
		Thread.sleep(10000);
		startCountDown.countDown();
		for(Thread t : threads){
			t.join();
		}
		
		System.out.println("Atomic最终运行结果："+TEST_INTEGER.get());
		System.out.println("volatile最终运行结果："+index);
		

	}

}
