package Tree.erChaShu;

import java.util.Objects;

public class Tree {
        String content;//节点存储值
        Tree left;//左子节点
        Tree right;//右子节点

        /**
         * 无参构造
         */
         Tree(){}

        /**
         * 有参构造
         * @param data
         */
        Tree(String data){
            this.content=data;
        }

        /**
         * 增加左子节点
         * @param data
         */
        public void addLeft(String data){
            Tree leftChild=new Tree(data);
            this.left=leftChild;
        }

        /**
         * 增加右子节点
         * @param data
         */
        public void addRight(String data){
            Tree rightChild=new Tree(data);
            this.right=rightChild;
        }

    @Override
    public String toString() {
        return "Tree{" +
                "content='" + content + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(content, tree.content) &&
                Objects.equals(left, tree.left) &&
                Objects.equals(right, tree.right);
    }

    @Override
    public int hashCode() {

        return Objects.hash(content, left, right);
    }
}
