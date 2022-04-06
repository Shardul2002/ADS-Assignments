import java.util.*;

class BTNode{
   int data;
   BTNode right,left;


   public BTNode(){
     right=null;
     left=null;
     data=0;
   }

   public BTNode(int val){
       data=val;
       right=null;
       left=null;

   }

public int getData() {
    return data;
}

public void setData(int data) {
    this.data = data;
}

public BTNode getRight() {
    return right;
}

public void setRight(BTNode right) {
    this.right = right;
}

public BTNode getLeft() {
    return left;
}

public void setLeft(BTNode left) {
    this.left = left;
}
   
}
class BT{
    private BTNode root;

    public BT(){
        root=null;
    }

    public void insert(int val){
        root=insert(root,val);
    }

    private BTNode insert(BTNode node,int val){
        if(node==null)
        node=new BTNode(val);

        else{
            if(val<node.data)
            node.left=insert(node.left,val);
            else
            node.right=insert(node.right, val);
        }
        return node;
    }
    public void inorder(){
        inorder(root);
    }

    public void inorder(BTNode root){
        if(root!=null){
            inorder(root.getLeft());
            System.out.print(root.getData()+" ");
            inorder(root.getRight());
        }
    }
    public void preorder(){
        preorder(root);
    }
    public void preorder(BTNode root){
        if(root!=null){
            System.out.print(root.getData()+" ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    public int min(BTNode r){
    
        int ans=root.data;
        while(r.left!=null){
            ans=r.left.data;
            r=r.left;
            
        }
        return ans;
    }
    public int max(BTNode r){
        
        int ans=root.data;
        while(r.right!=null){
            ans=r.right.data;
            r=r.right;
            
        }
        return ans;
    }
    
    void deleteKey(int key){
        root=delete(root,key);
    }
    BTNode delete(BTNode r,int key){
        if(r==null){
            return r;
        }
        if(key<r.data){
             r.left=delete(r.left,key);
        }
        else if(key>r.data){
            r.right=delete(r.right,key);
        }

        else{
            
            if(r.left==null){
                return r.right;
            }
            else if(r.right==null){
                return r.left;

            }
            r.data=min(r.right);
            r.right=delete(r.right,r.data);
        }
        return r;
    }

}

public class binarysearchtree
{
    public static void main(String args[]){
        BT bt= new BT();

        bt.insert(50);
        bt.insert(30);
        bt.insert(20);
        bt.insert(40);
        bt.insert(70);
        bt.insert(60);
        bt.insert(80);

        bt.inorder();
        System.out.println();
        bt.deleteKey(20);
        bt.inorder();
        System.out.println();
        bt.preorder();
        
    }
}

