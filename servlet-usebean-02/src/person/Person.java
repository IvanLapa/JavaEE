package person;

import java.util.List;

public class Person {
	 private int age;
     private String name;
     
     private List<Person> employees;
     
     public Person(int age, String name){
         this.age = age;
         this.name = name;
     }
     
     public int getAge() {
    	 return age;
     }
     public String getName() {
    	 return name;
     }
     public List<Person> getEmpoyees (){
    	 return employees;
     }
}
