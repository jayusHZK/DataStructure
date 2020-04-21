package zhanAndDuilie.zhan;

public class doubleZhanTest {
    public static void main(String[] args) {
        doubleZhan dz=new doubleZhan();
        dz.onePush("qiu");;
        dz.onePush("min");
        System.out.println(dz.getOneUp());
        dz.onePop();
        dz.onePrint();
        System.out.println("--------------");
        dz.twoPush("lin");
        dz.twoPush("gou");
        System.out.println(dz.getTwoUp());
        dz.twoPop();
        dz.twoPrint();
    }
}
