package inditex.price.application.port.out;

import inditex.price.domain.Price;

public interface LoadPvpPort {

	void loadPvp(Price price);

}
