import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static final String NAME_OF_THE_APP = "LOGIN REGISTRATION 4000";
	public static final String CSV_SEPARATOR = ",";
	public static final String PASSWORD_FILE_PATH = "secret_passw.csv";

	public static void main(String[] args) throws Exception {

		System.out.println("1 pour vous enregistrer");
		System.out.println("2 pour vous connecter");

		CsvController fileReader = new CsvController(PASSWORD_FILE_PATH);
		ArrayList<RegisterUser> allUsers = fileReader.getAllUsers();

		allUsers.forEach(System.out::println); 
		InputControler ctrl = new InputControler(new Scanner(System.in));
		String input = ctrl.readLine();

		switch (input) {
		case "1": ctrl.enregistrer(); break;
		case "2": 
			
			RegisterUser user = ctrl.login(allUsers);
			
			if(user == null) {
				System.out.println("Impossible de se connecter");
			
			} else {
				System.out.println("Vous être maintenant connecté " + user.getFullName());
			}
			
			break;
			
		default:
			System.out.println("Choisisez une option valide");
		}

	}
}
