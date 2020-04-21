package Tree.erChaShu;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {
    public static void main(String[] args) {
        TreeTools tool=new TreeTools();//树的操作类
        Tree tree=new Tree("0");//创建树
        tree.addLeft("1");
        tree.addRight("2");
        tree.left.addLeft("3");
        tree.left.addRight("4");
        tree.right.addLeft("5");
        tree.right.addRight("6");
        //tree.left.right.addRight("7");
        //创建树 end
        System.out.println(tree);
        System.out.println("树的结点个数为"+tool.getTreeNum(tree));
        System.out.println("树的深度为"+tool.getTreeDepth(tree));
        System.out.println("前序遍历");
        tool.preOrderTravel(tree);
        System.out.println("\n后序遍历");
        tool.backOrderTravel(tree);
        System.out.println("\n中序遍历");
        tool.midOrderTravel(tree);
        System.out.println("\n分层输出");
        tool.levelTravel(tree);
        System.out.println("第3层节点个数:"+tool.getLevelNum(tree,3));
        System.out.println("叶子节点个数为"+tool.getChildNum(tree));
        //交换树左右子树 start
        Tree tree1=tool.exChange(tree);//交换根结点左右子树
        tool.midOrderTravel(tree1);
        //交换树左右子节点 end
        //是否是父子节点比较 start
        Tree t1=new Tree("0");
        t1.addRight("1");
        Tree t2=new Tree("1");
        Tree t3=t1.right;//
        System.out.println("是否是父子节点比较"+tool.isChild(t1,t3));
        //是否是父子节点比较 end
        //求两个树在树中的公共父节点 start
        //tool.midOrderTravel(tree);
        Tree t4=tree.left.right;
        Tree t5=tree.left.left;
        //System.out.println(tool.isFather(tree,t4,t5));
        //求两个树在树中的公共父节点 end
        //用树的前序和中序构建树start
        List<String> pre=new ArrayList<>();
        pre.add("0");pre.add("1");pre.add("3");pre.add("4");pre.add("2");pre.add("5");pre.add("6");
        List<String> mid=new ArrayList<>();
        mid.add("3");mid.add("1");mid.add("4");mid.add("0");mid.add("5");mid.add("2");mid.add("6");
        List<String> back=new ArrayList<>();
        back.add("3");back.add("4");back.add("1");back.add("5");back.add("6");back.add("2");back.add("0");
        Tree premid=tool.getTreeByPreAndMid(pre,mid);
        Tree premid1=tool.getTreeByPreAndMid(pre,mid);
        tool.preOrderTravel(premid);
        //用树的前序和中序构建树end
        //System.out.println(premid.hashCode());
        //System.out.println(premid1.hashCode());
        System.out.println(12);
        Tree midback=tool.getTreeByMidAndBack(mid,back);
        tool.midOrderTravel(midback);
        System.out.println("创建树");
        String[] array=new String[]{"a","b","c","d","e","f","g"};
        Tree createTree=tool.createTree(array,0);
        tool.midOrderTravel(createTree);
        //二叉查找树
        int[] arr={3,7,1,4,8,6};
        String[] arr1={"a","b","c","d","e","h"};
        Tree1 sortTree=new Tree1(5,"asas");
        for (int i=0;i<arr.length;i++){
            tool.insert(sortTree,arr[i],arr1[i]);
        }
        tool.sortTreeMid(sortTree);
        System.out.println(tool.selectTree(sortTree,3));
        System.out.println("--------------------");
        List<String> midd=new ArrayList<>();
        midd.add("5");midd.add("3");midd.add("7");midd.add("4");midd.add("8");midd.add("6");midd.add("2");
        List<String> backk=new ArrayList<>();
        backk.add("3");backk.add("5");backk.add("4");backk.add("7");backk.add("2");backk.add("6");backk.add("8");
        Tree kaoshi=tool.getTreeByMidAndBack(midd,backk);
        tool.preOrderTravel(kaoshi);
    }

}
