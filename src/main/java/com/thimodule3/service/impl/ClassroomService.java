package com.thimodule3.service.impl;

import com.thimodule3.DAO.impl.ClassroomDAO;
import com.thimodule3.DAO.impl.StudentDAO;
import com.thimodule3.model.Classroom;
import com.thimodule3.model.Student;
import com.thimodule3.service.IGenerateService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

public class ClassroomService implements IGenerateService<Classroom> {
   private static ClassroomService classroomService;
    public static ClassroomService getInstance(){
        if (classroomService == null){
            classroomService = new ClassroomService();
        }
        return classroomService;
    }
    @Override
    public List<Classroom> findAll() {
        return ClassroomDAO.getInstance().findAll();
    }

    @Override
    public Classroom findOne(HttpServletRequest request) {
        int idClassroom = Integer.parseInt(request.getParameter("idClassroom"));
        return ClassroomDAO.getInstance().findOne(idClassroom);
    }

    @Override
    public void create(HttpServletRequest request) {
String classroom = request.getParameter("classroom");
Classroom classroom1 = new Classroom(classroom);
ClassroomDAO.getInstance().create(classroom1);
    }

    @Override
    public void delete(HttpServletRequest request) {
int idStudent = Integer.parseInt(request.getParameter("idClassroom"));
StudentDAO.getInstance().delete(idStudent);

    }

    @Override
    public void update(HttpServletRequest request) {
        int idClassroom = Integer.parseInt(request.getParameter("idClassroom"));
        String nameClassroom = request.getParameter("classroom");
        Classroom classroom = new Classroom(idClassroom,nameClassroom);
        ClassroomDAO.getInstance().update(classroom);
    }
}
