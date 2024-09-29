public class test_Q1 {

    String[][] board = new String[5][9];

    public static void main(String[] args) {
        String[][] board = new String[5][9];

        board[0] = new String[]{"#","#","#",".",".",".","#","#","#"};
        board[1] = new String[]{".",".","o","o",".",".",".",".","."};
        board[2] = new String[]{".",".",".",".",".","o","o",".","."};
        board[3] = new String[]{".",".",".",".",".",".",".",".","."};
        board[4] = new String[]{"#","#","#",".",".",".","#","#","#"};

        int[] result = A2_Q1.game(board);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

//        int[] l1 = new int[5];
//        int[] l2 = l1.clone();
//
//        add(l2);
//
//        for(int i : l1){
//            System.out.print(i);
//        }
//
//        System.out.println();
//
//        for(int i : l2){
//            System.out.print(i);
//        }


    }

    public static void add(int[] arr){
        arr[2] += 1;
    }

}
