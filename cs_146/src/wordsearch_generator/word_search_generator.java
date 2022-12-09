package wordsearch_generator;
import java .util .*;
public class word_search_generator {
    private static int width;
    private static int length;
    private static int wordC;
    private static  ArrayList<String> words;
    private static  int[] positions;
    private static char [][] key;
    private static String input;
    //Begin main
    public static void main(String [] args){
        intro();
        printY();
    }
    public static void intro(){  //introduction
        System .out .println("                              WORD SEARCH GENERATOR");
        System .out .println("This program will generate a word search puzzle. Please enter words to generate the puzzle.");
        System .out .println("when you finished, please enter: run");
        userInput(); //Call all methods to make the puzzle
        size();
        rndm();
    }
    public static void printY(){
        for(int i =0; i <width; i++){
            for(int ind =0; ind<length; ind ++){
                System.out.print(key[i][ind]+ " ");
            }
            System.out.println(" ");
        }
        System .out .println("FIND THESE WORDS");
        for(int i =0; i<wordC; i++){
            System.out.println(words .get(i));
        }
    }
    //method for randomizing where the placement of the words and letters are
    public static void rndm(){
        int a, b;
        int x, y;
        positions = new int[wordC];
        for(int i =0; i < wordC; i++){
            b = words .get(i) .length();
            a = width -b;
            x = randomRange(0, a);
            y = randomRange(0, length-5);
            if(key(positions,  y) ){
                y++;
            }
            positions[i] = y;



            for(int ind =0; ind <b; ind++){
                key[x][y] = words .get(i) .charAt(ind);
                x++;
            }
        }
        for (int i =0; i <length; i ++){
            for (int ind =0; ind< width; ind++){
                if(key[ind][i] == 0){
                    char t = (char) randomRange(97, 122);
                    key[ind][i] = t;
                }
            }
        }
    }
    //method for dictating the length of words for placement in the puzzle
    public static boolean key(int [ ] num, int lock) {
        for (int index = 0; index < num .length; index++){
            if (num[index] == lock ){
                return true;
            }
        }
        return false;
    }
    //random char creator
    public static int randomRange(int min, int max){
        Random generator = new Random();
        return generator .nextInt(max-min+1) + min;
    }
    //method for user input and menu navigation; continuation of the printIntro in the rubric
    public static void userInput(){
        Scanner scan = new Scanner(System.in);
        wordC =0;
        words= new ArrayList<String>();
        System.out.println("USER: please enter the words you would like in this puzzle. Only one word per line." );
        System.out.println("When user has complete the task please enter: run.");
        System.out.println("If user want solution please enter: solution");
        while (scan .hasNextLine()){
            input = scan .next();
            if(input .equals("run")){
                scan .close();
                break;
            }
            else if(input .equals("solution")){
                System .out .println("ADMIN MODE");
                System .out .println("The solution will always be verticaly lined, and will loop from the direct middle of the puzzle, from left to right, bottom to top");
                        scan .close();
                break;
            }
            wordC++;
            words .add(input);
        }
    }
    //this method is similar to the generate function outlined in the rubric
    public static void size(){
        System .out .println("Generating word search");



        int i;
        for(i =0; i<words .size(); i++){
            if(words .get(i) .length() > width){
                width = words .get(i) .length();
            }
        }
        width = width *2;
        length = width + (width/3);
        key = new char [width][length];
    }
}