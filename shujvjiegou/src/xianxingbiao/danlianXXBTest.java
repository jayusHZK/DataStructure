package xianxingbiao;

public class danlianXXBTest {
    public static void main(String[] args) {
        danlianXXB<Object> list=new danlianXXB<Object>();
        System.out.println(list);
        list.add("qiu");
        list.add("min");
        list.add("lin");
        System.out.println("包含min"+list.contains("min"));//检验是否包含
        System.out.println("第二个为"+list.getByIndex(2));//根据下标获取
        System.out.println("链表长度"+list.getCount());//返回单链表长度
        list.print();//输出链表值
        System.out.println("为空"+list.isEmpty());//判断是否为空
        list.setNode(1,"gou");//指定位置添加
        list.remove("lin");
        //list=null;
        System.out.println(list);//输出链表
    }
}
