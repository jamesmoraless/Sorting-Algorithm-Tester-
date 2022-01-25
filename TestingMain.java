package Lab2Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestingMain
{
    public static void main(String[] args)
    {
        header();//my header
        int sz = 50000;
        Integer[] mainArr = new Integer[sz];//main array
        Integer[] backupArr = new Integer[sz];// backup/ copy array

        for (int i = 0; i<sz; i++)
        {
            mainArr[i] = (int) (Math.random()*sz+1);//I populate the array
        }

        System.arraycopy(mainArr,0,backupArr,0,sz);//I copy the content from the main array into the backup array
        ArrayList<Integer> mainList = new ArrayList<>(Arrays.asList(mainArr));//pushes mainArr to mainList

        System.out.println("Testing execution time of different sorting algorithms for sorting "+ sz +" random numbers:");
        long startTime = System.nanoTime();//starting time
        Collections.sort(mainList);//Collection's sort
        long endTime = System.nanoTime() - startTime;
        System.out.println("Collections' Sorting Time: "+ (endTime/1E6) + " milliseconds");
        System.arraycopy(backupArr,0,mainArr,0,sz);//I copy the backup array content back into the main array so that its back to its original form

        //This format is repeated with all the sorting methods
        long time = JamesTestingSortingMethods.selectionSort(mainArr);//this stores the time in nanoseconds for this sorting method
        System.out.println("My Selection-Sort Time: " + time/1E6+ " milliseconds");//I print out the time in milliseconds
        System.arraycopy(backupArr,0,mainArr,0,sz);//Again, I Copy the elements from the backup array into the main array to get it back to unsorted

        time = JamesTestingSortingMethods.bubbleSort(mainArr);
        System.out.println("My Bubble-Sort Time: " + time/1E6 + " milliseconds");
        System.arraycopy(backupArr,0,mainArr,0,sz);

        time = JamesTestingSortingMethods.insertionSort(mainArr);
        System.out.println("My Insertion-Sort Time: " + time/1E6 + " milliseconds");
        System.arraycopy(backupArr,0,mainArr,0,sz);

        time = JamesTestingSortingMethods.mergeSort(mainArr);
        System.out.println("My Merge-Sort Time: " + time/1E6 + " milliseconds");
        System.arraycopy(backupArr,0,mainArr,0,sz);

        time = JamesTestingSortingMethods.quickSort(mainArr, 0, sz-1);
        System.out.println("My Quick-Sort Time: " + time/1E6 + " milliseconds");

        footer();//my footer method
    }

    public static void header()
    {
        String nm1 = "James Morales", nm2 = "Derin Yilmaz", goal = "In this question, we will be working with the concept sorting algorithms and we took note of their execution times" +
                " in order to see the effectiveness of each algorithm";
        int sN1 = 251136192, sN2 = 251159713;


        System.out.println("_______________________________________");
        System.out.println("Names: "+ nm1 + " and "+ nm2);
        System.out.println("Student Numbers: "+ sN1+ " and " + sN2);
        System.out.println("Goal of this project: "+ goal);
        System.out.println("---------------------------------------");
    }

    public static void footer()
    {
        //Here we pop out the values of our stack in LIFO order in order to print them
        System.out.println("_______________________________________");
        System.out.println("This is 4:40pm on November 25th 2021.");
        System.out.println("Completion of Lab Assignment 2 is successful!");
        System.out.println("Good Bye! James Morales.");
        System.out.println("---------------------------------------\n");
    }
}
