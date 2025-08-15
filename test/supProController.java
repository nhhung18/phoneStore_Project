package com.vti.controller;


import com.vti.dto.supproDto;
import com.vti.entity.suppro;
import com.vti.form.createSupProForm;
import com.vti.form.updateSupProForm;
import com.vti.service.ISupProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@RestController
@RequestMapping(value = "suppro")
@CrossOrigin("*")
public class supproController {

    @Autowired
    private ISupProService supproService;

    @GetMapping()
    public ResponseEntity<?> getAllSupPro(Pageable pageable) {
        return new ResponseEntity<>(supproService.getAllSupPro(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getSupProById(@PathVariable(name = "id") short id) {
        return new ResponseEntity<>(supproService.getSupProById(id), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteSupProById(@PathVariable(name = "id") short id) {
        supproService.deleteSupProById(id);

        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateSupProById(@PathVariable(name = "id") short id, @RequestBody updateSupProForm form){
        supproService.updateSupProById(id, form);

        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createSupPro(@RequestBody createSupProForm form){
        supproService.createSupPro(form);
        return new ResponseEntity<String>("Tao san pham thanh cong", HttpStatus.OK);
    }
}
