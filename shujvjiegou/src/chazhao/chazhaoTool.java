package chazhao;

public class chazhaoTool {
    public static void main(String[] args) {
        chazhao cz=new chazhao();
        int[] arr={1,3,5,7,8,9};
        System.out.println(cz.erFenSearch(arr,2));//二分查找
        System.out.println(cz.qibonalie(8));//斐波那契数列
        System.out.println(cz.qibonalie1(8));//斐波那契
        //cz.println(cz.feibonaqiArr());
        System.out.println(cz.feibonaqiSearch(arr,8));


    }

}
