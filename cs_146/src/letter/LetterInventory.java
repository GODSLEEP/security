package letter;


/*Zhenxin Wang
CS 145
Lab3: Letter Inventory
24/10/22
*/
public class LetterInventory {
    private int size;
    private int[] elementData;
    private String original;
    public static final int DEFAULT_CAPACITY = 26;

    // constructs an inventory for the given string input, and the
// total count of letters will be recorded
    public LetterInventory(String data) {
        elementData = new int[DEFAULT_CAPACITY];
        data = data.toLowerCase();
        original = data;
        for (int i = 0; i < data.length(); i++) {
            if (Character.isLetter(data.charAt(i))) {
                elementData[data.charAt(i) - 'a']++;
                if (data.charAt(i) == 'q') {
                    elementData['u' - 'a']++;
                }
                size++;
            }
        }
    }

    // return the total number of characters in the inventory
    public int size() {
        return size;
    }

    public String getOriginal() {
        return original;
    }

    // return true if the inventory is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //return the count of given character in the inventory
//IllegalArgumentException when the letter is a non alphabetic letter
    public int get(char letter) {
        if (!Character.isLetter(letter))
            throw new IllegalArgumentException("letter: " + letter);
        return elementData[Character.toLowerCase(letter) - 'a'];
    }

    // return a string of sorted letter of alphabet, surrounded with square brackets
    public String toString() {
        String result = "[";
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            for (int j = 0; j < elementData[i]; j++)
                result += (char) ('a' + i);
        }
        return result + "]";
    }
    //IllegalArgumentException when the letter is a nonalphabetic letter or when it is negative
    public void set(char letter, int value){
        if (!Character.isLetter(letter) || value < 0)
            throw new IllegalArgumentException("letter: " + letter + ", value: " + value);
        size += value - elementData[Character.toLowerCase(letter) - 'a'];
        elementData[Character.toLowerCase(letter) - 'a'] = value;
    }
    //return a LetterInventory object which is the sum of other two LetterInventory objects
    public LetterInventory add(LetterInventory other){
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < DEFAULT_CAPACITY; i++)
            sum.elementData[i] = this.elementData[i] +
                    other.elementData[i];
        sum.size = this.size + other.size;
        return sum;
    }
    // return a LetterInventory object of difference of other two
// null LetterInventory object will be returned if any letter's difference less than 0
    public LetterInventory subtract(LetterInventory other){
        LetterInventory result = new LetterInventory("");
        for (int i = 0; i < DEFAULT_CAPACITY; i++){
            result.elementData[i] = this.elementData[i] -
                    other.elementData[i];
            if (result.elementData[i] < 0)
                return null;
            result.size += result.elementData[i];
        }
        return result;
    }
}