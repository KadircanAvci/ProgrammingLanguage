package kodlama.io.Devs.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.demo.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.demo.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.demo.business.requests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.demo.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	
	
	@Autowired
	public ProgrammingLanguageManager (ProgrammingLanguageRepository programmingLanguageRepository) {
		
		this.programmingLanguageRepository = programmingLanguageRepository;
		
	}
	
	
	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		
		
		if(createProgrammingLanguageRequest.getName() == "") {
			throw new Exception ("Programlama ismi boş bırakılamaz.");
		}
		
		for (ProgrammingLanguage languages : programmingLanguageRepository.findAll()) {
			
			
			if(languages.getName().equals(createProgrammingLanguageRequest.getName())  ) {
				throw new Exception ("Bu programlamlama ismi daha önce kullanılmıştır.");
			}
			
		}
				
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		
			this.programmingLanguageRepository.save(programmingLanguage);
			
			System.out.println("Programlama dili kaydedildi.");
		

		
	}


	@Override
	public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		
		if(updateProgrammingLanguageRequest.getName() == "") {
			throw new Exception ("Programlama ismi boş bırakılamaz.");
		}
		
		for (ProgrammingLanguage languages : programmingLanguageRepository.findAll()) {
			
			
			if(languages.getName().equals(updateProgrammingLanguageRequest.getName())  ) {
				throw new Exception ("Bu programlamlama ismi daha önce kullanılmıştır.");
			}
			
		}
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
		
		
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		programmingLanguageRepository.save(programmingLanguage);
		
	}


	@Override
	public void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(deleteProgrammingTechnologyRequest.getId()).get();
		
	
		this.programmingLanguageRepository.delete(programmingLanguage);
		
	}


	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<GetAllProgrammingLanguagesResponse>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setId(programmingLanguage.getId());
			responseItem.setName(programmingLanguage.getName());
			
			programmingLanguagesResponse.add(responseItem);
		}
		
		return programmingLanguagesResponse;
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		
		return this.programmingLanguageRepository.getById(id);
	}

}
