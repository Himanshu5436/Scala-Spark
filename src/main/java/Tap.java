/**
 * Created by Himanshu on 26-05-2019.
 */
public class Tap {

    public static void main(String[] args)
    {
        // Create a queue of capacity 4
        Queue q = new Queue(4);

        // print Queue elements
        q.queueDisplay();

        // inserting elements in the queue
        q.queueEnqueue(1);
        q.queueEnqueue(2);
        q.queueDequeue();

        // print Queue elements
        q.queueDisplay();

        // insert element in the queue
        q.queueEnqueue(60);

        // print Queue elements
        q.queueDisplay();

        q.queueDequeue();
        q.queueDequeue();
        System.out.printf("\n\nafter two node deletion\n\n");

        q.queueEnqueue(4009);
        // print Queue elements
        q.queueDisplay();

        // print front of the queue
        q.queueFront();
    }
}