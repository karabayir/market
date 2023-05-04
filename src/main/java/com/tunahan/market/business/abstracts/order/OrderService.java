package com.tunahan.market.business.abstracts.order;

import java.util.List;

import com.tunahan.market.core.utilities.result.DataResult;
import com.tunahan.market.dtos.requests.order.CreateOrderRequest;
import com.tunahan.market.dtos.requests.order.UpdateOrderRequest;
import com.tunahan.market.dtos.responses.order.CreateOrderResponse;
import com.tunahan.market.dtos.responses.order.GetAllOrderResponse;
import com.tunahan.market.dtos.responses.order.GetOrderResponse;
import com.tunahan.market.dtos.responses.order.UpdateOrderResponse;

public interface OrderService {
	
	DataResult<List<GetAllOrderResponse>> getAll();
	DataResult<GetOrderResponse> getById(long id);
	DataResult<CreateOrderResponse> add(CreateOrderRequest request);
	DataResult<UpdateOrderResponse> update(UpdateOrderRequest request);
}
