package synchronised;

public class ThreadLocalTest {

	static class ResourceClass{
		//共享变量私有
		public final static ThreadLocal<String> RESSOURCE_1 = new ThreadLocal<String>();
		public final static ThreadLocal<String> RESSOURCE_2 = new ThreadLocal<String>();
	}
	
	static class A{
		public void setOne(String value){
			ResourceClass.RESSOURCE_1.set(value);
		}
		
		public void setTwo(String value){
			ResourceClass.RESSOURCE_2.set(value);
		}
	}
	
	static class B{
		public void display() {
			System.out.println(ResourceClass.RESSOURCE_1.get()+":"+ResourceClass.RESSOURCE_2.get());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final A a = new A();
		final B b = new B();
		for(int i=0; i<15; i++ ){
			final String resource1 = "线程-" + i;
			final String resource2 = "	value = ("+i+")";
			new Thread(){
				public void run() {
					try {
						a.setOne(resource1);
						a.setTwo(resource2);
						b.display();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}finally{
						ResourceClass.RESSOURCE_1.remove();
						ResourceClass.RESSOURCE_2.remove();
					}
				}
			}.start();
		}

	}

}
