import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QUESTION3 {
	public static void main(String[] args) {


		/** 피보나치 수열 100개를 연산하는 함수 설계 */


		int result = 0;
		List<Integer> list = new ArrayList<Integer>();

		for(int i=0;i<=100;i++){
			if(i<=1)
				list.add(i);
			else
				list.add(list.get(i-1)+list.get(i-2));
			result += list.get(i);
		}
		System.out.println(result);

	}
}
