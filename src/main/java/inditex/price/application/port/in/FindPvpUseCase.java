package inditex.price.application.port.in;

import inditex.price.domain.Price;

public interface FindPvpUseCase {

	Price findPvp(String applicationDate, Long productId, Long brandId);

}
