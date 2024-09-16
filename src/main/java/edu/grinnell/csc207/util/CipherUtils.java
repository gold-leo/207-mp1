package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    return (int) letter - (int) 'a';
  }

  private static char int2letter(int i) {
    return (char) (i + (int) 'a');
  }

  private static char charEncrypt(char ch, char key) {
    int n = letter2int(ch);
    n += letter2int(key);
    if (n > 25)
    {
      n -= 26;
    }
    return int2letter(n);
  }

  private static char charDecrypt(char ch, char key) {
    int n = letter2int(ch);
    n -= letter2int(key);
    if (n < 0)
    {
      n += 26;
    }
    return int2letter(n);
  }

  public static String caesarEncrypt(String str, char letter) {
    int l = str.length();
    String str_en = new String();
    for (int i = 0; i < l; i++)
    {
      char ch = charEncrypt(str.charAt(i), letter);
      str_en += ch;
    }
    return str_en;
  }

  public static String caesarDecrypt(String str, char letter) {
    int l = str.length();
    String str_dc = new String();
    for (int i = 0; i < l; i++)
    {
      char ch = charDecrypt(str.charAt(i), letter);
      str_dc += ch;
    }
    return str_dc;
  }

  public static String vigenereEncrypt(String str, String key) {
    int k_len = key.length();
    int s_len = str.length();
    String str_en = new String();
    for (int num = 0; num < s_len; num += k_len)
    {
      int n = s_len - num;
      if (n > k_len)
      {
        n = k_len;
      }
      for (int i = 0; i < n; i++)
      {
        char ch = charEncrypt(str.charAt(num + i), key.charAt(i));
        str_en += ch;
      }
    }
    return str_en;
  }

  public static String vigenereDecrypt(String str, String key) {
    int k_len = key.length();
    int s_len = str.length();
    String str_en = new String();
    for (int num = 0; num < s_len; num += k_len)
    {
      int n = s_len - num;
      if (n > k_len)
      {
        n = k_len;
      }
      for (int i = 0; i < n; i++)
      {
        char ch = charDecrypt(str.charAt(num + i), key.charAt(i));
        str_en += ch;
      }
    }
    return str_en;
  }
}
