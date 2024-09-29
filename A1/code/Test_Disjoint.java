public class Test_Disjoint {
    public static void main(String[] args) {
        DisjointSets set = new DisjointSets(6);

        set.union(2,3);
        System.out.println("集合rank = " + set.getSetRank(3));
        set.union(3,4);



//        System.out.println("parent:");
//        for (int i = 0; i < set.par.length; i++) {
//            System.out.println(i + " ---> " + set.par[i]);
//        }
//
//        System.out.println("Rank:");
//        for (int i = 0; i < set.rank.length; i++) {
//            System.out.println(i + " ---> " + set.rank[i]);
//        }

    }
}
