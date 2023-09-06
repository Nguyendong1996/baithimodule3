package com.thimodule3.DAO.impl;

import com.thimodule3.DAO.IGenerateDAO;
import com.thimodule3.connection.MyConnection;
import com.thimodule3.model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO implements IGenerateDAO<Classroom> {
    private static ClassroomDAO classroomDAO;
    private final String SELECT_Classroom = "select * from classroom;";
    private final String CREATE_CLASSROOM = "insert into classroom(classroom) value (?);";
    private final String DELETE_Classroom = "delete from classroom where idClassroom = ? ;";
    private final String UPDATE_classroom = "update classroom set classroom = ? where idClassroom = ? ;";
    public static ClassroomDAO getInstance(){
        if (classroomDAO == null){
            classroomDAO = new ClassroomDAO();
        }
        return classroomDAO;
    }
    @Override
    public List<Classroom> findAll() {
        List<Classroom> classrooms = new ArrayList<>();
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_Classroom);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int idClassroom = resultSet.getInt("idClassroom");
                String classroom = resultSet.getString("classroom");
                Classroom classroom1 = new Classroom(idClassroom,classroom);
                classrooms.add(classroom1);
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return classrooms;
    }

    @Override
    public Classroom findOne(int id) {
        List<Classroom> classrooms = findAll();
        for (Classroom classroom: classrooms){
            if (classroom.getIdClassroom() == id){
                return classroom;
            }
        }
        return null;
    }

    @Override
    public void create(Classroom classroom) {
try {
    Connection connection = MyConnection.getInstance().getConnection();
    PreparedStatement ps = connection.prepareStatement(CREATE_CLASSROOM);
    ps.setString(1, classroom.getClassroom());
    ps.executeUpdate();
    connection.close();
}catch (SQLException e){
    e.printStackTrace();
}
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_Classroom);
            ps.setInt(1,id);
            ps.executeUpdate();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Classroom classroom) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_classroom);
            ps.setString(1,classroom.getClassroom());
            ps.setInt(2,classroom.getIdClassroom());
            ps.executeUpdate();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
