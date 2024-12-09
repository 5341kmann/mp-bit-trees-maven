package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Grant Sackmann
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Root of bit tree.
   */
  private BitTreeInteriorNode root;
  /**
   * The number of levels in the bit tree, n + 1.
   */
  int n;

  /**
   * '0' in ASCII.
   */
  static final int ZERO = 48;

  /**
   * '1' in ASCII.
   */
  static final int ONE = 49;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Bit Tree Constructor.
   *
   * @param n the number of bits
   */
  public BitTree(int n) {
    this.n = n;
    this.root = new BitTreeInteriorNode();
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Checks if the input of bits are of valid length.
   *
   * @param bits String representation of bits
   * @return whether the bits are valid
   */
  private boolean bitsAreValid(String bits) {
    if (bits.length() != n) {
      return false;
    } // if

    for (char c : bits.toCharArray()) {
      if (c != ZERO && c != ONE) {
        return false;
      } // if
    } // for
    return true;
  } // bitsIsValid

  /**
   * @param bits String of bits
   * @return BitTreeLeaf of leaf
   * @throws IndexOutOfBoundsException Invalid String of bits
   */
  private BitTreeLeaf<String> leafAt(String bits) throws IndexOutOfBoundsException {
    if (!bitsAreValid(bits)) {
      throw new IndexOutOfBoundsException("Invalid bits");
    } // if

    BitTreeNode node = root;

    for (int i = 0; i < n - 1; i++) {
      char bit = bits.charAt(i);
      if (bit == ZERO) {
//        Makes left node if it does not already exist
        if (((BitTreeInteriorNode) node).left == null) {
          ((BitTreeInteriorNode) node).left = new BitTreeInteriorNode();
        } // if
//        Traverses to left node
        node = ((BitTreeInteriorNode) node).left;
      } else {
//        Makes right node if it does not already exist
        if (((BitTreeInteriorNode) node).right == null) {
          ((BitTreeInteriorNode) node).right = new BitTreeInteriorNode();
        } // if
//        Traverses to right node
        node = ((BitTreeInteriorNode) node).right;
      } // if-else
    } // for

//    processing last bit
    if (bits.charAt(n - 1) == ZERO) {
      if ((BitTreeLeaf<String>) ((BitTreeInteriorNode) node).left == null) {
        ((BitTreeInteriorNode) node).left = new BitTreeLeaf<String>("");
      } // if
      return (BitTreeLeaf<String>) ((BitTreeInteriorNode) node).left;
    } else {
      if ((BitTreeLeaf<String>) ((BitTreeInteriorNode) node).right == null) {
        ((BitTreeInteriorNode) node).right = new BitTreeLeaf<String>("");
      } // if
      return (BitTreeLeaf<String>) ((BitTreeInteriorNode) node).right;
    } // if-else
  } // leafAt(String)

  /**
   * Helper functions to print out BitTree mappings.
   *
   * @param pen  PrintWriter
   * @param node BitTreeNode
   * @param bits String of bits
   */
  @SuppressWarnings("unchecked")
  private void traverse(PrintWriter pen, BitTreeNode node, String bits) {

    if (node instanceof BitTreeLeaf && ((BitTreeLeaf<String>) node).value != null) {
      pen.println(bits + "," + ((BitTreeLeaf<String>) node).value);
    } // if

    if (node instanceof BitTreeInteriorNode && ((BitTreeInteriorNode) node).left != null) {
      traverse(pen, ((BitTreeInteriorNode) node).left, bits + "0");
    } // if

    if (node instanceof BitTreeInteriorNode && ((BitTreeInteriorNode) node).right != null) {
      traverse(pen, ((BitTreeInteriorNode) node).right, bits + "1");
    } // if
  } // traverse

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  /**
   * Assign bits to some String value.
   *
   * @param bits  String of bits mapping
   * @param value String value
   * @throws IndexOutOfBoundsException Invalid String of bits
   */
  public void set(String bits, String value) throws IndexOutOfBoundsException {
    BitTreeLeaf<String> leaf = leafAt(bits);
    leaf.value = value;
  } // set(String, String)

  /**
   * Returns the string value at the assigned bit string.
   *
   * @param bits String of bits mapping
   * @throws IndexOutOfBoundsException Invalid String of bits
   * @return String value encoded in BitTree
   */
  public String get(String bits) throws IndexOutOfBoundsException {
    BitTreeLeaf<String> leaf = leafAt(bits);
    String value = leaf.value;
    if (value == null) {
      throw new RuntimeException("Not in Tree");
    } else {
      return leaf.value;
    } // if-else
  } // get(String, String)I

  /**
   * Prints out the tree values to console.
   *
   * @param pen PrintWriter for printing
   */
  public void dump(PrintWriter pen) {
    traverse(pen, root, "");
  } // dump(PrintWriter)

  /**
   * Reads InputStream to populate tree.
   *
   * @param source InputStream
   */
  public void load(InputStream source) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(source));
    String line;
    try {
      while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        this.set(data[0], data[1]);
      } // while
    } catch (IOException e) {
//      Do Nothing failed read
    } // try-catch
  } // load(InputStream)
} // class BitTree
