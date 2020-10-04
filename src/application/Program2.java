package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("---Teste 1 : FindById---");
		Department department = departmentDao.findById(3);
		System.out.println(department);
/*		
		System.out.println("---Teste 2 : Insert---");
		Department newDepartment = new Department(null, "Drinks");
		departmentDao.insert(newDepartment);
		System.out.println("New Department Inserted! \n"+"New ID: " + newDepartment.getId() + "\n" + "New Name: " + newDepartment.getName());
	*/	
		System.out.println("---Teste 3 : Update---");
		department = departmentDao.findById(6);
		department.setName("Stellar Ships");
		departmentDao.update(department);
		System.out.println("Updated");
		
		System.out.println("---Teste 4 DeleteById---");
	//	department = departmentDao.findById(7);
		departmentDao.deleteById(7);
		System.out.println("Deleted");
		
		System.out.println("---Teste 5 findAll---");
		List<Department> depList = new ArrayList<>();
		depList = departmentDao.findAll();
		depList.forEach(System.out::println);
		
		sc.close();
	}

}
