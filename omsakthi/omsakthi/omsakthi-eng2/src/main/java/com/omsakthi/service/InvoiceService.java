package com.omsakthi.service;

import java.util.List;

import com.omsakthi.dto.Invoice;
import com.omsakthi.dto.Particulars;
import com.omsakthi.model.InvoiceEntity;
import com.omsakthi.model.ParticularEntity;

public interface InvoiceService {
	
	String createInvoice(InvoiceEntity invoice ,List<ParticularEntity> particularEntity);

	List<InvoiceEntity> getAllInvoice();
	
	InvoiceEntity getInvocieDetails(String invoiceNumber);
	
	List<ParticularEntity> getParticularDetails(String invoiceNumber);
	
	InvoiceEntity updateEmployee(InvoiceEntity invoiceEntity, List<ParticularEntity> particularEntity);

	
}
