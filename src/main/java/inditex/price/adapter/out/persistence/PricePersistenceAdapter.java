package inditex.price.adapter.out.persistence;

import inditex.price.adapter.in.web.exceptions.PvpNotFoundException;
import inditex.price.application.port.out.FindPvpPort;
import inditex.price.application.port.out.LoadPvpPort;
import inditex.price.domain.Price;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
class PricePersistenceAdapter implements LoadPvpPort, FindPvpPort {

	private final PriceRepository priceRepository;
	private final PriceMapper priceMapper;

	@Override
	public Price findPvp(String applicationDate, Long productId, Long brandId) {
		Optional<PriceJpaEntity> priceJpaEntity;

		try {
			priceJpaEntity = priceRepository.findPvp(applicationDate, productId, brandId).stream().findFirst();
			if (priceJpaEntity.isEmpty()) {
				log.error("The findPvp has dataBase problems!");
				throw new PvpNotFoundException("The findPvp has dataBase problems!");
			}
		} catch (RuntimeException exception) {
			log.error("The productId " + productId.toString() + " was not found!");
			throw new PvpNotFoundException("The productId " + productId.toString() + " was not found!");
		}

		return priceMapper.mapToDomainEntity(priceJpaEntity.get());
	}

	@Override
	public void loadPvp(Price price) {
		priceRepository.save(priceMapper.mapToJpaEntity(price));
	}
}
