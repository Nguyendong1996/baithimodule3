package com.thimodule3.controller.impl;

import com.thimodule3.controller.IGenerateServlet;
import com.thimodule3.model.Classroom;
import com.thimodule3.model.Student;
import com.thimodule3.service.impl.ClassroomService;
import com.thimodule3.service.impl.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet implements IGenerateServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if (action== null){
    action = "";
}switch (action){
            case "":
                display(request,response);
                break;
            case "create":
                createGet(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "update":
                updateGet(request,response);
                break;
            case "displayClassroom":
                displayClassroom(request,response);
                break;
            case "createClassroom":
                createGetClassroom(request,response);
                break;
            case "updateClassroom":
                updateGetClassroom(request,response);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action== null){
            action = "";
        }switch (action){
            case "create":
                createPost(request,response);
                break;
            case "update":
                updatePost(request,response);
                break;
            case "createClassroom":
                createPotClassroom(request,response);
                break;
            case "updateClassroom":
                updatePotClassroom(request,response);
                break;
        }
    }

    @Override
    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
       List<Student> students = StudentService.getInstance().findAll();
       request.setAttribute("student",students);
       RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
       rd.forward(request,response);
    }

    @Override
    public void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classroom> classrooms = ClassroomService.getInstance().findAll();
        request.setAttribute("classroom",classrooms);
RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
rd.forward(request,response);
    }

    @Override
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
StudentService.getInstance().create(request);
response.sendRedirect("/students");
    }

    @Override
    public void updateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Classroom> classrooms = ClassroomService.getInstance().findAll();
 Student student =  StudentService.getInstance().findOne(request);
 request.setAttribute("student",student);
        request.setAttribute("classroom",classrooms);
 RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
 rd.forward(request,response);
    }

    @Override
    public void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
StudentService.getInstance().update(request);
RequestDispatcher requestDispatcher =request.getRequestDispatcher("/students");
requestDispatcher.forward(request,response);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
StudentService.getInstance().delete(request);
response.sendRedirect("/students");
    }
    public void displayClassroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException{
        List<Classroom> classrooms = ClassroomService.getInstance().findAll();
        request.setAttribute("classroom",classrooms);
        RequestDispatcher rd = request.getRequestDispatcher("displayClassroom.jsp");
        rd.forward(request,response);
    }
    public void createGetClassroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException{
        response.sendRedirect("createClassroom.jsp");
    }
    public void createPotClassroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException{
        ClassroomService.getInstance().create(request);
        response.sendRedirect("/students");
    }
    public void updateGetClassroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException{
       Classroom classroom= ClassroomService.getInstance().findOne(request);
       request.setAttribute("classroom",classroom);
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("updateClassroom.jsp");
        requestDispatcher.forward(request,response);
}
    public void updatePotClassroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException{
        ClassroomService.getInstance().update(request);
        response.sendRedirect("/students");
}}