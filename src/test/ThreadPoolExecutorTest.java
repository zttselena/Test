package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
		
		//缓存线程池，要注意控制任务的数量，否则，由于大量线程同时运行，很有会造成系统瘫痪
		//CachedThreadPool使用没有容量的SynchronousQueue作为主线程池的工作队列，它是一个没有容量的阻塞队列。
		//每个插入操作必须等待另一个线程的对应移除操作。这意味着，如果主线程提交任务的速度高于线程池中处理任务的速度时，CachedThreadPool会不断创建新线程。
		//极端情况下，CachedThreadPool会因为创建过多线程而耗尽CPU资源。
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("CachedThreadPool:" + index);
				}
			});
		}

		//固定线程池，FixedThreadPool是一个典型且优秀的线程池，它具有线程池提高程序效率和节省创建线程时所耗的开销的优点。
		//但是，在线程池空闲时，即线程池中没有可运行任务时，它不会释放工作线程，还会占用一定的系统资源。
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println("FixedThreadPool:" + index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		
		//单线程化的Executor，即只创建唯一的工作者线程来执行任务，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
		//如果这个线程异常结束，会有另一个取代它，保证顺序执行。单工作线程最大的特点是可保证顺序地执行各个任务，并且在任意给定的时间不会有多个线程是活动的。
		ExecutorService singleThreadExecutor = Executors
				.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						System.out.println("singleThreadExecutor:" + index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		//创建一个定长的线程池，而且支持定时的以及周期性的任务执行，支持定时及周期性任务执行。
		ScheduledExecutorService scheduledThreadPool = Executors
				.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("延时3秒：" + "delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);

		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out
						.println("delay 1 seconds, and excute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);

	}
}
