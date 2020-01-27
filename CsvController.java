import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CsvController {

	private String filePath;

	public CsvController(String filePath) {
		this.filePath = filePath;
	}

	public ArrayList<RegisterUser> getAllUsers() throws Exception {

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		ArrayList<RegisterUser> allUsers = new ArrayList<>();

		String line;
		while ((line = br.readLine()) != null) {

			String[] inputs = line.split(Main.CSV_SEPARATOR);
			if (inputs.length == 6) {
				RegisterUser user = new RegisterUser(inputs);
				allUsers.add(user);
			}
		}
		return allUsers;
	}

	public void addToFile(CsvElement element) throws Exception {
		
		FileWriter writer = new FileWriter(filePath, true);
		writer.append(element.toCsvString()).append("\n"); //rajoute une ligne a la fin du fichier
		writer.flush();
		writer.close();
	}
}
