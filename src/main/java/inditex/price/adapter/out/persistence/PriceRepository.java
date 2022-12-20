package inditex.price.adapter.out.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface PriceRepository extends JpaRepository<PriceJpaEntity, Long> {

	@Query("select a from PriceJpaEntity a " +
			"where a.productId = :productId " +
			"and a.brandId = :brandId " +
			"and a.endDate >= :applicationDate " +
			"and a.startDate <= :applicationDate " +
			"order by priority desc ")
	List<PriceJpaEntity> findPvp(
			@Param("applicationDate") String applicationDate,
			@Param("productId") Long productId,
			@Param("brandId") Long brandId);

}
