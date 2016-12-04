package application.repositories;

import java.util.List;

import application.models.Vendor;

public interface VendorRepository {
	List<Vendor> getVendors();
	void saveVendor(Vendor vendor);
}
