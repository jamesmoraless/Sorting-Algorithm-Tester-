package Lab2Q2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class James_SortNameAndGrade
{
    public static void main(String[] args) {
//call your header method
        header();

        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        Integer[] grd = {(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26),(int)(60 + Math.random()*26)};
//create a Vector<> class instance sg with StudentGrade tag.
        Vector <StudentGrade> sg = new Vector<>();
//Add each StudentGrade object to the Vector class with its add method (Slide #36, Unit 2 Part 2)
        // generating student objects with given data and appending them to the vector collection
        for (int i = 0; i< grd.length ;i++){
            sg.add(new StudentGrade(fnArray[i],lnArray[i],grd[i]));
        }
//print the unsorted sg contents just by using toString() method (see the sample output)
        System.out.println("Unsorted Array.............");
        for (int i =0; i<sg.size(); i++)
        {
            System.out.println(sg.elementAt(i).toString());
        }
        System.out.println();

//sort sg using Collections’ sort method and that will sort the list based on the grade
        Collections.sort(sg);
//print the sorted content by using toString() method (see the sample output)
        System.out.println("Sorted by Grades...........");
        for (int i =0; i<sg.size(); i++)
        {
            System.out.println(sg.elementAt(i).toString());
        }
        System.out.println();
//Create an array of StudentGrade type with a length of fnArray
        StudentGrade[] sGArray = new StudentGrade[fnArray.length];

//with the help of Vectors copyInto() method, copy sg to StudentGrade array you just created above
        sg.copyInto(sGArray);
/*
At this point tweak one of the stable sorting methods (your created in Q1), either merge or insertion
        sort that will accept a StudentGrade array and an integer key. Define this public static void method
        outside the driver method below. The key in the method header will decide whether you would like to
        sort the StudentGrade array according to the first name (key = 1) or the last name (key = 2). Once
        done, come back to this place inside the driver and call your sort method with the argument of
        StudentGrade array (you created above) and key = 1 (first names).
*/
        mergeSort(sGArray, "1");
//print the sorted array (see the sample output)
        System.out.println("Sorted by First Names.........");
        for (int i =0; i<sg.size(); i++)
        {
            System.out.println(sGArray[i].toString());
        }
        System.out.println();
// Call your sort method again with the argument of StudentGrade array (you created above) and key =
        mergeSort(sGArray, "2");

//print the sorted array (see the sample output)
        System.out.println("Sorted by Last Names.........");
        for (int i =0; i<sg.size(); i++)
        {
            System.out.println(sGArray[i].toString());
        }
        System.out.println();

//call your footer method here
        footer();
    }
//mergeSort:
public static void mergeSort (StudentGrade [] a, String key){//merge sort, but for StudentGrade-type arrays
    //key determines whether it's sorting by 1st or last name, is a string to prevent errors from a mis-input
    int n = a.length;//length of array

    if (n < 2) {//trivially sorted if there's less than 2 elements
        return;//ends the method if trivially sorted
    }

    int mid = n/2;//integer division to find the "middle"
    StudentGrade[] S1 = Arrays.copyOfRange(a, 0, mid);;//1st half of array
    StudentGrade[] S2 = Arrays.copyOfRange(a, mid, n);;//2nd half of array
    mergeSort(S1, key); mergeSort(S2, key);//mergeSort is applied recursively on each half

    //sorting merging the components back
    int i = 0, j = 0;
    while (i + j < a.length) {
        if (key == "1"){ ////if key="1", sort by 1st names:
            if (j == S2.length || (i < S1.length && S1[i].getFirstName().compareTo(S2[j].getFirstName()) < 0)) {//sorting in ascending order
                a[i + j] = S1[i++]; // copy ith element of S1 and increment i
            }
            else if (j == S2.length || (i < S1.length && S1[i].getLastName().compareTo(S2[j].getLastName()) < 0 && S1[i].getFirstName().compareTo(S2[j].getFirstName()) == 0)) {//if the 1st names matched
                a[i + j] = S1[i++]; // copy ith element of S1 and increment i
            }
            else {
                a[i + j] = S2[j++];// copy jth element of S2 and increment j
            }
        }
        else if (key == "2"){//if key="2", sort by last names:
            if (j == S2.length || (i < S1.length && S1[i].getLastName().compareTo(S2[j].getLastName()) < 0)) {//sorting in ascending order
                a[i + j] = S1[i++]; // copy ith element of S1 and increment i
            }
            else if (j == S2.length || (i < S1.length && S1[i].getFirstName().compareTo(S2[j].getFirstName()) < 0 && S1[i].getLastName().compareTo(S2[j].getLastName()) == 0)) {//sorting in ascending order
                a[i + j] = S1[i++]; // copy ith element of S1 and increment i
            }
            else {
                a[i + j] = S2[j++];// copy jth element of S2 and increment j
            }
        }
    }
    //sorted
    //nothing to return, since actual input array will be sorted
}

    public static void header()
    {
        String nm1 = "James Morales", nm2 = "Derin Yilmaz", goal = "In this question, we will be working with the concept sorting algorithms and sort based off of certain key's" +
                " in order to see how stable sorting algorithms are used";
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
        System.out.println("This is 8:45pm on November 29th 2021.");
        System.out.println("Completion of Lab Assignment 2 is successful!");
        System.out.println("Good Bye! James Morales.");
        System.out.println("---------------------------------------\n");
    }
}
