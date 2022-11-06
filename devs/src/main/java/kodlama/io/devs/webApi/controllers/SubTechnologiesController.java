package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.SubTechnologyService;
import kodlama.io.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.devs.business.requests.DeleteSubTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllSubTechnologyResponse;
import kodlama.io.devs.business.responses.GetByIdSubTechnologyResponse;

@RestController
@RequestMapping("api/subTechnologies")
public class SubTechnologiesController {
	
	private SubTechnologyService subTechnologyService;

	@Autowired
	public SubTechnologiesController(SubTechnologyService subTechnologyService) {
		this.subTechnologyService = subTechnologyService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllSubTechnologyResponse> getAll(){
		return this.subTechnologyService.getAll();
	}
	
	@GetMapping("/getId/{id}")
	public GetByIdSubTechnologyResponse getById(@PathVariable int id) {
		return this.subTechnologyService.getByIdSubTechnologyId(id);
	}
	
	@PostMapping("/addSubTechnology")
	public void addSubTechnology(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) {
		this.subTechnologyService.addSubTechnology(createSubTechnologyRequest);
	}
	
	@PutMapping("/updateSubTechnology")
	public void updateSubTechnology(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		this.subTechnologyService.updateSubTechnology(updateSubTechnologyRequest);
	}
	
	@DeleteMapping("/deleteSubTechnology")
	public void deleteSubTechnology(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		this.subTechnologyService.deleteSubTechnology(deleteSubTechnologyRequest);
	}
}
