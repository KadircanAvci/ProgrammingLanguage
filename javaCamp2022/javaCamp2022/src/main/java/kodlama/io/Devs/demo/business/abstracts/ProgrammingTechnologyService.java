package kodlama.io.Devs.demo.business.abstracts;

import java.util.List;

import kodlama.io.Devs.demo.business.requests.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.responses.GetAllProgrammingTechnologiesResponse;

public interface ProgrammingTechnologyService {
	void add(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) throws Exception;
	
	void update(int id, UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest) throws Exception;
	
	void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest);
	
	List<GetAllProgrammingTechnologiesResponse> getAll();
}
