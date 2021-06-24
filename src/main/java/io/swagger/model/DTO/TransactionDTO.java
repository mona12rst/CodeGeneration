package io.swagger.model.DTO;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.model.User;
import io.swagger.model.enums.TransactionTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TransactionDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")


public class TransactionDTO
{
  @JsonProperty("FromIBAN")
  private String fromIBAN = null;

  @JsonProperty("ToIBAN")
  private String toIBAN = null;

  @JsonProperty("Amount")
  private Float amount = null;


  @JsonProperty("TransactionType")
  private TransactionTypeEnum transactionType = null;

  @JsonProperty("userPerforming")
  private User userPerforming = null;

  public TransactionDTO fromIBAN(String fromIBAN) {
    this.fromIBAN = fromIBAN;
    return this;
  }

  /**
   * Get fromIBAN
   * @return fromIBAN
   **/
  @Schema(example = "NL01ING09874374839", required = true, description = "")
      @NotNull

    public String getFromIBAN() {
    return fromIBAN;
  }

  public void setFromIBAN(String fromIBAN) {
    this.fromIBAN = fromIBAN;
  }

  public TransactionDTO toIBAN(String toIBAN) {
    this.toIBAN = toIBAN;
    return this;
  }

  /**
   * Get toIBAN
   * @return toIBAN
   **/
  @Schema(example = "NL01ING09874374839", required = true, description = "")
      @NotNull

    public String getToIBAN() {
    return toIBAN;
  }

  public void setToIBAN(String toIBAN) {
    this.toIBAN = toIBAN;
  }

  public TransactionDTO amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * minimum: 1
   * maximum: 10000
   * @return amount
   **/
  @Schema(required = true, description = "")
      @NotNull

  @DecimalMin("1") @DecimalMax("10000")   public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public TransactionDTO transactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  /**
   * Type of transaction
   * @return transactionType
   **/
  @Schema(required = true, description = "Type of transaction")
      @NotNull

    public TransactionTypeEnum getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
  }

  public TransactionDTO userPerforming(User userPerforming) {
    this.userPerforming = userPerforming;
    return this;
  }

  /**
   * Get userPerforming
   * @return userPerforming
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public User getUserPerforming() {
    return userPerforming;
  }

  public void setUserPerforming(User userPerforming) {
    this.userPerforming = userPerforming;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionDTO transactionDTO = (TransactionDTO) o;
    return Objects.equals(this.fromIBAN, transactionDTO.fromIBAN) &&
        Objects.equals(this.toIBAN, transactionDTO.toIBAN) &&
        Objects.equals(this.amount, transactionDTO.amount) &&
        Objects.equals(this.transactionType, transactionDTO.transactionType) &&
        Objects.equals(this.userPerforming, transactionDTO.userPerforming);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromIBAN, toIBAN, amount, transactionType, userPerforming);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionDTO {\n");
    
    sb.append("    fromIBAN: ").append(toIndentedString(fromIBAN)).append("\n");
    sb.append("    toIBAN: ").append(toIndentedString(toIBAN)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    userPerforming: ").append(toIndentedString(userPerforming)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
