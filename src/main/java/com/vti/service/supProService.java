package com.vti.service;

import com.vti.dto.productDto;
import com.vti.dto.supProDto;
import com.vti.entity.product;
import com.vti.entity.supPro;
import com.vti.entity.supProID;
import com.vti.form.updateSupProForm;
import com.vti.repository.ISupProRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class supProService implements ISupProService {
    @Autowired
    private ISupProRepository supProRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<supProDto> getAllSupPro(Pageable pageable) {
        Page<supPro> supPros = supProRepository.findAll(pageable);
        Page<supProDto> supProDtos = supPros.map(new Function<supPro, supProDto>() {
            @Override
            public supProDto apply(supPro supPro) {
                supProDto supProDto = mapper.map(supPro, supProDto.class);
                return supProDto;
            }
        });
        return supProDtos;
    }


    @Override
    public supProDto getSupProById(supProID id) {
        supPro entities = supProRepository.getById(id);
        supProDto dto = mapper.map(entities, supProDto.class);
        return dto;
    }
    ;

    @Override
    public void deleteSupProById(supProID id) {
        supProRepository.deleteById(id);
    }

    ;

    @Override
    public void updateSupProById(supProID id, updateSupProForm form) {
        supPro supPro = supProRepository.getById(id);
        if (form.getProduct_id() != null) supPro.setProduct(form.getProduct_id());
        supProRepository.save(supPro);
    }

//    @Override
//    public void createSupPro(createSupProForm form){
//        suppro suppro = new suppro();
//        suppro.setName(form.getName());
//        suppro.setPrice(form.getPrice());
//        suppro.setStockQuantity(form.getStock_quantity());
//        suppro.setCapacity(form.getCapacity());
//        suppro.setColor(form.getColor());
//        supproRepository.save(suppro);
//
//    };
}

