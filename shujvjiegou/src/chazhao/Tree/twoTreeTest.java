package chazhao.Tree;

import java.util.Arrays;
import java.util.List;

public class twoTreeTest {
    public static void main(String[] args) {
        TwoTree<Integer,String> t=new TwoTree<Integer, String>(5,"e");
        t.put(4,"d");
        t.put(6,"f");
        t.put(3,"c");
        t.put(2,"b");
        t.put(7,"g");
        t.put(8,"h");
        t.put(1,"a");
        t.midPrint(t);
        t.delete(6);
        t.midPrint(t);
    }
}
