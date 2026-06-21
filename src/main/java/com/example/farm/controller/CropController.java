package com.example.farm.controller;

import com.example.farm.dto.ApiResponse;
import com.example.farm.entity.Crop;
import com.example.farm.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/crop")
public class CropController {
    @Autowired private CropRepository cropRepository;

    @PostMapping("/add")
    public ApiResponse<Void> add(@RequestBody Crop crop){
        if(crop.getLandId()==null) return ApiResponse.err("landId 不能为空");
        cropRepository.save(crop);
        return ApiResponse.okMsg("新增作物记录成功");
    }

    @GetMapping("/del")
    public ApiResponse<Void> del(@RequestParam Integer id){
        Optional<Crop> opt = cropRepository.findById(id);
        if(opt.isEmpty()) return ApiResponse.err("作物记录不存在");
        cropRepository.deleteById(id);
        return ApiResponse.okMsg("删除成功");
    }
}
