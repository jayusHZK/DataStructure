package zhanAndDuilie.duilie.zhanDuiLie;

public class zhanDuiLie {
    private Node top;//队头
    private Node botton;//队尾
    private Node head;//头结点
    private int length=0;//长度

    @Override
    public String toString() {
        return "zhanDuiLie{" +
                "top=" + top +
                ", botton=" + botton +
                ", head=" + head +
                ", length=" + length +
                '}';
    }

    public boolean isEmpty(){
        return botton==null;
    }

    /**
     * 添加元素
     * @param data
     */
    public void push(String data){
        Node newNode=new Node(data);
        if(isEmpty()){//第一次插入元素
            botton=newNode;
            head=botton;
            top=botton;
        }else{
            botton.next=newNode;//将值赋给队尾       将值插入到队列尾部 并将队尾指向新值  先向队列尾赋值  再将队尾指向对列尾
            botton=newNode;//将新指赋给队尾的值  队尾指向新值，则插入过程
            length++;
        }
    }

    /**
     * 从队头删除一个节点  就是将头结点的下一个赋给头结点，并回去头结点的值
     * @return
     */
    public String pop(){
        if(isEmpty()){//队尾==头结点
            System.out.println("队列为空");
            return null;
        }
        String value=top.content;
        head=top.next;
        top=top.next;
        length--;
        return value;
    }
    public String getLast(){
        if(isEmpty()){
            return null;
        }
        return botton.content;
    }
    public String print(){
        StringBuilder sBuilder=new StringBuilder("[");
        for(Node node=top;node!=null;node=node.next){
            sBuilder.append(node.content+",");
        }
        int size=sBuilder.length();
        return sBuilder.delete(size-1,size).append("]").toString();
    }
    /**
     * 节点类
     */
    private class Node{
        String content;
        Node next;
        private Node(){}
        private Node(String data){
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
}
