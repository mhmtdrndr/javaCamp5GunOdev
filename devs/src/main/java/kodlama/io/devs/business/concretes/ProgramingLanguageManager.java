package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgramingLanguageService;
import kodlama.io.devs.business.requests.CreateProgramingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgramingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgramingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgramingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgramingLanguageResponse;
import kodlama.io.devs.dataAccess.abstracts.ProgramingLanguageRepository;
import kodlama.io.devs.entity.concretes.ProgramingLanguage;

@Service
public class ProgramingLanguageManager implements ProgramingLanguageService {
	
	private ProgramingLanguageRepository programingLanguageRepository;

	@Autowired
	public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository) {
		this.programingLanguageRepository = programingLanguageRepository;
	}

	@Override
	public List<GetAllProgramingLanguageResponse> getAll() {
		List<ProgramingLanguage> programingLanguages = programingLanguageRepository.findAll();
		List<GetAllProgramingLanguageResponse> getAllProgramingLanguageResponses = new ArrayList<GetAllProgramingLanguageResponse>();
		for(ProgramingLanguage programingLanguage : programingLanguages) {
			GetAllProgramingLanguageResponse responseItem = new GetAllProgramingLanguageResponse();
			responseItem.setId(programingLanguage.getId());
			responseItem.setProgramingLanguageName(programingLanguage.getProgramingLanguageName());
			getAllProgramingLanguageResponses.add(responseItem);
		}
		return getAllProgramingLanguageResponses;
	}

	@Override
	public void addProgramingLanguage(CreateProgramingLanguageRequest programingLanguageRequest) throws Exception {
		ProgramingLanguage programingLanguage = new ProgramingLanguage();		
		programingLanguage.setProgramingLanguageName(programingLanguageRequest.getProgramingLanguageName());
		if(!isExistLanguageName(programingLanguage) && !checkProgramingLanguageName(programingLanguage)) {
			programingLanguageRepository.save(programingLanguage);
		}		
	}
	
	@Override
	public GetByIdProgramingLanguageResponse getByProgramingLanguageId(int id) {
		ProgramingLanguage programingLanguage = this.programingLanguageRepository.findById(id).get();
		GetByIdProgramingLanguageResponse responseItem = new GetByIdProgramingLanguageResponse();
		responseItem.setId(programingLanguage.getId());
		responseItem.setProgramingLanguageName(programingLanguage.getProgramingLanguageName());
		return responseItem;
	}
	
	@Override
	public void updateProgramingLanguage(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) throws Exception {
		ProgramingLanguage programingLanguage = this.programingLanguageRepository.findById(updateProgramingLanguageRequest.getId()).get();
		if(!isExistLanguageName(programingLanguage) && !checkProgramingLanguageName(programingLanguage)) {
			programingLanguage.setProgramingLanguageName(updateProgramingLanguageRequest.getProgramingLanguageName());
		}		
	}
	
	@Override
	public void deleteProgramingLanguage(DeleteProgramingLanguageRequest deleteProgramingLanguageRequest) {
		this.programingLanguageRepository.deleteById(deleteProgramingLanguageRequest.getId());
		
	}
	
	public boolean isExistLanguageName(ProgramingLanguage programingLanguage) throws Exception {
		List<ProgramingLanguage> programingLanguages = programingLanguageRepository.findAll();
		for(ProgramingLanguage language : programingLanguages) {
			if(language.getProgramingLanguageName().equalsIgnoreCase(programingLanguage.getProgramingLanguageName())) {
				throw new Exception("Aynı Programlama Dilinden kayıt olduğundan işlem başarısız...");
			}
		}
		return false;
	}
	
	public boolean checkProgramingLanguageName(ProgramingLanguage programingLanguage) throws Exception {
		if (programingLanguage.getProgramingLanguageName().trim().length() == 0) {
			throw new Exception("Programlama dili boş geçilemez...");
		}
		return false;
	}

}
