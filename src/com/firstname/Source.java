package com.firstname;

import java.util.*;

class Employee {
  // Implement the class according to the specification given in the stub..

  private String firstName;
  private String lastName;
  private String ssn;
  public Employee(){

  }
public Employee (String firstName,String lastName,String ssn){
  this.firstName=firstName;
  this.lastName=lastName;
  this.ssn=ssn;
}
public String getFirstName()
{
  return firstName;
  
}
public void setFirstName(String firstName){
  this.firstName=firstName;
}
public String getlastName(){
  return lastName;
}

public void setlastName(String lastName){
  this.lastName=lastName;
}
public String getssn(){
  return ssn;
}
public void setssn(String ssn){
  this.ssn=ssn;

}
public String validateName(String firstName,String lastName){
if(firstName==null||lastName==null){
    try
    {
      throw new NullPointerException("Entry missing");
    }catch(NullPointerException ex){
      return ex.getMessage();
    }
  }
  
else if(firstName.length()==0||lastName.length()==0){
    try {
      throw new StringIndexOutOfBoundsException("Index out of bound");
    }catch(StringIndexOutOfBoundsException ex){
      return ex.getMessage();
    }
  }
else if(Character.isDigit(firstName.charAt(0))||Character.isDigit(lastName.charAt(0)));
    {
      try
      {
        throw new IllegalArgumentException("First character is invaild");
      }catch(IllegalArgumentException ex){
        return ex.getMessage();
      }
    }


}

public String vaildateSsn(String ssn){
if (Character.isDigit(ssn.charAt(0))&&Character.isDigit(ssn.charAt(ssn.length()
 -1))){
    return "Vaild String";
  }

else{
  return "Invalid String";
}
}

}

public class Source{
	public static void main(String[] args) {
    //Implemnt main() to check your program...
    //Don't remove the main() function or RUN CODE will not work...
Employee emp=new Employee("Robert","Alex","7bcf3");
System.out.println(emp.validateName(emp.getFristName(),emp.getlastName()));
System.out.println(emp.vaildateSsn(emp.getssn()));
