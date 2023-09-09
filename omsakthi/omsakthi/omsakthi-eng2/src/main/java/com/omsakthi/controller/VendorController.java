package com.omsakthi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omsakthi.model.Vendor;
import com.omsakthi.repository.VendorRepository;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class VendorController {
	@Autowired
	VendorRepository vendorRepository;
	
	@PostMapping("/vendor")
	public ResponseEntity<Vendor> createTutorial(@RequestBody Vendor vendor) {
		try {
			Vendor vendorController = vendorRepository
					.save(vendor);
			return new ResponseEntity<>(vendorController, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/vendor")
	public ResponseEntity<List<Vendor>> getAllVendor(@RequestParam(required = false) String vendorName) {
		try {
			List<Vendor> vendor = new ArrayList<Vendor>();

			if (vendorName == null)
				vendorRepository.findAll().forEach(vendor::add);
			else
				vendorRepository.findByVendorNameContaining(vendorName).forEach(vendor::add);

			if (vendor.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(vendor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/vendor/{vendorName}")
	public ResponseEntity <List<Vendor>> getVendorsByName(@PathVariable("vendorName") String vendorName) {
	    List<Vendor> vendors = vendorRepository.findByVendorNameContaining(vendorName);
	    if (!vendors.isEmpty()) {
	        return new ResponseEntity<>(vendors, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("/vendor/{Id}")
	public ResponseEntity<Vendor> updateVendor(@PathVariable("Id") long Id, @RequestBody Vendor vendor) {
		Optional<Vendor> vendorUpdate = vendorRepository.findById(Id);

		if (vendorUpdate.isPresent()) {
			Vendor vendorList = vendorUpdate.get();
			vendorList.setVendorName(vendor.getVendorName());
			//vendorList.setGstNo(vendor.getGstNo());
			vendorList.setPanNo(vendor.getPanNo());
			vendorList.setAddress1(vendor.getAddress1());
			vendorList.setAddress2(vendor.getAddress2());
			vendorList.setCity(vendor.getCity());
			vendorList.setState(vendor.getState());
			vendorList.setPinCode(vendor.getPinCode());
			vendorList.setContry(vendor.getContry());
			vendorList.setPhoneNumber(vendor.getPhoneNumber());
			
			return new ResponseEntity<>(vendorRepository.save(vendor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/vendor/{Id}")
	public ResponseEntity<HttpStatus> deleteVendor(@PathVariable("Id") long Id) {
		try {
			vendorRepository.deleteById(Id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/vendor/{id}")
	public ResponseEntity<Vendor> getVendorById(@PathVariable("id") long id) {
	    Optional<Vendor> vendorData = vendorRepository.findById(id);

	    if (vendorData.isPresent()) {
	        Vendor vendor = vendorData.get();
	        return new ResponseEntity<>(vendor, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	public VendorController() {
		// TODO Auto-generated constructor stub
	}

}
