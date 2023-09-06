package com.thimodule3.model;

public class Classroom {
   private int idClassroom;
    private String classroom;

    public Classroom(int idClassroom, String classroom) {
        this.idClassroom = idClassroom;
        this.classroom = classroom;
    }

    public Classroom(String classroom) {
        this.classroom = classroom;
    }

    public Classroom() {
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
