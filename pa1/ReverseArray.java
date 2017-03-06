//ReverseArray.java
//Erica Tom
//edtom
//pa1
//April 7 2016
//Reverse Arrays and finding the min and max of an array

public class ReverseArray{

 public static void main(String[] args){

    int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
    int[] B = new int[A.length];
    int[] C = new int[A.length];
    int minIndex = minArrayIndex(A, 0, A.length-1);
    int maxIndex = maxArrayIndex(A, 0, A.length-1);

    for(int x: A) System.out.print(x+" ");
    System.out.println();

    System.out.println( "minIndex = " + minIndex );
    System.out.println( "maxIndex = " + maxIndex );

    reverseArray1(A, A.length, B);
    for(int x: B) System.out.print(x+" ");
    System.out.println();

    reverseArray2(A, A.length, C);
    for(int x: C) System.out.print(x+" ");
    System.out.println();

    reverseArray3(A, 0, A.length-1);
    for(int x: A) System.out.print(x+" ");
    System.out.println();

}
 static void reverseArray1(int[] X, int n, int[] Y){
    if(n>0){
       Y[n-1] = X[X.length-n];
       reverseArray1(X,n-1,Y);
    }
 }

 static void reverseArray2(int[] X, int n, int[] Y){
    if(n>0){
       Y[X.length-n] = X[n-1];
       reverseArray2(X,n-1,Y);
    }
 }

 static void reverseArray3(int[] X, int i, int j){
    int temp=0;
    if(i<=j){
       temp = X[i];
       X[i] = X[j];
       X[j] = temp;
       i++; j--;
       reverseArray3(X,i,j);
    }
 }

 static int maxArrayIndex(int[] X, int p, int r){
    int q=0,a=0,b=0;
    if(p < r) {
       q = (p+r)/2;
       a = maxArrayIndex(X,p,q);
       b = maxArrayIndex(X,q+1,r);
       if (X[a] > X[b]){
          q = a;
       } else if (X[a] < X[b]){
          q=b;
          }
    }
    return q;
 }
 
 static int minArrayIndex(int[] X, int p, int r){
 int q=0,a=0,b=0;
    if(p < r) {
       q = (p+r)/2;
       a = minArrayIndex(X,p,q);
       b = minArrayIndex(X,q+1,r);
       if (X[a] < X[b]){
          q = a;
       } else if (X[a] > X[b]){
          q=b;
       }
    }
    return q;
    }
}
