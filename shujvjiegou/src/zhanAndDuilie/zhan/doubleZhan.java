package zhanAndDuilie.zhan;

/**
 * 两栈共享空间
 */
public class doubleZhan {
    private String[] arr;
    private int size=10;
    private int top;
    private int botton;
    public doubleZhan(){
        arr=new String[size];
        top=-1;  //初始化栈顶
        botton=size; //初始化栈底
    }

    /**
     * 判断栈1是否为空
     * @return
     */
    public boolean oneIsEmpty(){
        return top==-1;
    }

    /**
     * 判断栈2是否为空
     * @return
     */
    public boolean twoIsEmpty(){
        return botton==size;
    }

    /**
     * 判断栈1是否还有空间
     * @return
     */
    public boolean oneIndexOut(){
        return top==size;
    }

    /**
     * 判断栈2是否还有空间
     * @return
     */
    public boolean twoIndexOut(){
        return botton==-1;
    }

    /**
     * 栈1添加数据
     * @param data
     */
    public void onePush(String data){
        if(oneIndexOut()){
            System.out.println("栈1已满");
            return;
        }
        arr[++top]=data;
    }

    /**
     * 栈2添加数据
     * @param data
     */
    public void twoPush(String data){
        if(twoIndexOut()){
            System.out.println("栈2已满");
            return;
        }

        arr[--botton]=data;
    }

    /**
     * 获取栈1栈顶
     * @return
     */
    public String getOneUp(){
        if(oneIsEmpty()){
            System.out.println("栈1为空");
            return null;
        }
        return arr[top];
    }

    /**
     * 获取栈2栈顶
     * @return
     */
    public String getTwoUp(){
        if(twoIsEmpty()){
            System.out.println("栈2为空");
            return null;
        }
        return arr[botton];
    }

    /**
     * 删除并返回栈1栈顶元素
     * @return
     */
    public String onePop(){
        if(oneIsEmpty()){
            System.out.println("栈1为空");
            return null;
        }
        return arr[top--];
    }

    /**
     * 删除并返回栈2栈顶元素
     * @return
     */
    public String twoPop(){
        if(twoIsEmpty()){
            System.out.println("栈2为空");
            return null;
        }
        return arr[botton++];
    }
    public void onePrint(){
        for (int i=top;i>=0;i--){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
    public void twoPrint(){
        for (int i=botton;i<size;i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
}
