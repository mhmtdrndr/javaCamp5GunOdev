package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.SubTechnologyService;
import kodlama.io.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.devs.business.requests.DeleteSubTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllSubTechnologyResponse;
import kodlama.io.devs.business.responses.GetByIdSubTechnologyResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.devs.entity.concretes.ProgramingLanguage;
import kodlama.io.devs.entity.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {
	
	private SubTechnologyRepository subTechnologyRepository;
	private ProgramingLanguageRepository programingLanguageRepository;
	
	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository, ProgramingLanguageRepository programingLanguageRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
		this.programingLanguageRepository = programingLanguageRepository;
	}

	@Override
	public List<GetAllSubTechnologyResponse> getAll() {
		List<SubTechnology> subTechnologies = subTechnologyRepository.findAll();
		List<GetAllSubTechnologyResponse> allSubTechnologyResponses = new ArrayList<GetAllSubTechnologyResponse>();
		for(SubTechnology subTechnology : subTechnologies) {
			GetAllSubTechnologyResponse responseItem = new GetAllSubTechnologyResponse();
			responseItem.setId(subTechnology.getId());
			responseItem.setSubTechnologyName(subTechnology.getSubTechnologyName());
		}
		return allSubTechnologyResponses;
	}

	@Override
	public GetByIdSubTechnologyResponse getByIdSubTechnologyId(int id) {
		SubTechnology subTechnology = subTechnologyRepository.findById(id).get();
		GetByIdSubTechnologyResponse responseId = new GetByIdSubTechnologyResponse();
		responseId.setId(subTechnology.getId());
		responseId.setSubTechnologyName(subTechnology.getSubTechnologyName());
		return responseId;
	}

	@Override
	public void addSubTechnology(CreateSubTechnologyRequest createSubTechnologyRequest) {
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setSubTechnologyName(createSubTechnologyRequest.getSubTechnologyName());
		ProgramingLanguage programingLanguage = programingLanguageRepository.findById(createSubTechnologyRequest.getProgramingLanguageId()).get();
		subTechnology.setProgramingLanguage(programingLanguage);		
	}

	@Override
	public void updateSubTechnology(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		SubTechnology subTechnology = subTechnologyRepository.findById(updateSubTechnologyRequest.getId()).get();
		subTechnology.setSubTechnologyName(updateSubTechnologyRequest.getSubTechnologyName());
		ProgramingLanguage programingLanguage = programingLanguageRepository.findById(updateSubTechnologyRequest.getProgramingLanguageId()).get();
		subTechnology.setProgramingLanguage(programingLanguage);
	}

	@Override
	public void deleteSubTechnology(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		this.subTechnologyRepository.deleteById(deleteSubTechnologyRequest.getId());		
	}

}
