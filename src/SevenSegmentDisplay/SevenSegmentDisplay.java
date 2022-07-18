package SevenSegmentDisplay;

import java.util.Arrays;

public class SevenSegmentDisplay {

    public static void main(String[] args) {
        sevenSegment("11010111");
        display();
    }
        private static final int[][] sevenSegment = new int[5][4];

        public static void segmentA(){
            Arrays.fill(sevenSegment[0], 1);
        }
        public static void segmentB(){
            sevenSegment[0][3] = 1;
            sevenSegment[1][3] = 1;
            sevenSegment[2][3] = 1;
        }
        public static void segmentC(){
            sevenSegment[2][3] = 1;
            sevenSegment[3][3] = 1;
            sevenSegment[4][3] = 1;
        }
        public static void segmentD(){
            Arrays.fill(sevenSegment[4], 1);
        }
        public static void segmentE(){
            sevenSegment[2][0] = 1;
            sevenSegment[3][0] = 1;
            sevenSegment[4][0] = 1;
        }
        public static void segmentF(){
            sevenSegment[0][0] = 1;
            sevenSegment[1][0] = 1;
            sevenSegment[2][0] = 1;
        }
        public static void segmentG(){
            Arrays.fill(sevenSegment[2], 1);
        }
        public static void display(){
            for (int i = 0; i < sevenSegment.length; i++){
                for (int j = 0; j < sevenSegment[i].length; j++){
                    if (sevenSegment[i][j] == 1)
                        System.out.print("# ");
                    else
                        System.out.print("  ");
                }
                System.out.println();
            }
        }
        public static void sevenSegment(String sevenSegment){
            char[] array = sevenSegment.toCharArray();
            if (array[array.length - 1] == '0') {
                System.out.println("");
                return;
            }
            if (array.length != 8){
                System.out.println("Characters can not be less than or greater than 8");
                return;
            }
            for (char c : array) {
                if (!(c == '1' || c == '0')) {
                    System.out.println("All inputs must be zero or one!");
                    return;
                }
            }
            for (int chr = 0; chr < sevenSegment.length(); chr++) {
                if (sevenSegment.charAt(chr) == '1') {
                    switch (chr) {
                        case 0 -> segmentA();
                        case 1 -> segmentB();
                        case 2 -> segmentC();
                        case 3 -> segmentD();
                        case 4 -> segmentE();
                        case 5 -> segmentF();
                        case 6 -> segmentG();
                    }
                }
            }
        }

}

