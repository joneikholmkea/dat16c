package sorting;

import java.util.Arrays;

public class MergeSort
{

	public static void main(String[] args)
	{
		int[] arr1={7,3,4,6,8,1,2,5};
		int[] arr2={1,2,3,9};
		int[] result=new int[8];
		mergeSort(arr1);
		//merge(result, arr1, arr2);
		for (int i = 0; i < arr1.length; i++)
		{
			System.out.print(" "+arr1[i]);
		}
	}

	
	public static void mergeSort(int[] a){
		if(a.length>1){
			
			int[] left=Arrays.copyOfRange(a, 0, a.length/2);
			int[] right=Arrays.copyOfRange(a, a.length/2, a.length);
			mergeSort(left);
			mergeSort(right);
			
			merge(a, left, right);
		}
	}
	
	public static void merge(int[] result, int[] left, int[]right){
		int count1=0;
		int count2=0;
		for (int i = 0; i < result.length; i++)
		{
		//	System.out.println("merge kaldt med i:" + i + " c1:"+count1 + " c2:"+count2);
			if(count2>=right.length || (count1<left.length && left[count1]<=right[count2] )){ //take from left
				result[i]=left[count1];
				count1++;
			}else{
				result[i]=right[count2];  //take from right
				count2++;
			}
		}
	}
}






