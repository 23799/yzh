package com.example.farm.controller;

import com.example.farm.dto.ApiResponse;
import com.example.farm.dto.LoginRequest;
import com.example.farm.entity.User;
import com.example.farm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired private UserRepository userRepository;

    @PostMapping("/login")
    public ApiResponse<Map<String,Object>> login(@RequestBody LoginRequest req){
        if(req.getUsername()==null || req.getPwd()==null){
            return ApiResponse.err("缺少用户名或密码");
        }
        return userRepository.findByUsername(req.getUsername())
            .map(u -> {
                String stored = u.getPwd();
                boolean ok = false;
                if(stored != null){
                    try {
                        ok = BCrypt.checkpw(req.getPwd(), stored);
                    } catch (Exception ex) {
                        ok = false;
                    }
                    if(!ok && req.getPwd().equals(stored)) ok = true;
                }
                if(!ok) return ApiResponse.err("账号或密码错误");
                Map<String,Object> data = new HashMap<>();
                data.put("role", req.getUsername().equalsIgnoreCase("admin") ? "admin" : "farmer");
                return ApiResponse.ok(data);
            }).orElse(ApiResponse.err("账号或密码错误"));
    }
}
