package chazhao.Tree.AVLTree;

public class AVLTreeUtil {
    public AVLTree root;//根结点

    public AVLTree getRoot() {
        return root;
    }

    public void setRoot(AVLTree root) {
        this.root = root;
    }

    public AVLTreeUtil(){
    }
    public AVLTreeUtil(AVLTree tree){
        this.root=tree;
    }

    /**
     * 中序输出
     */
    public void midSearch(){
        if(root.left!=null){
            new AVLTreeUtil(root.left).midSearch();
        }
        System.out.println(root.value);
        if(root.right!=null){
            new AVLTreeUtil(root.right).midSearch();
        }
    }

    public void insert(int value){
        if(root==null){
            root=new AVLTree(value);
        }else if(value==root.value){
            return;
        }else if(value>root.value){ //插入右子树
            AVLTreeUtil rRoot=new AVLTreeUtil(root.right); //获取根结点右子树
            rRoot.insert(value);
            root.setRight(rRoot.getRoot());  //插入右子节点
            int lHeight=0;
            int rHeight=0;

        }else{

        }
    }

    /**
     * 左左  单旋转
     */
    public void songleRollLeft(){

    }
}
