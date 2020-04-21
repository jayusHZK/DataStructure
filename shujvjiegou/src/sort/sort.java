package sort;

public class sort {
    public static void shellSort(int[] arr){
        for (int gap=arr.length/2;gap>0;gap/=2){ //缩小步数
            for (int i=gap;i<arr.length;i++){
                int temp=arr[i],j;
                for (j=i;j>=gap&&temp<arr[j-gap];j-=gap){
                    arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }
    public static void arrPrint(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }

}
