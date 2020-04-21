package zhanAndDuilie.duilie;

import java.util.Arrays;

/**
 * 队列  先进先出
 */
public class duilie {
    private String[] arr; //数据存放数组
    private int top;//队列头部
    private int botton;//队列尾部
    private int size=10;//队列长度
    private int index;//当前队列元素数据
    private int maxIndex;//最大下标

    /**
     * 有参构造函数
     * @param size
     */
    public duilie(int size){
        if(size<=0){
            throw  new OutOfMemoryError("不合法");
        }
        arr=new String[size];
        this.size=size;
        index=0;
        top=botton=-1;
        maxIndex=size-1;
    }

    /**
     * 无参构造函数
     */
    public duilie(){
        arr=new String[size];
        index=0;
        top=botton=-1;
        maxIndex=15;
    }

    /**
     * 判断队列是否越界
     * @return
     */
    public boolean indexOut(){
        return index==maxIndex;
    }
    public boolean isEmpty(){
        return index==0;
    }

    /**
     * 往队尾添加数据
     * @param data
     */
    public void add(String data){
        if(indexOut()){
            System.out.println("越界");
            return;
        }
        index++;
        arr[++botton]=data;
    }

    /**
     * 从队列头部拉出数据
     * @return 返回队列第一个数据
     */
    public String pop(){
        if(isEmpty()){
            System.out.println("队列为空");
            return null;
        }
        index--;
        String data=arr[++top];
        arr[top]=null;//删除队列第一个数据
        return data;
    }

    /**
     * 查看第一个数据  就是队头数据
     * @return
     */
    public String peek(){
        if(isEmpty()){
            System.out.println("队列为空");
            return  null;
        }
        return arr[top+1];
    }

    /**
     * 查看队列元素个数
     * @return
     */
    public int length(){
        return index;
    }

    /**
     * 清空队列
     */
    public void clear(){
        for (int i=0;i<size;i++){
            arr[i]=null;
        }
        top=botton=-1;
        index=0;
    }

    @Override
    public String toString() {
        return "duilie{" +
                "arr=" + Arrays.toString(arr) +
                ", top=" + top +
                ", botton=" + botton +
                ", size=" + size +
                ", index=" + index +
                ", maxIndex=" + maxIndex +
                '}';
    }
}
