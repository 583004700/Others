package mysources;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    //指向第一个节点
    public static TreeNode first;
    //指向当前要给哪个节点添加子节点
    public static TreeNode current;
    //指向要切换的左边的节点
    public static TreeNode firstLeftNode;

    public static void add(TreeNode treeNode){
        if(first == null){
            first = treeNode;
            current = treeNode;
            //第一个节点的父节点的value为null
            treeNode.parent = new TreeNode(null);
            firstLeftNode = treeNode;
            return;
        }
        if(current.left == null){
            current.left = treeNode;
            if(firstLeftNode == current){
                firstLeftNode = treeNode;
            }
            treeNode.parent = current;
        }else if(current.right == null){
            current.right = treeNode;
            treeNode.parent = current;
            if(current.parent.right != null && current.parent.right != current){
                current = current.parent.right;
                return;
            }
            TreeNode index = current.parent;
            while(index.parent == null || index.parent.right == null || index.parent.right == index){
                index = index.parent;
            }
            current = index.parent.right.left;
            //current = firstLeftNode;
        }
    }

    /**
     * 按顺序遍历树
     */
    public static void fore(TreeNode treeNode){
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);

        //被移除的数据
        TreeNode r = null;
        while((r = queue.poll()) != null){    //队列中还有数据
            //添加到集合中
            treeNodes.add(r);
            if(r.left != null){
                queue.add(r.left);
            }
            if(r.right != null){
                queue.add(r.right);
            }
        }
        System.out.println(treeNodes);
    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        for(int i=1;i<=5000;i++){
            TreeNode treeNode = new TreeNode(i);
            tree.add(treeNode);
        }

        System.out.println(tree);
        //从头节点开始遍历
        fore(Tree.first);
    }
}

class TreeNode{
    public Integer value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
