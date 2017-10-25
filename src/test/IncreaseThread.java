package test;

/**
* 进行增加操作的线程。
* 
* @author cary
* @version 1.0.0
*/
public class IncreaseThread extends Thread {
	private NumberHolder numberHolder;
	
	public IncreaseThread(NumberHolder numberHolder) {
		this.numberHolder = numberHolder;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; ++i) {
			try {
				Thread.sleep((long) Math.random() * 1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			numberHolder.increase(); //增加操作
		}
	}
}
