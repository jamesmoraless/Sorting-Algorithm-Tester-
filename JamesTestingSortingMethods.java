package Lab2Q1;

import java.util.Arrays;

public class JamesTestingSortingMethods
{
    public static <T extends Comparable <? super T>>long selectionSort (T [] a)//Here I have the selection sort method
    {
        long startTime = System.nanoTime();//starting time
        for(int i=0; i<a.length -1; i++)
        {
            int iSmallest = i;

            for(int j=i+1; j<a.length; j++)
            {
                if(a[iSmallest].compareTo((a[j])) > 0  )
                {
                    iSmallest = j;
                }
            }
            T iSwap = a[iSmallest];
            a[iSmallest] = a[i];
            a[i] = iSwap;

        }
        return (long) ((System.nanoTime() - startTime));//how long it took
    }

    public static < T extends Comparable <? super T >> long bubbleSort(T[] a)//Here I have the bubble sort method
    {
        long startTime = System.nanoTime();//starting time

        boolean nextPassNeeded = true;
        for (int i = 1; i < a.length && nextPassNeeded; i++)
        {
            nextPassNeeded = false;
            for (int j = 0; j < a.length - i; j++) {
                if (a[j].compareTo(a[j + 1])>0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    nextPassNeeded = true;
                }
            }
        }
        return (long) ((System.nanoTime() - startTime));//how long it took

    }

    public static < T extends Comparable <? super T >> long insertionSort(T[] array)// here I have the insertion sort method
    {
        long startTime = System.nanoTime();//starting time
        // start at the first index and iterate through to the end
        for (int i = 1; i < array.length; i++)
        {
            T key = array[i];

            for(int j = i-1; (j>=0) && array[j].compareTo(key)>0; j--){
                array[j+1] = array[j];
                array[j] = key;
            }
        }
        return (long) ((System.nanoTime() - startTime));//how long it took
    }

    public static <T extends Comparable <? super T>>long mergeSort (T [] a)//here I have the merge sort method
    {
        long startTime = System.nanoTime();//starting time
        int n = a.length;//length of array

        if (n < 2) {//trivially sorted if there's less than 2 elements
            return (System.nanoTime() - startTime);//return the amount of time spent
        }

        int mid = n/2;//integer division to find the "middle"
        T[] S1 = Arrays.copyOfRange(a, 0, mid);;//1st half of array
        T[] S2 = Arrays.copyOfRange(a, mid, n);;//2nd half of array
        mergeSort(S1); mergeSort(S2);//mergeSort is applied recursively on each half

        //sorting merging the components back
        int i = 0, j = 0;
        while (i + j < a.length) {
            if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j])< 0)) {
                a[i + j] = S1[i++]; // copy ith element of S1 and increment i
            }
            else {
                a[i + j] = S2[j++];// copy jth element of S2 and increment j
            }
        }
        //sorted
        return (System.nanoTime() - startTime);//how long it took
    }

    //quickSort:
    public static <T extends Comparable <? super T>>long quickSort (T [] a,int p,int q)//Here I have the quick sort method
    {
        long startTime = System.nanoTime();//starting time
        if (p >= q){//subArray is already sorted, since there's one element or less
            return (System.nanoTime() - startTime);//how long it took
        }

        int left = p; int right = q;//section that'll be pivoted around index q
        T pivot = a[(p+q)/2];//pivot from middle
        T temp;//used for swapping

        while (left <= right) {//continues until the value is less or equal to the q-value
            while(a[left].compareTo(pivot) < 0) {//scan until reaching a value smaller/equal to pivot
                left++;
            }
            while(a[right].compareTo(pivot) > 0) {//checking from the other end
                right--;
            }
            if (left <= right){//if the indices did not strictly cross, swap the two values & shrink the range
                if (left!=right) {
                    temp = a[left]; a[left] = a[right]; a[right] = temp;//swap
                }
                left++; right--;//range shrink
            }
        }
        //sort the segments recursively, until the whole array is sorted:
        if(p<right){quickSort(a,p,right);}
        if(left<q){quickSort(a,left,q);}
        //sorted
        return (System.nanoTime() - startTime);//how long it took
    }


}
