
public class User {

	public static int nombreTotalUser = 0;

	protected String name, lastName, birth;

	public User(String name, String lastName, String birth) {
		this.name = name.trim();
		this.lastName = lastName.trim();
		this.birth = birth.trim();
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirth() {
		return birth;
	}
	public String getFullName() {
		return name + " " + lastName;
	}

	@Override
	public String toString() {
		return (name + " " + lastName + " " + birth);
	}

}
