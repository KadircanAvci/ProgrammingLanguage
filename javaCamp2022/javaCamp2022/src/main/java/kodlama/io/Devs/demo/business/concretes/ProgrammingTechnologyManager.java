package kodlama.io.Devs.demo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.demo.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.Devs.demo.business.requests.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.requests.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.demo.business.responses.GetAllProgrammingTechnologiesResponse;
import kodlama.io.Devs.demo.core.utilities.mappers.ModelMapperService;
import kodlama.io.Devs.demo.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlama.io.Devs.demo.entites.concretes.ProgrammingTechnology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService{
	
	
	private ProgrammingTechnologyRepository programmingTechnologyRepository;
	private ModelMapperService modelMapperService;
	
	

	@Override
	public void add(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) throws Exception  {
		
		
		ProgrammingTechnology programmingTechnology = this.modelMapperService.forRequest()
				.map(createProgrammingTechnologyRequest, ProgrammingTechnology.class);
		
		
		this.programmingTechnologyRepository.save(programmingTechnology);
		
	}

	@Override
	public void update(int id, UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest) throws Exception {
		
		ProgrammingTechnology programmingTechnology = this.modelMapperService.forRequest()
				.map(updateProgrammingTechnologyRequest, ProgrammingTechnology.class);
		
		this.programmingTechnologyRepository.save(programmingTechnology);
		
	}

	@Override
	public void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
		ProgrammingTechnology programmingTechnology = this.programmingTechnologyRepository.findById(deleteProgrammingTechnologyRequest.getId()).get();
		
		programmingTechnologyRepository.delete(programmingTechnology);
		
	}

	@Override
	public List<GetAllProgrammingTechnologiesResponse> getAll() {
		
		List<ProgrammingTechnology> programmingTechnologies = this.programmingTechnologyRepository.findAll();
		
		List<GetAllProgrammingTechnologiesResponse> programmingTechnologiesResponse =	programmingTechnologies.stream()
				.map(programmingTechnology->this.modelMapperService.forResponse()
				.map(programmingTechnology, GetAllProgrammingTechnologiesResponse.class)).collect(Collectors.toList());
		
		return programmingTechnologiesResponse;	
			
		}
		
	}


