package zhanAndDuilie.zhan;

public class zhanTest {
    public static void main(String[] args) {
        zhan z=new zhan();
        z.push("qiu");//添加
        z.push("min");
        z.printArr();//输出
        System.out.println(z.length());//输出长度
        System.out.println(z.getUp());//输出栈顶元素
        z.pop();//删除栈顶元素
        z.printArr();
        System.out.println(z.length());
        System.out.println(z.isEmpty());//是否为空
        System.out.println(z.indexOut());//是否已满
    }
}
