package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.DmartRequestDto;
import com.dto.DmartResponceDto;
import com.entity.Dmarts;
import com.exception.IdNotFoundException;
import com.repository.DmartRepository;

@Service
public class DmartServiceImpl implements DmartService
{

	@Autowired
	DmartRepository dmartRepository;
    

	@Override
	public DmartResponceDto saving(DmartRequestDto requestDto) {
		Dmarts dmart=new Dmarts();
		dmart.setDmartName(requestDto.getDmartName());
		dmart.setManagerName(requestDto.getManagerName());
		dmart.setLandLine(requestDto.getLandLine());
		dmart.setPincode(requestDto.getPincode());
		dmart.setState(requestDto.getState());
		Dmarts save = dmartRepository.save(dmart);
		DmartResponceDto dto =new DmartResponceDto();
		BeanUtils.copyProperties(save, dto);
		return dto;
	}

	@Override
	public List<DmartResponceDto> findAll() {
		List<Dmarts> all = dmartRepository.findAll();
	   List<DmartResponceDto>dtolist=new ArrayList<>();
	   for(Dmarts dmart :all)
	   {
		   DmartResponceDto dtos=new DmartResponceDto();
		   BeanUtils.copyProperties(dmart, dtos);
		   dtolist.add(dtos);
	   }
	  
		return dtolist;
	}

	@Override
	public DmartResponceDto byId(Long id) {
		
		Dmarts dmarts = dmartRepository.findById(id).get();
		DmartResponceDto res=new DmartResponceDto();
		BeanUtils.copyProperties(dmarts, res);
		return res;
	}

	@Override
	public List<DmartResponceDto> searchIds(List<Long> ids) {
		List<Dmarts> allById =  dmartRepository.findAllById(ids);
		if(allById.isEmpty())
		{
			throw new IdNotFoundException("no id found with this ids");
		}
				                
		List<DmartResponceDto> dtoList=new ArrayList<>();
		for(Dmarts dmart :allById)
		{
			DmartResponceDto dto=new DmartResponceDto();
			BeanUtils.copyProperties(dmart,dto);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public List<DmartResponceDto> searchNames(List<String> name) 
	{
		List<Dmarts> byManagerName = dmartRepository.findByManagerNameIn(name);
		List<DmartResponceDto> dtoList=new ArrayList<>();
		for(Dmarts dmart :byManagerName )
		{
			DmartResponceDto dto=new DmartResponceDto();
			BeanUtils.copyProperties(dmart,dto);
			dtoList.add(dto);
		}
		return dtoList;
	

	

	}
	
}	