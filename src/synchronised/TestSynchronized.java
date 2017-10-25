package synchronised;

public class TestSynchronized   
{    
	public static int i=50;
//	static Object obj=new Object();
    public synchronized void test1()   
    {    
//              int i = 5;    
              while( i-- > 0)   
              {    
                   System.out.println(Thread.currentThread().getName() + " : " + i);    
                   try   
                   {    
                        Thread.sleep(500);    
                   }   
                   catch (InterruptedException ie)   
                   {    
                   }    
              }    
    }    
      
    public synchronized static void test2()   
    {    
//         int i = 5;    
         while( i-- > 0)   
         {  
        	 
              System.out.println(Thread.currentThread().getName() + " : " + i);    
              try   
              {    
                   Thread.sleep(500);    
              }   
              catch (InterruptedException ie)   
              {    
            	  ie.printStackTrace();
              }    
         }    
    }    
      
    public static void main(String[] args)   
    {    
         final TestSynchronized myt2 = new TestSynchronized();   
         Thread test1 = new Thread(  new Runnable() {  
        	 public void run() {  
        		 myt2.test2(); 
        		 }  
        	 }, "test1"  );    
         Thread test2 = new Thread(  new Runnable() {  
        	 public void run() { 
        		 TestSynchronized.test2();   
        		 }  
        	 }, "test2"  );    
         Thread test3 = new Thread(  new Runnable() {  
        	 public void run() { 
        		 myt2.test2(); 
        		 }  
        	 }, "test3"  );  
         test1.start();    
         test2.start();  
         test3.start(); 
//         TestRunnable tr=new TestRunnable();  
//         Thread test3=new Thread(tr);  
//         test3.start();  
    }   
    
}  
