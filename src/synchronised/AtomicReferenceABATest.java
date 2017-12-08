package synchronised;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceABATest {

	public static final AtomicReference <String>ATOMIC_REFERENCE = new AtomicReference<String>("abc");
	
	private final static Random RANDOM_OBJECT = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final CountDownLatch startCountDownLatch = new CountDownLatch(1);
		Thread[] threads = new Thread[20];
		
		for(int i=0; i<20; i++){
			final int num=i;
			threads[i] = new Thread(){
				public void run(){
					String oldValue = ATOMIC_REFERENCE.get();
					try {
						startCountDownLatch.await();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					try {
						Thread.sleep(RANDOM_OBJECT.nextInt() & 500);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					if(ATOMIC_REFERENCE.compareAndSet(oldValue, oldValue+num)){
						System.out.println("我是线程："+num+",进行对象修改！");
					}
				}
			};
			threads[i].start();
		}
		Thread.sleep(200);
		startCountDownLatch.countDown();
		new Thread(){
			public void run(){
				try {
					Thread.sleep(RANDOM_OBJECT.nextInt() & 200);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				while(!ATOMIC_REFERENCE.compareAndSet(ATOMIC_REFERENCE.get(), "abc")){
					System.out.println("已经修改为原值");
				}
			}
		}.start();	
	}

}
