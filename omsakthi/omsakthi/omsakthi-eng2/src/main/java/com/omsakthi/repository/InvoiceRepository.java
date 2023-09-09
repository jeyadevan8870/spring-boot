package com.omsakthi.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.omsakthi.model.InvoiceEntity;



public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
	
	@Query(value = "SELECT * FROM invoice i WHERE i.INVOICENUMBER = ?1", nativeQuery = true)
	InvoiceEntity getInvocieDetails(String invoiceNumber);

	


}
