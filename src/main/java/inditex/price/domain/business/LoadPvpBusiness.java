package inditex.price.domain.business;

import inditex.price.application.port.in.LoadPvpUseCase;
import inditex.price.application.port.out.LoadPvpPort;
import inditex.price.domain.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoadPvpBusiness implements LoadPvpUseCase {

	private final LoadPvpPort loadPvpPort;

	@Override
	public void loadPvp(Price price) {
		loadPvpPort.loadPvp(price);
	}

}




