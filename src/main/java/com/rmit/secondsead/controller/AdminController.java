package com.rmit.secondsead.controller;

import com.rmit.secondsead.model.Admin;
import com.rmit.secondsead.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;


    @PostMapping(path = "/deladmins")
    public List<Admin> deleteAdmins(@RequestBody List<Admin> adminList) {

        return adminService.delAdmins(adminList);
    }

    @PostMapping(path = "/admin")
    public Admin addAdmin(@RequestBody Admin admin) {

        return adminService.addAdmin(admin);
    }

    @PostMapping(path = "/admins")
    public List<Admin> addAdmins(@RequestBody List<Admin> adminList) {
        System.out.println("Adding " + adminList.size() + " admins");
        System.out.println(adminList.get(0).getId());
        return adminService.addAdmins(adminList);
    }

    @GetMapping(path = "/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping(path = "/admin/{id}")
    public void deleteAdmin(@RequestParam int id) {
        adminService.delAdmin(id);
    }

    @PutMapping(path = "/admin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updAdmin(admin);
    }

    @PostMapping(path = "/admin/login/phone={phone}&pin={pin}")
    public Boolean loginAdmin(@PathVariable String phone, @PathVariable String pin) {
        System.out.println(phone);
        System.out.println(pin);
        return adminService.loginAdmin(phone, pin);
    }

    @PostMapping(path = "/admin/register")
    public Boolean registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

}
