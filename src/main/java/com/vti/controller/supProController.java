package com.vti.controller;

import com.vti.dto.supProDto;
import com.vti.entity.supPro;
import com.vti.entity.supProID;
import com.vti.service.ISupProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("supPro")
@CrossOrigin("*")
public class supProController {
    @Autowired
    private ISupProService supProService;

    @GetMapping()
    public ResponseEntity<?> getSupPro() {
        List<supPro> entities = supProService.getSupPro();
        List<supProDto> dtos = new ArrayList<>();

        for (supPro sP: entities) {
            supProDto dto = new supProDto(sP.getSupplier(), sP.getProduct());
            dtos.add(dto);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
