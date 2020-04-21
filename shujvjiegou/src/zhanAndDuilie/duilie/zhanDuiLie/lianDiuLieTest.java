package zhanAndDuilie.duilie.zhanDuiLie;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lianDiuLieTest {
    public static void main(String[] args) {
        zhanDuiLie zdl=new zhanDuiLie();
        zdl.push("qiu");
        zdl.push("min");
        zdl.push("lin");
        System.out.println(zdl.getLast());
        System.out.println(zdl.pop());
        System.out.println(zdl.getLast());
        System.out.println(zdl);
        System.out.println(zdl.print());
    }
}
