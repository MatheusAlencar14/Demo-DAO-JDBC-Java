package model.dao;

import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface SellerDAO {

    void insert(Seller seller);

    void update(Seller seller);

    void deleteById(Seller seller);

    Seller findById();

    List<Seller> findAll();
}
