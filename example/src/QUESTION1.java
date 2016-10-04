import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class QUESTION1 {

	private static int value = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/** •하나의 list를 받아서 총합을 구하는 함수 3개를 for, while, recursion(재귀)로 설계하세요. */

		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++){
			list.add((int)((Math.random()*10)));
		}
		
		//1.for
		System.out.println(getSolutionFor(list));

		//2.while
		System.out.println(getSolutionWhile(list));

		//3.재귀
		System.out.println(getSolutionRecursion(list));

	
	}

	//포문
	public static int getSolutionFor(List<Integer> list){
		int temp = 0;
		for(int a:list)
			temp += a;
		return temp; 
	}

	//와일문
	public static int getSolutionWhile(List<Integer> list){
		int temp = 0;
		Iterator i = list.iterator();
		while(i.hasNext())
			temp += (int)i.next();
		return temp;
	}

	//재귀문
	public static int getSolutionRecursion(List<Integer> list){
		if(list.size() >0){
			value += list.get(0);
			list.remove(0);
			getSolutionRecursion(list);
		}
		
		return value;
	
	}

}
