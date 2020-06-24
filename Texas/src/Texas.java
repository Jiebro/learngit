

import java.util.Scanner;

public class Texas {
    public String winner;
    public static void main(String[] args){
        String poke1;
        String poke2;
        Scanner sc =new Scanner(System.in);
        poke1 = sc.nextLine();
        poke2 = sc.nextLine();
        String result = rule(poke1,poke2);
        System.out.println(result);

    }


    static String rule(String poke1,String poke2){
        //战斗力:CE(Combat Effectiveness)
        int ce1=0;
        int ce2=0;
        search search =new search();
        //通过利用数值大小进行比较来确定输赢
        //ce1，ce2代表两位游戏玩家
        if(search.haveSameSuit(poke1))
            ce1=5;
        else if(search.haveThree(poke1))
            ce1=4;
        else if(search.haveSameNum2(poke1))
            ce1=3;
        else if (search.haveSameNum(poke1))
            ce1=2;
        else
            ce1=1;
        if(ce1==5&&search.haveStraight(poke1))
            ce1=6;

        if(search.haveSameSuit(poke2))
            ce2=5;
        else if(search.haveThree(poke2))
            ce2=4;
        else if(search.haveSameNum2(poke2))
            ce2=3;
        else if (search.haveSameNum(poke2))
            ce2=2;
        else
            ce2=1;
        if(ce2==5&&search.haveStraight(poke2))
            ce2=6;


        if(ce1>ce2)
            return "Black wins";
        else if (ce1<ce2)
            return "White wins";
        else{
            if(search.findTheBiggestnum(poke1)>search.findTheBiggestnum(poke2))
                return "Black wins";
            else if(search.findTheBiggestnum(poke1)<search.findTheBiggestnum(poke2))
                return "White wins";
            else
                return "Tie";
        }
    }
}

class search {
/*
haveSameSuit用于检测手牌当中是否有相同的花色
 */

    public boolean haveSameSuit(String s) {
        final String[] pokesuit = {"D", "S", "H", "C"};
        int flag = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < s.length(); i++) {
                flag = 0;
                char ch = s.charAt(i);
                if (pokesuit[j].equals(Character.toString(ch))) ;
                {
                    flag++;
                }
                if (flag == 5)
                    return true;

            }
        }

        return false;
    }

    /*
    haveSameNum用于检测是否有相同数字手牌
     */
    public boolean haveSameNum(String s) {
        final String[] pokenum = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q","k","A"};
        int flag = 0;
        for (int j = 0; j < 13; j++) {
            flag = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (pokenum[j].equals(Character.toString(ch))) ;
                {
                    flag++;
                }
                if (flag >= 2)
                    return true;
            }
        }
        return false;
    }

    /*
    haveSameNum2用于检测是否是双对
     */
    public boolean haveSameNum2(String s) {
        final String[] pokenum = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q","k","A"};
        int flag = 0;
        int times=0;
        for (int j = 0; j < 13; j++) {
            flag = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (pokenum[j].equals(Character.toString(ch))) ;
                {
                    flag++;
                }
                if (flag >= 2)
                    times++;
            }
        }
        if(times==2)
            return true;
        else
            return false;
    }

    /*
    findTheBiggestnum适用于当两个玩家手牌的类型相同时找出其中最大的数字
     */
    public int findTheBiggestnum(String s){
        final String[] pokenum = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q","k", "A"};
        int[] num =new int[6];
        int flag = 0;
        for(int j=12;j>=0;j--){
            for(int i =0;i<s.length();i++){
                char ch =s.charAt(i);
                if(pokenum[j].equals(Character.toString(ch))){
                    num[flag]=j;
                    flag++;
                }
            }
        }
        return num[0];
    }

    /*
    haveThere用于检测三条
     */
    public boolean haveThree(String s) {
        final String[] pokenum = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q","k","A"};
        int flag = 0;
        for (int j = 0; j < 13; j++) {
            flag = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (pokenum[j].equals(Character.toString(ch)))
                {
                    flag++;
                }
                if (flag >= 3)
                    return true;
            }
        }
        return false;
    }

    /*
    haveStraight适用于是同花的情况下判断是否是同花顺
     */
    public boolean haveStraight(String s) {
        final String[] pokenum = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q","k","A"};
        int[] num = new int[4];
        int flag = 0;
        for (int j = 0; j < 13; j++) {
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (pokenum[j].equals(Character.toString(ch)))
                {
                    num[flag++] = j;
                }
            }
        }
        int medium;
        for(int i=0;i<4-1;i++){
            for(int j=0;j<4-1-i;j++){
                if(num[j]>num[j+1]){
                    medium=num[j];
                    num[j]=num[j+1];
                    num[j+1]=medium;
                }
            }
        }
        for(int i=0;i<3;i++)
            if((num[i+1]-num[i])!=1)
                return false;
        return true;
    }

}
