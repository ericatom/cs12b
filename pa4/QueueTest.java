public class QueueTest{
  public static void main (String[] args){
    Queue A = new Queue();

    System.out.println(A.isEmpty()); //true
    A.enqueue((int)1); 
    A.enqueue((int)2);
    A.enqueue((int)3);
    A.enqueue((int)4);
    A.enqueue((int)5);
    System.out.println(A.isEmpty()); //false
    System.out.println(A.length()); //4
    System.out.println(A); // 1 2 3 4 5
    A.dequeue();
    System.out.println(A); // 2 3 4 5
    System.out.println(A.length()); //4
    System.out.println(A.peek()); //2
    A.dequeueAll();
    System.out.println(A.isEmpty()); //true
    System.out.println(A.length()); //0
    A.dequeue(); //throws exception
  }
}
