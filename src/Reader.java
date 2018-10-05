import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Reader {
	protected static JSONObject readjson(JFrame frame) {
		try {
			File file = new File("./Player.json");
			return new JSONObject(FileUtils.readFileToString(file, "utf-8"));
		} catch (FileNotFoundException e) {

		} catch (JSONException f) {

		} catch (IOException g) {

		}
		return null;
	}
}
