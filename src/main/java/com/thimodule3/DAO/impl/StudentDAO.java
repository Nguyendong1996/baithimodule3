package com.thimodule3.DAO.impl;

import com.thimodule3.DAO.IGenerateDAO;
import com.thimodule3.connection.MyConnection;
import com.thimodule3.model.Classroom;
import com.thimodule3.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IGenerateDAO<Student> {
    private final String SELECT_Student= "select * from student;";
    private final String CREATE_STUDENT = "insert into student(name,email,dob,phoneNumber,idClassroom,address) value (?,?,?,?,?,?);";
    private final String UPDATE_Student = "update student set name = ?, email = ?,dob = ?,phoneNumber = ?,idClassroom= ?,address = ? where idStudent = ? ;";
    private final String DELETE_Student = "delete from student where idStudent = ?;";

    private static StudentDAO studentDAO;
    public static StudentDAO getInstance(){
        if (studentDAO == null){
            studentDAO = new StudentDAO();
        }
        return studentDAO;
    }
    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(SELECT_Student);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int idStudent = resultSet.getInt("idStudent");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                LocalDate dob = LocalDate.parse(resultSet.getString("dob"));
                String phoneNumber = resultSet.getString("phoneNumber");
                int idClassroom = resultSet.getInt("idClassroom");
                Classroom classroom = ClassroomDAO.getInstance().findOne(idClassroom);
                String address = resultSet.getString("address");
                Student student = new Student(idStudent,name,email,dob,phoneNumber,classroom,address);
                students.add(student);
            }
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public Student findOne(int id) {
        List<Student> students = findAll();
        for (Student student:students){
            if (student.getIdStudent() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public void create(Student student) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(CREATE_STUDENT);
            ps.setString(1,student.getName());
            ps.setString(2,student.getEmail());
            ps.setObject(3,student.getDob());
            ps.setString(4,student.getPhoneNumber());
            ps.setInt(5,student.getClassroom().getIdClassroom());
            ps.setString(6,student.getAddress());
ps.executeUpdate();
ps.close();
connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_Student);
            ps.setInt(1,id);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Student student) {
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_Student);
            ps.setString(1,student.getName());
            ps.setString(2,student.getEmail());
            ps.setObject(3,student.getDob());
            ps.setString(4,student.getPhoneNumber());
            ps.setInt(5,student.getClassroom().getIdClassroom());
            ps.setString(6,student.getAddress());
            ps.setInt(7,student.getIdStudent());
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
