package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    PrintWriter err_pen = new PrintWriter(System.err, true);
    PrintWriter pen = new PrintWriter(System.out, true);
    
    int arg_len = 0;
    for (String s : args)
    {
      arg_len++;
    }
    if (arg_len != 2)
    {
      err_pen.println("Error: Incorrect number of parameters.");
      return;
    }

    int enc = 2;
    String en = new String("encode");
    String dc = new String("decode");
    if (en.equals(args[0]))
    {
      enc = 1;
    }
    else if (dc.equals(args[0]))
    {
      enc = 0;
    }
    else
    {
      err_pen.printf("Error: Invalid option: \"%s\". Valid options are \"encode\" or \"decode\".", args[0]);
      return;
    }

    String str = new String(args[1]);
    int str_len = str.length();
    for (int i = 0; i < str_len; i++)
    {
      int c = CipherUtils.letter2int(str.charAt(i));
      if (c < 0 || c > 25)
      {
        err_pen.println("Error: String contains characters other than lowercase letters.");
        break;
      }
      
    }

    switch(enc) {
      case 0:
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
        }
        break;
      case 1:
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
        }
        break;
    }
    
    pen.close();
    err_pen.close();
  }
}
