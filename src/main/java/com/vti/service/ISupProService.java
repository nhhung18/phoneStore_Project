package com.vti.service;

import com.vti.dto.supProDto;
import com.vti.entity.supPro;
import com.vti.entity.supProID;
import com.vti.form.updateSupProForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISupProService {
    Page<supProDto> getAllSupPro(Pageable pageable);

    supProDto getSupProById(supProID id);

    void deleteSupProById(supProID id);

    void updateSupProById(supProID id, updateSupProForm form);
}
