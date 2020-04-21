package xianxingbiao;

/**
 * 线性表
 * @param <E>
 */
public class xianxingbiao <E>{
    Object[]  data=null;//创建保存内容数组
    private int index;//当前是第几个元素
    private int size;//数组大小的指标

    /**
     * 无参构造方法
     */
    public xianxingbiao(){

        this(3); //保证数组长度
    }

    /***
     * 有参构造函数  设置数组大小
     * @param size
     */
    public xianxingbiao(int size){
        if(size<0){
            throw new RuntimeException("数组大小错误："+size);
        }else{
            this.data=new Object[size]; //初始化数组
            this.index=0;//初始化当前下标
            this.size=size;//初始化数组大小
        }
    }

    /**
     * 保证数组容量
     * @param index
     */
    public void setSize(int index){
        if(index==size){
            this.size=size+3;//扩容+3
            Object[] newdata=new Object[size];//重新设置数组长度
            for (int i=0;i<index;i++){
                newdata[i]=this.data[i];//扩容之后赋值
            }
            this.data=newdata;
        }
    }

    /**
     * 查看下标是否超出数组容量范围
     * @param index
     */
    public void indexout(int index){
        if(index<0||index>this.size){
            throw new RuntimeException("下标越界"+index);
        }
    }

    /**
     * 添加元素
     * @param e
     * @return
     */
    public boolean add(E e){
        setSize(index);//保证当前容量不会超出
        this.data[index]=e;//插入元素
        index++;//当前下标加1
        return true;
    }

    /**
     * 根据传入下标获取值
     * @param index
     * @return
     */
    public E getByIndex(int index){
        indexout(index);//检验下标是否越界
        return (E)this.data[index];
    }

    /**
     * 根据下标插入值
     * @param index
     * @param element
     * @return
     */
    public boolean addByIndex(int index,E element){
        indexout(index);//检验下标是否合法
        Object[] temp=new Object[size];//缓存数组
        for(int i=0;i<size;i++){
            if(i<index){ //插入元素  要腾出位置插入 后面的值要往后移一位
                temp[i]=data[i];
            }else if(i==index){
                temp[i]=element;
            }else if(i>index){
                temp[i]=data[i-1];
            }
        }
        this.data=temp;
        return true;
    }

    /**
     * 根据下标删除元素
     * @param index
     * @return
     */
    public boolean delByIndex(int index){
        indexout(index);
        for (int i=index;i<size;i++){
            if(i+1==size){
                this.data[i]=null;
                return false;
            }
            this.data[i]=this.data[i+1];
            this.index--;//数组值多少-1
        }
        return true;
    }

    /**
     * 输出数组长度
     * @return
     */
    public int length(){
        return this.index;
    }

    /**
     * 打印元素
     */
    public void priArr(){
        for (int i=0;i<this.index;i++){
            System.out.print(data[i]);
        }
    }
}
