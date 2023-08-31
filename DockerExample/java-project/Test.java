import java.util.Properties;

class Test{
	
	public static void printSystemProperties() {
		System.out.println("Printing system properties using java");
	     Properties properties = System.getProperties();
		 System.out.println(properties);
	}
	public static void main(String[] args) {
		System.out.println("Java Program Started");
		printSystemProperties();
	}
}