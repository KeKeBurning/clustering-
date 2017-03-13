package product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class readProduct {
	public static String productFile = "E:\\000XieCheng\\14month_dataset(UTF-8)\\product_quantity.txt";
	public static String productMonthFile = "E:\\000XieCheng\\处理\\productmoth.csv";
	public static void main(String[] args)throws IOException{
		readCSV();
	}
	public static TreeMap<String,Integer> readCSV() throws IOException{
		
		File f = new File(productFile);
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader bufr = new BufferedReader(isr);
		String temp = bufr.readLine();
		TreeMap<String,Integer> tm  = new TreeMap<String,Integer>();
		TreeSet<String> hs = new TreeSet<String>();
		TreeSet<String> ts = new TreeSet<String>();
		while((temp=bufr.readLine())!=null){
			String[] str = temp.split(",");
			
			String[] time = str[1].split("-");
			String key = str[0]+"_"+time[0]+"_"+time[1];
			hs.add(time[0]+"_"+time[1]);
			ts.add(str[0]);
			if(tm.get(key)==null){
				tm.put(key, 0);
			}
			tm.put(key,tm.get(key)+Integer.parseInt(str[6]));
		}
		bufr.close();
		isr.close();
		fis.close();
		witerCSV( tm, hs, ts);
		return tm;
	}
	public static void witerCSV(TreeMap<String,Integer> tm,TreeSet<String> hs,TreeSet<String> ts)throws IOException{
		FileWriter fw = new FileWriter(productMonthFile);
		Iterator<String> it = hs.iterator();
		fw.write("id");
		fw.write(",");
		while(it.hasNext()){
			fw.write(it.next());
			fw.write(",");
		}
		fw.write("\r\n");
		Iterator<String> its = ts.iterator();
		while(its.hasNext()){
			
			String id = its.next();
			fw.write(id);
			fw.write(",");
			Iterator<String> pp = hs.iterator();
			while(pp.hasNext()){
				String timeKey = pp.next();
				
				String key = id+"_"+timeKey;
				if(tm.get(key)==null){
					fw.write("0");
					fw.write(",");
				}
				else{
					fw.write(tm.get(key)+"");
					fw.write(",");
				}
			}
			fw.write("\r\n");
		
		}
		fw.flush();
		fw.close();
		
	}

}
