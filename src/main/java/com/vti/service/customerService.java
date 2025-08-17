package com.vti.service;

import com.vti.dto.customerDto;
import com.vti.dto.productDto;
import com.vti.entity.customer;
import com.vti.entity.product;
import com.vti.form.createCustomerForm;
import com.vti.form.customerFormForRegister;
import com.vti.form.updateCustomerForm;
import com.vti.form.updateProductForm;
import com.vti.repository.ICustomerRepository;
import com.vti.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class customerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<customerDto> getAllCustomer(Pageable pageable) {
        // Lấy dữ liệu theo phân trang
        Page<customer> customers = customerRepository.findAll(pageable);
        Page<customerDto> customerDtos = customers.map(new Function<customer,customerDto>() {
            @Override
            public customerDto apply(customer customer) {
                customerDto customerDto = mapper.map(customer, customerDto.class);
                return customerDto;
            }
        });
        return customerDtos;
    }

    @Override
    public customerDto getCustomerById(short id) {
        customer entities = customerRepository.getById(id);
        customerDto dto = mapper.map(entities, customerDto.class);
        return dto;
    }

    @Override
    public void deleteCustomerById(short id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void updateCustomerById(short id, updateCustomerForm form) throws Exception{
        customer customer = customerRepository.findById(id).orElseThrow(() -> new Exception("Khach hang khong ton tai"));
        if (form.getFullname() != null) customer.setFullname(form.getFullname());
        if (form.getAddress() != null) customer.setAddress(form.getAddress());
        if (form.getPhone_num() != null) customer.setPhone_num(form.getPhone_num());
        customerRepository.save(customer);
    };

    @Override
    public void createCustomer(createCustomerForm form) throws Exception{
        if (customerRepository.existsByUsername(form.getUsername())) {
            throw new Exception("Username đã tồn tại");
        }if (customerRepository.existsByEmail(form.getEmail())) {
            throw new Exception("Email đã tồn tại");
        }

        customer customer = new customer();
        customer.setEmail(form.getEmail());
        customer.setUsername(form.getUsername());
        customer.setFullname(form.getFullname());
        customer.setAddress(form.getAddress());
        customer.setPhone_num(form.getPhone_num());
        customer.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        if (form.getPhone_num() != null) customer.setRole(form.getRole());
        customerRepository.save(customer);
    };

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        customer customer = customerRepository.findByUsername(username);

        if (customer == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_" + customer.getRole());

        return new org.springframework.security.core.userdetails.User(
                customer.getUsername(),
                customer.getPassword(),
                authorities);
    }

    @Override
    public customer getLoginByUsername(String username) {
        return customerRepository.findByUsername(username);
    }


    @Override
    public void registerCustomer(customerFormForRegister form) throws Exception{
        if (customerRepository.existsByUsername(form.getUsername())) {
            throw new Exception("Username đã tồn tại");
        }if (customerRepository.existsByEmail(form.getEmail())) {
            throw new Exception("Email đã tồn tại");
        }

        customer customer = new customer();
        customer.setEmail(form.getEmail());
        customer.setUsername(form.getUsername());
        customer.setFullname(form.getFullname());
        customer.setAddress(form.getAddress());
        customer.setPhone_num(form.getPhone_num());
        customer.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        if (form.getPhone_num() != null) customer.setRole(form.getRole());

        customerRepository.save(customer);
    };
}
