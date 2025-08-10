
public class Main {
	public static void main(String[] args) {
		Customer c = new Customer();
		c.setSno(1);
		c.setName("Dharani");
		c.setEmail("dharanimarthala@gmail.com");
		System.out.println(c);
		
		Address addr = new Address();
		addr.setDoorno(1);
		addr.setCityName("Hyderabad");
		addr.setStreetAddr("MG Road");
		addr.setPincode("516360");
		System.out.println(addr);
		c.setAddr(addr);
		System.out.println("after setting");
		System.out.println(c);
		System.out.println(addr);
	}
}
