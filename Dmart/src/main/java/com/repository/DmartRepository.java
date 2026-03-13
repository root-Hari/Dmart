package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Dmarts;
@Repository
public interface DmartRepository extends JpaRepository<Dmarts,Long>
{
	
List<Dmarts> findByManagerNameIn(List<String> name);
}
