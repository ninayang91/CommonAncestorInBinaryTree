# CommonAncestorInBinaryTree
Given a binary tree, find two nodes' first common ancestor

1. If each node's parent is know, check 

commonAncestor(TreeNode p, TreeNode q)

   if x==y return x
   
   if x is a parent of y, return x
   
   if y is a parent of x, return x
   
   while()x=x.parent, y=y.parent, if(x==y) return x; Or go up until either one hit the root, return root

In this method, we need an additonal method boolean isParent(x,y), since we don't know the root, we cannot check if nodes are in this tree
 
2. If parent is not know, we traverse the tree from the root

commonAncestor(TreeNode root, TreeNode p, TreeNode q)

  if root==null, return null
  
  we first check if nodes are in this tree (additional method: boolean covers(root, p)) Once is enough, so write a helper to do the rest
  
  check if p or q==root, return root
  
  check if p q areon the differnt side, return root
  
  return commonAncestor(root.left,p,q) or commonAncestor(root.right,p,q)
  
Time O(n) because n/2+n/4+n/8+...




 
