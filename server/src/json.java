import java.io.*;
import java.net.*;
import java.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class json {

	public static void main(String[] args) {
		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 8124);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			Scanner a = new Scanner(System.in);
			String str1 = a.next();
			writer.println(str1);
			writer.flush();
			String str = reader.readLine();
			JSONObject js = new JSONObject();
			String i = js.getString(str);
			System.out.println(i);


		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception e) {
				
			}
		}
	}
}