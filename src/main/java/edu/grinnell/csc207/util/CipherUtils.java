package edu.grinnell.csc207.util;


/**
 * Utils for all ciphers.
 */
public class CipherUtils {

  /**
   * The number of lowercase letters.
   */
  public static final int NUM_LETTERS = 26;

  /**
   * Remove an element.
   * @param strs
   * @param index
   * @return array with removed element
   */
  public static String[] removeElement(String[] strs, int index) {
    int l = strs.length;
    String[] nStrs = new String[l - 1];
    for (int i = 0, n = 0; i < l; i++) {
      if (i == index) {
        continue;
      } else {
        nStrs[n++] = strs[i];
      } // else
    } // iterate
    return nStrs;
  } // removeElement()

  /**
   * Convert a char to int.
   * @param letter
   * @return int
   */
  public static int letter2int(char letter) {
    return (int) letter - (int) 'a';
  } // letter2int()

  /**
   * Convert an int to char.
   * @param i
   * @return char
   */
  public static char int2letter(int i) {
    return (char) (i + (int) 'a');
  } // int2letter()

  /**
   * Encrypt a character.
   * @param ch
   * @param key
   * @return encrypted char
   */
  private static char charEncrypt(char ch, char key) {
    int n = letter2int(ch);
    n += letter2int(key);
    if (n >= NUM_LETTERS) {
      n -= NUM_LETTERS;
    } // circle
    return int2letter(n);
  } // charEncrypt()

  /**
   * Decrypt a character.
   * @param ch
   * @param key
   * @return decrypted char
   */
  private static char charDecrypt(char ch, char key) {
    int n = letter2int(ch);
    n -= letter2int(key);
    if (n < 0) {
      n += NUM_LETTERS;
    } // circle
    return int2letter(n);
  } // charDecrypt()

  /**
   * Encrypt a caesar string.
   * @param str
   * @param letter
   * @return encrypted string
   */
  public static String caesarEncrypt(String str, char letter) {
    int l = str.length();
    String strEn = new String();
    for (int i = 0; i < l; i++) {
      char ch = charEncrypt(str.charAt(i), letter);
      strEn += ch;
    } // iterate
    return strEn;
  } // caesarEncrypt()

  /**
   * Decrypt a caesar cipher.
   * @param str
   * @param letter
   * @return decrypted cipher
   */
  public static String caesarDecrypt(String str, char letter) {
    int l = str.length();
    String strDc = new String();
    for (int i = 0; i < l; i++) {
      char ch = charDecrypt(str.charAt(i), letter);
      strDc += ch;
    } // iterate
    return strDc;
  } // caesarDecrypt()

  /**
   * Encrypt a vigenere string.
   * @param str
   * @param key
   * @return encrypted cipher
   */
  public static String vigenereEncrypt(String str, String key) {
    int kLen = key.length();
    int sLen = str.length();
    String strEn = new String();
    for (int num = 0; num < sLen; num += kLen) {
      int n = sLen - num;
      if (n > kLen) {
        n = kLen;
      } // check
      for (int i = 0; i < n; i++) {
        char ch = charEncrypt(str.charAt(num + i), key.charAt(i));
        strEn += ch;
      } // check
    } // iterate through string
    return strEn;
  } // vigenereEncrypt()

  /**
   * Decrypt a vigenere cipher.
   * @param str
   * @param key
   * @return decrypted cipher
   */
  public static String vigenereDecrypt(String str, String key) {
    int kLen = key.length();
    int sLen = str.length();
    String strEn = new String();
    for (int num = 0; num < sLen; num += kLen) {
      int n = sLen - num;
      if (n > kLen) {
        n = kLen;
      } // check
      for (int i = 0; i < n; i++) {
        char ch = charDecrypt(str.charAt(num + i), key.charAt(i));
        strEn += ch;
      } // check
    } // iterate through string
    return strEn;
  } // vigenereDecrypt()
} // CipherUtils
