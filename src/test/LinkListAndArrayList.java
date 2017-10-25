package test;

import java.util.LinkedList;   
import java.util.List;   
import java.util.Random;   
import java.util.ArrayList;   
import java.util.Arrays;   
import java.util.Collections;   
public class LinkListAndArrayList{   
     public static final int N=500000;   
  
     public static List values;   
     
     static{   
         Integer vals[]=new Integer[N];   
  
         Random r=new Random();   
  
         for(int i=0,currval=0;i<N;i++){   
             vals[i]=new Integer(currval);   
             currval+=r.nextInt(100)+1;   
         }   
  
         values=Arrays.asList(vals);   
     }   
  
//     static long timeList(List lst){   
//         long start=System.currentTimeMillis();   
//         for(int i=0;i<N;i++){   
//             int index=Collections.binarySearch(lst, values.get(i));   
//             if(index!=i)   
//                 System.out.println("***错误***");   
//         }   
//         return System.currentTimeMillis()-start;   
//     } 
     
     static long timeList(List list){   
         long start=System.currentTimeMillis();   
         Object o = new Object();   
         for(int i=0;i<N;i++)  {
        	 list.add(0);
//        	 System.out.println(list.get(i).toString());
         } 
                
         return System.currentTimeMillis()-start;   
    }
     public static void main(String args[]){
//    	 for(int i=0;i<N;i++)  {
//        	 System.out.println(values.get(i).toString());
//         }
         System.out.println("ArrayList消耗时间："+timeList(new ArrayList(values)));   
         System.out.println("LinkedList消耗时间："+timeList(new LinkedList(values)));   
     }   
} 
