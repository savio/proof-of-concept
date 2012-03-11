package com.indhio.async.people;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.directwebremoting.datasync.Directory;
import org.directwebremoting.datasync.MapStoreProvider;

public class People {
	private final Map<String, Person> smallCrowd;
	private final Map<String, Person> largeCrowd;
	
	public People() {
		this.smallCrowd = createCrowd(10);

		MapStoreProvider provider = new MapStoreProvider(createCrowd(1000), Person.class);
		Directory.register("largeCrowd", provider);

		this.largeCrowd = provider.asMap();
	}

	public Collection<Person> getSmallCrowd() {
		return this.smallCrowd.values();
	}

	public String setPerson(Person person) {
		this.smallCrowd.put(person.getId(), person);
		return "Updated values for " + person.getName();
	}

	public String deletePerson(String id) {
		Person person = (Person) this.smallCrowd.remove(id);
		if (person == null) {
			return "Person does not exist";
		}

		return "Deleted " + person.getName();
	}

	public List<Person> getMatchingFromLargeCrowd(String filter) {
		List reply = new ArrayList();
		Pattern regex = Pattern.compile(filter, 2);
		for (Person person : this.largeCrowd.values()) {
			if (regex.matcher(person.getName()).find()) {
				reply.add(person);
			}
		}
		return reply;
	}

	private static Map<String, Person> createCrowd(int count) {
		Map reply = new HashMap();
		for (int i = 0; i < count; i++) {
			Person person = new Person(true);
			reply.put(person.getId(), person);
		}
		return reply;
	}
}
