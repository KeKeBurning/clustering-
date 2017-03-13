package product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class translation {
	public static String productMonthFile = "E:\\000XieCheng\\处理\\productmoth.csv";
	public static String fpart = "E:\\000XieCheng\\处理\\productComplete.csv";
	public static void main(String[]  args) throws IOException{
		 readCSV() ;
	}
	
	public static void testTranslation()throws IOException{
		
	}
	public static void  readCSV() throws IOException{
		
			//读文件
			File f = new File(productMonthFile);
			FileInputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bufr = new BufferedReader(isr);
			String temp = bufr.readLine();
			TreeMap<String,ArrayList<String>> tm = new TreeMap<String,ArrayList<String>>();
			TreeMap<String,Integer> aveTm = new TreeMap<String,Integer>();
		
			//写文件
			FileWriter fw = new FileWriter(fpart);
			fw.write("id");fw.write(",");
			fw.write("2014_01");fw.write(",");fw.write("2014_02");fw.write(",");fw.write("2014_03");fw.write(",");fw.write("2014_04");fw.write(",");
			fw.write("2014_05");fw.write(",");fw.write("2014_06");fw.write(",");fw.write("2014_07");fw.write(",");fw.write("2014_08");fw.write(",");
			fw.write("2014_09");fw.write(",");fw.write("2014_10");fw.write(",");fw.write("2014_11");fw.write(",");fw.write("2014_12");fw.write(",");
			fw.write("2015_01");fw.write(",");fw.write("2015_02");fw.write(",");fw.write("2015_03");fw.write(",");fw.write("2015_04");fw.write(",");
			fw.write("2015_05");fw.write(",");fw.write("2015_06");fw.write(",");fw.write("2015_07");fw.write(",");fw.write("2015_08");fw.write(",");
			fw.write("2015_09");fw.write(",");fw.write("2015_10");fw.write(",");fw.write("2015_11");fw.write("\r\n");
			int num =0;
			TreeMap<String,ArrayList<Integer>> tmCom = new TreeMap<String,ArrayList<Integer>>();//存储23个月全部有销量的产品
			while((temp=bufr.readLine())!=null){
				int sum = 0;
				String[] str = temp.split(",");
				for(int i=1;i<str.length;i++){
					if(Integer.parseInt(str[i])!=0){
						sum+=1;
					}
				}
				if(sum>=0){
					ArrayList<Integer> arr = new ArrayList<Integer>();
					for(int i=1;i<str.length;i++){
						arr.add(Integer.parseInt(str[i]));
					}
					tmCom.put(str[0], arr);
					fw.write(temp);
					fw.write("\r\n");
				}
			}
			
			fw.flush();
			fw.close();
			bufr.close();
			isr.close();
			fis.close();
			
			double rmse=0;
			for(Map.Entry<String,ArrayList<Integer>> map:tmCom.entrySet()){
				ArrayList<Integer> con = map.getValue();
				for(int i=1;i<12;i++){
					rmse = rmse+Math.pow(con.get(i)-con.get(i+11)*0.55, 2);
				}
			}
			rmse = Math.sqrt(rmse/tmCom.size());
			System.out.println(rmse);
			
			
			
			
			
		}

}








