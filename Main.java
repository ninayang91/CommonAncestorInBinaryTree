import java.util.ArrayList;
import java.util.LinkedList;

import org.w3c.dom.Node;

public class Main {

	public static void main(String[] args) {
		
		TreeNode f =new TreeNode(3,null,null);
		TreeNode e =new TreeNode(1,null,null);
		TreeNode c =new TreeNode(6,null,null);
		TreeNode d= new TreeNode(2,e,f);
		e.parent=d;f.parent=d;
		TreeNode b= new TreeNode(4,d,null);
		d.parent=b;
		TreeNode a= new TreeNode(5,b,c);
		b.parent=a;c.parent=a;
		
		TreeNode x=new TreeNode(1,null,null);
		//System.out.println(isParent(a,f));
		//System.out.println(commonAncestor(f,a).data);
		System.out.println(commonAncestor2(a,f,e).data);
	}
	
	//Return true if p is a descendent of root
	public static boolean covers(TreeNode root, TreeNode p){
		if(root==null)return false;
		if(root==p)return true;
		return covers(root.left,p) || covers(root.right,p);
	}
	
	public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if(root==null) return null;
		if(root==p || root==q) return root;
		
		boolean is_p_on_left =covers(root.left,p);
		boolean is_q_on_left =covers(root.left,q);
		
		if(is_p_on_left!=is_q_on_left) return root;
		
		if(is_p_on_left){// p,q on left
			return commonAncestorHelper(root.left,p,q);
		}else{
			return commonAncestorHelper(root.right,p,q);
		}
			
	}
	
	public static TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root,p) || !covers(root,q))return null;// we only need to check once, that's why we write a helper
		return commonAncestorHelper(root,p,q);
	}
	
	public static TreeNode commonAncestor(TreeNode x, TreeNode y){
		//if(x==y)return x;
		if(isParent(x,y))return x;
		if(isParent(y,x))return y;
		
		while(x.parent!=null && y.parent!=null){
			if(x==y)return x;
			x=x.parent;
			y=y.parent;
			
			
		}
		return (x.parent==null)?x:y;//root
	}
	
	public static boolean isParent(TreeNode x, TreeNode y){//check if x is a parent of y
		if(x==null)return false;
		if(y==null)return true;
		if(x==y) return true;
		while(y!=null){
			y=y.parent;
			if(x==y) return true;
		}
		return false;
		
		
	}

}
