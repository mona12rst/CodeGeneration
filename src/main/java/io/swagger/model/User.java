package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")


@Entity
public class User   {
  @Id
  @GeneratedValue
  @JsonProperty("UserID")
  private Integer userID;

  @JsonProperty("Username")
  private String username;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("emailAddress")
  private String emailAddress = null;

  /**
   * Gets or Sets sex
   */
//  public enum SexEnum {
//    MALE("male"),
//
//    FEMALE("female");
//
//    private String value;
//
//    SexEnum(String value) {
//      this.value = value;
//    }
//
//    @Override
//    @JsonValue
//    public String toString() {
//      return String.valueOf(value);
//    }
//
//    @JsonCreator
//    public static SexEnum fromValue(String text) {
//      for (SexEnum b : SexEnum.values()) {
//        if (String.valueOf(b.value).equals(text)) {
//          return b;
//        }
//      }
//      return null;
//    }
//  }
//  @JsonProperty("sex")
//  private SexEnum sex = null;

  @JsonProperty("dateOfBirth")
  private String dateOfBirth = null;

  @JsonProperty("mobileNumber")
  private String mobileNumber = null;

  @JsonProperty("dailyLimit")
  private BigDecimal dailyLimit = null;

  @JsonProperty("transactionLimit")
  private BigDecimal transactionLimit = null;

  @JsonProperty("primaryAddress")
  @OneToOne // considering user can have only one primary address
  private Address primaryAddress = null;


//  @ElementCollection(fetch = FetchType.EAGER)
  @JsonProperty("userRole")
  private UserRoleEnum userRole = null;

  public User userID(Integer userID) {
    this.userID = userID;
    return this;
  }

  /**
   * Get userID
   * @return userID
   **/
  @Schema(example = "1", required = true, description = "")
  @NotNull

  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public User username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   **/
  @Schema(example = "john", required = true, description = "")
  @NotNull

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  @Schema(example = "john", required = true, description = "")
  @NotNull

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  @Schema(example = "doe", required = true, description = "")
  @NotNull

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Get emailAddress
   * @return emailAddress
   **/
  @Schema(example = "john@example.com", required = true, description = "")
  @NotNull

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

//  public User sex(SexEnum sex) {
//    this.sex = sex;
//    return this;
//  }

  /**
   * Get sex
   * @return sex
   **/
  @Schema(required = true, description = "")
  @NotNull

//    public SexEnum getSex() {
//    return sex;
//  }
//
//  public void setSex(SexEnum sex) {
//    this.sex = sex;
//  }

  public User dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  /**
   * Get dateOfBirth
   * @return dateOfBirth
   **/
  @Schema(example = "15-01-1996", required = true, description = "")
  @NotNull

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public User mobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Get mobileNumber
   * @return mobileNumber
   **/
  @Schema(example = "0753846288", required = true, description = "")
  @NotNull

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public User dailyLimit(BigDecimal dailyLimit) {
    this.dailyLimit = dailyLimit;
    return this;
  }

  /**
   * Get dailyLimit
   * @return dailyLimit
   **/
  @Schema(example = "10.5", required = true, description = "")
  @NotNull

  @Valid
  public BigDecimal getDailyLimit() {
    return dailyLimit;
  }

  public void setDailyLimit(BigDecimal dailyLimit) {
    this.dailyLimit = dailyLimit;
  }

  public User transactionLimit(BigDecimal transactionLimit) {
    this.transactionLimit = transactionLimit;
    return this;
  }

  /**
   * Get transactionLimit
   * @return transactionLimit
   **/
  @Schema(example = "10.5", required = true, description = "")
  @NotNull

  @Valid
  public BigDecimal getTransactionLimit() {
    return transactionLimit;
  }

  public void setTransactionLimit(BigDecimal transactionLimit) {
    this.transactionLimit = transactionLimit;
  }

  public User primaryAddress(Address primaryAddress) {
    this.primaryAddress = primaryAddress;
    return this;
  }

  /**
   * Get primaryAddress
   * @return primaryAddress
   **/
  @Schema(required = true, description = "")
  @NotNull

  @Valid
  public Address getPrimaryAddress() {
    return primaryAddress;
  }

  public void setPrimaryAddress(Address primaryAddress) {
    this.primaryAddress = primaryAddress;
  }

  public User userRole(UserRoleEnum userRole) {
    this.userRole = userRole;
    return this;
  }

  /**
   * Get userRole
   * @return userRole
   **/
  @Schema(description = "")

  public UserRoleEnum getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRoleEnum userRole) {
    this.userRole = userRole;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userID, user.userID) &&
            Objects.equals(this.username, user.username) &&
            Objects.equals(this.firstName, user.firstName) &&
            Objects.equals(this.lastName, user.lastName) &&
            Objects.equals(this.emailAddress, user.emailAddress) &&
//        Objects.equals(this.sex, user.sex) &&
            Objects.equals(this.dateOfBirth, user.dateOfBirth) &&
            Objects.equals(this.mobileNumber, user.mobileNumber) &&
            Objects.equals(this.dailyLimit, user.dailyLimit) &&
            Objects.equals(this.transactionLimit, user.transactionLimit) &&
            Objects.equals(this.primaryAddress, user.primaryAddress) &&
            Objects.equals(this.userRole, user.userRole);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userID, username, firstName, lastName, emailAddress/*, sex*/, dateOfBirth, mobileNumber, dailyLimit, transactionLimit, primaryAddress, userRole);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");

    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
//    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    dailyLimit: ").append(toIndentedString(dailyLimit)).append("\n");
    sb.append("    transactionLimit: ").append(toIndentedString(transactionLimit)).append("\n");
    sb.append("    primaryAddress: ").append(toIndentedString(primaryAddress)).append("\n");
    sb.append("    userRole: ").append(toIndentedString(userRole)).append("\n");
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
