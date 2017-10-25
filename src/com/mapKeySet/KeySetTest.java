package com.mapKeySet;

import java.util.HashMap;  
import java.util.LinkedHashMap;  
import java.util.Map;  
import java.util.Random;
import java.util.TreeMap;  
  
/** 
 * @version 1.0 
 */  
public class KeySetTest {  
    public static void main(String[] args) { 
//    	int iterators=100000;
        Map<String, String> map = new HashMap<String, String>();  
//        for(int i=0;i<iterators;i++){
//        	map.put(String.valueOf(i), String.valueOf(i%3));
//        }
        map.put("a", "1");  
        map.put("b", "2");  
        map.put("c", "3");  
        map.put("d", "4");  
        map.put("e", "5"); 
        map.put("f", "6"); 
          
        System.out.print("HashMap:");  
        for(String key : map.keySet()) {  
            System.out.print(map.get(key) + " ");  
        }  
        System.out.print(map); 
        Map<String, String> linkedMap = new LinkedHashMap<String, String>();  
        linkedMap.put("a", "1");  
        linkedMap.put("b", "2");  
        linkedMap.put("c", "3");  
        linkedMap.put("e", "5"); 
        linkedMap.put("f", "6"); 
        linkedMap.put("d", "4");  
          
        System.out.print("LinkedHashMap:");  
        for(String key : linkedMap.keySet()) {  
            System.out.print(linkedMap.get(key) + " ");  
        }  
          
        Map<String, String> treeMap = new TreeMap<String, String>();  
        treeMap.put("a", "1"); 
        treeMap.put("e", "5"); 
        treeMap.put("f", "6"); 
        treeMap.put("b", "2");  
        treeMap.put("c", "3");  
        treeMap.put("d", "4");  
          
        System.out.print("TreeMap:");  
        for(String key : treeMap.keySet()) {  
            System.out.print(treeMap.get(key) + " ");  
        }  
    }  
}