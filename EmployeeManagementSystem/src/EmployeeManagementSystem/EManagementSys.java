package EmployeeManagementSystem;
import java.util.Scanner;
import java.util.*;

class Employee{
	
	 private int e_id;
	 private String name;
	 private String department;
	 private double sallary;
	 
	 public Employee(int e_id,String name,String department,double sallary) {
		this.e_id=e_id;
		this.name=name;
		this.department=department;
		this.sallary=sallary;
	 }
	 
	 int getId() {
		 return e_id;
	 }
	 String getName() {
		 return name;
	 }
	 String getDepartment() {
		 return department;
	 }
	 double getSallay() {
		 return sallary;
	 }
	 
	 void setDepartment(String department) {
		 this.department=department;
	 }
	 void setSallary(double sallary) {
		 this.sallary=sallary;
	 }
	 String getEmployee() {
		 return "E_id:"+e_id+"\nName: "+name+"\nDepartment:"+department+"\nSallary:"+sallary+"\n";
	 }
	 
}

public class EManagementSys {

	private static List<Employee> employees=new ArrayList<Employee>();
	private static int  nextId=1;
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		int choice;
		System.out.println("Employee Management System\n");
	do {
		System.out.println( "1.Add Employee\n"
				+ "2.Delete Employee\n"
				+ "3.Update sallary\n"
				+ "4.Update Department\n"
				
				+ "5.view All Employees\n"
				+ "6.Exit\n");
		System.out.println("Enter your choice:");
		 choice=sc.nextInt();
		switch(choice) {
		case 1:addEmployee();
		break;
		case 2:deleteEmployee();
		 break;
		case 3:updateSallary();
		 break;
		case 4:updateDepartment();
		 break;
		case 5:viewEmployees();
		break;
		case 6:System.out.println("Exited from program");
		}
		
	}while(choice!=6);
		

	}
	
	static void addEmployee() {
		System.out.println("Enter Employee name:");
		String name=sc.next();
		System.out.println("Enter Employee department:");
		String department=sc.next();
		System.out.println("Enter Employee Sallary:");
		double sallary=sc.nextDouble();
		Employee employee=new Employee(nextId++,name,department,sallary);
		employees.add(employee);
		System.out.println("Employee added succesfully\n");
		
		
	}
	
	static void viewEmployees() {
		if(employees.size()==0) {
			System.out.println("No Employees present\n");
			return ;
		}
	System.out.println("Employee Details:\n");
		for(Employee employee:employees) {
			System.out.println(employee.getEmployee());
		}
	}
	
	static void deleteEmployee() {
		System.out.println("Enter emplyee id");
		int id=sc.nextInt();
		for(Employee employee:employees) {
			if(employee.getId()==id) {
				employees.remove(employee);
				System.out.println("Employee deleted succesfully\n");
				break;
			}
		}
		
	}
	static void updateSallary() {
		System.out.println("Enter emplyee id");
		int id=sc.nextInt();
		System.out.println("Sallary:");
		double sallary =sc.nextDouble();
		for(Employee employee:employees) {
			if(employee.getId()==id) {
				employee.setSallary(sallary);
				System.out.println("Employee sallary updated succesfully\n");
				break;
			}
		}
	}
	
	static void updateDepartment() {
		System.out.println("Enter emplyee id");
		int id=sc.nextInt();
		System.out.println("Department:");
		String department =sc.next();
		for(Employee employee:employees) {
			if(employee.getId()==id) {
				employee.setDepartment(department);
				System.out.println("Employee Department updated succesfully\n");
				break;
			}
		}
	}
	
	

}
