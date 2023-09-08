package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        System.out.println("=== TESTE 01 (Seller findById) ===");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);
    }
}
