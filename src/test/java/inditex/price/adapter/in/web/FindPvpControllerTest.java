package inditex.price.adapter.in.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@DisplayName("TaskIntegrationTests")class FindPvpControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testContentErrorDateTimePattern() throws Exception {

		final String contentErrorDateTimePattern = "{\n"
				+ "    \"Errors: \": [\n"
				+ "        \"The parameter date of application should be in format DateTime(yyyy-MM-dd-hh.mm.ss)\"\n"
				+ "    ]\n"
				+ "}";

		mockMvc.perform(get("/price/pvp/{brandId}/{productId}/{applicationDate}",
				1, 35455, "2020-06-14-0.00.00")
				.header("Content-Type", "application/json"))
				.andExpect(status().isBadRequest())
				.andExpect(content().json(contentErrorDateTimePattern)).andDo(print());;
	}

	@Test
	void testPrueba1() throws Exception {

		final String content = "{\n"
				+ "    \"brandId\": 1,\n"
				+ "    \"startDate\": \"2020-06-14-00.00.00\",\n"
				+ "    \"endDate\": \"2020-12-31-23.59.59\",\n"
				+ "    \"productId\": 35455,\n"
				+ "    \"tax\": 1,\n"
				+ "    \"price\": 35.50\n"
				+ "}";

		mockMvc.perform(get("/price/pvp/{brandId}/{productId}/{applicationDate}",
				1, 35455, "2020-06-14-11.00.00")
				.header("Content-Type", "application/json"))
				.andExpect(status().isOk())
				.andExpect(content().json(content)).andDo(print());;

	}
}
