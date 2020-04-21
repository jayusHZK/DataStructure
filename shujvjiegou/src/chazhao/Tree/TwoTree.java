package chazhao.Tree;

//二叉查找树
public class TwoTree<K,V> {
    private Node root;

    private class Node{
        private K key;
        private V value;
        private Node left,right,parent;
        public Node(){}
        public Node(K key,V value,Node parent){
            this.key=key;
            this.value=value;
            this.parent=parent;
        }
    }
    public TwoTree(){}
    public TwoTree(K key,V value){
        if(key==null)return;
        root=new Node(key,value,null);
        return;
    }
    public void put(K key,V value){
        if(key==null)return;
        if(root==null){
            root=new Node(key,value,null);
        }
        insert(root,key,value);
    }
    //插入节点
    public void insert(Node node,K key,V value){
        if(key.hashCode() == node.key.hashCode() && key.equals(node.key)){
            node.value=value;
        }else if(key.hashCode()<node.key.hashCode()){
            if(node.left==null){
                node.left=new Node(key,value,node);
            }else{
                insert(node.left,key,value);
            }
        }else{
            if(node.right==null){
                node.right=new Node(key,value,node);
            }else{
                insert(node.right,key,value);
            }
        }
    }
    //中序输出
    public void midPrint(TwoTree tree){
        midPrint(tree.root);
    }
    //中序输出
    private void midPrint(Node node){
        if(node==null) return;
        midPrint(node.left);
        System.out.print(node.key+"+"+node.value+""+"\t");
        midPrint(node.right);
    }
    //在树中根据key值查找节点
    public Node getNodeByKey(Node node,K key){
        if(node==null)return null;
        else if(node.key.hashCode() == key.hashCode() && node.key.equals(key)){
            return node;
        }else if(key.hashCode() > node.key.hashCode()){
            return getNodeByKey(node.right,key);
        }else{
            return getNodeByKey(node.left,key);
        }
    }
    //获得节点最小值的key
    private K getMin(Node node){
        if(node==null){
            return null;
        }if(node.left==null){
            return node.key;
        }
        return getMin(node.left);
    }
    //删除节点
    public boolean delete(K key){
        Node node = getNodeByKey(root, key);
        if(node==null){ //判空
            return false;
        }
        if(node.right==null){ //当前右子节点为空
            if(node.parent==null){ //根结点
                if(node.left==null){ //判断树是否只有一个节点
                    node=null;
                    return true;
                }
                root=root.left;
                root.parent=null;
                return true;
            }
            if(node.parent.left!=null && node.key.equals(node.parent.left.key)){ //当前节点为父节点的左子节点
                if(node.left==null){//当前节点为叶子节点
                    node.parent.left=null;
                }else{ //当前节点的左子节点代替当前节点
                    node.parent.left=node.left;
                    node.left.parent=node.parent;
                }
            }else if(node.parent.right!=null && node.key.equals(node.parent.right.key)){//当前节点为父节点的右子节点
                if(node.left==null){ //当前节点为叶子节点
                    node.parent.right=null;
                }else{ //当前节点的左节点替代当前节点
                    node.parent.right=node.left;
                    node.left.parent=node.parent;
                }
            }
            return true;
        }
        if(node.left==null){ //当前节点左子节点为空
            if(node.parent==null){ //为根结点
                if(node.right==null){ //右子节点为空
                    root=null;
                    return true;
                }
                root=node.right; //右子节点替代根结点
                node.parent=null;
                return true;
            }
            if(node.parent.left!=null && node.key.equals(node.parent.left)){//当前节点为父节点的左子节点
                if(node.right==null){  //当前节点为叶子节点
                    node.parent.left=null;
                }else{
                    node.parent.left=node.right;
                    node.left.parent=node.parent;
                }
            }else if(node.parent.right!=null && node.key.equals(node.parent.right.key)){ //当前节点为父节点的右子节点
                if(node.right==null){ //当前节点是叶子节点
                    node.parent.right=null;
                }else{
                    node.parent.right=node.right;
                    node.right.parent=node.parent;
                }
            }
            return true;
        }
        //当前节点有左子节点和右子节点
        Node minNode=getNodeByKey(root,getMin(node.right));//获得当前节点右子树的最小值
        node.right.parent=node.left.parent=minNode; //先替换当前节点子节点的父节点
        if(node.parent==null){//当前节点是根结点
            if(minNode.key.equals(node.right.key)){ //如果当前节点的右子节点=当前节点右子树的最小值说明右子树无左节点
                minNode.left=node.left;
                root=minNode;    //当前节点的右子树没有左节点  用获得的最小值替代当前节点，当前节点的左子树的parent换为最小值
                node.left.parent=minNode;
                minNode.parent=null;
            }else{ //最小值不是当前节点的右子节点
                if(minNode!=null){ //删除最小值节点  替换其父节点及右子节点的指向
                    minNode.right.parent=minNode.parent;
                    minNode.parent.left=minNode.right;
                } //将当前当前节点的值赋给最小值，并将最小值作为根结点
                minNode.left=node.left;
                minNode.right=node.right;
                node.right.parent=node.left.parent=minNode;
                minNode.parent=null;
                root=minNode;
            }
        }else{  //当前不是根结点
            if(minNode.key.equals(node.right.key)){  //如果当前节点右节点是最小值
                minNode.left=node.left;  //用最小值替代当前节点
                minNode.parent=node.parent;
                node.left.parent=minNode;
                if(node.parent.right.key.equals(node.key)){ //当前节点是父节点的右节点
                    node.parent.right=minNode;
                }else{
                    node.parent.left=minNode;
                }
            }else{ //如果最小值不是当前节点的右子节点
                minNode.right.parent=minNode.parent;
                minNode.parent.left=minNode.right; //最小值节点没有左子节点
                minNode.left=node.left;
                minNode.right=node.right;
                minNode.parent=node.parent;
                if(node.parent.left.key.equals(node.key)){ //当前节点是父节点的左节点
                    node.parent.left=minNode;
                }else{
                    node.parent.right=minNode;
                }
            }
        }
        return true;
    }
}
