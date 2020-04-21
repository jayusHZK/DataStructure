package Tree.erChaShu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的操作类
 */
public class TreeTools {
    /**
     * 获取树的结点个数
     * @param tree
     * @return
     */
    public int getTreeNum(Tree tree) {
        if (tree == null) {
            return 0;
        }
        return getTreeNum(tree.left)+getTreeNum(tree.right)+1;
    }

    /**
     * 使用数组创建树  index传入0就好
     * @param array
     * @param index
     * @return
     */
    public Tree createTree(String[] array,int index){
        Tree tree=null;
        if(index<array.length){
            tree=new Tree(array[index]);
            tree.left=createTree(array,index*2+1);
            tree.right=createTree(array,index*2+2);
        }
        return tree;
    }
    /**
     * 获取树的深度   遍历每一个节点的子节点  直到没有子节点
     * @param tree
     * @return
     */
    public int getTreeDepth(Tree tree){
        if(tree==null){
            return 0;
        }
        int leftDreth=getTreeDepth(tree.left)+1;
        int rightDreth=getTreeDepth(tree.right)+1;
        //System.out.println(leftDreth+""+rightDreth);
        return Math.max(leftDreth,rightDreth);
    }

    /**
     * 输出当前节点值
     * @param tree
     */
    public void visitNode(Tree tree){
        System.out.print(tree.content+"\t");
    }

    /**
     * 前序遍历   按关系等级先输出左边的结点  后输出右边的结点  根--左子节点--右子节点
     * 第一个数根结点
     * @param tree
     */
    public void preOrderTravel(Tree tree){
        if(tree==null){
            return ;
        }
        visitNode(tree);
        preOrderTravel(tree.left);
        preOrderTravel(tree.right);
    }

    /**
     * 后序遍历  按关系等级先输出左边的结点 后输出右边的结点  左子节点--右子节点--根
     * 最后一个是根结点
     * @param tree
     */
    public void backOrderTravel(Tree tree){
        if(tree==null){
            return ;
        }
        backOrderTravel(tree.left);
        backOrderTravel(tree.right);
        visitNode(tree);
    }

    /**
     * 中序遍历  从左到右的顺序遍历 先输出左子树   后输出右子树   左子节点--根--右子节点
     * 左子树后面是根结点
     * @param tree
     */
    public void midOrderTravel(Tree tree){
        if(tree==null){
            return ;
        }
        midOrderTravel(tree.left);
        visitNode(tree);
        midOrderTravel(tree.right);
    }

    /**
     * 分层输出  用队列来
     * @param tree
     */
    public void levelTravel(Tree tree){
        Queue<Tree> q=new LinkedList<Tree>();//创建一个队列
        q.offer(tree);//往队列里面添加一个元素 一般用add  offer添加如果队列已满不报异常 返回false
        while (!q.isEmpty()){ //如果队列不为空
            Tree temp=q.poll();//从队列删除并返回第一个元素 一般用remove offer如果队列为空不报异常
            visitNode(temp);
            if(temp.left!=null){//如果子节点不为空  则往队列里面添加元素
                q.offer(temp.left);
            }
            if(temp.right!=null){
                q.offer(temp.right);
            }
        }
    }

    /**
     * 获取k层节点个数
     * @param tree
     * @param level
     * @return
     */
    public int getLevelNum(Tree tree,int level){
        if(tree==null || level<1){
            return 0;
        }
        if(level==1){
            return 1;
        }
        int leftNum=getLevelNum(tree.left,level-1);
        int rightNum=getLevelNum(tree.right,level-1);
        return leftNum+rightNum;
    }

    /**
     * 返回树中叶子节点个数  就是没有子节点的结点个数
     * @param tree
     * @return
     */
    public int getChildNum(Tree tree){
        //System.out.println(tree.content);
        if(tree==null){
            return 0;
        }
        if(tree.left==null&&tree.right==null){
            //System.out.println(tree.content);
            return 1;
        }
        int leftChildNum=getChildNum(tree.left);
        int rightChideNum=getChildNum(tree.right);
        //System.out.println(leftChildNum+""+rightChideNum);
        return leftChildNum+rightChideNum;
    }

    /**
     * 交换跟节点的左右子树
     * @param tree
     * @return
     */
    public Tree exChange(Tree tree){
        if(tree==null){
            return null;
        }
        Tree left=exChange(tree.left);
        Tree right=exChange(tree.right);
        tree.left=right;
        tree.right=left;
        return tree;
    }

    /**
     * 查看是否是子节点
     * @param father
     * @param son
     * @return
     */
    public boolean isChild(Tree father,Tree son){
        if(father==null || son==null){
            return false;
        }
        if(father.equals(son)){  //==只可进行地址一致的比较 重写equals方法  即可进行值比较
            return true;
        }
        boolean isChild=isChild(father.left,son);//传左子节点进去比较
        if(!isChild){
            isChild=isChild(father.right,son);//传右子节点进去比较
        }
        return isChild;
    }

    /**
     * 查看两个子树在树中的公共父节点
     * @param father
     * @param son1
     * @param son2
     * @return
     */
    public Tree isFather(Tree father,Tree son1,Tree son2){
        if(son1==null ||son2==null ||father==null){
            return null;
        }
        if(son1==father ||son2==father){
            return father;
        }
        if(isChild(father.left,son1)) {//如果son1是左子树的子节点
            if (isChild(father.right, son2)) { //son2也是father的父节点 则其公共父节点是father
                return father;
            }else{
                return isFather(father.left,son1,son2);
            }
        }else{
            if(isChild(father.left,son2)){
                return father;
            }else{
                return isFather(father.right,son1,son2);
            }
        }
    }

    /**
     * 根据树的中序遍历和前序遍历构建树
     * @param pre
     * @param mid
     * @return
     */
    public Tree getTreeByPreAndMid(List<String> pre,List<String> mid){
        if(pre==null || mid==null || pre.size()==0 || mid.size()==0){
            return null;
        }
        if(pre.size()==1){
            return new Tree(pre.get(0));
        }
        Tree tree=new Tree(pre.get(0));//创建树  根结点为前序第一个元素
        int index=0;//找出根结点在中序中的位置
        while(!mid.get(index++).equals(pre.get(0))){//前序第一个为根结点  找出根结点在中序中位置
            //System.out.println(index); 由于中序第一个不会是根结点 所以index从1开始增长
        }
        List<String> preLeft=new ArrayList<>(index);//创建左子树的前序
        List<String> midLeft=new ArrayList<>(index);//创建左子树的中序
        for (int i=0;i<index-1;i++){//构建左子树的中序   中序根结点前面的是左子树的结点元素
            midLeft.add(mid.get(i));
        }
        for(int i=1;i<index;i++){//构建左子树的前序  前序根结点后的到前序的中序根结点位置的是左子树的前序
            preLeft.add(pre.get(i));
        }
        tree.left=getTreeByPreAndMid(preLeft,midLeft);//构建树的左子树
        List<String> preRight=new ArrayList<>(pre.size()-index-1);//创建右子树的前序
        List<String> midRight=new ArrayList<>(pre.size()-index-1);//创建右子树的中序
        for (int i=0;i<=pre.size()-index-1;i++){//构建右子树的前序  前序的中序跟结点位置下标到最后为右子树的结点元素
            preRight.add(pre.get(index+i));
        }
        for (int i=0;i<=pre.size()-index-1;i++){//构建右子树的中序  中序根结点后的是右子树的结点元素
            midRight.add(mid.get(index+i));
        }
        tree.right=getTreeByPreAndMid(preRight,midRight);
        return tree;
    }

    /**
     * 根据中序和后序构建树
     * @param mid
     * @param back
     * @return
     */
    public Tree getTreeByMidAndBack(List<String> mid,List<String> back){
        if (mid == null || back==null || mid.size() == 0 || back.size()==0 ){
            return null;
        }
        if (back.size() == 1){
            return new Tree(back.get(0));
        }
        Tree tree=new Tree(back.get(back.size()-1));//创建树  后续最后一个元素为根结点
        int index=0;
        while(!mid.get(index++).equals(back.get(back.size()-1))){//获取中序 根结点位置

        }
        List<String> midLeft=new ArrayList<>(index);
        List<String> backLeft=new ArrayList<>(index);
        for (int i=0;i<index-1;i++){
            midLeft.add(mid.get(i));
        }
        for(int i=0;i<index-1;i++){
            backLeft.add(back.get(i));
        }
        tree.left=getTreeByMidAndBack(midLeft,backLeft);
        List<String> midRight=new ArrayList<>(mid.size()-index-1);
        List<String> backRight=new ArrayList<>(mid.size()-index-1);
        for(int i=0;i<index-1;i++){
            midRight.add(mid.get(index+i));
        }
        for (int i=0;i<index-1;i++){
            backRight.add(back.get(index+i-1));
        }
        tree.right=getTreeByMidAndBack(midRight,backRight);
        return tree;
    }

    /**
     * 二叉排序树添加节点
     * @param tree
     * @param data
     */
    public void insert(Tree1 tree,int data,String content){
        if(tree==null){
            return;
        }
        if(data>tree.num){
            if(tree.right==null){
                tree.right=new Tree1(data,content);
            }
        }else if(data<tree.num){
            if(tree.left==null){
                tree.left=new Tree1(data,content);
            }
        }else{
            return;
        }
    }

    /**
     * 在二叉树中查找元素
     * @param tree
     * @param num
     * @return
     */
    public String selectTree(Tree1 tree,int num){
        if(num>tree.num){
            return selectTree(tree.right,num);
        }else if(num<tree.num){
            return selectTree(tree.left,num);
        }else if(num==tree.num){
            return tree.content;
        }
        return null;
    }

    public void sortTreeMid(Tree1 tree){
        if(tree==null){
            return;
        }
        sortTreeMid(tree.left);
        System.out.println(tree.num);
        sortTreeMid(tree.right);
    }


    /**
     * 输出list值
     * @param list
     */
    public void forSout(List<String> list){
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
}
