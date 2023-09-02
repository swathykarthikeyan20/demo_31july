package com.firstname;


class Employeesss{
		private String firstName;
		private String lastName;
		private  String ssn;
		public Employeesss(String firstName,String lastName,String ssn) {
			this.firstName=firstName;
			this.lastName=lastName;
			this.ssn=ssn;
		}
			public String getFirstName() {
				return firstName;
				
			}
			public void setFirstName(String firstName) {
				this.firstName=firstName;
				
			}
			public String getLastName() {
				return lastName;
				
			}
		
		public  void  setLastName(String lastName) {
			this.lastName=lastName;
		}
	
		public String getssn() {
			return ssn;
		}
		public void setssn(String ssn) {
			this.ssn=ssn;
		}
		public String ValidateName(String firstName,String lastName) {
			if(firstName==null||lastName==null) {
				try {
					throw new NullPointerException("Entry missing ");
				}catch(NullPointerException ex) {
					return ex.getMessage();
					
				}
			}
			if (firstName.length()==0||lastName.length()==0){
				try {
					throw new StringIndexOutOfBoundsException("Index out of bound");
				}catch (StringIndexOutOfBoundsException ex) {
					return ex.getMessage();
				}
			}
				else if(Character.isDigit(firstName.charAt(0))||Character.isDigit(lastName.charAt(0))){
					try {
						throw new IllegalArgumentException("First Character is invalid");
					}catch(IllegalArgumentException ex) {
					return ex.getMessage();
				}
					
				}
					
				else {
					return "valid String:";
				}
			
			}
			public 	String ValidateSsn(String ssn) {
				if(Character.isDigit(ssn.charAt(0))&& Character.isDigit(ssn.charAt(ssn.length()-1))){
					return "valid String";
				}
				else {
					return "Invalid String";
				}
			}

		}
		
public class FirstNameLastName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
					Employeesss emp=new Employeesss("Adash","Gupta","/AAAAB");
					System.out.println(emp.ValidateName(emp.getFirstName(),emp.getLastName()));
					System.out.println(emp.getssn());
			
		    
	}

}
