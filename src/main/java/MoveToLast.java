/**
 * Created by Himanshu on 27-05-2019.
 */
public class MoveToLast {

    public static void main(String s[]){
        int arr[] = {1,2,3,4,5};
        int arr1[] =new int[2];

        //for(int i=0;i<arr1.length;i++)


        for(int i = 0 ;i<arr.length;i++){
            if(i<2){
                arr1[i] = arr[i];
            }
            else{
                arr[i-2] = arr[i];
            }

        }//{1,2} {3,4,5,nul,null}

for(int i = 0 ;i<arr1.length; i++)
        arr[arr.length-2 +i]=arr1[i];

        for (int i = 0 ;i<arr.length;i++)
            System.out.println(arr[i]);
    }
}
