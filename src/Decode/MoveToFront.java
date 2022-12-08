package Decode;

import java.util.List;

public class MoveToFront {
	
	public String decode(List<Integer> idxs, String symTable){
		StringBuilder result = new StringBuilder();
		StringBuilder s = new StringBuilder(symTable);
		for(int idx : idxs){
			char c = s.charAt(idx);
			result = result.append(c);
			s = s.deleteCharAt(idx).insert(0, c);
		}
		return result.toString();
	}
}
