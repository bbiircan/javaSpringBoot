package bircan.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bircan.io.rentACar.business.abstracts.ModelService;
import bircan.io.rentACar.business.requests.CreateModelRequest;
import bircan.io.rentACar.business.responses.GetAllModelsResponse;
import bircan.io.rentACar.core.utilities.mappers.ModelMapperService;
import bircan.io.rentACar.dataAccess.abstracts.ModelRepository;
import bircan.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());

		return modelsResponse;
	}

	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
		
	}

}
