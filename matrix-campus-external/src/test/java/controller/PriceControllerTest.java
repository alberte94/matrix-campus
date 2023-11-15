package controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.matrix.campus.MatrixCampusExternalApplication;
import com.matrix.campus.dto.response.PriceResponseDto;
import java.time.OffsetDateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = MatrixCampusExternalApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PriceControllerTest {

  @Autowired
  private MockMvc mvc;

  private PriceResponseDto price1;

  private PriceResponseDto price2;

  private PriceResponseDto price3;

  private PriceResponseDto price4;

  ObjectWriter objectWriter;
  @Before
  public void init() {
     price1 = PriceResponseDto.builder().productId(35455L).pvp(35.50).brandId(1L).feeId(1L)
        .startDate(OffsetDateTime.parse("2020-06-14T00:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-12-31T23:59:59Z")).build();

     price2 = PriceResponseDto.builder().productId(35455L).pvp(25.45).brandId(1L).feeId(2L)
        .startDate(OffsetDateTime.parse("2020-06-14T15:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-06-14T18:30:00Z")).build();

     price3 = PriceResponseDto.builder().productId(35455L).pvp(30.50).brandId(1L).feeId(3L)
        .startDate(OffsetDateTime.parse("2020-06-15T00:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-06-15T11:00:00Z")).build();

     price4 = PriceResponseDto.builder().productId(35455L).pvp(38.95).brandId(1L).feeId(4L)
        .startDate(OffsetDateTime.parse("2020-06-15T16:00:00Z"))
        .endDate(OffsetDateTime.parse("2020-12-31T23:59:59Z")).build();

    ObjectMapper objectMapper = new ObjectMapper();
    objectWriter = objectMapper.registerModule(new JavaTimeModule()).writer();
  }

  @Test
  public void fetchUserByUsername() throws Exception {
    String response = getResponse("/prices?applicationDate=2020-06-14T10:00:00Z&productId=35455&brandId=1");
    String response2 = getResponse("/prices?applicationDate=2020-06-14T16:00:00Z&productId=35455&brandId=1");
    String response3 = getResponse("/prices?applicationDate=2020-06-14T21:00:00Z&productId=35455&brandId=1");
    String response4 = getResponse("/prices?applicationDate=2020-06-15T10:00:00Z&productId=35455&brandId=1");
    String response5 = getResponse("/prices?applicationDate=2020-06-16T21:00:00Z&productId=35455&brandId=1");
    assertEquals(response, objectWriter.writeValueAsString(price1));
    assertEquals(response2, objectWriter.writeValueAsString(price2));
    assertEquals(response3, objectWriter.writeValueAsString(price1));
    assertEquals(response4, objectWriter.writeValueAsString(price3));
    assertEquals(response5, objectWriter.writeValueAsString(price4));
  }

  private String getResponse(String url) throws Exception {
    return mvc.perform(get(url)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andReturn().getResponse().getContentAsString();
  }
}
