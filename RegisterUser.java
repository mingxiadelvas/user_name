
public class RegisterUser extends User implements CsvElement {

	private String username, passw;
	private long id;

	public RegisterUser(String name, String lastName, String birth, String username, String passw, long id) {

		super(name, lastName, birth); // super va appeler le constructeur de User
		this.username = username.trim();
		this.passw = passw.trim();
		this.id = id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassw() {
		return this.passw;
	}
	
	public RegisterUser(String[] fields) {
		this(fields[0], fields[1], fields[2], fields[3], fields[4], Long.parseLong(fields[5]));
	}
	
	@Override
	public String toString() {
		return super.toString() + " username " + username + " id " + id;
	}

	@Override
	public String toCsvString() {

		return name + Main.CSV_SEPARATOR + 
			   lastName + Main.CSV_SEPARATOR +
			   birth + Main.CSV_SEPARATOR +
			   username + Main.CSV_SEPARATOR +
			   passw + Main.CSV_SEPARATOR + id;
	}
}
