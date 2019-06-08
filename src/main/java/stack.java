/**
 * Created by Himanshu on 19-05-2019.
 */
public class stack {
    int size = 5;
    int arr[] = new int[size];
    int head = -1;
    int length = 0;

    void push(int data){

        if(length == size) {
            System.out.println("stack is full");
        }
        else{
            head++;
            arr[head] = data;
            length++;
        }
    }

    void pop(){
     if(head == -1){
         System.out.println("nothing to pop there");//1,2,3,4,5
     }
     else{
         length--;
         head--;
     }
    }

    void viewStack(){

        for(int i = 0;i<length;i++)
        {
            System.out.println(arr[i]);
        }
    }
public static void main(String s[]){
    stack stck = new stack();
    stck.push(1);
    stck.push(2);
    stck.push(3);
    stck.push(4);
    stck.push(5);
    stck.push(6);
   // stck.viewStack();
  //  stck.pop();
   // stck.viewStack();
//2,1,4,5,6,

int ch[] = new int[]{2,1,7,8,3};
for(int i = 0 ; i < ch.length ; i++){
    int min = i ;
    for(int j = i +1 ; j < ch.length ; j++){
        if(ch[j] < ch[min]){
            min = j;
        }

    }
    int temp = ch[i];
    ch[i] =  ch[min];
    ch[min] =temp;
}
for(int i = 0 ; i < ch.length ; i++){
    System.out.println(ch[i]);
}
    System.out.println("lo ji agayi");
// insertion sort 2,1,3,4,2,4,5
int[] ch1 = {3,2,5,8,7};
for(int i = 1; i < ch1.length;i++)
{
    int element = ch1[i];
    int j = i-1;
    while(j >= 0 && ch1[j] > element ){
        ch1[j+1] = ch1[j];
        j--;
    }
ch1[j+1] = element;
}
    for(int i = 0 ; i < ch1.length ; i++){
        System.out.println(ch1[i]);
    }



}
}
