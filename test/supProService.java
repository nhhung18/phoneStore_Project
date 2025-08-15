package com.vti.service;

import com.vti.dto.supproDto;
import com.vti.entity.suppro;
import com.vti.form.createSupProForm;
import com.vti.form.updateSupProForm;
import com.vti.repository.ISupProRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.lang.reflect.AccessibleObject;
import java.util.List;
import java.util.function.Function;

@Service
public class supproService implements ISupProService {
    @Autowired
    private ISupProRepository supproRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<supproDto> getAllSupPro(Pageable pageable) {
        // Lấy dữ liệu theo phân trang
        Page<suppro> suppros = supproRepository.findAll(pageable);
        Page<supproDto> supproDtos = suppros.map(new Function<suppro,supproDto>() {
            @Override
            public supproDto apply(suppro suppro) {
                supproDto supproDto = mapper.map(suppro, supproDto.class);
                return supproDto;
            }
        });
        return supproDtos;
    }

    @Override
    public supproDto getSupProById(short id) {
        suppro entities = supproRepository.getById(id);
        supproDto dto = mapper.map(entities, supproDto.class);
        return dto;
    }

    ;

    @Override
    public void deleteSupProById(short id) {
        supproRepository.deleteById(id);
    }

    ;

    @Override
    public void updateSupProById(short id, updateSupProForm form) {
        suppro suppro = supproRepository.getById(id);
        if (form.getName() != null) suppro.setName(form.getName());
        if (form.getPrice() != null) suppro.setPrice(form.getPrice());
        if (form.getStock_quantity() != null) suppro.setStockQuantity(form.getStock_quantity());
        if (form.getCapacity() != null) suppro.setCapacity(form.getCapacity());
        if (form.getColor() != null) suppro.setColor(form.getColor());
        supproRepository.save(suppro);
    }

    @Override
    public void createSupPro(createSupProForm form){
        suppro suppro = new suppro();
        suppro.setName(form.getName());
        suppro.setPrice(form.getPrice());
        suppro.setStockQuantity(form.getStock_quantity());
        suppro.setCapacity(form.getCapacity());
        suppro.setColor(form.getColor());
        supproRepository.save(suppro);

    };
}
