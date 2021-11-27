package tdd.pratice.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/**
 * pricePlanComparisons
 */
@javax.annotation.Generated(value = "uk.tw.energy.codegen.languages.SpringCodegen")
public class PricePlanComparisons   {
  @JsonProperty("pricePlanComparisons")
  @Valid
  private List<PriceAccount> pricePlanComparisons = null;

  @JsonProperty("pricePlanId")
  private String pricePlanId;

  public PricePlanComparisons pricePlanComparisons(List<PriceAccount> pricePlanComparisons) {
    this.pricePlanComparisons = pricePlanComparisons;
    return this;
  }

  public PricePlanComparisons addPricePlanComparisonsItem(PriceAccount pricePlanComparisonsItem) {
    if (this.pricePlanComparisons == null) {
      this.pricePlanComparisons = new ArrayList<>();
    }
    this.pricePlanComparisons.add(pricePlanComparisonsItem);
    return this;
  }


  @Valid

  public List<PriceAccount> getPricePlanComparisons() {
    return pricePlanComparisons;
  }

  public void setPricePlanComparisons(List<PriceAccount> pricePlanComparisons) {
    this.pricePlanComparisons = pricePlanComparisons;
  }

  public PricePlanComparisons pricePlanId(String pricePlanId) {
    this.pricePlanId = pricePlanId;
    return this;
  }



  public String getPricePlanId() {
    return pricePlanId;
  }

  public void setPricePlanId(String pricePlanId) {
    this.pricePlanId = pricePlanId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricePlanComparisons pricePlanComparisons = (PricePlanComparisons) o;
    return Objects.equals(this.pricePlanComparisons, pricePlanComparisons.pricePlanComparisons) &&
        Objects.equals(this.pricePlanId, pricePlanComparisons.pricePlanId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pricePlanComparisons, pricePlanId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricePlanComparisons {\n");
    
    sb.append("    pricePlanComparisons: ").append(toIndentedString(pricePlanComparisons)).append("\n");
    sb.append("    pricePlanId: ").append(toIndentedString(pricePlanId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

