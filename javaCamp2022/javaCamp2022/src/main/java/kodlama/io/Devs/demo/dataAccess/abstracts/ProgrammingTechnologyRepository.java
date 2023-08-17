package kodlama.io.Devs.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.demo.entites.concretes.ProgrammingTechnology;

public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Integer> {

}
