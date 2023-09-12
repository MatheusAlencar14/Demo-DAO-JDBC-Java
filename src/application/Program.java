package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        System.out.println("=== TESTE 01 (Seller findById) ===");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TESTE 02 (Seller findByDepartment) ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDAO.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("\n=== TESTE 03 (Seller findAll) ===");
        list = sellerDAO.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TESTE 04 (Seller insert) ===");
        Seller s1 = new Seller(null, "Miguel", "miguel@gmail.com", new Date(), 4000.00, department);
        sellerDAO.insert(s1);
        System.out.println("Inserido! Novo ID: " + s1.getId());

        System.out.println("\n=== TESTE 05 (Seller update) ===");
        seller = sellerDAO.findById(2);
        seller.setName("Maria Blue");
        seller.setBaseSalary(3459.00);
        sellerDAO.update(seller);
        System.out.println("Update concluído!");
    }
}
