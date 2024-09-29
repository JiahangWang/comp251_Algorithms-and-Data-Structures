import java.util.*;

public class A1_Q3 {


	public static ArrayList<String> Discussion_Board(String[] posts){

		if(posts.length == 0){
			return new ArrayList<String>();
		}

		HashMap<String,Integer> all = new HashMap<>();
		HashMap<String,HashSet<String>> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		//PriorityQueue<Word> queue = new PriorityQueue<>();
		ArrayList<String> result = new ArrayList<>();

//		long start = System.currentTimeMillis(); /*开始时间*/

		for (String post : posts) {
			se(post,map,all);  /***/
		}


//		System.out.println("-----------程序执行时间为：" + (System.currentTimeMillis()-start) +"毫秒-----------"); /**结束时间*/


		determine(map,set);

		Set<String> keySet = all.keySet();
		ArrayList<String> temp = new ArrayList<>(keySet);
		for (String key : temp){
			if(!(set.contains(key))){
				all.remove(key);
			}
		}

		Comparator<String> comparator = (o1, o2) -> {
			if(!Objects.equals(all.get(o1), all.get(o2))){
				return all.get(o2) - all.get(o1);
			}
			else return o1.compareTo(o2);
		};

		PriorityQueue<String> queue1 = new PriorityQueue<>(comparator);

		Set<String> keySet2 = all.keySet();
		queue1.addAll(keySet2);

		int num = queue1.size();
		for (int i = 0; i < num; i++) {
			if(queue1.peek() != null){
				result.add(queue1.poll());
			}
		}


//	已废弃
//		for(String word : set){
//			queue.add(new Word(all.get(word),word));
//		}
//
//
//		int num = queue.size();
//		for (int i = 0; i < num; i++) {
//			if(queue.peek() != null){
//				result.add(queue.poll().postWord);
//			}
//		}


		return result;

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 已废弃
//	public static void separate(String message, HashMap<String,HashSet<String>> map, HashMap<String,Integer> all){
//		if(message == null){return;}
//
//		HashSet<String> wordEx;
//		String name = message.substring(0,message.indexOf(" ")); //提取名字
//
//		if(map.containsKey(name)){  //判断是否已经有这个名字了
//			wordEx = map.get(name);
//		}
//		else {
//			wordEx = new HashSet<>();}
//
//		message = message.substring(message.indexOf(" ") + 1); //截取名字后面的字段
//
//		int first = 0;  //前指针
//		int second = message.indexOf(" ");  //后指针
//		while(second != -1){
//			String word = message.substring(first,second);
//
//			if(all.containsKey(word)){
//				all.put(word,all.get(word) + 1);
//			}
//			else{
//				all.put(word,1);
//			}
//
//			wordEx.add(word);
//			first = second + 1;
//			second = message.indexOf(" ",second + 1);
//		}
//
//		if(all.containsKey(message.substring(first))){
//			all.put(message.substring(first),all.get(message.substring(first)) + 1);
//		}
//		else{
//			all.put(message.substring(first),1);
//		}
//
//		wordEx.add(message.substring(first));
//		map.put(name, wordEx);
//	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void se(String message, HashMap<String,HashSet<String>> map, HashMap<String,Integer> all){
		if(message == null){return;}

		HashSet<String> wordEx;
		String name = message.substring(0,message.indexOf(" ")); //提取名字

		if(map.containsKey(name)){  //判断是否已经有这个名字了
			wordEx = map.get(name);
		}
		else {
			wordEx = new HashSet<>();}

		message = message.substring(message.indexOf(" ") + 1); //截取名字后面的字段

		String[] arr = message.split(" ");

		for (String s : arr){
			if(all.containsKey(s)){
				all.put(s,all.get(s) + 1);
			}
			else{
				all.put(s,1);
			}
			wordEx.add(s);
		}

		map.put(name, wordEx);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////



	public static void determine(HashMap<String,HashSet<String>> map,HashSet<String> set){
		Set<String> nameSet = map.keySet();
		if(nameSet.size() == 1){
			return;
		}
		for (String name : nameSet ){
			set.addAll(map.get(name));
		}
		HashSet<String> wordSet = new HashSet<>(set);
		for(String word : wordSet){
			for(String name : nameSet){
				if(!(map.get(name).contains(word))){
					set.remove(word);
				}
			}
		}
	}



//已废弃
//	public static class Word implements Comparable<Word>{
//		int Rank;
//		String postWord;
//
//		public Word(int rank, String postWord) {
//			Rank = rank;
//			this.postWord = postWord;
//		}
//
//		@Override
//		public int compareTo(Word o) {
//			if(this.Rank != o.Rank){
//				return o.Rank - this.Rank;
//			}
//			return this.postWord.compareTo(o.postWord);
//		}
//	}




}
