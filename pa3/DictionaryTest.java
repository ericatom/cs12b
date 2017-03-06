//DictionaryTest.java
////Erica Tom
////edtom
////pa3
////April 25 201
//Tests for functions of Dictionary.java

public class DictionaryTest{

   public static void main(String[] args){
      String v;
      Dictionary A = new Dictionary();
      //System.out.println(A.isEmpty()); 
      //System.out.println(A.size());  

      //A.insert("1","a"); 
      //System.out.println(A.size()); 
      //System.out.println(A.isEmpty()); 

      A.insert("25","hello world");
      A.insert("3","b");
      A.insert("5", "e");
                  A.insert("6", "f");
      System.out.println(A.toString());

      //System.out.println(A.size()); 
      //A.delete("3");
      //System.out.println("key=1 "+(v==null?"not found":("value="+v))); 

      //try {
      //   A.insert("6", "dup");
      //} catch(DuplicateKeyException e) {
      //System.out.println("Caught Exception " + e);

      //A.insert("3","new insert");  
      //System.out.println(A);

      //A.makeEmpty();
    
      System.out.println(A.size());
      try {
         A.delete("4");
      } catch(KeyNotFoundException e) {
            System.out.println("Caught Exception " + e);
      }


   }
}

/*output:
 * true
 * 0
 * 1
 * false
 * 1 a
 * 25 hello world
 * 3 b
 * 5 e
 * 6 f
 *
 * 5
 * key=1 value=a
 * Caught Exception DuplicateKeyException: cannot insert duplicate keys
 * 1 a
 * 25 hello world
 * 5 e
 * 6 f
 * 3 new insert
 *
 * 0
 * Caught Exception KeyNotFoundException: cannot delete non-existent key
*/
