package card_game;

public class JudgeNum {

    public int judgeString(String num) {

        String word= num.substring(2);
        if(word.equals("A")) {
            return  1;

        }
        else if(num.substring(2).equals("J")||
                num.substring(2).equals("Q")||
                num.substring(2).equals("K")||
                num.substring(2).equals("10")) {

            return 10;
        }


        else {
            int n=(int)num.substring(2).charAt(0)-48;
            return n;
        }




    }


}
