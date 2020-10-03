package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("---Test 1 : Seller findById---");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);
		
		System.out.println("\n --- Test 2 : Seller findByDepartment ---");
		Department department = new Department(2 , null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("\n --- Test 3 : Seller findAll ---");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n --- Test 4 : Seller Insert ---");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted!!! New id = " + newSeller.getId());

		System.out.println("\n --- Test 5 : Seller Update ---");
		seller = sellerDao.findById(1);
		seller.setName("Bruce Wayne");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		int a = 0;
		System.out.println("\n --- Test 6 : Seller delete ---");
		System.out.println("Enter the id for delete test");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
