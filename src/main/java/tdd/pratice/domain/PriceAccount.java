package tdd.pratice.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Size;

/**
 * PriceAccount
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PriceAccount   {
  @JsonProperty("planName")
  private String planName;

  @JsonProperty("smartMeterId")
  private String smartMeterId;

  public PriceAccount planName(String planName) {
    this.planName = planName;
    return this;
  }


  @Size(min=1,max=50)
  public String getPlanName() {
    return planName;
  }

  public void setPlanName(String planName) {
    this.planName = planName;
  }

  public PriceAccount smartMeterId(String smartMeterId) {
    this.smartMeterId = smartMeterId;
    return this;
  }


  @Size(min=1,max=50)
  public String getSmartMeterId() {
    return smartMeterId;
  }

  public void setSmartMeterId(String smartMeterId) {
    this.smartMeterId = smartMeterId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceAccount priceAccount = (PriceAccount) o;
    return Objects.equals(this.planName, priceAccount.planName) &&
            Objects.equals(this.smartMeterId, priceAccount.smartMeterId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(planName, smartMeterId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceAccount {\n");

    sb.append("    planName: ").append(toIndentedString(planName)).append("\n");
    sb.append("    smartMeterId: ").append(toIndentedString(smartMeterId)).append("\n");
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

