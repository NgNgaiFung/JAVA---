import java.util.Scanner;

// This is an Tic-Tac-Toe game (console)
// Author: Ng Ngai Fung

public class Main {

    // Print function
    public static String printlist(int a, int b, char[][] map){
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
        return "array has been printed";
    }

    // Input function
    public static String input(int player, char[][] map, int width, int length){
        Scanner read = new Scanner(System.in);
        int input_x = -1;
        int input_y = -1;
        try{
            while (input_x < 0 || input_x > (width-1)){
                System.out.print("Please enter value x:");
                int x = Integer.parseInt(read.nextLine());
                input_x = x;
            }
            while (input_y < 0 || input_y > (length-1)){
                System.out.print("Please enter value y:");
                int y = Integer.parseInt(read.nextLine());
                input_y = y;

            }
        } catch(Exception e){
            System.out.println("Something went wrong.");
            input(player, map, width, length);
        } finally {
            System.out.println("Input_x:" + input_x);
            System.out.println("Input_y:" + input_y);
            if (map[input_y][input_x] == '-'){
                if (player == 1){
                    map[input_y][input_x] = 'O';
                }else{
                    map[input_y][input_x] = 'X';
                }
            }else{
                System.out.println("Please retry!");
                input(player, map, width, length);
            }
        }
        return "Insert successfully!";
    }

    
    public static int winloss(char[][] map, int width, int height, int condition, int win){
        for (int x = 0; x < (width - condition + 1); x++){
            for (int y = 0; y < (height - condition + 1); y++){
                
                // horizon
                int countO = 0;
                int countX = 0;
                for (int k = 0; k < condition; k++){
                    if (map[y+k][x] == 'O'){
                        countO++;
                    }
                    if (countO == condition){
                        win = 1;
                        return win;
                    }
                    if (map[y+k][x] == 'X'){
                        countX++;
                    }
                    if (countX == condition){
                        win = 2;
                        return win;
                    }
                }

                // vertical
                countO = 0;
                countX = 0;
                for (int k = 0; k < condition; k++){
                    if (map[y][x+k] == 'O'){
                        countO++;
                    }
                    if (countO == condition){
                        win = 1;
                        return win;
                    }
                    if (map[y][x+k] == 'X'){
                        countX++;
                    }
                    if (countX == condition){
                        win = 2;
                        return win;
                    }
                }

                // slide up
                countO = 0;
                countX = 0;
                for (int k = 0; k < condition; k++){
                    if (map[y+( condition - 1 )-k][x+k] == 'O'){
                        countO++;
                    }
                    if (countO == condition){
                        win = 1;
                        return win;
                    }
                    if (map[y+( condition - 1 )-k][x+k] == 'X'){
                        countX++;
                    }
                    if (countX == condition){
                        win = 2;
                        return win;
                    }
                }

                // slide down
                countO = 0;
                countX = 0;
                for (int k = 0; k < condition; k++){
                    if (map[y+k][x+k] == 'O'){
                        countO++;
                    }
                    if (countO == condition){
                        win = 1;
                        return win;
                    }
                    if (map[y+k][x+k] == 'X'){
                        countX++;
                    }
                    if (countX == condition){
                        win = 2;
                        return win;
                    }
                }
            }
        }
        win = 0;
        return win;
    }
        

    

        // for (int x = 0; x < (condition - width + 1); x++){
        //     for (int y = 0; y < (condition - height + 1); y++){
        //         int count = 0;
        //         for (int k = 0; k < condition; k++){
        //             if (map[y+k][x] == 'X'){
        //                 count++;
        //             }
        //             if (count == condition){
        //                 win = 2;
        //                 return win;
        //             }
        //         } // horizon
        //         count = 0;
        //         for (int k = 0; k < condition; k++){
        //             if (map[y][x+k] == 'X'){
        //                 count++;
        //             }
        //             if (count == condition){
        //                 win = 2;
        //                 return win;
        //             }
        //         } // vertical

        //         count = 0;
        //         for (int k = 0; k < condition; k++){
        //             if (map[y+2-k][x+k] == 'X'){
        //                 count++;
        //             }
        //             if (count == condition){
        //                 win = 2;
        //                 return win;
        //             }
        //         } // slide up

        //         count = 0;
        //         for (int k = 0; k < condition; k++){
        //             if (map[y+k][x+k] == 'X'){
        //                 count++;
        //             }
        //             if (count == condition){
        //                 win = 2;
        //                 return win;
        //             }
        //         } // slide up
        //     }
        // }

    public static String checkwhowin(int win) {
        if (win == 1) {
            return "Player one win the game!";
        } else if (win == 2) {
            return "Player two win the game!";
        } else {
            return "no one win the game";
        }
    }

    public static char[][] initial(char[][] map, int width, int height){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                map[i][j] = '-';
            }
        }
        return map;
    }

    public static void main(String[] args){
        final int width = 5;
        final int height = 5;
        int win = 0; // who winning this game
        int condition = 3; // what is the condition of winning
        int player = 1;
        char [][] map = new char [width][height];
        map = initial(map, width, height);
        printlist(width, height, map);
        int Counttimes = 0;
        System.out.println(win);
    while (win == 0 && Counttimes < condition*condition){
            player = 1;
            input(player, map, width, height);
            printlist(width, height, map);
            win = winloss(map, width, height, condition, win);
            Counttimes++;
            System.out.println("Counttimes:" + Counttimes + "win:" + win);
            if (win != 0 || Counttimes == condition*condition){
                break;
            }
            player = 2;
            input(player, map, width, height);
            printlist(width, height, map);
            win = winloss(map, width, height, condition, win);
            Counttimes++;
            System.out.println("Counttimes:" + Counttimes + "win:" + win);
            if (win != 0 || Counttimes == condition*condition){
                break;
            }
        }
        System.out.println(checkwhowin(win));
    }
}
