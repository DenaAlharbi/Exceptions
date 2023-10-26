import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws TimeFormatException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter time in 24-hour notation: ");
            String input = scanner.nextLine();

            try {
                String output = convertTime(input);
                System.out.println("That is the same as");
                System.out.println(output);
            } catch (TimeFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Try Again:");
                continue;
            } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Invalid input!");
                System.out.println("Try Again:");
                continue;}
            System.out.print("Again? (y/n) ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                break;

            }
            }




        System.out.println("End of program");
    }

    public static String convertTime(String inp) throws TimeFormatException {
        int length = 5;
        if (inp.length() != length) {
            throw new TimeFormatException("Invalid time format!");
        }
        String minute = inp.substring(3, 5);
        String hour = inp.substring(0, 2);
        if (Integer.parseInt(hour) < 0 || Integer.parseInt(hour) > 23 || Integer.parseInt(minute) < 0 || Integer.parseInt(minute) > 59) {
            throw new TimeFormatException("Invalid time format!");
        }
        String sf = "AM";
        if (Integer.parseInt(hour) >= 12) {
            sf = "PM";
            hour = String.valueOf(Integer.parseInt(hour) - 12);
        }
        if (hour.equals("0")) {
            hour = "12";
        }
        return hour + ":" + minute + " " + sf;
    }
}

