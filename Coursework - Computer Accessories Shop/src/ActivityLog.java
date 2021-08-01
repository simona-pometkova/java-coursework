import java.io.*;
import java.util.*;

public class ActivityLog {
	
	/* Creates a list of activity logs by reading from ActivityLog.txt.
	 * This list is then appended whenever a user purchases, cancels or
	 * saves items for later.
	 */
	public static List<LogDetails> createLogList() throws Exception {
		List<LogDetails> logList = new ArrayList<LogDetails>(); 
		File readFrom = new File("ActivityLog.txt");
		Scanner scanner = new Scanner(readFrom);
		LogDetails log = null; //Creates an "log" object. Each object is made from a line of the text file.
		while (scanner.hasNextLine()) {
			String[] details = scanner.nextLine().split(",");
			log = new LogDetails(Integer.parseInt(details[0].trim()),
						         details[1].trim(), Integer.parseInt(details[2].trim()),
						         Double.parseDouble(details[3].trim()),
						         Integer.parseInt(details[4].trim()),
						         details[5].trim(), details[6].trim(),
						         details[7].trim());	
			logList.add(log);
		}
		scanner.close();
		return logList;
	}
}
