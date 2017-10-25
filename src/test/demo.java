package test;




public class demo {
	public static void main(String[] args) {
		String str="sub002.bancilchn.r.20170808.105838";
		str=str.toUpperCase();
		System.out.println(str);
		
		String a="abc";
		String b="ab"+"c";
		String d="ab";
		String e="c";
		System.out.println(d+e);
		System.out.println("a==(d+e):"+(a==(d+e)));
		System.out.println("a==b:"+(a==b));
		
		
		String aa=new String("abc");
		String bb=new String("abc");
		System.out.println("aa==bb:"+(aa==bb));
		System.out.println("aa==a:"+(aa==a));
		
		
		String s1 = new String("sss111");
		s1=s1.intern();//intern 方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中
		String s2 = "sss111";
		System.out.println(s1 == s2);  //true
		
	    String s = new String("1");
	    s.intern();
	    String s21 = "1";
	    System.out.println(s == s21);

	    String s3 = new String("1") + new String("1")+"3";
	    s3.intern();
	    String s4 = "113";
	    System.out.println(s3 == s4);
	    
	    String str1 = new String("计算机") + new String("软件");
        System.out.println("就是那几："+(str1.intern() == str1));

        String str2 = new String("ja") + new String("va");
        System.out.println("就是那几："+(str2.intern() == str2));
		
	}
	
	
}