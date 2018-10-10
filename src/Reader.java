import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Reader {

	private static JSONObject chars;

	protected static String[] getList() {
		try {
			JSONArray namelist = chars.getJSONArray("Namen");
			String[] namearray = new String[namelist.length()];
			for (int i = 0; i < namelist.length(); i++) {
				namearray[i] = (String) namelist.get(i);
			}
			return namearray;
		} catch (Exception e) {
			return new String[] { "" };
		}
	}

	protected static int getCharinit(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getInt("Charinit");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Charinit");
		}

	}

	protected static int getKampftechnikeninitbonus(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getInt("Kampftechnikeninitbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Kampftechnikeninitbonus");
		}

	}

	protected static int getGeschicklichkeitsbonus(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getInt("Geschicklichkeitsbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Geschicklichkeitsbonus");
		}

	}

	protected static char getGrößenklasse(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getString("Größenklasse").charAt(0);
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Größenklasse");
		}

	}

	protected static int getWahrnehmnungsbonus(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getInt("Wahrnehmnungsbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Wahrnehmnungsbonus");
		}

	}

	protected static int getKonstitutionsbonus(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getInt("Konstitutionsbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Konstitutionsbonus");
		}

	}

	protected static int getStärkebonus(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getInt("Stärkebonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Stärkebonus");
		}

	}

	protected static int getWillenskraftbonus(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getInt("Willenskraftbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Willenskraftbonus");
		}

	}

	protected static int getIntelligenzbonus(String player) throws JSONException {
		try {
			return chars.getJSONObject(player).getInt("Intelligenzbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Intelligenzbonus");
		}

	}

	protected static int[] getWaffenfertigkeitsbonus(String player) throws JSONException {
		try {
			int[] waffenlist = new int[chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").length()];
			waffenlist[0] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Äxte");
			waffenlist[1] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Dolche");
			waffenlist[2] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Fechtwaffen");
			waffenlist[3] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Improvisierte Waffen");
			waffenlist[4] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Kettenwaffen");
			waffenlist[5] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Lanze");
			waffenlist[6] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Lasso / Peitsche");
			waffenlist[7] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Schilde");
			waffenlist[8] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Schwerter");
			waffenlist[9] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Speere / Stäbe");
			waffenlist[10] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Stumpf");
			waffenlist[11] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Waffenlos");
			waffenlist[12] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Armbrust");
			waffenlist[13] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Blasrohr");
			waffenlist[14] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Bogen");
			waffenlist[15] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Schleuder");
			waffenlist[16] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Schwarzpulver");
			waffenlist[17] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Blind Kämpfen");
			waffenlist[18] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Belagerungsgeräte");
			waffenlist[19] = chars.getJSONObject(player).getJSONObject("Waffenfertigkeitsbonus").getInt("Geschütze");
			return waffenlist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Waffenfertigkeitsbonus");
		}

	}

	protected static JSONObject readjson() {
		try {
			File file = new File("./Chars.json");
			chars = new JSONObject(FileUtils.readFileToString(file, "utf-8").substring(1));
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (JSONException f) {
			System.out.println(f.toString());
		} catch (IOException g) {
			System.out.println(g.toString());
		}
		return null;
	}

	public static int getVerteidigungswertbonus(String player) {
		try {
			return chars.getJSONObject(player).getInt("Verteidigungswertbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Verteidigungswertbonus");
		}
	}

	public static int getSchockresistenzbonus(String player) {
		try {
			return chars.getJSONObject(player).getInt("Schockresistenzbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " Schockresistenzbonus");
		}
	}

	public static int getGeistigerWiderstandbonus(String player) {
		try {
			return chars.getJSONObject(player).getInt("GeistigerWiderstandbonus");
		} catch (Exception e) {
			throw new JSONException("Da stimmt was in der Json nicht bei: " + player + " GeistigerWiderstandbonus");
		}
	}
	
	

}
