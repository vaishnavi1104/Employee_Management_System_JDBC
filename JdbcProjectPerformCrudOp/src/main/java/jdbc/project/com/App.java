package jdbc.project.com;

import java.util.List;
import java.util.Scanner;

import javax.management.BadStringOperationException;

import com.project.dao.EmpDAO;
import com.project.dao.EmpDAOImpl;
import com.project.emp_entities.Emp;

public class App 
{
	private static final Scanner scanner = new Scanner(System.in);
	private static final EmpDAO empDAO = new EmpDAOImpl();

	public static void main( String[] args )
    {
        System.out.println( "Application Started" );
        while(true) {
        	System.out.println("......... Employee Management System .......");
        	System.out.println("1. Add Employee :: ");
        	System.out.println("2. Update Employee :: ");
        	System.out.println("3. Delete Employee :: ");
        	System.out.println("4. View All Employees :: ");
        	System.out.println("5. Exit");
        	
        	System.out.println("Enter Your Choise :: ");
        	int choise = scanner.nextInt();
        	
        	switch(choise){
        		case 1:
        			addEmployee();
        			break;
        		case 2:
        			updateEmployee();
        			break;
        		case 3:
        			deleteEmployee();
        			break;
        		case 4:
        			getAllEmployees();
        			break;
        		case 5:
        			System.out.println("Thank You! Please Come Again!!!..........");
        			System.exit(0);
        		default:
        			System.out.println("Invalid Input, Please try Again....");
        	}
        	
        }
        
    }
	
	

	public static void addEmployee() {
		while(true) {
				System.out.println("Enter Employee Id :: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Employee Name :: ");
				String name = scanner.nextLine();
				
				System.out.println("Enter Employee Department  :: ");
				String dept = scanner.nextLine();
				
				Emp emp = new Emp(id, name, dept);
				empDAO.addEmployee(emp);
				System.out.println("Employee added Successfully....");
				
				
				System.out.println("Do u want to add another employee? (yes/no) :");
				String response = scanner.nextLine();
				if(response.equalsIgnoreCase("no")) {
					break;
				}
		}
		
		
	}
			private static void updateEmployee() {
				System.out.println("Enter Employee Id :: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter Employee Name :: ");
				String name = scanner.nextLine();
				
				System.out.println("Enter Employee Department :: ");
				String dept  = scanner.nextLine();
				
				Emp emp = new Emp(id, name, dept);
				empDAO.updateEmployee(emp);
				System.out.println("Employee Updated Successfully...");
			}
    
    
			public static void deleteEmployee() {
				System.out.println("Enter Employee which you wants to Delete :: ");
				int id = scanner.nextInt();
				scanner.nextLine();
//				Emp emp = new Emp(id, name, dept);
				empDAO.deleteEmployee(id);
				System.out.println("Emploeyee Deleted Successfully...");
				System.out.println();
				System.out.println();
			
			}
				
			
			

			public static void getAllEmployees() {
				List<Emp> emps = empDAO.getAllEmployees();
				for(Emp emp : emps) {
					System.out.println(emp);
				}
				
			}
}