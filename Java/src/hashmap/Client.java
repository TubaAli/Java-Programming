package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {

	public static void main(String[] args) {
		HashMap<String, Integer> popmap = new HashMap<>();
		
		popmap.put("India", 125);
		System.out.println(popmap);
		
		popmap.put("China",200);
		System.out.println(popmap);
		
		popmap.put("Pak",80);
		System.out.println(popmap);
		
		popmap.put("US", 25);
		System.out.println(popmap);
		
		popmap.put("UK",20);
		System.out.println(popmap);
		
		popmap.put("Aus",10);
		System.out.println(popmap);
		
		popmap.put("India",140);
		System.out.println(popmap);
		
		System.out.println(popmap.get("India"));
		System.out.println(popmap.get("Utopia"));
		
		System.out.println(popmap.remove("Pak"));
		System.out.println(popmap.remove("Utopia"));
		
		System.out.println(popmap);
		
		ArrayList<String> keys = new ArrayList<>(popmap.keySet());
		for(String key:keys){
			Integer val = popmap.get(key);
			System.out.println(key+" = "+val);
		}
	}
	
	public static void highestFreqChar(String str){
		
	}
	
	public static void gce1(int[] one, int[] two){
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int val:one){
			map.put(val, true);
		}
		
		for(int val:two){
			if(map.containsKey(val) && map.get(val)==true){
				System.out.println(val);
				map.put(val, false);
			}
		}
	}
	
	public static void gce2(int[] one, int[] two){
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int val:one){
			map.put(val, map.containsKey(val)==true? map.get(val)+1:1);
		}
		
		for(int val:two){
			if(map.containsKey(val) && map.get(val)>0){
				System.out.println(val);
				map.put(val, map.get(val)-1);
			}
		}
	}
}
