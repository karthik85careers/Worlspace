package net.viralpatel;

import java.util.PriorityQueue;
import java.util.Queue;

public class TryMe {
	
	
	public static void tryMe()
	{
		
		System.out.println("Try me");
	}
	
	public static void printB(String str) {
        System.out.print(Boolean.valueOf(str) ? "true" : "false"); 
   }
	public static void size()
	{
		
		  int i = 10;
		      while (++i <= 10) {
		          i++;
		      }
		    System.out.print(i);
	}
    public static void main(String args[]) throws InterruptedException {
    	Thread.sleep(1);
    	String arr[] = new String[10];
        arr = null;
    	//tryMe();
    	//System.gc();
    ////	size();\
        printB("tRuE");
        printB("false");
    	
        Queue<String> q = new PriorityQueue<String>();
        q.add("3");
        q.add("1");
        q.add("2");
        String str = null;
        if (str.length() == 0) {
            System.out.print("1");
        }
       // System.out.print(q.poll() + " ");
       // System.out.print(q.peek() + " ");
        //System.out.print(q.peek());
    }
}
