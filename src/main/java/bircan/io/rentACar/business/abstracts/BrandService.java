package bircan.io.rentACar.business.abstracts;

import java.util.List;

import bircan.io.rentACar.business.requests.CreateBrandRequest;
import bircan.io.rentACar.business.requests.UpdateBrandRequest;
import bircan.io.rentACar.business.responses.GetAllBrandsResponse;
import bircan.io.rentACar.business.responses.GetByIdBrandsResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandsResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
