/**
 * Created by Himanshu on 15-05-2019.
 */
public class App {

    public static void main(String[] args) {
      /*  CircularLinkedList mylist = new CircularLinkedList();
       // mylist.insertFirst(100);
        mylist.insertFirst(50);
        mylist.insertFirst(99);
        mylist.insertFirst(88);
        mylist.insertLast(9999999);

        mylist.displayList();
      */
      linklist l = new linklist();
      l.insertAtLast(1);
      l.insertFirst(2);
        l.insertFirst(3);
        l.insertFirst(4);
        l.insertFirst(5);
        l.insertPos(4,6);
      l.viewList();
      //l.deletelast();
      //l.viewList();
    }

}
