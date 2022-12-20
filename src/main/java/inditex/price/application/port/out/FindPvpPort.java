package inditex.price.application.port.out;

import inditex.price.domain.Price;

public interface FindPvpPort {

	Price findPvp(String applicationDate, Long productId, Long brandId);

}
