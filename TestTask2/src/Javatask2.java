import java.util.Scanner;

public class Javatask2 {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String a[]) {

    int number = 0;

    do {
      try {
        System.out.println("Please Enter a Digit: ");
        number = scanner.nextInt();
        if (number == 0) {
          System.out.print("Program Exit");
          System.exit(0);

        } else {
          System.out.println("Result:" + convertDigitToWord(number));

        }
      } catch (Exception e) {
        System.out.println("Enter Vali1d digit");
      }
    } while (number != 0);
  }

  private static String convertDigitToWord(int number) {
    // Jp note: variable to hold string representation of number
    String words = " ";
    String onesArray[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
        "ninety" };

    if (number == 0) {
      return "zero";
    }

    if (number < 0) {

      String numberStr = "" + number;

      numberStr = numberStr.substring(1);

      return "minus " + convertDigitToWord(Integer.parseInt(numberStr));
    }

    if ((number / 1000) > 0) {
      words += convertDigitToWord(number / 1000) + " thousand ";
      number %= 1000;
    }

    if ((number / 100) > 0) {
      words += convertDigitToWord(number / 100) + " hundred ";
      number %= 100;
    }

    if (number > 0) {

      if (number < 20) {

        words += onesArray[number];
      } else {

        words += tensArray[number / 10];
        if ((number % 10) > 0) {
          words += "-" + onesArray[number % 10];
        }
      }
    }
    return words;

  }

}