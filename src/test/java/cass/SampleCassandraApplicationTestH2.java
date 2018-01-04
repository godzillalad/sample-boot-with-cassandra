package cass;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


/**
 * Sample test that uses the same context as the main production application and will connect to the configured cassandra database
 * @author SHANELynch
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SampleCassandraApplicationTestH2 {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHotels() throws Exception {

		MvcResult result = mvc.perform(get("/hotels/"))
				.andExpect(status().isOk())
				.andReturn();

		// // TODO this needs to be the same as the data added during initialisation
		assertThat(result.getResponse().getContentAsString(), is(not(equalTo(""))));

	}
}