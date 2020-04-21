package xianxingbiao;

import java.util.ArrayList;
import java.util.List;

public class xxbTest {
    public static void main(String[] args) {
        xianxingbiao<String> arr=new xianxingbiao<String>();
        arr.add("qiu");
        arr.add("min");
        arr.add("lin");
        System.out.println(arr.length());
        arr.priArr();
        System.out.println();
        arr.delByIndex(1);
        System.out.println(arr.getByIndex(1));
        arr.addByIndex(2,"gou");
        System.out.println();
        arr.priArr();
        List<String> list=new ArrayList<String>();
        list.remove(1);
    }
}
