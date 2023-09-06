package com.thimodule3.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IGenerateService <E>{
    List<E> findAll();
    E findOne(HttpServletRequest request);
    void create(HttpServletRequest request);
    void delete(HttpServletRequest request);
    void update(HttpServletRequest request);
}
