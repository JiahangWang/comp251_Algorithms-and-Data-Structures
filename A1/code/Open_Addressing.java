import java.io.*;
import java.util.*;

public class Open_Addressing {
     public int m; // number of SLOTS AVAILABLE
     public int A; // the default random number
     int w;
     int r;
     public int[] Table;

     protected Open_Addressing(int w, int seed, int A) {

         this.w = w;
         this.r = (int) (w-1)/2 +1;
         this.m = power2(r);
         if (A==-1){
            this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
         }
        else{
            this.A = A;
        }
         this.Table = new int[m];
         for (int i =0; i<m; i++) {
             Table[i] = -1;
         }


     }
     
                 /** Calculate 2^w*/
     public static int power2(int w) {
         return (int) Math.pow(2, w);
     }
     public static int generateRandom(int min, int max, int seed) {     
         Random generator = new Random(); 
                 if(seed>=0){
                    generator.setSeed(seed);
                 }
         int i = generator.nextInt(max-min-1);
         return i+min+1;
     }


        /**Implements the hash function g(k)*/
        public int probe(int key, int i) {
            int h = ((A * key) % power2(w)) >> (w - r);
            return (h + i) % power2(r);
        }


    /**判断输入的slot是否为0*/
    public boolean isEmpty(int slot){
            return (Table[slot] <= -1);
        }
     
     
     /**Inserts key k into hash table. Returns the number of collisions encountered*/
        public int insertKey(int key){
            int collision = 0;
            for (int i = 0; i < m; i++) {
                int slot = probe(key,i);
                if(isEmpty(slot)){
                    Table[slot] = key;
                    return collision;
                }
                else {
                    collision ++;
                }
            }
            return collision;
        }
        
        /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
        public int insertKeyArray (int[] keyArray){
            int collision = 0;
            for (int key: keyArray) {
                collision += insertKey(key);
            }
            return collision;
        }
            
         /**删除哈希表中的元素并返回collision的次数*/
         public int removeKey(int key){
             int collision = 0;
             int count = 0;
             for (int i = 0; i < m; i++) {
                 int slot = count + probe(key,i);
                 if(Table[slot] == key){
                     Table[slot] = -2;
                     return collision;
                 }

                 else if(Table[slot] < -1){
                     collision++;
                     int loc = slot + ((-Table[slot]) -1);
                     if(Table[loc] == key){
                         collision ++;
                         Table[loc] = -1;
                         Table[slot] -= 1;
                         return collision;
                     }
                     else {
                         count = ((-Table[slot]) -1);
                         collision ++;
                     }
                 }

                 else if(Table[slot] == -1){
                     collision ++;
                     return collision;
                 }
                 else{
                     collision ++;
                 }
             }
             return collision;
         }



}
