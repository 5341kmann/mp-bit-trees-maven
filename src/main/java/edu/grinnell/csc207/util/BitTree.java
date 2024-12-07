package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length
 * sequences of bits and corresponding values.
 *
 * @author Grant Sackmann
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * root of bit tree
   */
  private BitTreeNode root;
  /**
   * The number of levels in the bit tree, n + 1.
   */
  int n;

  final int ZERO = 48;

  final int ONE = 49;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Bit Tree Constructor.
   * @param n the number of bits
   */
  public BitTree(int n) {
    this.n = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Checks if the input of bits are of valid length.
   * @param bits String representation of bits
   * @return whether the bits are valid
   */
  private boolean bitsIsValid(String bits){
    if(bits.length() != n){
      return false;
    } // if

    for(char c : bits.toCharArray()){
      if (c != ZERO && c != ONE){
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
  private BitTreeLeaf<String> leafAt(String bits) throws IndexOutOfBoundsException{
    if (!bitsIsValid(bits)) {
      throw new IndexOutOfBoundsException("Invalid bits");
    } // if

    BitTreeNode node = root;
    for (char bit : bits.toCharArray()) {
      if (bit == ZERO) {
        if()
      } // if
    } // for
  }
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


  /**
   * Assign bits to some String value
   * @param bits String of bits mapping
   * @param value String value
   * @throws IndexOutOfBoundsException Invalid String of bits
   */
  public void set(String bits, String value) throws IndexOutOfBoundsException {

  } // set(String, String)

  /**
   *
   */
  public String get(String bits) throws IndexOutOfBoundsException {
    if(!bitsIsValid(bits)){
      throw new IndexOutOfBoundsException();
    } // if
    return "";  // STUB
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    // STUB
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)

} // class BitTree
