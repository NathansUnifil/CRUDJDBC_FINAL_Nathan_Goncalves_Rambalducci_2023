package br.com.ExemploJDBC.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ExemploJDBC.model.Department;

public class Teste {

	public static void main(String[] args) {
		
		AbstractCRUD<Department> crud;
		// ...
		crud = new CRUDDepartment<Department>();
		try {
			System.out.println(crud.open());
			
			// INSERT
			Department d = new Department();
			d.setNameDepartment("Artes. Ciencias");
			d.setBuildingDepartment("Campus Principal");
			d.setNumberDepartment(18000.0);
			
			boolean res = crud.create(d);
			
			// DELETE
			boolean res1 = crud.delete(1);
			
			
			// UPDATE
			Department d = new Department();
			d.setIdDepartment(2);
			d.setNameDepartment("Departamento Fisica");
			d.setBuildingDepartment("Campus Principal");
			d.setNumberDepartment(180000.0);
			
			boolean res11 = crud.update(d);
			
			if(res11) {
				System.out.println("Feito");
			} else {
				System.out.println("Erro");
			}
			
			// Select by id
			Department dep = crud.getById(2);
			System.out.println(dep.getNameDepartment());
			
			
			ArrayList<Department> departments = crud.listAll();
			for(Department d : departments) {
				System.out.println(d.getNameDepartment());
			}
			System.out.println(crud.close());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
