package DiceModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

public class HighScore {
	HashMap<String, String> map;

	String high;
	
	public HighScore(){
	
	}
	public String getHigh() {
		return high;
	}
	private void makeHighestMap(String filename) {
		BufferedReader in = null;
		map = new HashMap<String, String>();
		try {
			in = new BufferedReader(new FileReader(filename));
			String line;
			String key = null;
			String value = null;
			String tmp=null;
			while ((line = in.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(line, "\t\n");

				while (token.hasMoreTokens()) {
					key = token.nextToken();
					tmp=token.nextToken();
					if(isStringInt(tmp))
						value = tmp;
					else value="0"; 
					tmp=null;
				}
				if (map.containsKey(key)) {
					if (Integer.parseInt(map.get(key)) < Integer.parseInt(value)) {

						high = value;
						map.put(key, high);// 이미 key(이름)이 등록되있는데 지금 값이 더 크면 갱신

					}
				} else {
					high = value;
					map.put(key, value);// 이미 등록되지 않음->등록하기
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("setInfo 시스템 오류");
		}
	}
	public String exportListMember() {
		Vector<String> listmember=new Vector<String>();
		this.makeHighestMap("play.txt");
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			listmember.add(key + "\t" + map.get(key) + "\n");
		}
		Iterator<String> it2=listmember.iterator();
		String str=new String("");

		while(it2.hasNext()){
			String next=it2.next();
			str=str.concat(next);
		}
		return str;
	}
	public static boolean isStringInt(String s) {
	    try {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }


		/*
	public static void main(String[] args){
		HighScore hs=new HighScore();
		System.out.println(hs.exportListMember());
	}
*/
}
