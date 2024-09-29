import java.util.*;


public class Test_Q3 {


    public static void main(String[] args) {
        
        

        String[] posts = new String[8];

//        String[] word = new String[10];

//        posts[0] = "David no no no no nobody never";
//        posts[1] = "Jennifer why ever not";
//        posts[2] = "Parham no not never nobody";
//        posts[3] = "Shishir no never know nobody";
//        posts[4] = "Alvin why no nobody";
//        posts[5] = "Alvin nobody never know why nobody";
//        posts[6] = "David never no nobody";
//        posts[7] = "Jennifer never never nobody no";

//        posts[0] = "David no no no no nobody never ".repeat(60000);
//        posts[1] = "Jennifer why ever not ".repeat(60000);
//        posts[2] = "Parham no not never nobody ".repeat(60000);
//        posts[3] = "Shishir no never know nobody ".repeat(60000);
//        posts[4] = "Alvin why no nobody ".repeat(60000);
//        posts[5] = "Alvin nobody never know why nobody ".repeat(60000);
//        posts[6] = "David never no nobody ".repeat(60000);
//        posts[7] = "Jennifer never never nobody no ".repeat(60000);

//        posts[0] = "Dav a d b e";
//        posts[1] = "Bob a d b e";
//        posts[2] = "Bll a d b e";
//        posts[3]= "Bill boy cy ca";




//        for (int i = 0; i < 100; i++) {
//            posts[i] = word[generateRandom(-1,8,-1)];
//        }


//        int size = 0;
//
//        for (int i = 0; i < posts.length; i++) {
//            if(posts[i] != null){
//                size += posts[i].length();
//            }
//        }
//        System.out.println("字符的个数为： " + size);



//        posts[0] = "user1 chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp";
//        posts[1] = "user2 chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp";
//        posts[2] = "user3 chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp";
//        posts[3] = "user1 chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp chomp";


//        posts[0] = "James gobble de gook";
//        posts[1] = "Bill gobble";
//        posts[2] = "james de gook";

//        posts[0] = "Villain avast";
//        posts[1] = "Scoundrel ahoy";

//        posts[0] = "user1 doubledutch double double dutch";
//        posts[1] = "user2 dutch doubledutch doubledutch double";
//        posts[2] = "user3 not double dutch doubledutch";



        ArrayList<String> list = new ArrayList<>();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String,Integer> map1 = new HashMap<>();
        HashSet<String> set = new HashSet<>();

//        test_separate(posts[0]);

        list = A1_Q3.Discussion_Board(posts); /***/

        for (String s : list){
            System.out.println(s);
        }




    }



    public static int generateRandom(int min, int max, int seed) {
        Random generator = new Random();
        if(seed>=0){
            generator.setSeed(seed);
        }
        int i = generator.nextInt(max-min-1);
        return i+min+1;
    }


    public static void test_separate(String message){
        long start = System.currentTimeMillis();
        message = message.substring(message.indexOf(" ") + 1); //截取名字后面的字段
        int first = 0;  //前指针
        int second = message.indexOf(" ");  //后指针
        while(second != -1){
            String word = message.substring(first,second);
            first = second + 1;
            second = message.indexOf(" ",second + 1);
        }
        System.out.println("-----------separate程序执行时间为：" + (System.currentTimeMillis()-start) +"毫秒-----------"); /**结束时间*/
    }



}
