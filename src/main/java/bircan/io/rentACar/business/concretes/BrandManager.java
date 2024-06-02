package bircan.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bircan.io.rentACar.business.abstracts.BrandService;
import bircan.io.rentACar.business.requests.CreateBrandRequest;
import bircan.io.rentACar.business.requests.UpdateBrandRequest;
import bircan.io.rentACar.business.responses.GetAllBrandsResponse;
import bircan.io.rentACar.business.responses.GetByIdBrandsResponse;
import bircan.io.rentACar.business.rules.BrandBusinessRules;
import bircan.io.rentACar.core.utilities.mappers.ModelMapperService;
import bircan.io.rentACar.dataAccess.abstracts.BrandRepository;
import bircan.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	}

	@Override
	public GetByIdBrandsResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandsResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandsResponse.class);
		return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);	
	}

	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}

}
