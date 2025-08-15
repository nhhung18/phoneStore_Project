package com.vti.service;

import com.vti.dto.customerDto;
import com.vti.entity.customer;
import com.vti.form.createCustomerForm;
import com.vti.form.updateCustomerForm;
import com.vti.form.updateProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//     Là giao diện tầng service quy định hàm lấy toàn bộ khách hàng.
//        Class nào implements nó sẽ phải viết code thực hiện hàm này như customerService ,
//        thường gọi tới Repository để lấy dữ liệu.

// ==> Ngắn gọn: Định nghĩa ra các hàm và class nào implements nó thì
// phải triển khai hàm ra
public interface ICustomerService {
    Page<customerDto> getAllCustomer(Pageable pageable);

    customerDto getCustomerById(short id);

    void deleteCustomerById(short id);

    void updateCustomerById(short id, updateCustomerForm form) throws Exception;

    void createCustomer(createCustomerForm form) throws Exception;
}
