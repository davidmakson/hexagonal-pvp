package inditex.price.adapter.in.web;

import inditex.price.application.port.in.FindPvpUseCase;
import inditex.price.domain.Price;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@Slf4j
class FindPvpController {

	private final FindPvpUseCase findPvpUseCase;

	@Operation(summary = "Find a Pvp")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Bad request"),
			@ApiResponse(responseCode = "404", description = "Not Found")})
	@GetMapping(path = "/price/pvp/{brandId}/{productId}/{applicationDate}")
	ResponseEntity<Price> findPvp(
			@PathVariable("applicationDate")
			@NotNull @Pattern(regexp = "\\d{4}-[01]\\d-[0-3]\\d-[0-2]\\d.[0-5]\\d.[0-5]\\d(?:\\.\\d+)?Z?",
					message="The parameter date of application should be in format DateTime(yyyy-MM-dd-hh.mm.ss)") String applicationDateParameter,
			@PathVariable("productId")
			@NotNull @Positive Long productId,
			@PathVariable("brandId")
			@NotNull @Positive Long brandId) {
		return ResponseEntity.ok(findPvpUseCase.findPvp(applicationDateParameter, productId, brandId));
	}

}
