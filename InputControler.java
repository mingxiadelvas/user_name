import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InputControler {

	private Scanner scanner;

	public InputControler(Scanner scanner) {
		this.scanner = scanner;
	}

	public void enregistrer() throws Exception{

		System.out.print("Prenom : \t");
		String name = readLine();

		System.out.print("Nom de famille : \t");
		String lastName = readLine();

		System.out.print("Username : \t");
		String username = readLine();

		System.out.print("Date de naissance : \t");
		String birth = readLine();

		Random r = new Random();
		int id = r.nextInt();

		String pssw = askForPassWord();

		RegisterUser registeruser = new RegisterUser(name, lastName, birth, username, pssw, id);
		User.nombreTotalUser++;

		CsvController writer = new CsvController(Main.PASSWORD_FILE_PATH);
		writer.addToFile(registeruser);

		System.out.println(registeruser);
	}

	public RegisterUser login(ArrayList<RegisterUser> allUsers) {
		
		RegisterUser user = null;
		
		System.out.print("Username :\t");
		String username = readLine();
		
		for(RegisterUser currentUser : allUsers) {
			
			if(username.equals(currentUser.getUsername())) {
				//On a trouvé un user compatible, il faut demander le mot de passe
				System.out.println("mot de passe : \t");
				String pssw = readLine();
				
				if(pssw.equals(currentUser.getPassw())) {
					//Si le password est égal au password de currentUser
					user = currentUser;
					System.out.println("mot de passe valide");
					break;
				
				} else {
					System.out.println("mot de passe invalide");
				}
			}
		}
		return user;
	}

	public String readLine() {
		return scanner.nextLine().trim();
	}

	/* Demande a l'utilisateur un nouveau mot de passe */
	private String askForPassWord() {

		System.out.println("\n Veuillez choisir votre mot de passe (min 8 characteres) :");
		String pass = readLine();

		if (pass.length() < 8) {

			System.out.println("Minimum 8 characteres");
			return askForPassWord();

		} else if (pass.contains(" ") || pass.contains("(") || pass.contains(")")) {

			System.out.println("Interdit d'utiliser les characteres \" \", ( ou )");
			return askForPassWord();

		} else {

			return pass;
		}
	}
}
