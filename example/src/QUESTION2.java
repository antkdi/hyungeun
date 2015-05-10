import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class QUESTION2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/** 두개의 리스트를 받아 쌍으로 출력 */
		
		List<String> lst1 = Arrays.asList("1", "2", "3");
		List<String> lst2 = Arrays.asList("A","B","C");
		List<String> temp = new ArrayList<String>();
		for(int i =0;i<lst1.size();i++){
			temp.add(lst1.get(i));
			temp.add(lst2.get(i));
		}
		System.out.println(temp);
	}

}
