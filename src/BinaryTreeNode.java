// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
// Modified by Prince Mashava

public class BinaryTreeNode{
   private Kb data;
   private BinaryTreeNode left;
   private BinaryTreeNode right;
   
   public BinaryTreeNode ( Kb d)
   {
      data = d;
      left = null;
      right = null;
   }
   
   /**
   * Returns Kb object that contains key - value pairs. The data is copied to avoid memory leaks.
   * 
   * 
   * @return Kb object that contains key - value pairs or null if there is no data to copy from the
   */
   public Kb getData(){
      return this.data;
   }
   
   /**
   * Sets the data from a Kb object. This is useful for testing and to avoid having to re - use the data from an already existing knowledge base
   * 
   * @param kb - the knowledge base to
   */
   public void setData(Kb kb){
      data.setTerm(kb.getTerm());
      data.setSentence(kb.getSentence());      
      data.setConfidence(kb.getConfidence());      
   }   
   /**
   * Returns the left child of this node. This node is not part of the tree and can be used to access other nodes.
   * 
   * 
   * @return the left child of this node or null if this node is the root of a tree or has no
   */
   public BinaryTreeNode getLeft () { return left; }
   /**
   * Returns the right child of this node. This node is not changed by this method. The value returned by this method is null if this node has no right child.
   * 
   * 
   * @return the right child of this node or null if this node has no right child in other words if this node has no
   */
   public BinaryTreeNode getRight () { return right; }
   
   /**
   * Sets the left child of this node. This is used to determine the position of the left child when traversing a subtree.
   * 
   * @param l - Node to set as the left child of this
   */
   public void setLeft (BinaryTreeNode l) {left = l; }
   /**
   * Sets the right child of this node. This is used to determine the position of the right child when traversing the tree.
   * 
   * @param r - Node to set as right child of this node
   */
   public void setRight (BinaryTreeNode r) {right = r; }
   
}
