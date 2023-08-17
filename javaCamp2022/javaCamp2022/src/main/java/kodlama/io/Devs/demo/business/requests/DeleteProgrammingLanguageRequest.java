package kodlama.io.Devs.demo.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProgrammingLanguageRequest {
	@NotNull
	@NotBlank
	private int id;
}
