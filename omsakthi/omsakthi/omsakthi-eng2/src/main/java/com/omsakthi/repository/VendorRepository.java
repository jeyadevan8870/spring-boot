package com.omsakthi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omsakthi.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long>  {
	List<Vendor> findByVendorNameContaining(String vendorName);

}
