/**
 * 
 */
package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author duchauha
 *
 */

class Node{
	int value;
	Node left;
	Node right;
	Node(int value){
		this.value=value;
		left=null;
		right=null;
	}
}

public class BinarySearchTree {
	
	 Node root;
	
	 public void add(int value) {
		 root=  addRecursively(root,value);
	 }
	
	 private Node addRecursively(Node current,int value) {
		if(current==null) {
			return new Node(value) ;
		}
		if(value<current.value) {
			current.left = addRecursively(current.left,value);
		}else if(value>current.value){
			current.right=addRecursively(current.right,value);
		}else {
			//value already exists
			return current;
		}
		
		return current;
		
		
	}
	
	
	private boolean searchNodeRecursively(Node current,int value) {
		if(current==null) {
			return false;
		}
		if(current.value==value) {
			return true;
		}
		
		return value<current.value?searchNodeRecursively(current.left,value):searchNodeRecursively(current.right,value);
	}
	
	public boolean search(int value) {
		return searchNodeRecursively(root,value);
	}
	
	
	private Node deleteRecursively(Node current,int value) {
		if(current==null) {
			return null;
		}
		
		if(current.value==value) {
			//case 1 no subchild
			if(current.left==null && current.right==null) {
				return null;
			}
			
			//case 2 one child node
			if(current.left==null) {
				return current.right;
			}
			
			if(current.right==null) {
				return current.left;
			}
			
			// case 2 two child nodes
			int smallest =  findSmallestValue(current.right);
			current.value = smallest;
			current.right = deleteRecursively(current.right,smallest);
			return current;
			
		}
		
		if(current.value>value) {
			 current.left = deleteRecursively(current.left,value);
		}else {
			current.right=deleteRecursively(current.right,value);
		}
		
		return current;
	}
	
	
	private int findSmallestValue(Node root) {
		return root.left==null?root.value:findSmallestValue(root.left);
	}
	
	public void delete(int value) {
		root =  deleteRecursively(root,value);
	}
	
	//below three are dfs traversal 
	public void traverseInOrder(Node node) {
		if(node!=null) {
			traverseInOrder(node.left);
			visit(node.value);
			traverseInOrder(node.right);
		}
	}
	
	public void traversePreOrder(Node node) {
		if(node!=null) {
			visit(node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	
	public void traversePostOrder(Node node) {
		if(node!=null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			visit(node.value);
		}
	}
	
	//bfs traversal
	public void bfsTraversal() {
		if(root==null) {
			return ;
		}
		
		Queue<Node> q= new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node node = q.poll();
			visit(node.value);
			if(node.left!=null) {
				q.add(node.left);
			}
			
			if(node.right!=null) {
				q.add(node.right);
			}
		}
	}
	
	
	private void visit(int value) {
        System.out.print(" " + value);        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();

	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	    
	    System.out.println("bfs traversal");
	    bt.bfsTraversal();
	    
	    System.out.println("\n dfs inorder traversal");
	    bt.traverseInOrder(bt.root);
	    
	    System.out.println("\n dfs preorder traversal");
	    bt.traversePreOrder(bt.root);
	    
	    System.out.println("\n dfs postorder traversal");
	    bt.traversePostOrder(bt.root);
	    
	    System.out.println("");
	    System.out.println(bt.search(3));
	    System.out.println(bt.search(11));
	    
	    bt.delete(3);
	    System.out.println(bt.search(3));
	    
	    bt.delete(4);
	    bt.delete(8);
	    
	    System.out.println("bfs traversal");
	    bt.bfsTraversal();
	}

}
