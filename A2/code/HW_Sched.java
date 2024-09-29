import java.util.*;

public class HW_Sched {
	ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
	int m;
	int lastDeadline = 0;
	
	protected HW_Sched(int[] weights, int[] deadlines, int size) {
		for (int i=0; i<size; i++) {
			Assignment homework = new Assignment(i, weights[i], deadlines[i]);
			this.Assignments.add(homework);
			if (homework.deadline > lastDeadline) {
				lastDeadline = homework.deadline;
			}
		}
		m =size;
	}
	
	
	/**
	 * 
	 * @return Array where output[i] corresponds to the assignment 
	 * that will be done at time i.
	 */
	public int[] SelectAssignments() {
		Collections.sort(Assignments, new Assignment()); //Sort assignments, Order will depend on how compare function is implemented
		// If homeworkPlan[i] has a value -1, it indicates that the 
		// i'th timeslot in the homeworkPlan is empty
		//homeworkPlan contains the homework schedule between now and the last deadline
		int[] homeworkPlan = new int[lastDeadline];  //
		for (int i=0; i < homeworkPlan.length; ++i) {  //
			homeworkPlan[i] = -1;  //
		}  //

		int current = 0;
		for (int i = 0; i < m; i++) {
			if(current == lastDeadline){     //超出最大个数终止
				return homeworkPlan;
			}
			else if(Assignments.get(i).deadline >= current + 1){     //取到一个可以被添加的作业
				if(Assignments.get(i).deadline == lastDeadline || (m - i) <= lastDeadline){
					homeworkPlan[current] = Assignments.get(i).number;
					current ++;
				}
				else {
					int count = 0;
					int position = i + 1;
					int diff = lastDeadline - current;

					while (count <= diff && position < m){
						if(Assignments.get(position).deadline > Assignments.get(i).deadline){
							count ++;
							if(Assignments.get(position).weight < Assignments.get(i).weight){
								homeworkPlan[current] = Assignments.get(i).number;
								current ++;
								break;
							}
						}
						position ++;
					}

				}
			}
		}

		return homeworkPlan;
	}
}
	



