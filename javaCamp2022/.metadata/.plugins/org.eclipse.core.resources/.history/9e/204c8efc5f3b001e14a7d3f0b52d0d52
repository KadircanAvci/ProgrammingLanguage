package kodlama.io.Devs.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.demo.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.Devs.demo.business.requests.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.responses.GetAllProgrammingTechnologiesResponse;
import kodlama.io.Devs.demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.demo.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingLanguage;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingTechnology;

@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService{
	
	
	private ProgrammingTechnologyRepository programmingTechnologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingTechnologyManager (ProgrammingTechnologyRepository programmingTechnologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingTechnologyRepository = programmingTechnologyRepository;
		this.programmingLanguageRepository = programmingLanguageRepository;
	}
	

	@Override
	public void add(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) throws Exception  {
		
		if(createProgrammingTechnologyRequest.getName() == "") {
			throw new Exception ("İsim boş bırakılamaz.");
		}
		
		for (ProgrammingTechnology languages : programmingTechnologyRepository.findAll()) {
			
			
			if(languages.getName().equals(createProgrammingTechnologyRequest.getName())  ) {
				throw new Exception ("Bu isim daha önce kullanılmıştır.");
			}
			
		}
		
		
		ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(createProgrammingTechnologyRequest.getProgrammingLanguageId()).get();
		
		programmingTechnology.setName(createProgrammingTechnologyRequest.getName());
		programmingTechnology.setProgrammingLanguage(programmingLanguage);
		
		
		this.programmingTechnologyRepository.save(programmingTechnology);
		
	}

	@Override
	public void update(int id, UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest) throws Exception {
		
		if(updateProgrammingTechnologyRequest.getName() == "") {
			throw new Exception ("İsim boş bırakılamaz.");
		}
		
		for (ProgrammingTechnology languages : programmingTechnologyRepository.findAll()) {
			
			
			if(languages.getName().equals(updateProgrammingTechnologyRequest.getName())  ) {
				throw new Exception ("Bu İsim daha önce kullanılmıştır.");
			}
			
		}
		ProgrammingTechnology programmingTechnology = this.programmingTechnologyRepository.findById(id).get();
		programmingTechnology.setName(updateProgrammingTechnologyRequest.getName());
		programmingTechnologyRepository.save(programmingTechnology);
		
	}

	@Override
	public void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		ProgrammingTechnology programmingTechnology = this.programmingTechnologyRepository.findById(deleteProgrammingTechnologyRequest.getId()).get();
		
		programmingTechnologyRepository.delete(programmingTechnology);
		
	}

	@Override
	public List<GetAllProgrammingTechnologiesResponse> getAll() {
		
		List<ProgrammingTechnology> programmingTechnologies = this.programmingTechnologyRepository.findAll();
		List<GetAllProgrammingTechnologiesResponse> programmingTechnologiesResponse = new ArrayList<GetAllProgrammingTechnologiesResponse>();
		
		for (ProgrammingTechnology programmingTechnology : programmingTechnologies) {
			
			GetAllProgrammingTechnologiesResponse responseItem = new GetAllProgrammingTechnologiesResponse();
			responseItem.setId(programmingTechnology.getId());
			responseItem.setName(programmingTechnology.getName());
			
			programmingTechnologiesResponse.add(responseItem);
			
			
		}
		
		

		return programmingTechnologiesResponse;
	}

}
