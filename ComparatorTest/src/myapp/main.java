package myapp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {

	public static void main(String[] args) {

		UserVO users[] = new UserVO[5];
		users[0] = new UserVO("김기사",34);
		users[1] = new UserVO("정학생",21);
		users[2] = new UserVO("전주부",38);
		users[3] = new UserVO("하중딩",16);
		users[4] = new UserVO("김중딩",16);

		ObjectSort sorter = new ObjectSort();
		Arrays.sort(users,sorter);

		for(UserVO u : users){
			System.out.println(u.getName() + "," + u.getAge());
		}

		System.out.println("");


		List<UserVO> list = Arrays.asList(users);

		Collections.sort(list,new Comparator<UserVO>(){
			@Override
			public int compare(UserVO o1, UserVO o2) {
				// TODO Auto-generated method stub
				if(o1.age == o2.age){
					return o2.name.compareTo(o1.name);
				}
				return o1.age - o2.age;
			}
		});

		for(UserVO u : list){
			System.out.println(u.getName() + "," + u.getAge());
		}
	}

}
