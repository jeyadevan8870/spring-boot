package com.omsakthi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.omsakthi.dto.Invoice;
import com.omsakthi.dto.Particulars;
import com.omsakthi.exception.ResourceNotFoundException;
import com.omsakthi.model.InvoiceEntity;
import com.omsakthi.model.ParticularEntity;
import com.omsakthi.repository.InvoiceRepository;
import com.omsakthi.repository.ParticularRepository;
import com.omsakthi.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
private final InvoiceRepository invoiceRepository;
private final ParticularRepository particularRepository;
	
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository,ParticularRepository particularRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
		this.particularRepository=particularRepository;
	}
	
	@Override
	public String createInvoice(InvoiceEntity invoiceEntity,List<ParticularEntity> particularEntity ) {
		
		
		System.out.println(invoiceEntity.getInvoiceNumber());
		invoiceRepository.save(invoiceEntity);
		particularRepository.saveAll(particularEntity);
		return "";
	}
	
	@Override
	public List<InvoiceEntity> getAllInvoice() {
		return invoiceRepository.findAll();
	}

	@Override
	public InvoiceEntity getInvocieDetails(String invoiceNumber) {
		return invoiceRepository.getInvocieDetails(invoiceNumber);
	}
	
	@Override
	public List<ParticularEntity> getParticularDetails(String invoiceNumber) {
		return particularRepository.getParticularDetails(invoiceNumber);
	}
	
	@Override
	public InvoiceEntity updateEmployee(InvoiceEntity invoiceEntity, List<ParticularEntity> listParticularEntity) {
	    InvoiceEntity invoiceDetails = invoiceRepository.getInvocieDetails(invoiceEntity.getInvoiceNumber() + "");

	    if (invoiceDetails != null) {
	        
	        invoiceDetails.setInvoiceDate(invoiceEntity.getInvoiceDate());
	        invoiceDetails.setTotalAmount(invoiceEntity.getTotalAmount());
	        invoiceDetails.setCgst(invoiceEntity.getCgst());
	        invoiceDetails.setSgst(invoiceEntity.getSgst());
	        invoiceDetails.setTax(invoiceEntity.getTax());

	        System.out.println("DDDDDDDDDDDDd"+invoiceEntity.getInvoiceNumber());
	   particularRepository.deleteParticular(invoiceEntity.getInvoiceNumber() + "");
	        System.out.println("FFFFFFFFFFFFFFF");
	        
	        List<ParticularEntity> updatedParticulars = new ArrayList<>();
	        for (ParticularEntity particularEntity : listParticularEntity) {
	            ParticularEntity updatedParticular = new ParticularEntity();
	            updatedParticular.setHsnsac(particularEntity.getHsnsac());
	            updatedParticular.setInvoiceNumber(particularEntity.getInvoiceNumber());
	            updatedParticular.setItem(particularEntity.getItem());
	            updatedParticular.setQuantity(particularEntity.getQuantity());
	            updatedParticular.setRate(particularEntity.getRate());
	            updatedParticular.setTotalPrice(particularEntity.getTotalPrice());

	            updatedParticulars.add(updatedParticular);
	        }

	       // invoiceDetails.setParticulars(updatedParticulars);
	        invoiceRepository.save(invoiceDetails);
	        particularRepository.saveAll(updatedParticulars);
	        
	    } else {
	        System.out.println("Invoice number not found");
	    }

	    return invoiceDetails;
	}
	


	
	
}
