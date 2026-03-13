package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.DmartRequestDto;
import com.dto.DmartResponceDto;

@Service
public interface DmartService 
{

	DmartResponceDto saving(DmartRequestDto requestDto);

	List<DmartResponceDto> findAll();

	DmartResponceDto byId(Long id);

	List<DmartResponceDto> searchIds(List<Long> ids);

	List<DmartResponceDto> searchNames(List<String> name);



	

	
	

}
