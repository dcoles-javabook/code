package javabook.chap3.sect1;

/**
 * Demonstrates escape and Unicode characters.
 *
 * @author Drue Coles
 */
public class StringDemo4 {

   public static void main(String[] args) {
      // escape characters
      System.out.println("*\n**\n***");
      System.out.println("T\tA\tB");
      System.out.println("She said, \"Attack!\"");
      System.out.println("Here is a backslash: \\");

      // Unicode
      String symbols = "\u03c0 \u21c6 \u266c \u222c \u2665 \u2605";
      System.out.println("Some Unicode characters: " + symbols);
   }
}
