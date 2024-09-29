import java.util.Random;

public class test_Q2 {
    public static void main(String[] args) {

//        int[] plates = {900,500,498,4};
//        int[] plates = {4,498,500,900,11,3};

        int[] plates = new int[1000];
        for (int i = 0; i < plates.length; i++) {
            plates[i] = generateRandom(1,300,-1);
        }

        long start= System.currentTimeMillis();   /**开始时间*/
//        A2_Q2.weight(plates);
        System.out.println("\n" + A2_Q2.weight(plates));
        System.out.println("-----------程序执行时间为：" + (System.currentTimeMillis() - start) +"毫秒---------------");





    }


    public static int generateRandom(int min, int max, int seed) {
        Random generator = new Random();
        if(seed>=0){
            generator.setSeed(seed);
        }
        int i = generator.nextInt(max-min-1);
        return i+min+1;
    }



}
