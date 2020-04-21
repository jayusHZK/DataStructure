package Tree.puTongShu;

import sun.rmi.runtime.Log;

public class Tree<T> {
    private T content;
    private Tree<T> parent;
    private Tree<T>[] son;

    public Tree(){}
    public Tree(T data){
        content=data;
    }

}
