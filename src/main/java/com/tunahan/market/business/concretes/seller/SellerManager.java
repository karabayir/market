package com.tunahan.market.business.concretes.seller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tunahan.market.business.abstracts.seller.SellerService;
import com.tunahan.market.core.messages.seller.SellerMessages;
import com.tunahan.market.core.utilities.mapping.ModelMapperService;
import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.core.utilities.result.SuccessDataResult;
import com.tunahan.market.core.utilities.result.SuccessResult;
import com.tunahan.market.dtos.requests.seller.CreateSellerRequest;
import com.tunahan.market.dtos.requests.seller.UpdateSellerRequest;
import com.tunahan.market.dtos.responses.seller.CreateSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetAllSellerResponse;
import com.tunahan.market.dtos.responses.seller.GetSellerResponse;
import com.tunahan.market.dtos.responses.seller.UpdateSellerResponse;
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
	public DataResult<List<GetAllSellerResponse>> getAll() {
		List<GetAllSellerResponse> result= sellerRepository.findAll()
				.stream()
				.map(s -> mapperService.forResponse().map(s, GetAllSellerResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllSellerResponse>>(result,SellerMessages.Result.getAllSeller);
	}

	@Override
	public DataResult<GetSellerResponse> getById(long id) {
		rules.checkIfSellerExists(id);
		Seller seller = sellerRepository.findById(id).orElseThrow();
		GetSellerResponse result= mapperService.forResponse().map(seller, GetSellerResponse.class);
		return new SuccessDataResult<GetSellerResponse>(result,SellerMessages.Result.getSellerById);
	}

	@Override
	public DataResult<List<GetSellerResponse>> getByName(String name) {
		rules.checkIfSellerExists(name);
		List<GetSellerResponse> result= sellerRepository.findByName(name)
				.stream()
				.map(s -> mapperService.forResponse().map(s, GetSellerResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetSellerResponse>>(result,SellerMessages.Result.getSellerByName);
	}
	
	@Override
	public DataResult<GetSellerResponse> getByTaxNumber(String number) {
		rules.checkIfSellerTaxNumberExists(number);
		Seller seller = sellerRepository.findByTaxNumber(number).orElseThrow();
		GetSellerResponse result = mapperService.forResponse().map(seller, GetSellerResponse.class);
		return new SuccessDataResult<GetSellerResponse>(result,SellerMessages.Result.getSellerByTaxNumber);
	}

	@Override
	public DataResult<CreateSellerResponse> add(CreateSellerRequest request) {
		rules.checkIfSellerTaxNumberForAdd(request.getTaxNumber());
		Seller  seller = mapperService.forRequest().map(request, Seller.class);
		sellerRepository.save(seller);
		CreateSellerResponse result= mapperService.forResponse().map(seller, CreateSellerResponse.class);
		return new SuccessDataResult<CreateSellerResponse>(result,SellerMessages.Result.addSeller);
	}

	@Override
	public DataResult<UpdateSellerResponse> update(UpdateSellerRequest request) {
		rules.checkIfSellerExists(request.getId());
		Seller seller = mapperService.forRequest().map(request, Seller.class);
		sellerRepository.save(seller);
		UpdateSellerResponse result= mapperService.forResponse().map(seller, UpdateSellerResponse.class);
		return new SuccessDataResult<UpdateSellerResponse>(result,SellerMessages.Result.updateSeller);
	}

	@Override
	public Result delete(long id) {
		rules.checkIfSellerExists(id);
		sellerRepository.deleteById(id);
		return new SuccessResult(SellerMessages.Result.deleteSeller);
	}

	@Override
	public DataResult<Page<Seller>> getAllPageable(int number, int size) {
		Pageable pageable = PageRequest.of(number, size);
		Page<Seller> result = sellerRepository.findAll(pageable);
		return new SuccessDataResult<Page<Seller>>(result,SellerMessages.Result.getAllSellerPageable);
	}


}
