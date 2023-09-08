package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        Department dp = new Department(1, "Books");

        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        Seller sl = new Seller(10, "Matheus", "matheus@gmail.com", new Date(), 13000.00, dp);
        System.out.println(dp);
        System.out.println(sl);
    }
}
