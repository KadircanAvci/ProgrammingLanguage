package kodlama.io.Devs.demo.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.demo.core.utilities.exceptions.BusinessException;
import kodlama.io.Devs.demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageBusinessRules {
	
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.programmingLanguageRepository.existsByName(name)){
			throw new BusinessException("Programming language already exists.");
		}
	}

}
