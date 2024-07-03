package com.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.validation.Validation;

// Using Hibernate Validator
public class Uservalidation {
	public static void main(String[] args)
	{
	ValidatorFactory validatorfactory= Validation.buildDefaultValidatorFactory();
	Validator validator=validatorfactory.getValidator();
	System.out.println("-------------------------");
	System.out.println("Checking for Invalid user data..");
	System.out.println("-------------------------");
	User invalidUser=new User(1l,"a","test123",123456,"JavaTechnology","db","","1234","y",-2,1,new Date(),getPastOrFutureDate(34),getPastOrFutureDate(-2),5,"sample1.com","123@");
	Set<ConstraintViolation<User>> violations=validator.validate(invalidUser);
	if(violations.isEmpty()) {
		System.out.println("Valid UserData provided");
		Transaction tr=null;
  	     try(Session session= HBUtil.getSesFactory().openSession())
  	     {
  	    	 tr=(Transaction) session.beginTransaction();
  	    	 session.persist(invalidUser);
  	    	 
  	    	   tr.commit(); 
  	     }
  	     catch(Exception x)
  	     {
  	    	 if(tr!=null)
  	    	 {  
  	    		 tr.rollback();
  	    	     x.printStackTrace(); 
  	           
  	    	 }
  	     }
	}
	else {
		System.out.println("Invalid user data found");
		for(ConstraintViolation<User> violation:violations)
		{
			System.out.println(violation.getMessage());
		}
	}
	
	System.out.println("-------------------------");
	
	System.out.println("Checking for valid user data..");
	System.out.println("-------------------------");
	
	
	User validUser=new User(1L,"krish","a@gmail.com",16,"5","3","ML",null,"YN",2,0,getPastOrFutureDate(2),getPastOrFutureDate(1),getPastOrFutureDate(-2),2,"https://www.vsb.org/","4532015112830366");
    violations=validator.validate(validUser);
  
	
    if (violations.isEmpty()) {
        System.out.println("Valid user data provided");
        Transaction tr = null;
        try (Session session = HBUtil.getSesFactory().openSession()) {
            tr = (Transaction)session.beginTransaction();
            session.persist(validUser);
            tr.commit();
            System.out.println("User data persisted successfully");
        } catch (Exception x) {
            if (tr != null) {
            	try {
                    tr.rollback();
                    System.out.println("Transaction rolled back due to an error");
                } catch (RuntimeException rbEx) {
                    System.err.println("Couldn’t roll back transaction " + rbEx);
                }
            }x.printStackTrace();
        }
    }
    else {
        System.out.println("Invalid user data found");
        for (ConstraintViolation<User> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

	System.out.println("-------------------------");
	}
	public static Date getPastOrFutureDate(int days)
	{
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	
}

