//Dictionary.java
//Erica Tom
//edtom
//pa3
//April 25 2016
//Dictionary for keeping track and finding nodes based on keys and returning both key and value

public class Dictionary implements DictionaryInterface{

   private class Node { //Node will have two string fields
      String key;
      String value;
      Node next;

      Node(String k, String v){
         key = k;
         value = v;
         next = null;
      }
   }
   private Node head;
   private int numItems;

   public Dictionary(){
      head = null;
      numItems = 0;
   }

   private Node findKey(String key){ //return the Node that matches with key if it exists
      Node N = head;
      while(N != null){
         if(N.key != key){
         N = N.next;
         } else return N;
      }
      return null;
   }

   public boolean isEmpty(){  //returns a boolean true if Dictionary is empty
      return(numItems==0);
   }

   public int size(){  //returns number of pairs in Dictionary
      return(numItems);
   }
   
   public String lookup(String key){  //returns value of a specified key
      Node N = findKey(key);
      while(N != null){
         if(N.key.equals(key)){
            return N.value;
         }
         N = N.next;
      }
      return null;
      }

   public void insert(String key, String value) throws DuplicateKeyException{
   //inserts a pair into the dictionary but throws an excpetion if there is already an existing key
         if(lookup(key)!=null){
         throw new DuplicateKeyException ("cannot insert duplicate keys");
         }else{
            if(head == null){
               Node N = new Node(key,value);
               head = N;
            }else{
               Node N = head;
               while( N != null){
                  if(N.next == null) break;
                  N = N.next;
               }
               N.next = new Node(key,value);
               }
            numItems++;
         }
   }

   public void delete(String key) throws KeyNotFoundException{
   //deletes a pair in the dictionary but throws an exception if key does not exist
      if(lookup(key) == null){
         throw new KeyNotFoundException ("cannot delete non-existent key");
      }else{
         if(numItems <= 1){
            Node N = head;
            head = head.next;
            N.next = null;
         }else{
            Node N = head;
            if(N.key.equals(key)){
               head = N.next;
            }else{
               while(!N.next.key.equals(key)){
                  N= N.next;
               }
               N.next = N.next.next;
            }
         }
         numItems--;
      }
   }

   public void makeEmpty(){  //resets the dictionary to the empty state
      numItems =0;
      head = null;
   }

   public String toString(){  //returns String representation of Dictionary
      Node N = head;
      String stringList = "";
      while(N != null){
         stringList += N.key + " " + N.value + "\n";
         N = N.next;
       }
       return stringList;
    }
}
