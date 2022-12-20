package inditex.price.adapter.out.persistence;

import inditex.price.domain.Price;
import org.mapstruct.Mapper;

@Mapper
interface PriceMapper {

	Price mapToDomainEntity(PriceJpaEntity priceJpaEntity);

	PriceJpaEntity mapToJpaEntity(Price price);

}
