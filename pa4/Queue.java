
public class Queue implements QueueInterface {

   private class Node {
      Object item;
      Node next;

      Node(Object x){
         item = x;
         next = null;
      }
   }

   private Node front;  // reference to first Node in List
   private int numItems;
   
   public Queue(){
      front = null;
      numItems = 0;
   }
   
   public boolean isEmpty(){
      return (numItems == 0);
   }

   public int length(){
      return numItems;
   }
   
   public void enqueue(Object newItem){
      if(numItems == 0){
         front = new Node(newItem);
      }else{
         Node N = front;
         while(N.next != null){
            N = N.next;
         }
         N.next = new Node(newItem);
      }
      numItems++;
   }
   
   public Object dequeue() throws QueueEmptyException{
      if(numItems == 0){
         throw new QueueEmptyException("cannot dequeue() empty queue");
      }else{
         Node N = front;
         front = N.next;
         numItems--;
         return N.item;
      }
   }
   
   public Object peek() throws QueueEmptyException{
      if(numItems == 0){
         throw new QueueEmptyException("cannot dequeue() empty queue");
      }else{
         Node N = front;
         return N.item;
      }
   }
   
   public void dequeueAll() throws QueueEmptyException{
      if(numItems == 0){
         throw new QueueEmptyException("cannot dequeue() empty queue");
      }else{
         Node N = front;
         front = null;
         numItems = 0;
      }
   }
   
   public String toString(){
      Node N = front;
      String s = "";
      while ( N != null){
         s += N.item + " ";
         N = N.next;
      }
      return s;     
   }

}
