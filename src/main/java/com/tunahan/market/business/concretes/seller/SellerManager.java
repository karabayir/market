package com.tunahan.market.business.concretes.seller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.seller.SellerService;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.dtos.requests.seller.CreateSellerRequest;
import com.tunahan.market.dtos.responses.seller.CreateSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetAllSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetSellerResponse;
import com.tunahan.market.entities.seller.Seller;
import com.tunahan.market.repository.seller.SellerRepository;
import com.tunahan.market.rules.seller.SellerRules;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SellerManager implements SellerService{
	
	private final SellerRepository sellerRepository;
	private final ModelMapperService mapperService;
	private final SellerRules rules;
	
	@Override
	public List<GetAllSellerResponse> getAll() {
		return sellerRepository.findAll()
				.stream()
				.map(s -> mapperService.forResponse().map(s, GetAllSellerResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public GetSellerResponse getById(long id) {
		rules.checkIfSellerExists(id);
		Seller seller = sellerRepository.findById(id).orElseThrow();
		return mapperService.forResponse().map(seller, GetSellerResponse.class);
	}

	@Override
	public List<GetSellerResponse> getByName(String name) {
		rules.checkIfSellerExists(name);
		return sellerRepository.findByName(name)
				.stream()
				.map(s -> mapperService.forResponse().map(s, GetSellerResponse.class))
				.collect(Collectors.toList());
	}

	@Override
	public CreateSellerResponse add(CreateSellerRequest createRequest) {
		Seller  seller = mapperService.forRequest().map(createRequest, Seller.class);
		sellerRepository.save(seller);
		return mapperService.forResponse().map(seller, CreateSellerResponse.class);
	}

}
