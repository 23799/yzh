package com.example.farm.controller;

import com.example.farm.dto.ApiResponse;
import com.example.farm.entity.Land;
import com.example.farm.repository.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/land")
public class LandController {
    @Autowired private LandRepository landRepository;

    @PostMapping("/add")
    public ApiResponse<Void> add(@RequestBody Land land){
        if(land.getLandName()==null) return ApiResponse.err("landName 不能为空");
        landRepository.save(land);
        return ApiResponse.okMsg("新增地块成功");
    }

    @GetMapping("/del")
    public ApiResponse<Void> delGet(@RequestParam Integer id){
        Optional<Land> opt = landRepository.findById(id);
        if(opt.isEmpty()) return ApiResponse.err("地块不存在");
        landRepository.deleteById(id);
        return ApiResponse.okMsg("删除成功");
    }

    @GetMapping("/getAll")
    public ApiResponse<List<Land>> getAll(){
        return ApiResponse.ok(landRepository.findAll());
    }
}
