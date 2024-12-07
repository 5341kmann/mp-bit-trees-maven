package edu.grinnell.csc207.util;

/**
 * Very simple leaf node class.
 * @author Grant Sackmann
 * @param <T> Generic Object type value for leaf node.
 */
public class BitTreeLeaf<T> implements BitTreeNode{

  /**
   * Value of leaf node.
   */
  T value;

  /**
   * Bit Leaf constructor.
   * @param value T leaf value
   */
  public BitTreeLeaf(T value) {
    this.value = value;
  } // BitTre(T)
} // BitTreeNode
