package com.indhio.async.people;

import java.util.Random;
import org.directwebremoting.datasync.ExposeToString;

@ExposeToString
public class Person {
	private String id;
	private String name;
	private String address;
	private int age;
	private boolean superhero;
	private static int nextId = 1;

	private static final Random random = new Random();

	public Person() {
		this.id = getNextId();
	}

	public Person(boolean withRandom) {
		if (withRandom) {
			this.name = RandomData.getFullName();
			this.address = RandomData.getAddress();
			this.age = RandomData.getAge();
			this.superhero = (random.nextInt(100) == 1);
		}

		this.id = getNextId();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSuperhero() {
		return this.superhero;
	}

	public void setSuperhero(boolean superhero) {
		this.superhero = superhero;
	}

	public String toString() {
		return this.name;
	}

	public static synchronized String getNextId() {
		return "P" + nextId++;
	}
}
