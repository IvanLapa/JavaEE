package _stax;

public enum StudentTagName {
	NAME, TELEPHONE, ADDRESS, COUNTRY, CITY, STREET, STUDENT, STUDENTS;

	public static StudentTagName getElementTagName(String element) {
		switch (element) {
		case "name":
			return NAME;
		case "telephone":
			return TELEPHONE;
		case "address":
			return ADDRESS;
		case "country":
			return COUNTRY;
		case "city":
			return CITY;
		case "street":
			return STREET;
		case "student":
			return STUDENT;
		case "students":
			return STUDENTS;	
		default:
			throw new EnumConstantNotPresentException(StudentTagName.class,
					element);
		}
	}
}
