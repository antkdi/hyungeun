import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


public class QUESTION4 {
	
	private static String value = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/** 양의정수 임의로 생성해서 형식화 할때 어떤조합이든 가장 큰수가 나오게 **/
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add((int)((Math.random()*10)));
		}
		list.stream().sorted(Comparator.reverseOrder()).forEach((test) -> value += test);
		System.out.println(list);
		System.out.println(value);
		
		//List<String> temp = new ArrayList<String>();
		//String result ="";
		
		/*char [] cd = value.toCharArray();
		Arrays.sort(cd);
		for(char a:cd)
			System.out.println(a);
		Arrays.sort(value.toCharArray());*/
		//Arrays.asList(cd).stream().sorted(Comparator);

		//System.out.println(value);
		 
		/*System.out.println(Arrays.asList(value));
		Arrays.asList(value).stream().sorted(Comparator.reverseOrder()).forEach(x -> temp.add(x.toString()));
		System.out.println(temp);*/
		//).forEach(c -> temp.add(c.toString())); 
		//char ch [] = value.toCharArray();
		
		//System.out.println("잉?"+ value);
		//System.out.println("뭐야"+ list.stream().sorted(Comparator.reverseOrder()).findFirst()); 
		//System.out.println(list);
		//String imsi = "";
		/*list.forEach((test) -> {
			char [] c = Integer.toString(test).toCharArray();
			String imsi =""; 
			
			temp.forEach((String s) -> temp.add(c.toString()));
			//temp.add(Integer.toString(test));	
		});
		System.out.println(temp);*/
		/*list.forEach((int te) -> temp.add(Integer.toString(te).toCharArray().toString()));
		for(int te:list){
			char [] ch = Integer.toString(te).toCharArray();
			for(int i=0;i<ch.length;i++){
				temp.add(Character.toString(ch[i]));
			}
		}*/
		/*Collections.sort(temp,Collections.reverseOrder());
		
		temp.forEach((str) -> { value += str;});
		System.out.println(value);*/
		/*for(String a:temp){
			result += a;
		}
		System.out.println(list);
		System.out.println(result);*/
		
	}

}
