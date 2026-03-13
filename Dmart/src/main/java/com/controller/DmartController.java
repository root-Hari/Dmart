package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.DmartRequestDto;
import com.dto.DmartResponceDto;
import com.service.DmartService;

@RestController
public class DmartController 
{
	@Autowired
	DmartService dmartService;
	
    @PostMapping("/save")
    public DmartResponceDto saving(@RequestBody DmartRequestDto requestDto)
    {
    	return dmartService.saving(requestDto);
    }
    
    @GetMapping("/findAll")
    public List<DmartResponceDto>findAll()
    {
		return dmartService.findAll();
    	
    }
    
    @GetMapping("/findById/{id}")
    public DmartResponceDto byId(@PathVariable("id")Long id)
    {
    	return dmartService.byId(id);
    }
    
    @GetMapping("/ids")
    public List<DmartResponceDto>findIds(@RequestParam ("id")List<Long>ids)
    {
    	return dmartService.searchIds(ids);
    }
    
    @GetMapping("/name")
    public List<DmartResponceDto>findNames(@RequestParam ("name") List<String>name)
    {
    	return dmartService.searchNames(name);
    }

}
