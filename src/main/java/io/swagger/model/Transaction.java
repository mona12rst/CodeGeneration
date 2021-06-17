package io.swagger.model;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")

@Entity
public class Transaction   {
  @Id
  @GeneratedValue
  @JsonProperty("TransactionID")
  private UUID transactionID = null;

  @JsonProperty("FromIBAN")
  private String fromIBAN = null;

  @JsonProperty("ToIBAN")
  private String toIBAN = null;

  @JsonProperty("Amount")
  private Float amount = null;

  /**
   * Type of transaction
   */
  public enum TransactionTypeEnum {
    TRANSFER("transfer"),
    
    DEPOSIT("deposit"),
    
    WITHDRAW("withdraw");

    private String value;

    TransactionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransactionTypeEnum fromValue(String text) {
      for (TransactionTypeEnum b : TransactionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("TransactionType")
  private TransactionTypeEnum transactionType;

  @JsonProperty("Date")
  private LocalDate date;

  @OneToOne
  @JsonProperty("userPerforming")
  private User userPerforming;

  public Transaction transactionID(UUID transactionID) {
    this.transactionID = transactionID;
    return this;
  }

  /**
   * Get transactionID
   * @return transactionID
   **/
  @Schema(required = true, description = "")

  public UUID getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(UUID transactionID) {
    this.transactionID = transactionID;
  }

  public Transaction fromIBAN(String fromIBAN) {
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

  public Transaction toIBAN(String toIBAN) {
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

  public Transaction amount(Float amount) {
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

  public Transaction transactionType(TransactionTypeEnum transactionType) {
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

  public Transaction date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Transaction userPerforming(User userPerforming) {
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
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.transactionID, transaction.transactionID) &&
        Objects.equals(this.fromIBAN, transaction.fromIBAN) &&
        Objects.equals(this.toIBAN, transaction.toIBAN) &&
        Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.transactionType, transaction.transactionType) &&
        Objects.equals(this.date, transaction.date) &&
        Objects.equals(this.userPerforming, transaction.userPerforming);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionID, fromIBAN, toIBAN, amount, transactionType, date, userPerforming);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    transactionID: ").append(toIndentedString(transactionID)).append("\n");
    sb.append("    fromIBAN: ").append(toIndentedString(fromIBAN)).append("\n");
    sb.append("    toIBAN: ").append(toIndentedString(toIBAN)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
