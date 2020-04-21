package zhanAndDuilie.zhan.lianzhan;

public class lianzhanTest {
    public static void main(String[] args) {
        lianzhan lz=new lianzhan();
        lz.push("qiu");
        lz.push("min");
        System.out.println(lz.peek());
        System.out.println(lz.pop());
        System.out.println(lz);
    }
}
