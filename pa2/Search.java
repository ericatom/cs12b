//Search.java
//Erica Tom
//edtom
//pa2
//April 17 2016
//Implementing MergeSort and BinarySearch to search for target words in a file

import java.io.*;
import java.util.Scanner;

class Search {
   public static void main(String[] args) throws IOException{
      int n = 0;
      String line = null;

      if(args.length < 2) {
         System.err.println("Usage: Search file target1 [target2 target3 ..]");
         System.exit(1);
       }

       Scanner in = new Scanner(new File(args[0]));
       while(in.hasNextLine()) {
          line = in.nextLine();
             n++;
        }

        String[] A = new String[n];
        int[] lineNum = new int[n];
        in = new Scanner(new File(args[0]));

        for(int i=1; i<=lineNum.length; i++) lineNum[i-1] = i;

        for(int i = 0; in.hasNextLine(); i++) {
           line = in.nextLine();
           A[i] = line;
        }

        mergeSort(A, lineNum, 0, A.length-1);
        for(int i=1; i<args.length; i++)
           System.out.println(binarySearch(A, lineNum, 0, A.length-1, args[i]));
        in.close();
   }
   
   static void mergeSort(String[] word,int[] lineNum, int p, int r){
      int q;
      if(p < r) {
         q = (p+r)/2;
         mergeSort(word,lineNum, p, q);
         mergeSort(word,lineNum, q+1, r);
         merge(word,lineNum, p, q, r);
      }
   }
   
   static void merge(String[] word, int[] lineNum, int p, int q, int r){
      int n1 = q-p+1;
      int n2 = r-q;
      String[] left = new String[n1];
      String[] right = new String[n2];
      int[] L = new int[n1];
      int[] R = new int[n2];
      int i, j, k;

      for(i=0; i<n1; i++) {
         left[i] = word[p+i];
         L[i] = lineNum[p+i];
      }

      for(j=0; j<n2; j++) {
         right[j] = word[q+j+1];
         R[j] = lineNum[q+j+1];
      }

      i = 0; j = 0;

      for(k=p; k<=r; k++){
         if( i<n1 && j<n2 ){
            if( left[i].compareTo(right[j])>0 ){
               word[k] = left[i];
               lineNum[k] = L[i];
               i++;
            }else{
               word[k] = right[j];
               lineNum[k] = R[j];
               j++;
            }
         }else if( i<n1 ){
            word[k] = left[i];
            lineNum[k] = L[i];
            i++;
         }else{
            word[k] = right[j];
            lineNum[k] = R[j];
            j++;
         }
      }
   }
   
   public  static String binarySearch(String[] word, int[] lineNum, int p, int r, String target){
      int q;
      if(p == r) {
         return target + " not found";
      }else{
         q = (p+r)/2;
         if(word[q].compareTo(target)==0){
            return target + " found on line " + lineNum[q];
         }else if(word[q].compareTo(target)<0){
            return binarySearch(word,lineNum, p, q, target);
         }else
            return binarySearch(word,lineNum, q+1, r, target);

      }
   }
}
   
   
