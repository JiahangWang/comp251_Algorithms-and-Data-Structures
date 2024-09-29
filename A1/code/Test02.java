import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Test02 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); /*开始时间*/

        int n = 10000000;
        String[] posts = new String[8];

        String[] word = new String[10];


        posts[0] = con("David no no no no nobody never");
        posts[1] = con("Jennifer why ever not");
        posts[2] = con("Parham no not never nobody");
        posts[3] = con("Shishir no never know nobody");
        posts[4] = con("Alvin why no nobody");
        posts[5] = con("Alvin nobody never know why nobody");
        posts[6] = con("David never no nobody");
        posts[7] = con("Jennifer never never nobody no");

//        word[0] = "David no no no no nobody never";
//        word[1] = "Jennifer why ever not";
//        word[2] = "Parham no not never nobody";
//        word[3] = "Shishir no never know nobody";
//        word[4] = "Alvin why no nobody";
//        word[5] = "Alvin nobody never know why nobody";
//        word[6] = "David never no nobody";
//        word[7] = "Jennifer never never nobody no";
//
//
//        for (int i = 0; i < 10000000; i++) {
//            posts[i] = word[generateRandom(-1,8,-1)];
//        }


        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

//        list = A1_Q3.Discussion_Board(posts); /***/

        for (int i = 0; i < posts.length; i++) {
            if(posts[i] != null && posts[i].length() > 2000000){
                posts[i] = posts[i].substring(0,2000000);
            }
            concate2(posts[i],set);
        }



//        for (int i = 0; i < posts.length; i++) {
//            if(posts[i] != null && posts[i].length() > 2000000){
//                posts[i] = posts[i].substring(0,2000000);
//            }
//            concate1(posts[i],list);
//        }

//        for(String s : list){
//            System.out.println(s);
//        }

//        System.out.println(posts[0]);




        System.out.println("-----------程序执行时间为：" + (System.currentTimeMillis()-start) +"毫秒-----------"); /**结束时间*/

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static int generateRandom(int min, int max, int seed) {
        Random generator = new Random();
        if(seed>=0){
            generator.setSeed(seed);
        }
        int i = generator.nextInt(max-min-1);
        return i+min+1;
    }

    public static void concate1(String message, ArrayList<String> list){
        if(message == null){return;}
        message = message.substring(message.indexOf(" ") + 1);
        int first = 0;  //前指针
        int second = message.indexOf(" ");  //后指针
        while(second != -1 ){
            String word = message.substring(first,second);
            message = message.substring(second + 1);
            list.add(word);
            second = message.indexOf(" ");
        }
        list.add(message);
    }


    public static void concate2(String message, HashSet<String> set){
        if(message == null){return;}
        message = message.substring(message.indexOf(" ") + 1);
        int first = 0;  //前指针
        int second = message.indexOf(" ");  //后指针
        while(second != -1){
            String word = message.substring(first,second);
            message = message.substring(second + 1);
            set.add(word);
            second = message.indexOf(" ");
        }
        set.add(message);
    }

    public static String con(String s){
        String copy = s;
        for (int i = 0; i < 40000; i++) {
            s = s.concat(copy);
        }
        return s;
    }

}
