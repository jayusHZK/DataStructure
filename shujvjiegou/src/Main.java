import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeSet;

import test.son;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String a="123";
        String b="123";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());//hashcode值一样
        final String c="123";
        final StringBuffer d=new StringBuffer("456");
        d.append("1");
        System.out.println(d.toString());
        System.out.println(a instanceof String);
        final int aa=3;
        Set<String> set=new HashSet<>();
        Hashtable<String,String>[] maps;

        set.add("c");
        set.add("b");
        for(String item:set){
            System.out.println(item);
        }
        son s=new son();
        s.setName("aa");
        System.out.println(s.getName());
        s.iter();

        int aaaa=1;
        int aaaaa=aaaa++;
        System.out.println(aaaaa);
        System.out.println(aaaa);
    }
}
