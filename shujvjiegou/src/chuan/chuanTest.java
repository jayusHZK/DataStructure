package chuan;

public class chuanTest {
    public static void main(String[] args) {
        String str="abCdabCd";
        String str1="abcdabCd";
        System.out.println(str.toLowerCase());//转小写
        System.out.println(str.toUpperCase());//转大写
        System.out.println(str.length());//获得长度
        System.out.println(str.charAt(1));//获得第i个字符
        System.out.println(str.compareTo(str1));//不忽略大小写比较大小 < 负整数,=0,>正整数
        System.out.println(str.compareToIgnoreCase(str1));//忽略大小写比较大小 < 负整数,=0,>正整数
        System.out.println(str.equals(str1));//不忽略大小写比较字符串是否相等
        System.out.println(str.equalsIgnoreCase(str1));//忽略大小写比较字符串是否相等
        System.out.println(str.indexOf("C"));//返回字符串出现的位置
        System.out.println(str.indexOf("C",2));//返回字符串出现的位置
        System.out.println(str.lastIndexOf("C"));//返回字符串最后出现的位置
        System.out.println(str.lastIndexOf("C",3));//返回字符串最后出现的位置
        System.out.println(str.substring(1,3));//截取字符串  第二个参数不填表示到最后
        String[] cs = str.split("C");//分割字符串
        for (int i=0;i<cs.length;i++){
            System.out.println(cs[i]);
        }
        System.out.println(str.replace('C','c'));
        System.out.println(str.replaceAll("a","A"));;

    }

}
