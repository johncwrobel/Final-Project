/**
 * @author John Wrobel and Thomas Lee
 * @date 7/23/2014
 * @version 2.0
 */


public class BTree {
	public static void main(String[] args) {
		
		//Testing isEmpty() on the same tree
		BTree tree = new BTree();
		tree.insert(10);
		System.out.println("Testing isEmpty() on a non-empty tree. Should show false.");
		System.out.println(tree.isEmpty());
		System.out.println();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		//Testing isEmpty() on an empty tree
		BTree emptyTree = new BTree();
		System.out.println("Testing isEmpty() on empty tree. Should show true.");
		System.out.println(emptyTree.isEmpty());
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Testing insert with several nodes");
		//Testing a tree with several nodes
		BTree tree1 = new BTree();
		tree1.insert(10);
		tree1.insert(20);
		tree1.insert(15);
		tree1.insert(5);
		tree1.insert(25);
		tree1.insert(30);
		tree1.insert(50);
		tree1.insert(100);
		System.out.println("Second Tree: 8 values inserted");
		preorder(tree1.root);
		System.out.println();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Testing remove");
		//Testing remove()
		BTree tree2 = new BTree();
		tree2.insert(10);
		tree2.insert(20);
		tree2.insert(15);
		tree2.insert(5);
		tree2.insert(25);
		tree2.insert(30);
		tree2.insert(50);
		tree2.insert(100);
		tree2.insert(200);
		
		tree2.remove(20);
		tree2.remove(5);
		System.out.println("Third Tree: 9 values inserted, 2 values deleted");
		preorder(tree2.root);
		System.out.println();
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Testing remove when the value doesn't exist in the tree");
		//Testing remove()
		BTree tree3 = new BTree();
		tree3.insert(10);
		tree3.insert(20);
		tree3.insert(15);
		tree3.insert(5);
		tree3.insert(25);
		tree3.insert(30);
		tree3.insert(50);
		tree3.insert(100);
		tree3.insert(200);
		System.out.println("remove(500); remove(17);");
		tree3.remove(500);
		tree3.remove(17);
		System.out.println("Third Tree: 9 values inserted, 0 values deleted");
		preorder(tree3.root);
		System.out.println();
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//Testing a tree with a single full node
				System.out.println("Testing insert and remove");
				System.out.println("");
				BTree tree5 = new BTree();
				System.out.println("insert(10);");
				tree5.insert(10);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");

				System.out.println("insert(20);");
				tree5.insert(20);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");

				System.out.println("insert(15);");
				tree5.insert(15);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("insert(5);");
				tree5.insert(5);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("insert(50);");
				tree5.insert(50);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("insert(100);");
				tree5.insert(100);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("remove(10);");
				tree5.remove(10);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("remove(50);");
				tree5.remove(50);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("remove(15); //Testing remove root");
				tree5.remove(15);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("insert(10);");
				tree5.insert(10);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("remove(100); //Testing handleUnderFlow");
				tree5.remove(100);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("remove(5); //Testing handleUnderFlow");
				tree5.remove(5);
				preorder(tree5.root);
				System.out.println("Size: " + tree5.size());
				System.out.println("---------------");
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//Testing a tree. This shows how insertion works and how the structure develops
		System.out.println();
		BTree tree4 = new BTree();
		tree4.insert(4);
		System.out.println("-------------");
		preorder(tree4.root);
		tree4.insert(12);
		System.out.println("-------------");
		preorder(tree4.root);
		tree4.insert(6);
		System.out.println("-------------");
		preorder(tree4.root);
		tree4.insert(15);
		System.out.println("-------------");
		preorder(tree4.root);
		tree4.insert(3);
		System.out.println("-------------");
		preorder(tree4.root);
		tree4.insert(5);
		System.out.println("-------------");
		preorder(tree4.root);
	}
	
	public Node root;
	private Node lastVisited;
	private int size;
	
	public BTree() {
		this.root = null;
		this.size = 0;
	}
	
	public boolean isEmpty() { //to test this make a new BTree and then call it
		return root == null;
	}
	
	public void clear() { //to test this, add some stuff, call it, then check isEmpty()
		root = null;
	}
	
	public int remove(int data) {
		int e;
		Node p;
		int pos;
		
		e = dataSearch(data);
		
		if (e == -1) {
			return -1; // Not found, nothing to delete...
		}
		int returnValue = e;
		p = lastVisited;
		
		for (pos = 0; pos < 3; pos++) {
			if (p.dataArray[pos] == data) {
				break;
			}
		}
		
		if (p.childArray[0] == null /* if this is a leaf node */) {
			for (int x = pos; x < 2; x++) {
				p.dataArray[x] = p.dataArray[x+1];
				p.dataArray[2] = 0;
			}
		} else {
			/*non leaf node*/
			Node q;
			// use q to traverse to p's successor
			q = p.childArray[pos + 1];//the node bigger than the value we are removing
			
			while (q.childArray[0] != null) {
				q = q.childArray[0]; //go left all the way down
			}
			p.dataArray[pos] = q.dataArray[0]; //replace
			
			for (int x = 0; x < 2; x++) { //delete e's successor in q
				q.dataArray[x] = q.dataArray[x + 1];
				q.dataArray[2] = 0;
			}
			
			p = q; //node where entry was delete
		}
		
		if (p.dataArray[0] == 0) { //if p is empty
			handleUnderflow(p , null);
		}
		size--;
		return returnValue;
	}
	
	public void handleUnderflow(Node p, Node z) {
		if (p == root) {
			root = z;
			return;
		}
		
		Node parent1;
		int pos;
		
		parent1 = p.parent;
		
		for (pos = 0; pos < 4; pos++) {
			if (parent1.childArray[pos] == p) {
				break;
			}
		}
		
		if ((pos <= 2 && parent1.childArray[pos + 1] != null) && parent1.childArray[pos + 1].dataArray[1] != 0) {
			Node rightSib = parent1.childArray[pos + 1];
			p.childArray[0] = z;
			if (z != null) {
				z.parent = p;
			}
			
			p.dataArray[0] = parent1.dataArray[pos];
			p.childArray[1] = rightSib.childArray[0];
			if (p.childArray[1] != null) {
				p.childArray[1].parent = p;
			}
			
			parent1.dataArray[pos] = rightSib.dataArray[0];
			
			
			for (int i = 0; i < 2; i ++) {
				rightSib.dataArray[i] = rightSib.dataArray[i + 1];
				rightSib.childArray[i] = rightSib.childArray[1 + 1];
			}
			
			return;
		} else if (pos > 0 && parent1.childArray[pos - 1].dataArray[1] != 0) {
			Node leftSib = parent1.childArray[pos - 1];
			int last;
			
			for (last = 0; last < 3; last++) {
				if (leftSib.dataArray[last] == 0) {
					break;
				}
			}
			
			if (last >= 3 || leftSib.dataArray[last] == 0) {
				last--;
			}
			
			p.childArray[0] = leftSib.childArray[last + 1];
			if (p.childArray[0] != null) {
				p.childArray[0].parent = p;
			}
			
			p.dataArray[0] = parent1.dataArray[pos - 1];
			
			p.childArray[1] = z;
			if (z != null) {
				z.parent = p;
			}
			
			parent1.dataArray[pos - 1] = leftSib.dataArray[last];
			
			leftSib.dataArray[last] = 0;
			leftSib.childArray[last + 1] = null;
			
			return;
		} else if (pos != 3 && parent1.childArray[pos + 1] != null) {
			Node rightSib = parent1.childArray[pos + 1];
			
			p.childArray[0] = z;
			if (z != null) {
				z.parent = p;
			}
			
			p.dataArray[0] = parent1.dataArray[pos];
			
			p.childArray[1] = rightSib.childArray[0];
			if (p.childArray[1] != null) {
				p.childArray[1].parent = p;
			}
			
			p.dataArray[1] = rightSib.dataArray[0];
			p.childArray[2] = rightSib.childArray[1];
			if (p.childArray[2] != null) {
				p.childArray[2].parent = p;
			}
			
			for (int i = pos; i < 2; i++) {
				parent1.dataArray[i] = parent1.dataArray[i + 1];
				parent1.childArray[i + 1] = parent1.childArray[i + 2];
			}
			parent1.dataArray[2] = 0;
			parent1.childArray[3] = null;
			
			if (parent1.dataArray[0] == 0) {
				handleUnderflow(parent1, p);
			}
		} else {
			Node leftSib = parent1.childArray[pos - 1];
			
			leftSib.dataArray[1] = parent1.dataArray[pos - 1];
			leftSib.childArray[2] = z;
			
			if (z != null) {
				z.parent = p;
			}
			
			for (int i = pos -1; i< 2; i++) {
				parent1.dataArray[i] = parent1.dataArray[i + 1];
				parent1.childArray[i + 1] = parent1.childArray[i + 2];
			}
			
			parent1.dataArray[2] = 0;
			parent1.childArray[3] = null;
			
			if (parent1.dataArray[0] == 0) {
				handleUnderflow(parent1, leftSib);
			}
		}
	}
	
	public int dataSearch(int data) {
		Node current;

		lastVisited = root;
		current = root;
		
		while (current != null) {
			for (int i = 0; i < 3; i++) {
				if (current.dataArray[i] != 0 && data < current.dataArray[i]) {
					lastVisited = current;
					current = current.childArray[i];
					break;
				}
				
				if (current.dataArray[i] != 0 && data == current.dataArray[i]) {
					lastVisited = current; // NOTE this may cause issues. Delete it if debugging
					return current.dataArray[i];
				}
				
				if (i == 2 || current.dataArray[i+1] == 0) {
					lastVisited = current;
					current = current.childArray[i+1];
					break;
				}
			}
		}
		return -1; //data not found
	}
	
	public int insert(int data) {
		if (root == null) {
			Node temp = new Node();
			temp.dataArray[0] = data;
			temp.parent = temp;
			root = temp;
			size++;
			return -1; //normally you'd return null but you can't since ints are a thing
		}
		int tempInt = dataSearch(data); //although this and the next if statement seem useless
										//their main purpose is to update lastVisited
		if (tempInt != -1) {
			int oldData = tempInt;
			tempInt = data;
			return oldData;
		}
		
		insertionHelper(data, null, lastVisited);
		size++;
		return -1; //data didn't previously exist
	}
	
	//having not used a real array in forever, working with all these indexes was a huge pain
	private void insertionHelper(int data, Node rightSubtree, Node insertPoint) {
		if (rightSubtree != null) {
			rightSubtree.parent = insertPoint;
		}
		if (insertPoint.dataArray[2] == 0) { //this node has room
			insertInNode(data, rightSubtree, insertPoint);
		} else { //split is necessary
			int[] tempData = new int[4];
			Node[] tempChild = new Node[5];
			tempChild[0] = insertPoint.childArray[0];
			int i = 0;
			
			while ((i < 3) && (insertPoint.dataArray[i] < data)) { //copy less than
				tempData[i] = insertPoint.dataArray[i];
				tempChild[i+1] = insertPoint.childArray[i+1];
				i++;
			}
			tempData[i] = data; //add in the new data
			tempChild[i+1] = rightSubtree;
			
			while (i < 3) { //copy greater than
				tempData[i+1] = insertPoint.dataArray[i];
				tempChild[i+2] = insertPoint.childArray[i+1];
				i++;
			}
			//now do the actual splitting
			insertPoint.childArray[0] = tempChild[0];
			insertPoint.childArray[1] = tempChild[1];
			insertPoint.childArray[2] = tempChild[2];
			insertPoint.childArray[3] = null;
			insertPoint.dataArray[0] = tempData[0];
			insertPoint.dataArray[1] = tempData[1];
			insertPoint.dataArray[2] = 0;
			
			Node newNode = new Node();
			newNode.childArray[0] = tempChild[3];
			newNode.childArray[1] = tempChild[4];
			newNode.dataArray[0] = tempData[3];
			//don't forget to change parent pointer!
			if (newNode.childArray[0] != null) {
				newNode.childArray[0].parent = newNode;
			}
			if (newNode.childArray[1] != null) {
				newNode.childArray[1].parent = newNode;
			}
			
			if (insertPoint == root) {
				Node newRoot = new Node();
				newRoot.childArray[0] = insertPoint;
				insertPoint.parent = newRoot;
				newRoot.childArray[1] = newNode;
				newNode.parent = newRoot;
				newRoot.dataArray[0] = tempData[2];
				root = newRoot;
			} else { //INVOKE THE POWER OF RECURSION
				insertionHelper(tempData[2], newNode, insertPoint.parent);
			}
		}
	}
	
	//having not used a real array in forever, working with all these indexes was a huge pain
	private void insertInNode(int data, Node rightChild, Node insertPoint) {
		if (((insertPoint.dataArray[0] != 0) && (data < insertPoint.dataArray[0])) || (insertPoint.dataArray[0] == 0)) { //data[0] good spot?
			for (int i = 2; i > 0; i--) { //move the existing data to the right to make room for new. Tricky numbers here
				insertPoint.childArray[i+1] = insertPoint.childArray[i];
				insertPoint.dataArray[i] = insertPoint.dataArray[i-1];
			}
			insertPoint.childArray[1] = rightChild;
			insertPoint.dataArray[0] = data;
			
		} else if (((insertPoint.dataArray[1] != 0) && (data < insertPoint.dataArray[1])) || (insertPoint.dataArray[1] == 0)) { //data[1] good spot?
			for (int i = 2; i > 1; i--) {
				insertPoint.childArray[i+1] = insertPoint.childArray[i];
				insertPoint.dataArray[i] = insertPoint.dataArray[i-1];
			}
			insertPoint.childArray[2] = rightChild;
			insertPoint.dataArray[1] = data;
			
		} else { //data[2] IS a good spot
			insertPoint.childArray[3] = rightChild;
			insertPoint.dataArray[2] = data;
		}
		if (rightChild != null) { //can't forget to update parent pointer!
			rightChild.parent = insertPoint;
		}
	}
	
	public static void preorder(Node root) {
		if (root != null) {
			System.out.println(root);
			for (int i = 0; i < 4; i++) {
				if (root.childArray[i] != null) {
					preorder(root.childArray[i]);
				}
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	private class Node {
		public int[] dataArray;
		public Node[] childArray;
		public Node parent;
		
		public Node() {
			this.dataArray = new int[3];
			this.childArray = new Node[4];
			this.parent = null;
		}
		
		public String toString() {
			StringBuilder returnString = new StringBuilder(); //using StringBuilder for fastest possible running time
			
			for (int i = 0; i < 3; i++) {
				if (dataArray[i] == 0) {
					returnString.append("_");
					returnString.append(" ");
				} else {
					returnString.append(dataArray[i]);
					returnString.append(" ");
				}
			}
			
			return returnString.toString();
		}
	}
}
