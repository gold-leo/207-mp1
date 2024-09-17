package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 4) {
      System.err.printf("Error: Expected 4 parameters, received %d", args.length);
      return;
    }

    int enc = 2;
    int cae = 2;
    String en = new String("-encode");
    String dc = new String("-decode");
    String ca = new String("-caesar");
    String ve = new String("-vigenere");

    String[] a = new String[3];
    for (int i = 0; i < 4; i++) {
      if (en.equals(args[i])) {
        enc = 1;
        a = CipherUtils.removeElement(args, i);
        break;
      }
      else if (dc.equals(args[i])) {
        enc = 0;
        a = CipherUtils.removeElement(args, i);
        break;
      }
    }
    
    if (enc == 2) {
     System.err.println("Error: No valid action specified.  Legal values are '-encode' and '-decode'");
     return;
    }

    String[] b = new String[2];
    for (int i = 0; i < 3; i++) {
      if (ca.equals(a[i])) {
        cae = 1;
        b = CipherUtils.removeElement(a, i);
        break;
      }
      else if (ve.equals(a[i])) {
        cae = 0;
        b = CipherUtils.removeElement(a, i);
        break;
      }
    }

    if (cae == 2) {
      System.err.println("Error: No valid action specified.  Legal values are '-caesar' and '-vigenere'");
      return;
    }

    for (int num = 0; num < 2; num++) {
      String s = b[num];
      int str_len = s.length();
      for (int i = 0; i < str_len; i++)
    {
      int c = CipherUtils.letter2int(s.charAt(i));
      if (c < 0 || c > 25)
      {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return;
      }
    }
    }

    if (cae == 1) {
      if (b[1].length() != 1) {
        System.err.println("Error: Caesar ciphers require a one-character key");
        return;
      }
      else if (enc == 1) {
        String result = CipherUtils.caesarEncrypt(b[0], b[1].charAt(0));
        pen.println(result);
      }
      else if (enc == 0) {
        String result = CipherUtils.caesarDecrypt(b[0], b[1].charAt(0));
        pen.println(result);
      }
    }
    else if (cae == 0) {
      if (enc == 1) {
        String result = CipherUtils.vigenereEncrypt(b[0], b[1]);
        pen.println(result);
      }
      else if (enc == 0) {
        String result = CipherUtils.vigenereDecrypt(b[0], b[1]);
        pen.println(result);
      }
    }


    pen.close();
  }
}
