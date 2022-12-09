package Calendar;

// 1/12/20
// CS 140
// Assignment #3 - Calendar Part 3
// A further improved version of the calendar program, with the ability to add events and print the calendar into a file.
import java.util.*;
import java.io.*;
public class Mycalendar {
    public static final int SIZE = 15; // Class constant; used to modify size of calendar
    public static String[][] eventsPrint = new String[13][]; // Array to store events
    public static int today = 1; // Value for today's date
    public static final int firstDay = 2; // First day of the month

    public static void main(String[]args) throws FileNotFoundException {

        Scanner console = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out);

        for (int i = 0; i < 12; i++) {
            eventsPrint[i] = new String[totalMonthDays(i + 1)];
        }

        blankSpaces(eventsPrint);
        fileInput(scanFile());


        String command = printMenu(console);
        int month = 0;
        int day = -1;
        String date = "";

        if (command.equals("n") || command.equals("p")) { // checks if user has already entered the commands necessary
            while (command.equals("n") || command.equals("p")) {
                System.out.println("Please print a calendar first!");
                command = printMenu(console);
            }
        }

        while (!command.equals("q")) {
            Calendar name = Calendar.getInstance();
            if(command.equals("t")) { //today's date
                today = name.get(Calendar.DATE);
                month = drawMonth(name.get(Calendar.MONTH) + 1);
                displayDate(name.get(Calendar.MONTH) + 1, today);
            } else if (command.equals("e")) { // to enter date
                month = getDate(console);
            } else if (command.equals("n")) { // next month
                if (month == 12) {
                    month = 0;
                }
                month++;
                month = drawMonth(month);
                displayDate(month, today);
            } else if (command.equals("p")) { // previous month
                if (month == 1) {
                    month = 13;
                }
                month--;
                month = drawMonth(month);
                displayDate(month, today);
            } else if (command.equals("ev")) { // to enter event
                printFromFile(eventsPrint);
            } else if (command.equals("fp")) { // to print calendar onto file
                drawMonth(printOntoFile(console));
                System.setOut(ps);
            }

            String input = printMenu(console);
            command = input;

        }
        Calendar name = Calendar.getInstance();
    }
    // Determines if calendarEvents.txt exists
    public static String scanFile()throws FileNotFoundException {
        File f = new File("calendarEvents.txt");
        String file = "calendarEvents.txt";
        if (!f.exists()) {
            f = new File("blank.txt");
            file = "blank.txt";
        }
        return file; // returns the filename to main
    }
    // Scans the file for any events
    public static void fileInput(String file) throws FileNotFoundException
    { //filename passed from main

        int month = 0;
        int day = 0;
        String space = "";

        File f = new File(file);
        Scanner fconsole = new Scanner(f);

        for (int i = 1; i <= 8; i++) {
            while (fconsole.hasNextLine()) {
                String input = fconsole.nextLine();
                Scanner lscan = new Scanner(input);
                while (lscan.hasNext()) {
                    String date = lscan.next();
                    space = lscan.next();
                    String scanmonth = date.substring(0, 2);
                    month = Integer.parseInt(scanmonth);
                    String scanday = date.substring(3, 5);
                    day = Integer.parseInt(scanday);
                }
                eventsPrint[month - 1][day - 1] = space;
            }
        }
    }
    // Replaces any null values in an array to blank spaces
    public static void blankSpaces(String[][] events) throws FileNotFoundException{
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < totalMonthDays(i+1); j++) {
                events[i][j] = "";
            }
        }

    }


    // Allows user to put their own events inside the calendar
    public static void printFromFile(String[][] eventsPrint) throws FileNotFoundException { // accepts array as parameter
        int day = 0;
        int month = 0;
        String event = "";

        Scanner fconsole = new Scanner(System.in);
        System.out.print("Date (MM/DD) ");
        String date = fconsole.next();
        String scanmonth = date.substring(0,2);
        String scanday = date.substring(3,5);
        month = Integer.parseInt(scanmonth);
        day = Integer.parseInt(scanday);
        System.out.print("Event (Like_This) ");
        event = fconsole.next();

        eventsPrint [month - 1][day - 1] = event;

    }
    // Prints a month's calendar onto a file
    public static int printOntoFile(Scanner console) throws FileNotFoundException { // scanner as parameter
        System.out.println("Which month would you like to print? ");
        int month = console.nextInt();
        System.out.println("What name would you like to give to the file the month prints to? ");
        PrintStream out = new PrintStream(console.next());
        System.setOut(out);
        return month; // returns month so we know what value the user entered
    }

    // Prints the menu, uses scanner to record input
    public static String printMenu(Scanner console) throws FileNotFoundException{
        System.out.println("Please type in a command.");
        System.out.println(" \"e\" to enter a date and display the corresponding calendar");
        System.out.println(" \"t\" to get today's date and display today's calendar");
        System.out.println(" \"n\" to display the next month");
        System.out.println(" \"p\" to display the previous month");
        System.out.println(" \"ev\" to enter an event");
        System.out.println(" \"fp\" to print a calendar to a file");
        System.out.println(" \"q\" to quit the program");
        return console.next(); // returns user's choice to main

    }

    // Asks user what date they would like to view, uses scanner to record input
    public static int getDate(Scanner console)throws FileNotFoundException {
        System.out.print("What date would you like to look at? (dd/mm) ");
        String date = console.next();
        int month = monthFromDate(date);
        int day = dayFromDate(date);
        today = day;
        drawMonth(month);
        displayDate(month, day);
        return month; // returns user's choice to main
    }

    // Gets today's date
    public static String getToday() {
        String date = "";
        Calendar today = Calendar.getInstance();
        date += (today.get(Calendar.MONTH)) + 1;
        date += "/" + today.get(Calendar.DATE);
        return date; // Returns date value
    }

    // Draws a full month based on a full set of drawRow methods, with row no.set as parameter

    public static int drawMonth(int month) {

        drawArt();
        int finalDate = totalMonthDays(month);
        int sixthRow = 0;
        for (int j = 1; j <= 1; j++) {
            for (int i = 1; i <= SIZE * 7 / 2; i++) {
                System.out.print(" ");
            }
            System.out.println(month);
        }

        for (int i = 1; i <= 5; i++) {
            sixthRow = drawRow(i, month);
        }

        if (sixthRow < finalDate) {
            for (int i = 1; i <= 1; i++) {
                drawRow(6, month);
            }
        }
        for (int i = 1; i <= 1; i++) {
            for (int j = 1; j <= SIZE * 7; j++) {
                System.out.print("=");
            }
        }
        System.out.println();
        return month; // Returns the processed month value

    }

    // Draws a row of the calendar

    public static int drawRow(int row, int month) { // row to determine size, month to call other methods

        int endDate = totalMonthDays(month);
        int lastDay = 0;
        for (int i = 1; i <= 1; i++) {
            for (int j = 1; j <= SIZE * 7; j++) {
                System.out.print("=");
            }
            System.out.println();
        }


        int weekday = getWeekday(month);
        if (row == 1) {
            for (int i = 1; i <= weekday; i++) {
                System.out.print("|");
                for (int j = 1; j <= SIZE - 1; j++) {
                    System.out.print(" ");
                }
            }

            for (int i = row * 7 - 6; i <= row * 7 - weekday; i++) {
                System.out.print("|");
                if (i == today) {
                    System.out.print("*" + extendInt(i, SIZE - 3));
                }
                System.out.print(" ");
                if (i != today) {
                    System.out.print(extendInt(i, SIZE - 2));
                }
            }
            System.out.println("|");

            for (int i = 1; i <= weekday; i++) {
                System.out.print("|");
                for (int j = 1; j <= SIZE-1; j++) {
                    System.out.print(" ");
                }
            }

            for (int i = row * 7 - 6; i <= row * 7 - weekday; i++) {
                System.out.print("|");
                String eventing = eventsPrint[month - 1][i - 1];
                System.out.print(extendString(eventing, SIZE - 1));
            }
            System.out.println("|");

            for (int i=1; i<=SIZE/2-3; i++) {
                for (int j=1; j<=7; j++) {
                    System.out.print("|");
                    for (int s=1; s<=SIZE-1; s++) {
                        System.out.print(" ");
                    }
                }
                System.out.println("|");
            }

        } else if (row <= 6) {

            int dateNumber = row * 7 - 6 - weekday;

            for (int i = dateNumber; i<=row*7-weekday; i++) {
                dateNumber = i;

                System.out.print("|");
                if (dateNumber!=today) {
                    System.out.print(" ");
                }

                if (dateNumber > endDate) {
                    for (int j=1; j<=SIZE-2; j++) {
                        System.out.print(" ");
                    }
                } else {
                    if (i==today) {
                        System.out.print("*" + extendInt(i, SIZE-2));
                    } else if (i!=today) {
                        System.out.print(extendInt(i, SIZE-2));
                        lastDay = i;
                    }
                }

            }

            System.out.println("|");

            for (int i=row*7-6-weekday; i<=row*7-weekday; i++) {
                if (i <= endDate) {
                    System.out.print("|");
                    String eventing = eventsPrint[month - 1][i - 1];
                    System.out.print(extendString(eventing, SIZE - 1));
                } else if (i > endDate) {
                    System.out.print("|");
                    for (int j=1; j<=SIZE-1; j++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("|");

            for (int i=1; i<=SIZE/2-3; i++) {
                for (int n=1; n<=7; n++) {
                    System.out.print("|");
                    for (int j=1; j<=SIZE-1; j++) {
                        System.out.print(" ");
                    }
                }
                System.out.println("|");
            }
        }
        return lastDay; // Returns the last day of the month so program can determine if sixth row is needed
    }
    // Method that allows program to output multiple strings in succession
    // Input is string that user wants printed, and number of times it needs to be printed

    public static void printMultipleTimes(String multi, int howManyTimes) {


        for (int i = 1; i <= howManyTimes; i++) {
            System.out.print(multi);
        }
    }
    // Method that allows single digit and double digit numbers on the calendar to have even spacing

    public static String extendInt(int j, int width) {

        String extended = j + " ";
        for(int i = extended.length(); i < width; i++) {
            extended = extended + " ";
        }
        return extended;
    }

    // Same method as above, but for String values
    public static String extendString(String j, int width) { // String and width desired
        String extended = j + " ";
        for(int i = extended.length(); i < width; i++) {
            extended = extended + " ";
        }
        return extended;
    }

    // Displays month and date values below the calendar
    public static void displayDate(int month, int day) { // accepts day and month parameters

        System.out.print("Month: ");
        System.out.print(month);

        System.out.println();

        System.out.print("Day: ");
        System.out.print(day);

        System.out.println();

    }

    // Draws the calendar art
    public static void drawArt() {

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= (4*4) - 4 * i; j++) {
                System.out.print("\\");
            }
            for (int j = 1; j <= 8 * i - 8; j++) {
                System.out.print("-");
            }
            for (int j = 1; j <= (4*4) - 4 * i; j++) {
                System.out.print("/");
            }
            System.out.println();
        }

    }

    // Returns the date of user input as an int
    public static int monthFromDate(String date) {

        int index = date.indexOf("/");
        String month = date.substring(0, index);
        return Integer.parseInt(month); // Returns the user's choice as an int


    }
    // Returns the month of user input as an int
    public static int dayFromDate(String date) {

        int index = date.indexOf("/");
        String day = date.substring(index + 1);
        return Integer.parseInt(day); // Returns the user's choice as an int

    }
    // Sums up the number of days in each month
    public static int getTotalDays (int month) { // month
        int totalDays = 1;
        int daysInMonth = 0;
        if (month == 1) {
            totalDays = 1;
        } else {
            for (int i = 0; i <= month; i++) {
                daysInMonth = totalMonthDays(i);
                totalDays += daysInMonth;
            }
        }
        return totalDays; // Returns the total amount of days in the month
    }
    // Gets the weekday the first day of the month starts on
    public static int getWeekday (int month) {
        int totalDay = getTotalDays(month);
        int weekday = (firstDay + totalDay) % 7;

        return weekday; // returns the cell value

    }
    // Determines the amount of days in a month based on the month
    public static int totalMonthDays (int month) {

        int daysInMonth = 0;

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            daysInMonth = 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            daysInMonth = 30;
        } else if (month == 2) {
            daysInMonth = 28;
        }
        return daysInMonth; // Returns the specified value
    }






    // special thanks to schuyler for helping me out




}
