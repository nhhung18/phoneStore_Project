package com.vti.service;

import com.vti.entity.customer;

import java.util.List;

//     Là giao diện tầng service quy định hàm lấy toàn bộ khách hàng.
//        Class nào implements nó sẽ phải viết code thực hiện hàm này như customerService ,
//        thường gọi tới Repository để lấy dữ liệu.

// ==> Ngắn gọn: Định nghĩa ra các hàm và class nào implements nó thì
// phải triển khai hàm ra
public interface ICustomerService {
    List<customer> getAllCustomer();
}
