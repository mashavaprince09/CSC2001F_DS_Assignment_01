// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman
// Modified by Prince Mashava

public class BinarySearchTree
{
   private BinaryTreeNode root;
   
   public BinarySearchTree ()
   {
      root = null;
   }
   
   /**
   * Returns the root of the tree. This is used to determine if there are any subtrees that need to be traversed in order to get the root of the tree.
   * 
   * 
   * @return the root of the tree or null if this is the root of the tree ( which may or may not be the root
   */
   public BinaryTreeNode getRoot(){
      return root;
   }

   /**
   * Inserts a Kb into the tree. If the tree is empty a new node is created to represent the root
   * 
   * @param d - the Kb to be
   */
   public void insert ( Kb d )
   {
      // Inserts the binary tree into the tree.
      if (root == null)
         root =new BinaryTreeNode(d);
      else
         insert (d, root);
   }
   /**
   * Inserts a Kb into the tree. This method is used to insert a Kb into the BST
   * 
   * @param d - The Kb to be inserted
   * @param node - The node that will hold the Kb. This node is updated in
   */
   public void insert ( Kb d, BinaryTreeNode node )
   {
      // Insert the node to the left or right of the tree.
      if (d.compareTo (node.getData()) <= 0)
      {
         // Inserts the left node in the tree.
         if (node.getLeft() == null)
            node.setLeft(new BinaryTreeNode (d)) ;
         else
            insert (d, node.getLeft());
      }
      else
      {
         // Inserts the right node in the tree.
         if (node.getRight() == null)
            node.setRight(new BinaryTreeNode (d));
         else
            insert (d, node.getRight());
      }
   }
   
   /**
   * Find the node that contains the Kb. If there is no such node return null. This is a non - recursive version of #find ( Kb )
   * 
   * @param d - the Kb to look for
   * 
   * @return the BinaryTreeNode that contains the Kb or null if not found in the tree or if the tree is
   */
   public BinaryTreeNode find ( Kb d )
   {
      // Find the root node in the tree.
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   /**
   * Finds the node that contains the key. This is a recursive method. It traverses the tree until it finds the node that contains the key.
   * 
   * @param d - Key to look for. This is the key we are looking for.
   * @param node - Node where we are looking for the key.
   * 
   * @return BinaryTreeNode The node that contains the key or null if not found. Note that the root node is the same as the node passed in
   */
   public BinaryTreeNode find ( Kb d, BinaryTreeNode node )
   {
      // Find the node that is closest to the given data.
      if (d.compareTo (node.getData()) == 0) 
         return node;
      // Find the node in the tree.
      else if (d.compareTo (node.getData()) < 0)
         return (node.getLeft() == null) ? null : find (d, node.getLeft());
      else
         return (node.getRight() == null) ? null : find (d, node.getRight());
   }
   
     
   /**
   * Finds the minimum node in the tree. This is used to find the minimum node in the sub - tree
   * 
   * @param node - The node to start from
   * 
   * @return The node with the minimum value in the sub - tree or null if there is no such node in
   */
   public BinaryTreeNode findMin ( BinaryTreeNode node )
   {
      // Get the leftmost node in the tree.
      if (node != null)
         // Get the leftmost node in the tree.
         while (node.getLeft() != null)
            node = node.getLeft();
      return node;
   }
    
   //Find exact term 
   /**
   * Finds and returns the BinaryTreeNode that contains the term. If there is no such node null is returned
   * 
   * @param term - the term to search for
   * 
   * @return the BinaryTreeNode that contains the term or null if not found in the tree or if the term is
   */
   public BinaryTreeNode findTerm(String term){
      // Returns the term or null if no term is found.
      if(root == null){
        return null;
      }
      else {
         return findTerm(term,root);
      }
   }
   /**
   * Finds and returns the node that contains the term. This is a recursive method. It traverses the tree starting at the root and looks for the term in the data.
   * 
   * @param term - The term to search for. Must be non - null.
   * @param node - The node to start the search from. Must be non - null.
   * 
   * @return The node that contains the term or null if not found. Note that null is returned if there is no node with the term
   */
   public BinaryTreeNode findTerm ( String term, BinaryTreeNode node )
   {
      // Returns the node that matches the term.
      if (term.compareTo (node.getData().getTerm()) == 0) {
         return node;}
      // Returns the term of the node.
      else if (term.compareTo (node.getData().getTerm())  < 0){
         return (node.getLeft() == null) ? null : findTerm (term, node.getLeft());}
      else{
         return (node.getRight() == null) ? null : findTerm (term, node.getRight());}
   }
   
 //Find Partial Term
    /**
    * Finds a term in the tree. This is useful for looking up an individual term that is part of a sentence.
    * 
    * @param term - The term to search for. Must be non - null.
    * @param sen - The sentence to search for. Must be non - null.
    * 
    * @return The BinaryTreeNode that contains the term or null if not found. Note that null is returned if the term is not part of the sentence
    */
    public BinaryTreeNode findTermPartial(String term, String sen){
      // Returns the partial term of the root node.
      if(root == null){
         return null;
      }
      else {
         return findTermPartial(term,sen,root);
      }
   }
   /**
   * Finds the node in the BST that contains the term and sen. This is used to find the most common sub - node of a term and sen
   * 
   * @param term - the term to search for
   * @param sen - the sen to search for ( may be null )
   * @param node - the root of the tree to search from ( may be null )
   * 
   * @return the BinaryTreeNode that contains the term sen or null if not found ( does not have to be a subtree
   */
   public BinaryTreeNode findTermPartial ( String term, String sen, BinaryTreeNode node )
   {
      // Returns the node that matches the term.
      if ((node.getData().matchTermPartial(term)) && (node.getData().matchSenPartial(sen))) {
         return node;}
      // Returns the term of the node.
      else if (term.compareTo (node.getData().getTerm())  < 0){
         return (node.getLeft() == null) ? null : findTermPartial (term, sen ,node.getLeft());}
      else{
         return (node.getRight() == null) ? null : findTermPartial (term, sen ,node.getRight());}
   }
      
      
      
   /**
   * Finds and returns the node that contains the term. If no node is found null is returned. This method is O ( n ) where n is the number of nodes in the tree
   * 
   * @param term - the term to search for
   * 
   * @return the node that contains the term or null if no node is found with that term in the tree or if no node is
   */
   public BinaryTreeNode findNode(String term){
      // Returns the node in the tree.
      if(root == null){
         return null;
      }
      else {
         return findNode(term,root);
      }
   }
   /**
   * Finds the node that contains the term. This is a recursive method. It uses the data member of the BinaryTreeNode to search for the term
   * 
   * @param term - the term to search for
   * @param node - the node to start the search from. This must be a root node
   * 
   * @return the node that contains the term or null if not found. Note that the node is returned as a side effect
   */
   public BinaryTreeNode findNode ( String term, BinaryTreeNode node )
   {
     // Returns the node that is the node that is the node that is the node.
     if (term.compareTo(node.getData().getTerm()) == 0)
      {
            return node;
      }   
     // Find a node by term.
     if (term.compareTo(node.getData().getTerm()) < 0)
      {
         // Find the left node of the tree.
         if (node.getLeft().getData().matchTerm(term))
            return node.getLeft();
         else
            return findNode(term,node.getLeft());
      }
      else
      {
         // Find the right node in the tree.
         if (node.getRight().getData().matchTerm(term))
            return node.getRight();
         else
            return findNode(term,node.getRight());
      }
   }

   /**
   * Updates the data associated with a key. This is called when one of the keys changes in the tree
   * 
   * @param kb - the key that has changed
   * @param btn - the node to update with the new data ( must be a child
   */
   public void update(Kb kb, BinaryTreeNode btn){
      btn.setData(kb);
   }      
    
   /**
   * This method traverses the tree in in order. The root is visited first then the subtrees are visited
   */
   public void inOrder ()
   {
      inOrder (root);
   }
   /**
   * Prints the in order traversal of the tree. Used for debugging purposes. Note that this is a recursive method
   * 
   * @param node - the node to start
   */
   public void inOrder ( BinaryTreeNode node )
   {
      // This method is used to sort the nodes in the order of the nodes.
      if (node != null)
      {
         inOrder (node.getLeft ());
         System.out.println(node.getData());
         inOrder (node.getRight ());
      }   
   }    
   /**
   * Returns the number of nodes in the tree. This is the number of nodes that are connected to the root node by a path from the root node to the node that has the largest distance to the root node.
   * 
   * 
   * @return the number of nodes in the tree. A negative value indicates that the tree is empty ; a positive value indicates that the tree has no nodes
   */
   public int getHeight ()
   {
      return getHeight (root);
   }
   /**
   * Returns the height of the subtree rooted at node. This is the sum of the height of the children of the node's left and right subtrees
   * 
   * @param node - the node to start the search from
   * 
   * @return the height of the subtree rooted at node or - 1 if node is null or has no children
   */
   public int getHeight ( BinaryTreeNode node )
   {
      // Returns the height of the node.
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   } 
   /**
   * Returns the number of elements in the tree. This is the same as #getSize ( Node ) but for the root node.
   * 
   * 
   * @return the number of elements in the tree ; negative if the tree is empty or contains no elements ; positive
   */
   public int getSize ()
   {
      return getSize (root);
   }   
   /**
   * Returns the size of the subtree rooted at node. It is used to determine the number of nodes in the tree
   * 
   * @param node - the node to start from
   * 
   * @return the size of the subtree rooted at node or 0 if node is null or not a binary tree
   */
   public int getSize ( BinaryTreeNode node )
   {
      // Returns the number of nodes in the tree.
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }   
   
}
