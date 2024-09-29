public class Test_Hash {

    public static void main(String[] args) {


        Open_Addressing opa = new Open_Addressing(10,0,-1);

//        int[] array = new int[10];
//        for (int i = 0; i < 10; i++) {
//            array[i] = Open_Addressing.generateRandom(1,100,-1);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("collision = " + opa.insertKey(array[i]));
//        }


        System.out.println("collision = " + opa.insertKey(69));
        System.out.println("collision = " + opa.insertKey(89));
        System.out.println("collision = " + opa.insertKey(109));
        System.out.println("collision = " + opa.insertKey(129));
//        System.out.println("删除collision = " + opa.removeKey(109));
        System.out.println("删除collision = " + opa.removeKey(69));
//        System.out.println("删除collision = " + opa.removeKey(89));
//        System.out.println("删除collision = " + opa.removeKey(109));
        System.out.println("删除collision = " + opa.removeKey(129));



        for (int i = 0; i < opa.Table.length; i++) {
            System.out.println(opa.Table[i]);
        }

    }
}
