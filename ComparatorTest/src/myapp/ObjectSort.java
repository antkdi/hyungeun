package myapp;

import java.util.Comparator;

public class ObjectSort implements Comparator<UserVO> {

	@Override
	public int compare(UserVO o1, UserVO o2) {
		//o1 - o2 = ASC , o2 - o1 = DESC
		if(o1.age == o2.age){
			return o2.name.compareTo(o1.name);
		}
		return o1.age - o2.age;
	}
}
