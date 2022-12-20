package inditex.price.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
public class Price {

	@Getter
	@NonNull
	@JsonIgnore
	private UUID id;

	@Getter
	@NonNull
	private Long brandId;

	@Getter
	@NonNull
	private String startDate;

	@Getter
	@NonNull
	private String endDate;

	@Getter
	@NonNull
	private Long productId;

	@Getter
	@NonNull
	@JsonIgnore
	private Long priority;

	@Getter
	@NonNull
	private Long tax;

	@Getter
	@NonNull
	private BigDecimal price;

	@Getter
	@NonNull
	@JsonIgnore
	private String currency;

	public Price(@NonNull Long brandId, @NonNull String startDate, @NonNull String endDate,
			@NonNull Long productId, @NonNull Long priority, @NonNull Long tax, @NonNull BigDecimal price, @NonNull String currency) {
		this.id = UUID.randomUUID();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = productId;
		this.priority = priority;
		this.tax = tax;
		this.price = price;
		this.currency = currency;
	}
}
