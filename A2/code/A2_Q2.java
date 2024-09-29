import java.util.*;

public class A2_Q2 {

	public static int weight_val(int[] plates,int val) {
		int result = 0;
		int length = plates.length;
		HashMap<Integer,HashSet<Integer>> memory = new HashMap<>(); //
//

		for (int i = 1; i <= length ; i++) {  //
			memory.put(i,new HashSet<>());
		}
		memory.get(1).add(plates[0]);


		for (int i = 2; i <= length; i++) {
			for (int j = i; j >= 1; j--) {
				int current = plates[i - 1];
				if(j == 1){
					memory.get(1).add(current);
				}
				else{
					for (Integer pre : memory.get(j - 1)){
						if(pre < 1000){
							if(current + pre == 1000){
								return 1000;
							}
							memory.get(j).add(current + pre);
						}
					}
				}
			}
		}


		Set<Integer> key = memory.keySet();
		for(Integer keys : key){
			for(Integer num : memory.get(keys)){
				if(better(result,num,val) == num){
					result = num;
				}
			}
		}


		return result;
	}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static int weight(int[] plates) {
		return weight_val(plates,1000);
	}




	public static int better(int a, int b,int num){
		int x = Math.abs(num - a);
		int y = Math.abs(num - b);
		if(x == y){
			return Math.max(a, b);
		}
		else if(x < y){
			return a;
		}
		else return b;
	}





}
