package chazhao;

import java.util.Arrays;

public class chazhao {
    /**
     * 二分查找
     * @param arr
     * @param num
     * @return
     */
    public int erFenSearch(int[] arr,int num){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(int)(left+right)/2;
            //left+((num-arr[left])/(arr[right]-arr[left]))*(right-left);插值排序计算方法
            if(arr[mid]==num){
                return mid+1;
            }else if(arr[mid]>num){
                right=mid-1;
            }else if(arr[mid]<num){
                left=mid+1;
            }else{
                return 0;
            }
        }
        return 0;
    }

    /**
     * 递归实现斐波那契数列    当前项=前一项+前前一项
     * @param n
     * @return
     */
    public int qibonalie(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return qibonalie(n-1)+qibonalie(n-2);
    }

    /**
     * 遍历实现斐波那契数列
     * @param n
     * @return
     */
    public int qibonalie1(int n){
        int value1=0;
        int value2=1;
        int value3=0;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        for(int i=2;i<=n;i++){
            value3=value1+value2;
            value1=value2;
            value2=value3;
        }
        return value3;
    }

    /**
     * 删除斐波那契数列
     * @return
     */
    public int[] feibonaqiArr(){
        int[] arr=new int[20];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr;
    }

    public void println(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }

    /**
     * 斐波那契查找
     * @param arr
     * @param n
     * @return
     */
    public int feibonaqiSearch(int[] arr,int n){
        int low=0;
        int high=arr.length-1;
        int k=0;//斐波那契分割数值下标
        int mid=0;//存放mid值
        int[] f=feibonaqiArr();//获取斐波那契数列
        while(high>f[k]-1){//获取数组长度在斐波那契数列的下标  f[k]永远大于数组长度
            k++;
        }
        int[] temp= Arrays.copyOf(arr,f[k]);//创建一个长度为f[k]的数组，用arr填充  不足部分填0
        for(int i=high+1;i<temp.length;i++){//将temp数组0的部分填充数组arr最后一项
            temp[i]=arr[high];
        }
        while(low<=high){
            mid=low+f[k-1]-1;//获取数组黄金分割数下标
            if(n<temp[mid]){//当前值小于查找值
                high=mid-1; //
                k--;
            }else if(n>temp[mid]){
                low=mid+1;
                k-=2;
            }else{
                if(mid<=high){
                    return mid;
                }else{//如果mid值大于high  则是数组扩列的位置了  就是数组即最后一个数就是要查的树
                    return high;
                }
            }
        }
        return 0;
    }
}
