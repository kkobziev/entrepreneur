package com.demo.entrepreneur.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateDto {

    @JsonProperty("ccy")
    private String currentCurrency;
    @JsonProperty("base_ccy")
    private String baseCurrency;
    @JsonProperty("buy")
    private String buyPrice;
    @JsonProperty("sale")
    private String salePrice;
    @JsonProperty("date")
    @Builder.Default
    private LocalDate date = LocalDate.now();
}
