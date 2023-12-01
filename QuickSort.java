/********************************************************************************/
//  LeetCode------->
//  CodeStudio----->https://www.codingninjas.com/codestudio/problems/quick-sort_983625?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_15
/********************************************************************************/

/*
    QuickSort is a sorting algorithm based on the Divide and Conquer algorithm that picks an element 
    as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct 
    position in the sorted array.
*/

/*
    Divide And Conquer 
    This technique can be divided into the following three parts:

    Divide: This involves dividing the problem into smaller sub-problems.
    Conquer: Solve sub-problems by calling recursively until solved.
    Combine: Combine the sub-problems to get the final solution of the whole problem.
*/

/*
Intution:
step1: kisi bhi ele ko pivot ele consider karlo in this ex suppose pivot ele is 0th index ele in ana array
step2: Us pivot ele ko uske jagha means sorting ke bad wale correct index pe swap karlo
step3: index find out karne ke liye chek akaro ki array me kitne ele use chote he
step4: ab pivot ele ke left ke sare ele pivot se chote ya equal hone chahiye our right side ke sare bade
*/

/**
 * QuickSort
 */
import java.util.Scanner;

// my comment added
//  0  1  2  3 4  5  6 7 8 9 10 11
// 4 22 20 0 12 8 15

/*
 Not working properly
*/

class Logic {
    public int quickSort(int arr[], int s, int e) {
        // always consider first ele as a pivot index
        int pivot = arr[s];
        // now insert pivot ele at its correct position by finding smaller ele than
        // current ele in array
        int indx = 0;
        for (int i = s + 1; i <= e; i++) {
            if (arr[i] <= pivot)
                indx++;
        }
        indx += s;
        // now swap ele at cnt indx and pivot ele
        arr[s] = arr[indx];
        arr[indx] = pivot;

        // after moving pivot at its actual place after sorting array make sure all ele
        // to left of pivot are smaller
        // and all elements to right of pivot is grater ele

        int st = s, en = e;
        while (st < indx && en > indx) {
            // find larger ele from left part
            while (arr[st] <= pivot)
                st++;
            // find smaller ele from right part
            while (arr[en] > pivot)
                en--;

            if (st < indx && en > indx) {// move ele at correct position
                int temp = arr[st];
                arr[st] = arr[en];
                arr[en] = temp;
                st++;
                en--;
            }
        }

        return indx;
    }

    public void solve(int arr[], int s, int e) {
        if (s >= e)
            return;
        // first call partition method
        int partition = quickSort(arr, s, e);
        solve(arr, 0, partition - 1);
        solve(arr, partition + 1, e);
    }
}

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size");
        int sz = sc.nextInt();
        int arr[] = new int[50];

        for (int i = 0; i < sz; i++) {
            System.out.println("Enter " + i + "th ele");
            arr[i] = sc.nextInt();
        }
        System.out.println("Before sorting");
        for (int i = 0; i < sz; i++) {// printin logic
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Logic obj = new Logic();
        obj.solve(arr, 0, sz - 1);
        // after sorting
        System.out.println("Ater sorting");
        for (int i = 0; i < sz; i++) {// printin logic
            System.out.print(arr[i] + " ");
        }

    }

}

/*
 *************************************** Code studio *********************************************************
 */
/*
 * import java.util.* ;
 * import java.io.*;
 * 
 * class SortingLogic{
 * 
 * public int partition(int[] arr,int s,int e){
 * int pivot=arr[s];
 * int cnt=0;
 * for(int i=s+1;i<=e;i++){
 * if(arr[i]<pivot) cnt++;
 * … }
 * 
 * 
 * public void sortQuick(int arr[],int s,int e){
 * if(s>=e) return ;
 * int p=partition(arr,s,e);
 * sortQuick(arr, s, p-1);
 * sortQuick(arr, p+1, e);
 * }
 * }
 * 
 * https://www.codingninjas.com/studio/problems/quick-sort_983625?leftPanelTab=0
 * &utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_15
 */
