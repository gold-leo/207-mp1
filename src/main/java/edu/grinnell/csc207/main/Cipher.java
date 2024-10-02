package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * Cipher class.
 */
public class Cipher {
  /**
   * The permitted size of the args array.
   */
  private static final int ARGS_SIZE = 4;

  /**
   * Main function.
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != ARGS_SIZE) {
      System.err.printf("Error: Expected 4 parameters, received %d", args.length);
      return;
    } // length check

    int enc = 2;
    int cae = 2;
    String en = new String("-encode");
    String dc = new String("-decode");
    String ca = new String("-caesar");
    String ve = new String("-vigenere");

    String[] a = new String[ARGS_SIZE - 1];
    for (int i = 0; i < ARGS_SIZE; i++) {
      if (en.equals(args[i])) {
        enc = 1;
        a = CipherUtils.removeElement(args, i);
        break;
      } else if (dc.equals(args[i])) {
        enc = 0;
        a = CipherUtils.removeElement(args, i);
        break;
      } // decrypt call
    } // iterate

    if (enc == 2) {
      System.err.printf("Error: No valid action specified.  "
          + "Legal values are '-encode' and '-decode'");
      return;
    } // no encode or decode call

    String[] b = new String[2];
    for (int i = 0; i <= 2; i++) {
      if (ca.equals(a[i])) {
        cae = 1;
        b = CipherUtils.removeElement(a, i);
        break;
      } else if (ve.equals(a[i])) {
        cae = 0;
        b = CipherUtils.removeElement(a, i);
        break;
      } // check for action call (vig)
    } // iterate

    if (cae == 2) {
      System.err.printf("Error: No valid action specified.  "
          + "Legal values are '-caesar' and '-vigenere'");
      return;
    } // check if action call

    for (int num = 0; num < 2; num++) {
      String s = b[num];
      int strLen = s.length();
      for (int i = 0; i < strLen; i++) {
        int c = CipherUtils.letter2int(s.charAt(i));
        if (c < 0 || c >= CipherUtils.NUM_LETTERS) {
          System.err.printf("Error: String contains characters other than lowercase letters.");
          return;
        } // illegal char check
      } // iterate
    } // iterate

    if (cae == 1) {
      if (b[1].length() != 1) {
        System.err.printf("Error: Caesar ciphers require a one-character key");
        return;
      } else if (enc == 1) {
        String result = CipherUtils.caesarEncrypt(b[0], b[1].charAt(0));
        pen.printf(result);
      } else if (enc == 0) {
        String result = CipherUtils.caesarDecrypt(b[0], b[1].charAt(0));
        pen.printf(result);
      } // if decrypt
    } else if (cae == 0) {
      if (b[1].length() < 1) {
        System.err.printf("Error: Invalid key");
        return;
      } // if key length smaller than 1
      if (enc == 1) {
        String result = CipherUtils.vigenereEncrypt(b[0], b[1]);
        pen.printf(result);
      } else if (enc == 0) {
        String result = CipherUtils.vigenereDecrypt(b[0], b[1]);
        pen.printf(result);
      } // if decrypt
    } // if vigenere

    pen.close();
  } // main
} // Cipher()
