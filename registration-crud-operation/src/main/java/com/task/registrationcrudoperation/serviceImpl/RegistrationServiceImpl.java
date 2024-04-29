package com.task.registrationcrudoperation.serviceImpl;

import com.task.registrationcrudoperation.entity.Customer;
import com.task.registrationcrudoperation.repository.RegistrationRepo;
import com.task.registrationcrudoperation.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;


    @Override
    public Customer createUser(Customer registration) {
        return registrationRepo.save(registration);
    }

    @Override
    public List<Customer> getAllUsers() {
        return registrationRepo.findAll();
    }

    @Override
    public Optional<Customer> getUserById(int id) {
            return registrationRepo.findById(id);
    }

//    @Override
//    public Registration updateUser(int id, Registration registration) {
//        if (registrationRepo.existsById(id)) {
//            registration.setId(id);
//            return registrationRepo.save(registration);
//        }
//        return null;
//    }
    public Customer updateUser(int id, Customer updateRegistration)
    {
        Customer registration=registrationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id:"+id));
        registration.setFirstName(updateRegistration.getFirstName());
        registration.setLastName(updateRegistration.getLastName());
        registration.setEmailId(updateRegistration.getEmailId());
        registration.setGender(updateRegistration.getGender());
        registration.setPhoneNo(updateRegistration.getPhoneNo());
        registration.setDateOfBirth(updateRegistration.getDateOfBirth());
        registration.setAddress(updateRegistration.getAddress());
        return  registrationRepo.save(registration);

    }

    @Override
    public void deleteUserById(int id) {
            registrationRepo.deleteById(id);
    }




}
