/**
 * 
 */
package test;

import java.util.Scanner;

/**
 * @author duchauha
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub  10,40,20,50,30
		Scanner input = new Scanner(System.in);
		System.out.println("please enter the length of the array");
		
		int arr[] = new int[input.nextInt()];
		for(int i=0;i<arr.length;i++) {
			System.out.println("please enter the "+i+1+" elemnt of the array");
			arr[i]=input.nextInt();
		}
		
		input.close();
		QuickSort qs = new QuickSort();
		System.out.println("array before sorting");
		for(int k:arr) {
			 System.out.println(k);
		}
		qs.quickSort(arr,0,arr.length-1);
		System.out.println("array after sorting");
		for(int k:arr) {
			 System.out.println(k);
		}
	}
	
	private void quickSort(int arr[],int low,int high) {
		if(low<high) {
			int pivot = partition(arr,low,high);
			quickSort(arr,low,pivot-1);
			quickSort(arr,pivot+1,high);
		}
	}
	private int partition(int arr[],int low,int high) {
		int i=low-1;
		for(int j=low;j<=high-1;j++) {
			if(arr[j]<=arr[high]) {
				i++;
				swap(arr,i,j);
			}
		}
		i++;
		swap(arr,i,high);
		return i;
		
	}
   
    private void swap(int arr[],int i,int j) {
    	int val = arr[i];
    	arr[i] = arr[j];
    	arr[j]=val;
    }
}
