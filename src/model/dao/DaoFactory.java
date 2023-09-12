package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;

public class DaoFactory {

    public static SellerDAO createSellerDAO() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDAO createDepartmentDAO() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
