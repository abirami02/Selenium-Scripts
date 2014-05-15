package com.genwi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JSONCompare {
	
	private static Set<String> ignoreProperties = null;
	
	private static Set<String> includeProperties = null;
	
	private static final String outputFolder = "/Users/abirami/Documents/Abirami/JSONCompare/output/";
	
	public static boolean compareJSON(String file, String url, Set<String> incProperties, Set<String> excProperties) throws JsonSyntaxException, MalformedURLException, IOException {
		JsonParser parser = new JsonParser();
		String name = new File(file).getName();
		JsonElement a = parser.parse(getFileContentAsString(file));
		JsonElement b = parser.parse(getUrlContentAsString(url, name));
		includeProperties = incProperties; 
		ignoreProperties = excProperties;
		
		return compare(a, b);
	}

	/**
	 * @param args
	 * @throws JsonSyntaxException
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws JsonSyntaxException,
			MalformedURLException, IOException {
		
		/****** TODO: Get these from command line *********/
		String file = "/Users/abirami/Documents/Abirami/JSONCompare/jsonObject_addCat.json";
		String url = "http://app.genwi.com/4.0/getjson/jsonObject/41979";
		
		Set<String> incProperties = new HashSet<String>();
		incProperties.add("category_title");
		
		System.out.println(compareJSON(file, url, incProperties, null));
	}

	private static String getFileContentAsString(String url)
			throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(url));
		String content = scanner.useDelimiter("\\Z").next();
		scanner.close();
		return content;
	}

	private static String getUrlContentAsString(String url, String name)
			throws MalformedURLException, IOException {
		File output = new File(outputFolder + name);
		Scanner scanner = new Scanner(new URL(url).openStream(), "UTF-8");
		String content = scanner.useDelimiter("\\A").next();
		FileUtils.writeStringToFile(output, content);
		scanner.close();
		return content;
	}
	
	private static boolean compare(JsonElement a, JsonElement b) {
		
		if (a.isJsonArray() && b.isJsonObject() || a.isJsonObject() && b.isJsonArray()) {
			return false;
		}
		if (a.isJsonArray()) {
			JsonArray array1 = a.getAsJsonArray();
			JsonArray array2 = b.getAsJsonArray();
			if (array1.size() != array2.size())
				return false;
			for (int i = 0; i < array1.size(); i++) {
				JsonElement e1 = array1.get(i);
				JsonElement e2 = array2.get(i);
				if (compare(e1, e2) == false)
					return false;
			}
		}
		if (a.isJsonObject()) {
			JsonObject object1 = a.getAsJsonObject();
			JsonObject object2 = b.getAsJsonObject();
			Map map = new Gson().fromJson(object1.toString(), Map.class);
			map.putAll(new Gson().fromJson(object2.toString(), Map.class));
			Set<String> keys = map.keySet();
			
			for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
				String key = iterator.next();
				
				JsonElement e1 = object1.get(key);
				JsonElement e2 = object2.get(key);
				
				if (includeProperties != null && !includeProperties.contains(key) && (e1 == null || e1.isJsonPrimitive())) {
						continue;
				} 
				if (ignoreProperties != null && ignoreProperties.contains(key) && (e1 == null || e1.isJsonPrimitive())) {
						continue;
				}
				
				if (!object2.has(key) || !object1.has(key)) {
					if (includeProperties != null && !includeProperties.contains(key))
						continue;
					if ((ignoreProperties == null || !ignoreProperties.contains(key)))
						return false;
				}
				
				if (compare(e1, e2) == false)
					return false;
			}
		}
		if (a.isJsonPrimitive()) {
			System.out.println("a => " + a.toString());
			System.out.println("b => " + b.toString());
			return a.toString().equals(b.toString());
		}
		return true;
	}

	public static Set<String> getTimestampDiff(String file, String url) throws JsonSyntaxException, MalformedURLException, IOException {
		JsonParser parser = new JsonParser();
		String name = new File(file).getName();
		
		JsonArray oldArray = parser.parse(getFileContentAsString(file)).getAsJsonObject().getAsJsonArray("cache");
		JsonArray newArray = parser.parse(getUrlContentAsString(url, name)).getAsJsonObject().getAsJsonArray("cache");
		
		return getDiffMap(getCacheMap(newArray), getCacheMap(oldArray));
	}

	private static Set<String> getDiffMap(Map<String, String> newMap,
			Map<String, String> oldMap) {
		
		Set<String> updates = new HashSet<String>();
		
		Set<String> keys = newMap.keySet();
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String key = iterator.next();
			if (!newMap.get(key).equals(oldMap.get(key))) {
				updates.add(key.split("-")[0]);
			}
		}
		
		return updates;
		
	}

	private static Map<String, String> getCacheMap(JsonArray newArray) {
		Map<String, String> cacheMap = new HashMap<String, String>();
		for (Iterator<JsonElement> iterator = newArray.iterator(); iterator.hasNext();) {
			JsonObject update = iterator.next().getAsJsonObject();
			String tab = update.get("tab").toString().replace("\"", "");
			
		//	if (tab.equals("5")) {
			//	cacheMap.put(tab + "-" + update.get("category_id").toString(), 
			//			update.get("added_datetime").getAsString());
			//}
			//else{		
			cacheMap.put(tab + "-" + update.get("category_id").toString(), 
				update.get("updated_datetime").getAsString());
			//}
		}
		return cacheMap;
	}

}
