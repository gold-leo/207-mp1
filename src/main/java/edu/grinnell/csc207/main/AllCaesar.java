package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * AllCaesar class.
 */
public class AllCaesar {
  /**
   * Main function.
   * @param args
   */
  public static void main(String[] args) {
    PrintWriter errPen = new PrintWriter(System.err, true);
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) {
      errPen.println("Error: Incorrect number of parameters.");
      return;
    } // illegal num of params

    int enc = 2;
    String en = new String("encode");
    String dc = new String("decode");
    if (en.equals(args[0])) {
      enc = 1;
    } else if (dc.equals(args[0])) {
      enc = 0;
    } else {
      errPen.printf("Error: Invalid option: \"%s\"."
          + "Valid options are \"encode\" or \"decode\".", args[0]);
      return;
    } // decrypt or encrypt

    String str = new String(args[1]);
    int strLen = str.length();
    for (int i = 0; i < strLen; i++) {
      int c = CipherUtils.letter2int(str.charAt(i));
      if (c < 0 || c >= CipherUtils.NUM_LETTERS) {
        errPen.println("Error: String contains characters other than lowercase letters.");
        break;
      } // illegal char
    } // iterate

    switch (enc) {
      case 0:
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
        } // iterate
        break;
      case 1:
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
        } // iterate
        break;
      default:
    } // switch

    pen.close();
    errPen.close();
  } // main()
} // AllCaesar()
