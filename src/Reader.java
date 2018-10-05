import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
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
