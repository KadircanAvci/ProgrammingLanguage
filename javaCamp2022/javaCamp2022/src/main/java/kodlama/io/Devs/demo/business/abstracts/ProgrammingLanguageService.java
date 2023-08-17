package kodlama.io.Devs.demo.business.abstracts;

import java.util.List;

import kodlama.io.Devs.demo.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.demo.business.requests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.demo.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	
	void update(int id,UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	
	void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest);
	
	List<GetAllProgrammingLanguagesResponse> getAll();
	
	ProgrammingLanguage getById(int id);
}
