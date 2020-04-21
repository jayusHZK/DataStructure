package zhanAndDuilie.zhan.lianzhan;

/**
 * 链式存储结构的栈
 */
public class lianzhan {
    Node node; //头结点
    int length; //长度

    /**
     * 内部类 节点
     */
    private class Node{
        String content;
        Node next;
        public Node(){}
        public Node(String data){
            content=data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "content='" + content + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
    /**
     * 添加元素
     * @param data
     */
    public void push(String data){
        Node newnode=new Node();
        newnode.next=node;
        newnode.content=data;
        length++;
        node=newnode;
    }

    /**
     * 删除元素
     * @return
     */
    public String pop(){
        if(node==null){
            System.out.println("当前链栈为空");
            return null;
        }
        String value=node.content;
        node=node.next;
        length--;
        return value;
    }

    /**
     * 返回第一个节点的内容
     * @return
     */
    public String peek(){
        if(node==null){
            System.out.println("当前链栈为空");
            return null;
        }
        return node.content;
    }

    /**
     * 返回链栈长度
     * @return
     */
    public int size(){
        return length;
    }

    @Override
    public String toString() {
        return "lianzhan{" +
                "node=" + node +
                ", length=" + length +
                '}';
    }
}
