package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ====");
		Department dep = departmentDao.findById(6);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: Department findAll ====");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== TEST 3: Department insert ====");
		Department newDepartment = new Department(null, "Sports");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== TEST 4: Department update ====");
		dep = departmentDao.findById(8);
		dep.setName("Food");
		departmentDao.update(dep);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 5: Department delete ====");
		departmentDao.deleteById(15);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
