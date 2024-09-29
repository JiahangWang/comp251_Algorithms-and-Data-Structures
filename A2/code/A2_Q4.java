import java.math.BigInteger;

public class A2_Q4 {

	public static String mod_fibonacci(int N, BigInteger K) {
		BigInteger[] f = new BigInteger[N];
		putNTerm(f,N);
		return judge(N,K,f);
	}


	public static String judge(int N, BigInteger K, BigInteger[] f){
		String result;
		if(N == 1){ // 初始情况
			result = "X";
		}
		else if(N == 2){
			result = "Y";
		}
		else {  //递归
			BigInteger pre2 = f[N - 3];
			if(K.compareTo(pre2) > 0){
				result = judge(N-1,K.subtract(pre2),f);
			}
			else {
				result = judge(N-2,K,f);
			}
		}
		return result;
	}



	public static void putNTerm(BigInteger[] f, int n){
		if(f.length == 1){
			f[0] = BigInteger.valueOf(1);
		}
		else if(f.length == 2){
			f[0] = BigInteger.valueOf(1);
			f[1] = BigInteger.valueOf(1);
		}
		else {
			f[0] = BigInteger.valueOf(1);
			f[1] = BigInteger.valueOf(1);
			for(int i = 2;i < n ;i ++){
				f[i] = f[i - 1].add(f[i - 2]);
			}
		}
	}

//	public static BigInteger nTerm(int n){
//		double result = (1 / (Math.sqrt(5))) * (Math.pow(((1 + Math.sqrt(5)) / 2),n) - Math.pow(((1 - Math.sqrt(5)) / 2),n));
//		return BigInteger.valueOf((long) result);
//	}
	
	public static void main(String[] args) {

//		System.out.println(putNTerm(3));

//		for (int i = 1; i <= 7; i++) {
//			for (int j = 1; j <= nTerm(i).intValue(); j++) {
//				System.out.print(mod_fibonacci(i,BigInteger.valueOf(j)));
//			}
//			System.out.println();
//		}

		System.out.println(mod_fibonacci(7777,new BigInteger("474150155627499133")));
//		System.out.println(mod_fibonacci(1,new BigInteger("1")));
	}

}
