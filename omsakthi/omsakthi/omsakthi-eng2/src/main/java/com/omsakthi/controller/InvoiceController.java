package com.omsakthi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.omsakthi.dto.Invoice;
import com.omsakthi.dto.Particulars;
import com.omsakthi.model.InvoiceEntity;
import com.omsakthi.model.ParticularEntity;
import com.omsakthi.model.Vendor;
import com.omsakthi.model.request.InvoiceDetailRequest;
import com.omsakthi.repository.VendorRepository;
import com.omsakthi.service.InvoiceService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class InvoiceController {

	@Autowired
	private ModelMapper modelMapper;

	private InvoiceService invoiceService;

	public InvoiceController(InvoiceService invoiceService) {
		super();
		this.invoiceService = invoiceService;
	}

	@PostMapping("/createInvoice")
	public ResponseEntity<String> createInvoice(@RequestBody Invoice invoice) {

		InvoiceEntity invoiceEntity = modelMapper.map(invoice, InvoiceEntity.class);

		List<ParticularEntity> listParticularEntity = Arrays
				.asList(modelMapper.map(invoice.getParticulars(), ParticularEntity[].class));

		List<ParticularEntity> newList = listParticularEntity.stream().map(e -> {
			e.setInvoiceNumber(invoice.getInvoiceNumber());
			return e;
		}).collect(Collectors.toList());

		// TODO Insert Invoice data
		invoiceService.createInvoice(invoiceEntity, newList);
		// TODO Insert Particulars Data

		// Test

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/getInvoice")
	public List<Invoice> getAllInvoice() {

		return invoiceService.getAllInvoice().stream().map(invoice -> modelMapper.map(invoice, Invoice.class))
				.collect(Collectors.toList());
	}

	@PostMapping("/getInvocieDetails")
	public Invoice getInvocieDetails(@RequestBody InvoiceDetailRequest invoiceDetailRequest) {

		String invoiceNumber = invoiceDetailRequest.getInvoiceNumber();

		// TODO Insert Invoice data
		InvoiceEntity invoiceEntity = invoiceService.getInvocieDetails(invoiceNumber);

		List<ParticularEntity> listParticularEntity = invoiceService.getParticularDetails(invoiceNumber);
		// TODO Insert Particulars Data
	
		// Test

		Invoice invoice = new Invoice();
		invoice.setCgst(invoiceEntity.getCgst());
		invoice.setInvoiceDate(invoiceEntity.getInvoiceDate());
		invoice.setInvoiceNumber(invoiceEntity.getInvoiceNumber() + "");
		invoice.setSgst(invoiceEntity.getSgst());
		invoice.setTax(invoiceEntity.getTax());
		invoice.setTotalAmount(invoiceEntity.getTotalAmount());
		invoice.setVendorId(invoiceEntity.getVendorId());

		List<Particulars> particularsList = new ArrayList<>();
		for (ParticularEntity particularEntity : listParticularEntity) {
			Particulars particulars = new Particulars();
			particulars.setHsnsac(particularEntity.getHsnsac());
			particulars.setInvoiceNumber(particularEntity.getInvoiceNumber());
			particulars.setItem(particularEntity.getItem());
			particulars.setQuantity(particularEntity.getQuantity() + "");
			particulars.setRate(particularEntity.getRate() + "");
			particulars.setTotalPrice(particularEntity.getTotalPrice() + "");
			particularsList.add(particulars);
		}
		invoice.setParticulars(particularsList);

		return invoice;
	}
	@PostMapping("/updateInvoice")
	public ResponseEntity<InvoiceEntity> updateEmployee(@RequestBody Invoice invoice){
		

		InvoiceEntity invoiceEntity = modelMapper.map(invoice, InvoiceEntity.class);

		List<ParticularEntity> listParticularEntity = Arrays
				.asList(modelMapper.map(invoice.getParticulars(), ParticularEntity[].class));

		List<ParticularEntity> newList = listParticularEntity.stream().map(e -> {
			e.setInvoiceNumber(invoice.getInvoiceNumber());
			return e;
		}).collect(Collectors.toList());

		
		
		return new ResponseEntity<InvoiceEntity>(invoiceService.updateEmployee(invoiceEntity, newList), HttpStatus.OK);
	}
	
	

}
