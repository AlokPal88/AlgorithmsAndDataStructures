package Visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppendNamesWithNumbers {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("alex", "tom", "alex", "francis", "alex", "franklin","francis");
		List<String> result = new ArrayList<>();
		Map<String,Integer> freq = new HashMap<>();
		names.stream().forEach(name -> {
			if(freq.getOrDefault(name, 0) == 0)
				result.add(name);
			else
				result.add(name+freq.get(name).toString());
			freq.put(name,freq.getOrDefault(name, 0)+1);
		});
		result.stream().forEach(System.out::println);
	}
}
