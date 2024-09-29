import java.util.*;

public class A2_Q1 {
	
	public static int[] game(String[][] board){
		int[] result = new int[2];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(Objects.equals(board[i][j], "o")){
					result[0] ++;
				}
			}
		}

		if(result[0] <= 1){
			return result;
		}


		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j].equals("o")){


					if(up(board,i,j)){  // move up
						String[][] bo = cloneArray(board);
						int[] tmp = {result[0],0};
						upJump(bo,i,j);
						tmp[1] += 1;
						int[] re = game(bo);
						tmp[0] = re[0];
						tmp[1] += re[1];
						if(result[0] > tmp[0]){
							result[0] = tmp[0];
							result[1] = tmp[1];
						}
					}

					if(down(board,i,j)){  // move down
						String[][] bo = cloneArray(board);
						int[] tmp = {result[0],0};
						downJump(bo,i,j);
						tmp[1] += 1;
						int[] re = game(bo);
						tmp[0] = re[0];
						tmp[1] += re[1];
						if(result[0] > tmp[0]){
							result[0] = tmp[0];
							result[1] = tmp[1];
						}
					}

					if(left(board,i,j)){  // move left
						String[][] bo = cloneArray(board);
						int[] tmp = {result[0],0};
						leftJump(bo,i,j);
						tmp[1] += 1;
						int[] re = game(bo);
						tmp[0] = re[0];
						tmp[1] += re[1];
						if(result[0] > tmp[0]){
							result[0] = tmp[0];
							result[1] = tmp[1];
						}
					}

					if(right(board,i,j)){  // move right
						String[][] bo = cloneArray(board);
						int[] tmp = {result[0],0};
						rightJump(bo,i,j);
						tmp[1] += 1;
						int[] re = game(bo);
						tmp[0] = re[0];
						tmp[1] += re[1];
						if(result[0] > tmp[0]){
							result[0] = tmp[0];
							result[1] = tmp[1];
						}
					}


				}
			}
		}

		return result;

	}


	public static void upJump(String[][] bo, int a, int b){
		bo[a-2][b] = "o";
		bo[a-1][b] = ".";
		bo[a][b] = ".";
	}

	public static void downJump(String[][] bo, int a, int b){
		bo[a+2][b] = "o";
		bo[a+1][b] = ".";
		bo[a][b] = ".";
	}

	public static void leftJump(String[][] bo, int a, int b){
		bo[a][b-2] = "o";
		bo[a][b-1] = ".";
		bo[a][b] = ".";
	}

	public static void rightJump(String[][] bo, int a, int b){
		bo[a][b+2] = "o";
		bo[a][b+1] = ".";
		bo[a][b] = ".";
	}


	public static boolean up(String[][] board,int a,int b){
		if(a >= 2){
			return board[a-1][b].equals("o") && board[a-2][b].equals(".");
		}
		return false;
	}

	public static boolean down(String[][] board,int a,int b){
		if((a+2) <= (board.length - 1)){
			return board[a+1][b].equals("o") && board[a+2][b].equals(".");
		}
		return false;
	}

	public static boolean left(String[][] board,int a,int b){
		if(b >= 2){
			return board[a][b-1].equals("o") && board[a][b-2].equals(".");
		}
		return false;
	}

	public static boolean right(String[][] board,int a,int b){
		if((b+2) <= (board[0].length - 1)){
			return board[a][b+1].equals("o") && board[a][b+2].equals(".");
		}
		return false;
	}


	public static String[][] cloneArray(String[][] arr){
		String[][] arr2 = new String[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i].clone();
		}
		return arr2;
	}



}
