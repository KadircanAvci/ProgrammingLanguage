package kodlama.io.Devs.demo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.demo.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.demo.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.demo.business.requests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.demo.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.demo.business.rules.ProgrammingLanguageBusinessRules;
import kodlama.io.Devs.demo.core.utilities.mappers.ModelMapperService;
import kodlama.io.Devs.demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapperService modelMapperService;
	private ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;
	
	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
			
			this.programmingLanguageBusinessRules.checkIfBrandNameExists(createProgrammingLanguageRequest.getName());
				
			ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
					.map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
		
			this.programmingLanguageRepository.save(programmingLanguage);
			
			System.out.println("Programlama dili kaydedildi.");
	}


	@Override
	public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest()
				.map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		this.programmingLanguageRepository.save(programmingLanguage);
	}


	@Override
	public void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(deleteProgrammingTechnologyRequest.getId()).get();
		
	
		this.programmingLanguageRepository.delete(programmingLanguage);
		
	}


	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		
		List<ProgrammingLanguage> programmingLanguages = this.programmingLanguageRepository.findAll();
		
		List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = programmingLanguages.stream()
				.map(programmingLanguage->this.modelMapperService.forResponse()
						.map(programmingLanguage,GetAllProgrammingLanguagesResponse.class)).collect(Collectors.toList());
		
		return programmingLanguagesResponse;
	}


	@Override
	public ProgrammingLanguage getById(int id) {
		
		return this.programmingLanguageRepository.getById(id);
	}

}
