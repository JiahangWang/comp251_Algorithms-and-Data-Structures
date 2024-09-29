import java.util.ArrayList;
import java.util.Arrays;

public class test_Q3 {

    public static void main(String[] args) {


//        int[] weights = new int[] {23, 60, 14, 25, 7};
//        int[] deadlines = new int[] {3, 1, 2, 1, 3};

        int[] weights = new int[] {10,20,30,60};
        int[] deadlines = new int[] {1,2,3,3};

        int m = weights.length;
        HW_Sched schedule =  new HW_Sched(weights, deadlines, m);

        int[] result = schedule.SelectAssignments();

        System.out.println(Arrays.toString(result));


    }


}
