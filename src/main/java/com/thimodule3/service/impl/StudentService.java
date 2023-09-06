package com.thimodule3.service.impl;

import com.thimodule3.DAO.impl.StudentDAO;
import com.thimodule3.model.Classroom;
import com.thimodule3.model.Student;
import com.thimodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class StudentService implements IGenerateService<Student> {
   private static StudentService studentService;
   public static StudentService getInstance(){
       if (studentService == null){
           studentService = new StudentService();
       }
       return studentService;
   }
    @Override
    public List<Student> findAll() {
        return StudentDAO.getInstance().findAll();
    }

    @Override
    public Student findOne(HttpServletRequest request) {
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        return StudentDAO.getInstance().findOne(idStudent);
    }

    @Override
    public void create(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String phoneNumber = request.getParameter("phoneNumber");
        Classroom classroom = ClassroomService.getInstance().findOne(request);
        String address = request.getParameter("address");
        Student student = new Student(name,email,dob,phoneNumber,classroom,address);
        StudentDAO.getInstance().create(student);
    }

    @Override
    public void delete(HttpServletRequest request) {
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        StudentDAO.getInstance().delete(idStudent);

    }

    @Override
    public void update(HttpServletRequest request) {
        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));
        String phoneNumber = request.getParameter("phoneNumber");
        Classroom classroom = ClassroomService.getInstance().findOne(request);
        String address = request.getParameter("address");
        Student student = new Student(idStudent,name,email,dob,phoneNumber,classroom,address);
        StudentDAO.getInstance().create(student);

    }
}
