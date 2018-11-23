package algorithm;

import java.util.Date;

public class Person {

	private final String name;
	private final Date birthDate;

	public Person(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	Boolean isYoungerThan(Person anotherPerson) {
		return birthDate.getTime() < anotherPerson.birthDate.getTime();
	}

	long ageDifferenceWith(Person anotherPerson) {
		return birthDate.getTime() - anotherPerson.birthDate.getTime();
	}

	Person youngest(Person anotherPerson) {
		return isYoungerThan(anotherPerson) ? this : anotherPerson;
	}

	Person oldest(Person anotherPerson) {
		return isYoungerThan(anotherPerson) ? anotherPerson : this;
	}

	int nameLength() {
		return name.length();
	}
}

