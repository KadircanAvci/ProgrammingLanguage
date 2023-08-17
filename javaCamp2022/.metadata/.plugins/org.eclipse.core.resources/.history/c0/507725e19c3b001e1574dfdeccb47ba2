package kodlama.io.Devs.demo.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.demo.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.demo.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.demo.business.requests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.demo.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController (ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@RequestBody DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		this.programmingLanguageService.delete(deleteProgrammingTechnologyRequest);
	}
	@GetMapping("/getAll")
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return this.programmingLanguageService.getAll();
	}
	@PutMapping("/update/{id}")
	public void update (@PathVariable int id,@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		this.programmingLanguageService.update(id,updateProgrammingLanguageRequest);
	}
	@GetMapping("/getById")
	public ProgrammingLanguage getById(int id) {
		return this.programmingLanguageService.getById(id);
	}
}
