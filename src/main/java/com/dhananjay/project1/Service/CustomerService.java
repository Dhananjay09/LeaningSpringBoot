package com.dhananjay.project1.Service;

import com.dhananjay.project1.Model.Customer;
import com.dhananjay.project1.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    private int customerId = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public  Customer addCustomer(Customer customer){
        customer.setCustomerID(customerId);
        customerId += 1;
        customerList.add(customer);
        return customer;
    }

    public List<Customer> getCustomers(){
        return customerList;
    }

    public  Customer getCustomer(int customerId){
        return customerList.
                stream().
                filter(c -> c.getCustomerID() == customerId).
                findFirst().
                get();
    }

    public Customer updateCustomer(int customerId, Customer customer){
        customerList.stream().forEach(c-> {
            if (c.getCustomerID() == customerId){
                c.setCustomerFirstName(customer.getCustomerFirstName());
                c.setCustomerLastName(customer.getCustomerLastName());
                c.setCustomerEmail(customer.getCustomerEmail());
            }
        });
        return customerList.stream().filter(c-> c.getCustomerID() == customerId).findFirst().get();
    }

    public void deleteCustomer(int customerId){
        customerList.stream().forEach(c-> {
            if (c.getCustomerID() == customerId){
                customerList.remove(c);
            }
        });
    }

}
