package product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class result {
	public static String productMonthFile = "E:\\000XieCheng\\处理\\productmoth.csv";
	public static String result = "E:\\000XieCheng\\处理\\result2.csv";
	public static void main(String[] args) throws IOException{
		 readCSV() ;
	}
	public static void  readCSV() throws IOException{
		
		File f = new File(productMonthFile);
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader bufr = new BufferedReader(isr);
		String temp = bufr.readLine();
		TreeMap<String,ArrayList<String>> tm = new TreeMap<String,ArrayList<String>>();
		TreeMap<String,Integer> aveTm = new TreeMap<String,Integer>();
		TreeMap<String,Integer> aveTm3 = new TreeMap<String,Integer>();
		TreeMap<String,Integer> aveTm6 = new TreeMap<String,Integer>();
		TreeMap<String,Integer> aveTm9 = new TreeMap<String,Integer>();
		while((temp=bufr.readLine())!=null){
			String[] str = temp.split(",");
			ArrayList<String> arr = new ArrayList<String>();
			double sum =0;
			int num =0;
			for(int i =12;i<23;i++){
				arr.add(str[i]);
				if(Integer.parseInt(str[i])!=0){
					sum = sum+Integer.parseInt(str[i]);
					num = num+1;
					
				}		
			}
			double sum1 = 0;
			int num1 = 0;
			for(int i=20;i<23;i++){
				if(Integer.parseInt(str[i])!=0){
					sum1 = sum1+Integer.parseInt(str[i]);
					num1 = num1+1;
					
				}		
			}
			if(sum1!=0){
				aveTm3.put(str[0],(int)sum1/num1);
			}
			else
				aveTm3.put(str[0],0);
			
			
			double sum2 = 0;
			int num2 = 0;
			for(int i=17;i<23;i++){
				if(Integer.parseInt(str[i])!=0){
					sum2 = sum2+Integer.parseInt(str[i]);
					num2 = num2+1;
					
				}		
			}
			if(sum2!=0){
				aveTm6.put(str[0],(int)sum2/num2);
			}
			else
				aveTm6.put(str[0],0);
			
			double sum3 = 0;
			int num3 = 0;
			for(int i=14;i<23;i++){
				if(Integer.parseInt(str[i])!=0){
					sum3 = sum3+Integer.parseInt(str[i]);
					num3 = num3+1;
					
				}		
			}
			if(sum3!=0){
				aveTm9.put(str[0],(int)sum3/num3);
			}
			else
				aveTm9.put(str[0],0);
			
			
			System.out.println(num);
			tm.put(str[0], arr);
			if(sum!=0){
				aveTm.put(str[0],(int)sum/num);
			}
			else
				aveTm.put(str[0],0);
			
		}
		
		bufr.close();
		isr.close();
		fis.close();
		
		FileWriter fw = new FileWriter(result);
		fw.write("product_id");  ///product_id,product_month,ciiquantity_month
		fw.write(",");
		fw.write("product_month");
		fw.write(",");
		fw.write("ciiquantity_month");
		fw.write("\r\n");
		ArrayList<String> arrTime = new ArrayList<String>();
		arrTime.add("2015-12-01");arrTime.add("2016-01-01");arrTime.add("2016-02-01");arrTime.add("2016-03-01");
		arrTime.add("2016-04-01");arrTime.add("2016-05-01");arrTime.add("2016-06-01");arrTime.add("2015-07-01");
		arrTime.add("2016-08-01");arrTime.add("2016-09-01");arrTime.add("2016-10-01");arrTime.add("2016-11-01");
		arrTime.add("2016-12-01");arrTime.add("2017-01-01");
		
		ArrayList<Double> arrPa = new ArrayList<Double>();
		arrPa.add(0.7);arrPa.add(0.7);arrPa.add(0.8);arrPa.add(0.9);arrPa.add(1.0);arrPa.add(1.1);arrPa.add(1.2);
		arrPa.add(1.3);arrPa.add(1.2);arrPa.add(1.1);arrPa.add(1.5);arrPa.add(1.0);arrPa.add(1.9);arrPa.add(1.2);
		Random rand = new Random();
		for(int j=1;j<=4000;j++){
			if(tm.get(j+"")!=null){
				for(int i=0;i<14;i++){
//					if(Integer.parseInt(map.getValue().get(9+i))==0){
//						fw.write(map.getKey());
//						fw.write(",");
//						fw.write(arrTime.get(i));
//						fw.write(",");
//						fw.write(aveTm.get(map.getKey())+"");
//						fw.write("\r\n");
//					}
					//else{
					if(i<3){
						fw.write(j+"");
						fw.write(",");
						fw.write(arrTime.get(i));
						fw.write(",");
						fw.write((int)(aveTm6.get(j+""))+"");
						fw.write("\r\n");
					}
					else if(i>=3&&i<6){
						fw.write(j+"");
						fw.write(",");
						fw.write(arrTime.get(i));
						fw.write(",");
						fw.write((int)(aveTm9.get(j+""))+"");
						fw.write("\r\n");
					}
					else if(i>=6&&i<9){
						fw.write(j+"");
						fw.write(",");
						fw.write(arrTime.get(i));
						fw.write(",");
						fw.write((int)(aveTm6.get(j+""))+"");
						fw.write("\r\n");
					}
					else{
						fw.write(j+"");
						fw.write(",");
						fw.write(arrTime.get(i));
						fw.write(",");
						fw.write((int)(aveTm9.get(j+""))+"");
						fw.write("\r\n");
					}
					
						
					//}
					
				}
			}
			else{
				for(int i=0;i<14;i++){
//					if(Integer.parseInt(map.getValue().get(9+i))==0){
//						fw.write(map.getKey());
//						fw.write(",");
//						fw.write(arrTime.get(i));
//						fw.write(",");
//						fw.write(aveTm.get(map.getKey())+"");
//						fw.write("\r\n");
//					}
					//else{
						fw.write(j+"");
						fw.write(",");
						fw.write(arrTime.get(i));
						fw.write(",");
						fw.write(140+"");
						fw.write("\r\n");
					//}
					
				}
			}
			
		}
		fw.flush();
		fw.close();

	}
}







