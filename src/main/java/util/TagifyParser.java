package util;

import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TagifyParser {
	public static List<String> parseStrings(String string) {
		JSONParser parser = new JSONParser();
		JSONArray arr = null;
		
		try {
			arr = (JSONArray)parser.parse(string);

		} catch(ParseException e) {
			System.out.println("변환 실패");
			return null;
		}
		
		List<String> list = new ArrayList<String>();
		
		for(Object obj: arr) {
			JSONObject tag = (JSONObject) obj;
			list.add(tag.get("value").toString());
		}
		
		return list;
	}
	public static List<Long> parseIds(String string) {
		JSONParser parser = new JSONParser();
		JSONArray arr = null;
		
		try {
			arr = (JSONArray)parser.parse(string);

		} catch(ParseException e) {
			System.out.println("변환 실패");
			return null;
		}
		
		List<Long> list = new ArrayList<Long>();
		
		for(Object obj: arr) {
			JSONObject tag = (JSONObject) obj;
			list.add((Long) tag.get("value"));
		}
		
		return list;
	}
}
