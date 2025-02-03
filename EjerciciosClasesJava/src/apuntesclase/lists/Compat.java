package apuntesclase.lists;

import java.util.HashSet;

public class Compat {
	
	public static void main(String[] args) {

		//Alex
		HashSet<Perks> perksAlexHas = new HashSet<>();
		perksAlexHas.add(Perks.A);

		HashSet<Perks> perksAlexLikes = new HashSet<>();
		perksAlexLikes.add(Perks.B);

		//Bea
		HashSet<Perks> perksBeaHas = new HashSet<>();
		perksBeaHas.add(Perks.B);

		HashSet<Perks> perksBeaLikes = new HashSet<>();
		perksBeaLikes.add(Perks.A);

		//Clara
		HashSet<Perks> perksClaraHas = new HashSet<>();
		perksClaraHas.add(Perks.C);
		perksClaraHas.add(Perks.B);

		HashSet<Perks> perksClaraLikes = new HashSet<>();
		perksClaraLikes.add(Perks.A);
		perksClaraLikes.add(Perks.B);

		//Damian
		HashSet<Perks> perksDavidHas = new HashSet<>();
		perksDavidHas.add(Perks.D);


		Person Alex = new Person("Alex", perksAlexHas, perksAlexLikes);
		Person Bea = new Person("Bea", perksBeaHas, perksBeaLikes);
		Person Clara = new Person("Clara", perksClaraHas, perksClaraLikes);
		Person David = new Person("David", perksDavidHas, new HashSet<>());

		Person p1 = Alex;
		Person p2 = Bea;

		System.out.println(p1.name + " is " + p1.selfPerks + " and wants " + p1.desiredPerks);
		System.out.println(p2.name + " is " + p2.selfPerks + " and wants " + p2.desiredPerks);
		System.out.println();

		System.out.println(p1.name + " is interested in " + p2.name + "?: " + p1.isInterestedIn(p2));
		System.out.println(p2.name + " is interested in " + p1.name + "?: " + p2.isInterestedIn(p1));
		System.out.println();

		System.out.println(p1.name + " is matched with " + p2.name + "?: " + p1.isMatchedWith(p2));
		p1.setPartner(p2);
	}	
}

class Person {
	String name;
	Person partner;

	HashSet<Perks> selfPerks;
	HashSet<Perks> desiredPerks;


	public Person(String name) {
		this(name, new HashSet<>(), new HashSet<>());		
	}

	public Person(String name, HashSet<Perks> selfPerks, HashSet<Perks> desiredPerks) {
		this.name = name;
		this.selfPerks = selfPerks;
		this.desiredPerks = desiredPerks;
	}

	public void setPartner(Person other) {
		if (this.isMatchedWith(other)) {
			this.partner = other;
			other.partner = this;
			System.out.println(this.name + " are now partners with " + other.name);
		}
		else System.err.println("Couldn't set partner. " + this.name + " is not compatible with " + other.name);
	}

	public void setPerks(HashSet<Perks> selfPerks, HashSet<Perks> desiredPerks) {
		this.selfPerks = selfPerks;
		this.desiredPerks = desiredPerks;
	}

	public boolean isInterestedIn(Person other) {
		return other.selfPerks.containsAll(this.desiredPerks);
	}

	public boolean isMatchedWith(Person other) {
		return this.isInterestedIn(other) && other.isInterestedIn(this);
	}
}

enum Perks {
	A,
	B,
	C,
	D,
	E
}
