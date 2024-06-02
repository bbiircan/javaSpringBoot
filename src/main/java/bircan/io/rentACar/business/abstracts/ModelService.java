package bircan.io.rentACar.business.abstracts;

import java.util.List;

import bircan.io.rentACar.business.requests.CreateModelRequest;
import bircan.io.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
