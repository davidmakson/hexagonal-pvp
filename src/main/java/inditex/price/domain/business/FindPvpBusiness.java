package inditex.price.domain.business;

import inditex.price.domain.Price;
import inditex.price.application.port.out.FindPvpPort;

import inditex.price.application.port.in.FindPvpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class FindPvpBusiness implements FindPvpUseCase {

	private final FindPvpPort findPvpPort;

	@Override
	public Price findPvp(String applicationDate, Long productId, Long brandId) {
		return findPvpPort.findPvp(applicationDate, productId, brandId);
	}
}
