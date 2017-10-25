package synchronised;

import java.util.concurrent.CountDownLatch;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
public class TestSynchronizedS {  
  
        /** 
         * @param args 
         */  
        public static void main(String[] args) {  
              
            ExecutorService service = Executors.newCachedThreadPool();  
            final CountDownLatch cdOrder = new CountDownLatch(1);  
            final CountDownLatch cdAnswer = new CountDownLatch(3);  
              
            final SynchonizedClass sc = new SynchonizedClass();  
            for(int i=0; i<3; i++){  
                Runnable runnable = new Runnable(){  
  
                    public void run() {  
                        try{  
                            cdOrder.await();  
                            sc.start();  
                            cdAnswer.countDown();  
                        }catch(Exception e){  
                            e.printStackTrace();  
                        }  
                    }  
                      
                };  
                service.execute(runnable);  
            }  
            try{  
                Thread.sleep((long) (Math.random()*10000));  
                System.out.println("线程" + Thread.currentThread().getName() +   
                        "发布执行命令");  
                cdOrder.countDown();  
                long beginTime = System.currentTimeMillis();  
                System.out.println("线程" + Thread.currentThread().getName() +   
                "已经发送命令，正在等待结果");  
                cdAnswer.await();  
                System.out.println("线程" + Thread.currentThread().getName() +   
                "已收到所有响应结果,所用时间为：" + (System.currentTimeMillis()-beginTime));  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
            service.shutdown();  
    }  
}  
  
class SynchonizedClass{  
      
    public void start() throws InterruptedException{  
          
        Thread.sleep(100);//执行其它逻辑消耗时间  
        synchronized(this){  
         System.out.println("我运行使用了 10 ms");  
        }  
    }  
} 
