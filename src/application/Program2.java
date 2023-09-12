package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program2 {

    public static void main(String[] args) {

        DepartmentDAO departmentDAO = DaoFactory.createDepartmentDAO();

        System.out.println("\n=== TESTE 01 (Department insert) ===");
        Department d1 = new Department(null, "Music");
        departmentDAO.insert(d1);
        System.out.println("Inserido! Novo ID: " + d1.getId());

        System.out.println("\n=== TESTE 02 (Department update) ===");
        Department department = new Department(3, null);
        department.setName("Food");
        departmentDAO.update(department);
        System.out.println("Update concluído!");
    }
}
