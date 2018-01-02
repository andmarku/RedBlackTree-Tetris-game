package redBlackTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that provides some auxiliary methods to trees implemented in an arrays.
 * 
 * @author Markus
 *
 */
public class Auxiliary {
	/**
	 * A method which prints a linked tree using a folder structure with the
	 * root most to the left.
	 * 
	 * @param tree
	 *            the tree to print.
	 */
	// public static List<RBTNode> convertToArray(RBTree tree) {
	// List<RBTNode> ls = new ArrayList<>();
	// RBTNode root = tree.getRoot();
	// if (root == null)
	// return ls;
	// convertToArray(ls, root, 0, 0);
	// return ls;
	// }
	//
	// private static int convertToArray(List<RBTNode> ls, RBTNode node,
	// int layer, int indent) {
	// // Do nothing if at a leaf
	// if (node == null)
	// //return;
	//
	// // Fix the node and add it to the list
	// node.layer = layer;
	// node.position = indent;
	// ls.add(node);
	//
	// // Add one to the layer of the children
	// int nextLayer = layer + 1;
	//
	// // Right child
	// convertToArray(node.getRightChild(), indent + "\t");
	// System.out.println(indent + node.getValue() + " (" +
	// node.getColor().toString() + ")");
	// // Left child
	// convertToArray(node.getLeftChild(), indent + "\t");
	// }

	public static List<RBTNode> convertToArray(RBTree tree) {
		List<RBTNode> ls = new ArrayList<>();
		if (tree.getRoot() == null)
			return ls;

		// Fill the list with lots of null nodes.

		for (int j = 0; j < 100; j++) {
			ls.add(null);
		}

		convertToArray(tree.getRoot(), 0, ls);

		// Fit the size
		List<RBTNode> finalList = new ArrayList<>();
		int i = 0;
		boolean hasNextNode = false;
		for (RBTNode node : ls) {
			if (node != null) {
				finalList.add(node);
			} else {
				for (int j = i + 1; j < ls.size(); j++) {
					if (ls.get(j) != null) {
						hasNextNode = true;
						break;
					}
				}
				if (hasNextNode)
					finalList.add(node);
				hasNextNode = false;
			}
			i++;
		}
		return finalList;
	}

	private static void convertToArray(RBTNode node, int posOfNode, List<RBTNode> ls) {
		if (node == null)
			return;
		ls.add(posOfNode, node);
		// Add one to index before multiplication, then subtract to get correct
		// index
		convertToArray(node.getLeftChild(), (posOfNode + 1) * 2 - 1, ls);
		convertToArray(node.getRightChild(), (posOfNode + 1) * 2, ls);
	}

	public static RBTNode RBTNodeFactory(int value) {
		return new RBTNode(value, null);
	}

	/**
	 * A method which prints a linked tree using a folder structure with the
	 * root most to the left.
	 * 
	 * @param tree
	 *            the tree to print.
	 */
	public static void printLinkedTree(RBTree tree) {
		RBTNode root = tree.getRoot();
		if (root == null)
			System.out.println("Empty tree");
		printLinkedTree(root, "");
	}

	private static void printLinkedTree(RBTNode node, String indent) {
		// Can be changed to print a string containing '-' at each leaf.
		if (node == null)
			return;
		printLinkedTree(node.getRightChild(), indent + "\t");
		System.out.println(indent + node.getValue() + " (" + node.getColor().toString() + ")");
		printLinkedTree(node.getLeftChild(), indent + "\t");
	}

	/**
	 * Computes the index of the left child of a parent node.
	 * 
	 * @param index
	 *            the position of the parent in the tree
	 * @return the index of the left child
	 */
	public static int getLeftChild(int index) {
		// Add one to index in order to start at one instead of zero.
		// Times two gives the left child.
		// Remove one in order the shift first element to position zero.
		return (index + 1) * 2 - 1;
	}

	/**
	 * Computes the index of the right child of a parent node.
	 * 
	 * @param index
	 *            the position of the parent in the tree
	 * @return the index of the right child
	 */
	public static int getRightChild(int index) {
		// Add one to index in order to start at one instead of zero.
		// Times two plus one gives the right child.
		// Remove one in order the shift first element to position zero.
		return (index + 1) * 2;
	}

	public static List<RBTNode> convertTreeToList(RBTree tree) {
		List<RBTNode> nodes = new ArrayList<RBTNode>();
		RBTNode curr = tree.getRoot();
		for (int i = 0; i < 2 * tree.size(); i++) {
			nodes.add(curr);

		}

		return nodes;
	}

	private static void addToList(List<RBTNode> nodes, RBTNode curr) {
		nodes.add(curr);
	}
}
