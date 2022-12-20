package inditex.price.adapter.out.persistence;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRECIOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
class PriceJpaEntity {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name = "BRAND_ID")
	private Long brandId;

	@Column(name = "START_DATE")
	private String startDate;

	@Column(name = "END_DATE")
	private String endDate;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRIORITY")
	private Long priority;

	@Column(name = "PRICE_LIST")
	private Long tax;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	private String currency;

}
