/**
 * Created by Himanshu on 11-05-2019.
 *//*

public class linklist {
    Node first;

    void addele(int a){
        Node n = new Node();
        n.data = a;
        n.next = first;
        first = n;

    }
    void viewlist()
    {
        Node a = first;
     while(a != null)
     {
         System.out.println(a.data);
         a = a.next;
     }
    }

    public static void main(String k[]){
        linklist l = new linklist();
        l.addele(1);
        l.addele(4);
        l.viewlist();
    }
}
*/
public class linklist {
Node head;
int length;

public boolean isEmpty(){
if(head == null)
    return true;
else
    return false;
}

void insertFirst(int i){
    Node newNode = new Node();
    newNode.data = i;
    newNode.next = head;
    head = newNode;
    length++;
}

void insertPos(int sec,int data){
    if(sec == 1)
    {
        insertFirst(data);
        //System.out.println("list is empty canntot insert at this location");
    }
    else if(sec == length+1)
        insertAtLast(data);
    else if(sec > 1 || sec<=length){
        Node newNode = new Node();
        Node t = head;//5
        for(int i = 1 ; i < sec-1 ; i ++){
            t = t.next; //4.3.2.1
        }
        newNode.data = data;
        newNode.next = t.next;
        t.next= newNode;
    }
    length++;
}

void insertAtLast(int da){
    if(isEmpty()){
        Node last =  new Node();
        last.data = da;
        last.next = head;
        head = last;
        length++;
    }
    else {
        Node newNode = new Node();
        newNode.data = da;
        Node t = head;
        while(t.next != null){
            t = t.next;
        }
        t.next =newNode;
        length ++;
    }
}
void deletelast(){
    if (isEmpty()){
        System.out.println("canot delete as the list ");
    }
    else{
        head = head.next;
        length-- ;

    }
}

    void viewList()
    {
        Node f = head;
        while(f != null)
        {
            System.out.println(f.data);
            f = f.next;

        }
    }
}