package javabook.chap3.sect1;

/**
 * Demonstrates escape sequences and Unicode characters.
 *
 * @author Drue Coles
 */
public class StringDemo4 {

   public static void main(String[] args) {
      System.out.println("SLUBBERDEGULLION");
      System.out.println("SLUB\tBERD\nEGUL\tLION");

      System.out.println("She said, \"Attack!\"");

      System.out.println("Slash: /");
      System.out.println("Backslash: \\");

      String symbols = "\u03c0 \u21c6 \u266c \u222c \u2665 \u2605";
      System.out.println("Unicode: " + symbols);
   }
}
