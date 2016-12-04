package application.ui.controllers;

import java.util.List;

import application.models.Order;
import application.models.Vendor;
import application.repositories.OrderRepository;
import application.repositories.VendorRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddVendorController extends BaseController {
	private static final String ERROR_HEADER = "Save Failed";

	private VendorRepository vendorRepository;

	public void setVendorRepository(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}

	@FXML
	private TextField nameTextField;
	@FXML
	private CheckBox preferredCheckBox;

	private Vendor newVendor;

	@Override
	public void onLoad() {
	}
  
	private boolean copyDataToVendor() {

		newVendor = new Vendor();

		if (nameTextField.getText().length() == 0) {
			showError(ERROR_HEADER, "Vendor name is required");
			return false;
		}
		newVendor.setName(nameTextField.getText());
		
		newVendor.setPreferred(preferredCheckBox.isSelected());
		
		return true;
	}

	@FXML
	private void saveVendor() {
		if (copyDataToVendor()) {
			vendorRepository.saveVendor(newVendor);
			applicationController.loadMenuedScreen("/application/ui/views/EditOrder.fxml");
		}
	}
}
