import java.math.BigInteger;

public class A2_Q4_trick {

	public static String mod_fibonacci(int N, BigInteger K) {
		String result;
		BigInteger pre2 = nTerm(N-2);
		if(N == 1){ // 初始情况
			result = "X";
		}
		else if(N == 2){
			result = "Y";
		}
		else {  //递归
			if(K.compareTo(pre2) > 0){
				result = mod_fibonacci(N-1,K.subtract(pre2));
			}
			else {
				result = mod_fibonacci(N-2,K);
			}
		}
		return result;
	}



//	public static BigInteger putNTerm(int n){
//		if(n <= 2){
//			return BigInteger.valueOf(1);
//		}
//		BigInteger[] f = new BigInteger[n];
//		f[0] = BigInteger.valueOf(1);
//		f[1] = BigInteger.valueOf(1);
//		for(int i = 2;i < n ;i ++){
//			f[i] = f[i - 1].add(f[i - 2]);
//		}
//		return f[n - 1];
//	}

	public static BigInteger nTerm(int n){
		double result = (1 / (Math.sqrt(5))) * (Math.pow(((1 + Math.sqrt(5)) / 2),n) - Math.pow(((1 - Math.sqrt(5)) / 2),n));
		return BigInteger.valueOf((long) result);
	}
	
	public static void main(String[] args) {


//		System.out.println(putNTerm(3));

		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= nTerm(i).intValue(); j++) {
				System.out.print(mod_fibonacci(i,BigInteger.valueOf(j)));
			}
			System.out.println();
		}

//		System.out.println(mod_fibonacci(7777,new BigInteger("474150155627499133")));


	}

}
