package contacts.model;

public class Person {
	private int id;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private int age;

	public Person(String name, String lastName, String address, String phone, int age) {
		super();
		this.name = name;
		this.surname = lastName;
		this.address = address;
		this.phone = phone;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String lastName) {
		this.surname = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String addess) {
		this.address = addess;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + ", phone="
				+ phone + ", age=" + age + "]";
	}
}
