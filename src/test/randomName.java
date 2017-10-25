package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class randomName {
	public static void main(String[] args) {
		for(int i=0;i<8;i++){
			randomNameForCheck("D://name.txt");
		}
	}
	
	public static String randomNameForCheck(String filePathAndName){
		// 定义人名数组
				File file = new File(filePathAndName);
				InputStreamReader read = null;
				BufferedReader reader = null;
				String line="";
				List<String> nameList = new ArrayList<String>();
				try {
					read = new InputStreamReader(new FileInputStream(file), "GBK");
					reader = new BufferedReader(read);
					while((line=reader.readLine())!=null){
						nameList.add(line);
					}
					}catch(Exception e){
						e.printStackTrace();
					}
				// 随机生成数组下标、
				int num = (int) (Math.random() * 1000);
				// 对生成的随机数进行判断，如果小于数组下标，就跳出循环
				while (num > nameList.size() - 1) {
					if (num <= nameList.size() - 1) {
						break;
					}
					num = (int) (Math.random() * 1000);
				}
				// 将数组下标设置成随机数，就可以实现人名的随机抽取
				System.out.println("被抽到的同学是：" + nameList.get(num).toString());
				return nameList.get(num).toString();
	}
}
