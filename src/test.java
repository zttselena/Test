import java.awt.datatransfer.SystemFlavorMap;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DateTime dateTime=new DateTime();
		System.out.println(dateTime);
		System.out.println(dateTime.toString("yyyyMMdd"));
		System.out.println(dateTime.minusDays(80));
//	    String aaa="";
//		String aa="hello";
//		System.out.println("hello");
//		System.out.println(aa.substring(1, 3)
//		BigDecimal bd = new BigDecimal(1000);
//		System.out.println(bd);
//		BigDecimal b = BigDecimal.TEN.multiply(BigDecimal.TEN);
//		System.out.println(b);
//		String rate="0.2";
//		String a=bd.divide(b).multiply(new BigDecimal(0.975))
//                .multiply(new BigDecimal(rate)).setScale(2, 4)
//                .toString().split("\\.")[0];
//		aaa+="hell0";
//		System.out.println(a		
//                		);
//		System.out.println(new BigDecimal(rate).setScale(2, 4));
//		System.out.println("hello");
//		System.out.println(new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));
//		System.out.println(getyDDD());
//		String AcctName="湛江开发区海景明珠药行一分店";
//		if(AcctName.charAt(0) > 256){
//			System.out.println("AcctName.charAt(0) > 256");
//		} 
//		if(AcctName.length() >= 6){
//			System.out.println("AcctName.length() >= 6");
//		}
//		if(AcctName.matches("[\u4e00-\u9fa5\\w()（）]*")){
//			System.out.println(true);
//		}
//		System.out.println(AcctName.length());
//		if (AcctName.charAt(0) > 256 && AcctName.length() >= 6
//				&&AcctName.matches("[\u4e00-\u9fa5\\w()（）]*")) {
//				System.out.println("0");
//		}else
//			System.out.println("1");
	}
	
    public static String getyDDD() {
        int str = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        return new SimpleDateFormat("yy").format(new Date()).charAt(1) + "" + str;
   }

}
