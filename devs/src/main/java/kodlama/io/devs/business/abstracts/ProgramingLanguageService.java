package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateProgramingLanguageRequest;
import kodlama.io.devs.business.requests.DeleteProgramingLanguageRequest;
import kodlama.io.devs.business.requests.UpdateProgramingLanguageRequest;
import kodlama.io.devs.business.responses.GetAllProgramingLanguageResponse;
import kodlama.io.devs.business.responses.GetByIdProgramingLanguageResponse;

public interface ProgramingLanguageService {
	List<GetAllProgramingLanguageResponse> getAll();
	void addProgramingLanguage(CreateProgramingLanguageRequest programingLanguageRequest) throws Exception;
	GetByIdProgramingLanguageResponse getByProgramingLanguageId(int id);
	void updateProgramingLanguage(UpdateProgramingLanguageRequest updateProgramingLanguageRequest) throws Exception;
	void deleteProgramingLanguage(DeleteProgramingLanguageRequest deleteProgramingLanguageRequest);
}
