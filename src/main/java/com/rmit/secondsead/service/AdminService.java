package com.rmit.secondsead.service;


import com.rmit.secondsead.model.Admin;
import com.rmit.secondsead.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository repository;


    public Admin addAdmin(Admin admin) {
        return this.repository.save(admin);
    }

    public List<Admin> addAdmins(List<Admin> admins) {
        return this.repository.saveAll(admins);
    }

    public void delAdmin(long admin) {
        repository.deleteById(admin);
    }

    public List<Admin> delAdmins(List<Admin> admins) {
        for (Admin admin : admins
        ) {
            delAdmin(admin.getId());
        }
        return this.repository.findAll();
    }

    public List<Admin> getAllAdmins() {
        return this.repository.findAll();
    }

    public Boolean loginAdmin(String phone, String pin) {
        Admin admin = repository.findByPhoneContains(phone);

        return admin.getPin().equals(pin);
    }

    public Boolean registerAdmin(Admin admin) {
        try {
            if (repository.findByPhoneContains(admin.getPhone()) != null) {
                return false;
            } else {
                if (admin.getPin().length() != 6) {
                    return false;
                } else {
                    repository.save(admin);
                    return true;
                }
            }
        } catch (Exception ignored) {
            return false;
        }
    }
    public Admin updAdmin(Admin admin){
        Admin existedAdmin=repository.findById(admin.getId()).get();
        existedAdmin.setName(admin.getName());
        existedAdmin.setPhone(admin.getPhone());
        existedAdmin.setPin(admin.getPin());

        return repository.save(existedAdmin);
    }
}
