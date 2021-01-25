package service;

import model.Customer;

import java.util.*;

public class CustomerService implements ICustomerService {
    private static Map<Long,Customer> customers;
    static {
        customers=new HashMap<>();
        customers.put(1L,new Customer(1L,"phong","phong@123","anhvu"));
        customers.put(2L,new Customer(2L,"phong1","phong@1234","anhvu1"));
        customers.put(3L,new Customer(3L,"phong2","phong@1235","anhvu2"));
        customers.put(4L,new Customer(4L,"phong3","phong@1236","anhvu3"));
    }
    public CustomerService(){};
    @Override
    public List<Customer> findAll() {
        ArrayList list= new ArrayList(customers.values());
        return list;
    }

    @Override
    public Customer findByID(Long id) {
        return customers.get(id);
    }

    @Override
    public Customer findByName(String name) {
        return null;
    }

    @Override
    public void update(Customer model) {
        customers.put(model.getId(),model);
    }

    @Override
    public void save(Customer model) {
        long maxId=0;
        maxId = Collections.max(customers.entrySet(),Map.Entry.comparingByKey()).getKey();
        model.setId(maxId+1);
        customers.put(maxId+1,model);
    }

    @Override
    public void remove(Long id) {
        customers.remove(id);
    }
}
