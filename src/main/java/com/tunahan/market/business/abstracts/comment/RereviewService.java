package com.tunahan.market.business.abstracts.comment;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.core.utilities.result.Result;
import com.tunahan.market.dtos.requests.comment.rereview.CreateRereviewRequest;
import com.tunahan.market.dtos.requests.comment.rereview.UpdateRereviewRequest;
import com.tunahan.market.dtos.responses.comment.rereview.CreateRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.GetAllRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.GetRereviewResponse;
import com.tunahan.market.dtos.responses.comment.rereview.UpdateRereviewResponse;
import com.tunahan.market.entities.comment.Rereview;

public interface RereviewService {

	DataResult<List<GetAllRereviewResponse>> getAll();
	DataResult<GetRereviewResponse> getById(long id);
	DataResult<CreateRereviewResponse> add(CreateRereviewRequest request);
	DataResult<UpdateRereviewResponse> update(UpdateRereviewRequest request);
	DataResult<Page<Rereview>> getAllPageable(int number, int size);
	Result delete(long id);
}
