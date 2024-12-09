package edu.grinnell.csc207.util;

/**
 * Very simple interior node class.
 *
 * @author Grant Sackmann
 */
public class BitTreeInteriorNode implements BitTreeNode {

  /**
   * Pointer to left node.
   */
  BitTreeNode left;
  /**
   * Pointer to right node.
   */
  BitTreeNode right;

  /**
   * Simple interior node constructor.
   */
  public BitTreeInteriorNode() {
  } // BitTreeInteriorNode

  /**
   * BitTreeInteriorNodeConstructor with children.
   *
   * @param left  BitTreeInteriorNode left child
   * @param right BitTreeInteriorNode right child
   */
  public BitTreeInteriorNode(BitTreeInteriorNode left, BitTreeInteriorNode right) {
    this.left = left;
    this.right = right;
  } // BitTreeInteriorNode(BitTreeInteriorNode,BitTreeInteriorNode)
} // BitTreeInteriorNode class
