package com.vti.controller;

import com.vti.dto.supProDto;
import com.vti.entity.supPro;
import com.vti.entity.supProID;
import com.vti.form.updateSupProForm;
import com.vti.service.ISupProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("supplierProduct")
@CrossOrigin("*")
public class supProController {
    @Autowired
    private ISupProService supProService;

//    @GetMapping()
//    public ResponseEntity<?> getSupPro(Pageable pageable) {
////        List<supPro> entities = supProService.getSupPro();
////        List<supProDto> dtos = new ArrayList<>();
////
////        for (supPro sP: entities) {
////            supProDto dto = new supProDto(sP.getSupplier(), sP.getProduct());
////            dtos.add(dto);
////        }
//        return new ResponseEntity<>(supProService.getSupPro(pageable), HttpStatus.OK);
//    }

    @Autowired
    private ISupProService supproService;

    @GetMapping()
    public ResponseEntity<?> getAllSupPro(Pageable pageable) {
        return new ResponseEntity<>(supproService.getAllSupPro(pageable), HttpStatus.OK);
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<?> getSupProById(@PathVariable(name = "id") supProID id) {
//        return new ResponseEntity<>(supproService.getSupProById(id), HttpStatus.OK);
//    }
//
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteSupProById(@PathVariable(name = "id") supProID id) {
//        supproService.deleteSupProById(id);
//        return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<?> updateSupProById(@PathVariable(name = "id") supProID id, @ RequestBody updateSupProForm form){
//        supproService.updateSupProById(id, form);
//        return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
//    }
//
//    @PostMapping()
//    public ResponseEntity<?> createSupPro(@RequestBody createSupProForm form){
//        supproService.createSupPro(form);
//        return new ResponseEntity<String>("Tao san pham thanh cong", HttpStatus.OK);
//    }
@GetMapping("/{supplierId}/{productId}")
public ResponseEntity<?> getSupProById(
        @PathVariable short supplierId,
        @PathVariable short productId) {

    supProID id = new supProID();
    id.setSupplierId(supplierId);
    id.setProductId(productId);

    supProDto dto = supproService.getSupProById(id);
    return new ResponseEntity<>(dto, HttpStatus.OK);
}

    @DeleteMapping("/{supplierId}/{productId}")
    public ResponseEntity<?> deleteSupProById(
            @PathVariable short supplierId,
            @PathVariable short productId) {

        supProID id = new supProID();
        id.setSupplierId(supplierId);
        id.setProductId(productId);

        supproService.deleteSupProById(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }

    @PutMapping("/{supplierId}/{productId}")
    public ResponseEntity<?> updateSupProById(
            @PathVariable short supplierId,
            @PathVariable short productId,
            @RequestBody updateSupProForm form) {

        supProID id = new supProID();
        id.setSupplierId(supplierId);
        id.setProductId(productId);

        supproService.updateSupProById(id, form);
        return new ResponseEntity<>("Cập nhật thành công", HttpStatus.OK);
    }
}
