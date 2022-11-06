package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.devs.business.requests.DeleteSubTechnologyRequest;
import kodlama.io.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.devs.business.responses.GetAllSubTechnologyResponse;
import kodlama.io.devs.business.responses.GetByIdSubTechnologyResponse;

public interface SubTechnologyService {
	List<GetAllSubTechnologyResponse> getAll();
	GetByIdSubTechnologyResponse getByIdSubTechnologyId(int id);
	void addSubTechnology(CreateSubTechnologyRequest createSubTechnologyRequest);
	void updateSubTechnology(UpdateSubTechnologyRequest updateSubTechnologyRequest);
	void deleteSubTechnology(DeleteSubTechnologyRequest deleteSubTechnologyRequest);
}
