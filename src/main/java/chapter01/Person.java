package chapter01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Person {
	private String name;
	private int age;
	
	public Person () {
		System.out.println("Person 기본생성자");
	}
}
