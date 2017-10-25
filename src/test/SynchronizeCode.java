package test;

public class SynchronizeCode {
//   public static void main(String[] args) {
//       new TicketSeller().start();
//       new TicketSeller().start();
//       new TicketSeller().start();
//       new TicketSeller().start();
//   }
	
	//为加同步的线程
//	   public static void main(String[] args) {
//	       new Thread() {
//	           public void run() {
//	               while (true) {
//	                   System.out.print("同步");
//	                   System.out.println("代码");
//	               }
//	           };
//	       }.start();
//	       new Thread() {
//	           public void run() {
//	               while (true) {
//	                   System.out.print("Synchronize");
//	                   System.out.println("Code");
//	               }
//	           };
//	       }.start();
//	   }
	
	//加入同步
//	private static int N = 10;
//	   public static void main(String[] args) {
//	       /************ 创建锁对象 ************/
//	       final Object lock = new Object();
//	       /************ 开启线程一 ************/
//	       new Thread() {
//	           public void run() {
//	               while (true) {
//	            	   if(N==0){
//	            		   break;
//	            	   }
//	                   synchronized (lock) {
//	                	   N--;
//	                       System.out.print("同步");
//	                       System.out.println("代码");
//	                   }
//	               }
//	           };
//	       }.start();
//	       /************ 开启线程二 ************/
//	       new Thread() {
//	           public void run() {
//	               while (true) {
//	            	   if(N==0){
//	            		   break;
//	            	   }
//	                   synchronized (lock) {
//	                	   N--;
//	                       System.out.print("Synchronize");
//	                       System.out.println("Code");
//	                   }
//	               }
//	           };
//	       }.start();
//	   }
	public static void main(String[] args) {
		Object obj=new Object();
		int n=0;
		new Thread(){
			
		}.start();
	}
	
}

class TicketSeller extends Thread {

   private static int ticket = 100;
   private static Object lock = new Object();

   public void run() {
       while (true) {
           synchronized (lock) {
               /************ 每次售票前进行判断 ************/
               if (ticket == 0) {
                   break;
               }

               /************ 模拟售票的网络延迟 ************/
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               /************ 符合条件后进行售票 ************/
               System.out.println(Thread.currentThread().getName() + " 售出了第　" + ticket-- + "　张票");
           }
       }
   }
}