package sample04;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String phone;
	private Outputter outputter = new FileOutputter();
	
	public MessageBeanImpl(String name) {
		System.out.println("MessageBeanImpl 생성자");
		this.name = name;
	}
	
	
	public void setPhone(String phone) {
		System.out.println("setPhone method");
		this.phone = phone;
	}
	public void setOutputter(Outputter outputter) {
		System.out.println("setOutoputter method");
		this.outputter = outputter;
	}


	@Override
	public void helloCall() {
		System.out.println("hellocall method");
		outputter.output("이름 = " + name + "\t 핸드폰 =" + phone );
	}
	
	
	
}
