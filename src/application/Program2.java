package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program2 {

    public static void main(String[] args) {

        DepartmentDAO departmentDAO = DaoFactory.createDepartmentDAO();
        List<Department> list = new ArrayList<>();

        System.out.println("\n=== TESTE 01 (Department insert) ===");
        Department d1 = new Department(null, "Music");
        departmentDAO.insert(d1);
        System.out.println("Inserido! Novo ID: " + d1.getId());

        System.out.println("\n=== TESTE 02 (Department update) ===");
        Department department = new Department(3, null);
        department.setName("Food");
        departmentDAO.update(department);
        System.out.println("Update concluído!");

        System.out.println("\n=== TESTE 03 (Department delete) ===");
        departmentDAO.deleteById(7);
        System.out.println("Delete concluído!");

        System.out.println("\n=== TESTE 04 (Department findById) ===");
        Department dep = departmentDAO.findById(6);
        System.out.println(dep);

        System.out.println("\n=== TESTE 05 (Department findAll) ===");
        list = departmentDAO.findAll();
        list.forEach(System.out::println);
    }
}
