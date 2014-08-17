package org.algorithm;

public class MissingNumbersinArray {

	/**
	 * @param args
	 */
	
	int [] num =new int[100];;
	public void addNumbers()
	{
		for(int i=0;i<100;i++)
		{
		num[i]=i+2;	
		i=i+1;
			
		}
			 
		
	}
	
	public void displayNumbers()
	{
		for(int i=0;i<num.length;i++)
		{
		System.out.println("/n the ellements are"+num[i]);
			
		}
		
	}
	
	public void bubbleSort(){
		
		// i starts at the end of the Array
		// As it is decremented all indexes greater
		// then it are sorted
		
		for(int i = num.length - 1; i > 1; i--){
			
			// The inner loop starts at the beginning of 
			// the array and compares each value next to each 
			// other. If the value is greater then they are 
			// swapped
			
			for(int j = 0; j < i; j++){
				
				// To change sort to Descending change to <
				
				if(num[j] > num[j + 1]){
					
					swapValues(j, j+1);
					
					//printHorzArray(i, j);
					
				}
				
			}
			
		}
		
	}
	
	public void swapValues(int indexOne, int indexTwo){
		
		int temp = num[indexOne];
		num[indexOne] = num[indexTwo];
		num[indexTwo] = temp;
		
	}
	
	
	
	public void missingNumbers()
	{
		int j=0;
		for(int i=0;i<num.length;i++)
		{
			
			if(num[i]!=j)
			{
				System.out.println("/n The missing elements are"+j);
				j=j+1;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
MissingNumbersinArray mi=new MissingNumbersinArray();
mi.addNumbers();

mi.displayNumbers();
mi.bubbleSort();
mi.displayNumbers();
//mi.missingNumbers();
	}

}
