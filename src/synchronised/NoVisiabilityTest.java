package synchronised;

/**
 * 并发模型中的“可见性”问题
 * 一个线程将该对象的属性修改后，另一个线程看不到该属性被修改后的结果，或不能立马看到
 * 修改方式：
 * 1）ready 加volatile关键字
 * 2）run 方法中使用yield();方法
 * */
public class NoVisiabilityTest {

	private static class ReadThread extends Thread {
//		private volatile boolean ready;
		private boolean ready;
		private int number;
		
		public void run(){
			while(!ready){
				number++;
//				yield();
			}
			System.out.println(ready);
		}
		public void readyOn() {
			this.ready = true;
		}
	}
	
	/**
	 * 主程序已经结束，但是run方法会进入死循环
	 * */
	public static void main(String[] args) throws InterruptedException{
		ReadThread readThread = new ReadThread();
		readThread.start();
		Thread.sleep(200);
		readThread.readyOn();
		System.out.println(readThread.ready);
	}
}
