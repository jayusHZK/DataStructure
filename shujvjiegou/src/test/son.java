package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class son extends father {
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void iter(){
        Set<String> set=new HashSet<>();
        set.add("abc");
        set.add("bac");
        set.add("aaa");
        set.add("aaa");
        Set<String> set1=new TreeSet<>();
        set1.add("aa");
        Iterator<String> it=set.iterator();
        String aa="";
        while(it.hasNext()){
            aa=it.next();
            System.out.println(aa.hashCode());
            System.out.println(aa);
        }
    }

    @Override
    void aa() {

    }
}
