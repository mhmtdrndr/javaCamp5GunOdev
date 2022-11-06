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

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.requests.CreateProgramingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgramingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgramingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgramingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgramingLanguageResponse;

@RestController
@RequestMapping("/api/programingLanguages")
public class ProgramingLanguagesController {
	
	private ProgramingLanguageService programingLanguageService;

	@Autowired
	public ProgramingLanguagesController(ProgramingLanguageService programingLanguageService) {
		this.programingLanguageService = programingLanguageService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllProgramingLanguageResponse> getAll(){
		return this.programingLanguageService.getAll();
	}
	
	@GetMapping("/getId/{id}")
	public GetByIdProgramingLanguageResponse getById(@PathVariable int id) {
		return this.programingLanguageService.getByProgramingLanguageId(id);
	}
	
	@PostMapping("/addLanguage")
	public void addProgramingLanguage(@RequestBody CreateProgramingLanguageRequest createProgramingLanguageRequest) throws Exception {
		this.programingLanguageService.addProgramingLanguage(createProgramingLanguageRequest);
	}
	
	@PutMapping("/updateLanguage")
	public void updateProgramingLanguage(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) throws Exception {
		this.programingLanguageService.updateProgramingLanguage(updateProgramingLanguageRequest);
	}
	
	@DeleteMapping("/deleteLanguage")
	public void deleteProgramingLanguage(DeleteProgramingLanguageRequest deleteProgramingLanguageRequest) {
		this.programingLanguageService.deleteProgramingLanguage(deleteProgramingLanguageRequest);
	}
}
