package com.vti.service;

import com.vti.entity.order;
import com.vti.repository.IorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService implements IorderService{
    @Autowired
    private IorderRepository iorderRepository;

    @Override
    public List<order> getAllOrder(){
        return iorderRepository.findAll();
    };
}
