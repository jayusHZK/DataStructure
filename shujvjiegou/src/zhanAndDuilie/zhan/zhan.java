package zhanAndDuilie.zhan;

/**
 * 栈 先进后出
 */
public class zhan {
    private String[] arr;
    private int size=5;
    private int top;

    /**
     * 初始化栈
     */
    public zhan(){
        arr=new String[size];
        top=-1;
    }

    /**
     * 判断是否还有空间
     * @return
     */
    public boolean indexOut(){
        return top==size-1;
    }

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }
    /**
     * 添加
     * @param data
     */
    public void push(String data){
        if(indexOut()){
            System.out.println("栈已满");
            return ;
        }
        arr[++top]=data;
    }

    /**
     * 删除
     * @return
     */
    public String pop(){
        if(isEmpty()){
            System.out.println("栈里面没数据");
            return null;
        }
        return arr[top--];
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public String getUp(){
        if(isEmpty()){
            System.out.println("栈里面没数据");
            return null;
        }
        return arr[top];
    }

    /**
     * 返回栈长度
     * @return
     */
    public int length(){
        return top+1;
    }

    /**
     * 输出栈内元素
     */
    public void printArr(){
        for (int i=top;i>=0;i--){
            System.out.print(arr[i]+"");
        }
        System.out.println("");
    }
}
