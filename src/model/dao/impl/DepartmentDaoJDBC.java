package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDAO;
import model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDAO {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(
                    "INSERT INTO department (Name) VALUES (?)"
                    , Statement.RETURN_GENERATED_KEYS
            );

            pst.setString(1, department.getName());

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    department.setId(id);
                } else {
                    throw new DbException("Erro: Nenhuma linha foi alterada!");
                }
                DB.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pst);
        }
    }

    @Override
    public void update(Department department) {
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(
                    "UPDATE department SET Name = ? WHERE Id = ?"
            );

            pst.setString(1, department.getName());
            pst.setInt(2, department.getId());

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pst);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ?"
            );

            pst.setInt(1, id);
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pst);
        }
    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
