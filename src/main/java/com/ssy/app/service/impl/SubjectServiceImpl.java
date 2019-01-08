package com.ssy.app.service.impl;

import com.ssy.app.dao.SubjectMapper;
import com.ssy.app.enity.Subject;
import com.ssy.app.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectDao;
    @Override
    public List<Subject> selectAll() {
        return null;
    }
}
