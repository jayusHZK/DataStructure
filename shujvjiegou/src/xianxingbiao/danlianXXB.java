package xianxingbiao;

import java.util.Arrays;

/**
 *单链表
 * @param <E>
 */
public class danlianXXB<E> {
    private Node node;
    private int count; //数据总条数
    private int index=0; //记录当前下标
    private String[] arr=new String[0];  //转义数组

    /**
     * 内部类 节点
     */
    private class Node{
        String content; // 链表节点内容
        Node next;  //链表下一节点

        /**
         * 有参构造
         * @param data
         */
        public Node(String data){
            this.content=data;
        }

        /**
         * 判断下一节点是否为空
         * @return
         */
        public boolean nextIsNull(){
            if(next==null){
                return true;
            }
            return false;
        }

        /**
         * 往链表末端添加一个新节点
         * @param node
         */
        public void addNewNode(Node node){
            if(!nextIsNull()){//如果下一个节点不为空 则往再下一个节点添加
                this.next.addNewNode(node);//添加当前节点的下一节点的下一节点
            }else {
                this.next=node;  //添加到当前节点的下一节点
            }
        }

        /**
         * 输出
         */
        public void printNode(){
            System.out.println(this.content);
            if(!nextIsNull()){//如果下一节点不为null 则输出下一节点值
                this.next.printNode();;
            }
        }

        /**
         * 判断是否包含
         * @param data
         * @return
         */
        public boolean conrtainNode(String data){
            if(data.equals(content)){//当前节点是否是判断值
                return true;
            }
            if(!nextIsNull()){//下一节点是否为null 不为null则判断下一节点值
                this.next.conrtainNode(data);
                return true;
            }
            return false;
        }

        /**
         * 根据下标获取
         * @param index
         * @return
         */
        public String getContent(int index) {
            if(danlianXXB.this.index==index){//如果当前记录等于查找下标 则返回当前值
                return this.content;
            }else{ //否则 记录+1 判断下一节点是否等于 直到找到相同值
                danlianXXB.this.index++;
                return this.next.getContent(index);
            }
        }

        /**
         * 往指定位置添加
         * @param index
         * @param data
         */
        public void addNewNode(int index,String data){
            if(danlianXXB.this.index==index){//如果当前记录数等于插入下标
                this.content=data;
            }else{
                danlianXXB.this.index++;
                this.next.addNewNode(index,data);
            }
        }

        /**
         * 根据内容删除节点
         * @param data
         */
        public void delNode(Node upNode,Node node,String data){ //获取被删除节点的前一个和后一个 将前一个的next直接指向后一个 则当前节点删除
            Node newNode=upNode;
            if(!node.content.equals(data)){
                node.next.delNode(node,node.next,data);
            }else{
                newNode.next=node.next;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "content='" + content + '\'' +
                    ", next=" + next +
                    '}';
        }

        /**
         * 转义为数组
         */
        public void toArray(){
            danlianXXB.this.arr[danlianXXB.this.index]=(String)this.content;
            if(!nextIsNull()){
                this.next.toArray();
            }
        }
    }

    /**
     * 添加
     * @param data
     */
    public void add(String data){
        if(data==null){ //判空
            return;
        }
        Node newNode=new Node(data); //创建节点
        if(node==null){
            node=newNode;
        }else{
            this.node.addNewNode(newNode);
        }
        count++; //总数+1
    }

    /**
     * 获取总条数
     * @return
     */
    public int getCount(){
        return count;
    }

    /**
     * 输出
     */
    public void print(){
        if(this.node!=null){
            this.node.printNode();
        }
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        if(node==null&&count==0){
            return true;
        }
        return false;
    }

    /**
     * 判断是否包含
     * @param data
     * @return
     */
    public boolean contains(String data){
        if(data==null||node==null){
            return false;
        }else{
            return node.conrtainNode(data);
        }
    }

    /**
     * 根据下标获取
     * @param index
     * @return
     */
    public String getByIndex(int index){
        if(index<0||index>count){
            return null;
        }
        this.index=0;
        return node.getContent(index);
    }

    /**
     * 指定位置添加值
     * @param index
     * @param data
     */
    public void setNode(int index,String data){
        if(index>=count){
            return ;
        }else{
            this.index=0;
            node.addNewNode(index,data);
        }
    }

    /**
     * 根据内容删节点
     * @param data
     */
    public void remove(String data){
        if(contains(data)){ //判断是否包含此值
            node.delNode(node,node,data);
            count--;
        }
    }

    @Override
    public String toString() {
        return "danlianXXB{" +
                "node=" + node +
                ", count=" + count +
                ", index=" + index +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
