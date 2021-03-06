package pol.generateUsers.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pol.abstractController.AbstractController;
import pol.doctor.service.DoctorService;
import pol.patient.service.PatientService;


@Controller
@RequestMapping( value="/generate-users")
public class GenerateUsersController extends AbstractController{

	private static final String VIEW_NAME = "users/GenerateUsers";
	
	@Autowired
	PatientService patientService;
	@Autowired
	DoctorService doctorService;
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String generate() throws IOException{
		doctorService.generateSampleDoctors();
		patientService.generateSamplePatient();
		return VIEW_NAME;
	}
}
