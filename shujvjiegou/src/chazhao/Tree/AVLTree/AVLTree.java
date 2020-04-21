package chazhao.Tree.AVLTree;

public class AVLTree {
    public int value;
    public AVLTree right,left;
    public int height; //树高度
    public AVLTree(){}
    public AVLTree(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AVLTree getRight() {
        return right;
    }

    public void setRight(AVLTree right) {
        this.right = right;
    }

    public AVLTree getLeft() {
        return left;
    }

    public void setLeft(AVLTree left) {
        this.left = left;
    }
}
