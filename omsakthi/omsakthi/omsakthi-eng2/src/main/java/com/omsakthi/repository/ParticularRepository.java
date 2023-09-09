package com.omsakthi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.omsakthi.model.ParticularEntity;

public interface ParticularRepository extends JpaRepository<ParticularEntity, Long> {

	@Query(value = "SELECT * FROM particular i WHERE i.INVOICENUMBER = ?1", nativeQuery = true)
	List<ParticularEntity> getParticularDetails(String invoiceNumber);
	  
	@Modifying
    @Transactional
	@Query(value = "DELETE FROM particular  WHERE INVOICENUMBER = ?1", nativeQuery = true)
	void deleteParticular(String invoiceNumber);
	
}
