package test;

public class C extends A implements B {
    public static void main(String[] args) {
        System.out.println(B.x);
        System.out.println(new A().x);
        System.out.println(computeAge(8));
        D d=new D();
        d.name="aa";
        System.out.println(d.toString());
        //System.out.println(d.getClass()+"\t"+d.getClass().getName());
        Class d1=d.getClass();
        System.out.println(d1.getCanonicalName());
    }

    public static int computeAge(int n){
        if(n==1) return 10;

        return computeAge(n-1)+2;
    }
}
