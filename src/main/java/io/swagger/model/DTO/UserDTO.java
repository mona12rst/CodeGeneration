package io.swagger.model.DTO;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.model.Address;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserToCreate
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO
{
    @JsonProperty("Username")
    private String username = null;

    @JsonProperty("firstName")
    private String firstName = null;

    @JsonProperty("lastName")
    private String lastName = null;

    @JsonProperty("emailAddress")
    private String emailAddress = null;



    @JsonProperty("dateOfBirth")
    private String dateOfBirth = null;

    @JsonProperty("mobileNumber")
    private String mobileNumber = null;

    @JsonProperty("dailyLimit")
    private double dailyLimit;

    @JsonProperty("transactionLimit")
    private double transactionLimit;

//    @JsonProperty("primaryAddress")
//    private Address primaryAddress = null;


    @JsonProperty("userRole")
    private List<UserRoleEnum> userRoles = null;

    public UserDTO username(String username)
    {
        this.username = username;
        return this;
    }

    /**
     * Get username
     *
     * @return username
     **/
    @Schema(example = "john", required = true, description = "")
    @NotNull

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public UserDTO firstName(String firstName)
    {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     *
     * @return firstName
     **/
    @Schema(example = "john", required = true, description = "")
    @NotNull

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public UserDTO lastName(String lastName)
    {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     **/
    @Schema(example = "doe", required = true, description = "")
    @NotNull

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public UserDTO emailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Get emailAddress
     *
     * @return emailAddress
     **/
    @Schema(example = "john@example.com", required = true, description = "")
    @NotNull

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

//  public UserToCreate sex(SexEnum sex) {
//    this.sex = sex;
//    return this;
//  }
//
//  /**
//   * Get sex
//   * @return sex
//   **/
//  @Schema(required = true, description = "")
//      @NotNull
//
//    public SexEnum getSex() {
//    return sex;
//  }
//
//  public void setSex(SexEnum sex) {
//    this.sex = sex;
//  }

    public UserDTO dateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * Get dateOfBirth
     *
     * @return dateOfBirth
     **/
    @Schema(example = "15-01-1996", required = true, description = "")
    @NotNull

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public UserDTO mobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
        return this;
    }

    /**
     * Get mobileNumber
     *
     * @return mobileNumber
     **/
    @Schema(example = "0753846288", required = true, description = "")
    @NotNull

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public UserDTO dailyLimit(double dailyLimit)
    {
        this.dailyLimit = dailyLimit;
        return this;
    }

    /**
     * Get dailyLimit
     *
     * @return dailyLimit
     **/
    @Schema(example = "10.5", required = true, description = "")

    public double getDailyLimit()
    {
        return dailyLimit;
    }

    public void setDailyLimit(double dailyLimit)
    {
        this.dailyLimit = dailyLimit;
    }

    public UserDTO transactionLimit(double transactionLimit)
    {
        this.transactionLimit = transactionLimit;
        return this;
    }

    /**
     * Get transactionLimit
     *
     * @return transactionLimit
     **/
    @Schema(example = "10.5", required = true, description = "")

    public double getTransactionLimit()
    {
        return transactionLimit;
    }

    public void setTransactionLimit(double transactionLimit)
    {
        this.transactionLimit = transactionLimit;
    }

//    public UserDTO primaryAddress(Address primaryAddress)
//    {
//        this.primaryAddress = primaryAddress;
//        return this;
//    }

    /**
     * Get primaryAddress
     *
     * @return primaryAddress
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
//    public Address getPrimaryAddress()
//    {
//        return primaryAddress;
//    }

//    public void setPrimaryAddress(Address primaryAddress)
//    {
//        this.primaryAddress = primaryAddress;
//    }

    public UserDTO userRole(List<UserRoleEnum> userRoles)
    {
        this.userRoles = userRoles;
        return this;
    }

    /**
     * Get userRole
     *
     * @return userRole
     **/
    @Schema(description = "")

    public List<UserRoleEnum> getUserRoles()
    {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleEnum> userRoles)
    {
        this.userRoles = userRoles;
    }


    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(this.username, userDTO.username) &&
                Objects.equals(this.firstName, userDTO.firstName) &&
                Objects.equals(this.lastName, userDTO.lastName) &&
                Objects.equals(this.emailAddress, userDTO.emailAddress) &&
//        Objects.equals(this.sex, userToCreate.sex) &&
                Objects.equals(this.dateOfBirth, userDTO.dateOfBirth) &&
                Objects.equals(this.mobileNumber, userDTO.mobileNumber) &&
                Objects.equals(this.dailyLimit, userDTO.dailyLimit) &&
                Objects.equals(this.transactionLimit, userDTO.transactionLimit) &&
//                Objects.equals(this.primaryAddress, userDTO.primaryAddress) &&
                Objects.equals(this.userRoles, userDTO.userRoles);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(username, firstName, lastName, emailAddress/*, sex*/, dateOfBirth, mobileNumber, dailyLimit, transactionLimit, /*primaryAddress,*/ userRoles);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserToCreate {\n");

        sb.append("    username: ")
                .append(toIndentedString(username))
                .append("\n");
        sb.append("    firstName: ")
                .append(toIndentedString(firstName))
                .append("\n");
        sb.append("    lastName: ")
                .append(toIndentedString(lastName))
                .append("\n");
        sb.append("    emailAddress: ")
                .append(toIndentedString(emailAddress))
                .append("\n");
//    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
        sb.append("    dateOfBirth: ")
                .append(toIndentedString(dateOfBirth))
                .append("\n");
        sb.append("    mobileNumber: ")
                .append(toIndentedString(mobileNumber))
                .append("\n");
        sb.append("    dailyLimit: ")
                .append(toIndentedString(dailyLimit))
                .append("\n");
        sb.append("    transactionLimit: ")
                .append(toIndentedString(transactionLimit))
                .append("\n");
//        sb.append("    primaryAddress: ")
//                .append(toIndentedString(primaryAddress))
//                .append("\n");
        sb.append("    userRole: ")
                .append(toIndentedString(userRoles))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString()
                .replace("\n", "\n    ");
    }
}
