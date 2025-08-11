package com.vti.service;

import com.vti.entity.supPro;
import com.vti.entity.supProID;
import com.vti.repository.ISupProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class supProService implements ISupProService{
    @Autowired
    private ISupProRepository supProRepository;
    @Override
    public List<supPro> getSupPro(){
        return supProRepository.findAll();
    };
}
