package io.swagger.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.model.Address;
import io.swagger.exception.InvalidUserDetailsException;
import io.swagger.model.enums.UserRoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-17T13:48:13.918Z[GMT]")


@Entity
public class User
{
    @Id
    @GeneratedValue
    @JsonProperty("UserID")
    private long userID;

    @JsonProperty("Username")
    private String username;

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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    private String password;


    @JsonProperty("userRole")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<UserRoleEnum> userRoles;

    public User userID(Integer userID) throws Exception
    {
        if (userID <= 0)
        {
            throw new InvalidUserDetailsException("user id cant be zero or less");
        }
        this.userID = userID;
        return this;
    }

    @Schema(example = "1", required = true, description = "")

    public long getUserID()
    {
        return userID;
    }

    public void setUserID(long userID) throws Exception
    {
        if (userID <= 0)
        {
            throw new InvalidUserDetailsException("user id cant be zero or less");
        }
        this.userID = userID;
    }

    public User username(String username) throws Exception
    {
        if (username == null || username.length() < 3)
        {
            throw new InvalidUserDetailsException("username cant be empty;");
        }
        this.username = username;
        return this;
    }


    @Schema(example = "john", required = true, description = "")
    @NotNull

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username) throws Exception
    {
        if (username == null || username.length() < 5)
        {
            throw new InvalidUserDetailsException("username cant be empty;");
        }
        this.username = username;
    }

    public User firstName(String firstName) throws Exception
    {
        if(firstName == null || firstName.length() < 3)
            throw new InvalidUserDetailsException("first name cant be empty");
        this.firstName = firstName;
        return this;
    }


    @Schema(example = "john", required = true, description = "")
    @NotNull

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception
    {
        if(firstName == null || firstName.length() < 3)
            throw new InvalidUserDetailsException("first name cant be empty");
        this.firstName = firstName;
    }

    public User lastName(String lastName) throws Exception
    {
        if(lastName == null || lastName.length() < 3)
            throw new InvalidUserDetailsException("last name cant be empty");
        this.lastName = lastName;
        return this;
    }


    @Schema(example = "doe", required = true, description = "")
    @NotNull

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception
    {
        if(lastName == null || lastName.length() < 3)
            throw new InvalidUserDetailsException("last name cant be empty");
        this.lastName = lastName;
    }

    public User emailAddress(String emailAddress) throws Exception
    {
        if(emailAddress == null || !emailAddress.contains("@") || !emailAddress.contains(".") || emailAddress.length() <3)
            throw new InvalidUserDetailsException("email address cant be empty");
        this.emailAddress = emailAddress;
        return this;
    }


    @Schema(example = "john@example.com", required = true, description = "")
    @NotNull

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) throws Exception
    {
        if(emailAddress == null || !emailAddress.contains("@") || !emailAddress.contains(".") || emailAddress.length() <3)
            throw new InvalidUserDetailsException("email address cant be empty");
        this.emailAddress = emailAddress;
    }


    public User dateOfBirth(String dateOfBirth) throws Exception
    {

        LocalDate value = LocalDate.parse(dateOfBirth);
        if(value == null || (LocalDate.now().getYear() - value.getYear()) <18 )
        {
            throw new InvalidUserDetailsException("date of birth cant be empty and you need to be older than 18");
        }
        this.dateOfBirth = dateOfBirth;
        return this;
    }


    @Schema(example = "15-01-1996", required = true, description = "")
    @NotNull

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) throws Exception
    {
        LocalDate value = LocalDate.parse(dateOfBirth);
        if(value == null || (LocalDate.now().getYear() - value.getYear()) <18 )
        {
            throw new InvalidUserDetailsException("date of birth cant be empty and you need to be older than 18");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public User mobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
        return this;
    }


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

    public User dailyLimit(double dailyLimit) throws Exception
    {
        if(dailyLimit <=0 )
        {
            throw new InvalidUserDetailsException("daily limit cant be less than or equal to zero");
        }
        this.dailyLimit = dailyLimit;
        return this;
    }


    @Schema(example = "10.5", required = true, description = "")

    public double getDailyLimit()
    {
        return dailyLimit;
    }

    public void setDailyLimit(double dailyLimit) throws Exception
    {
        if(dailyLimit <=0 )
        {
            throw new InvalidUserDetailsException("daily limit cant be less than or equal to zero");
        }
        this.dailyLimit = dailyLimit;
    }

    public User transactionLimit(double transactionLimit) throws Exception
    {
        if(transactionLimit <= 0 )
        {
            throw new InvalidUserDetailsException("transaction limit cant be less than or equal to zero");
        }
        this.transactionLimit = transactionLimit;
        return this;
    }


    @Schema(example = "10.5", required = true, description = "")

    public double getTransactionLimit()
    {
        return transactionLimit;
    }

    public void setTransactionLimit(double transactionLimit) throws Exception
    {
        if(transactionLimit <= 0 )
        {
            throw new InvalidUserDetailsException("transaction limit cant be less than or equal to zero");
        }
        this.transactionLimit = transactionLimit;
    }



    public User userRole(List<UserRoleEnum> userRole) throws Exception
    {
        if(userRole == null )
        {
            throw new InvalidUserDetailsException("user role cant be null");
        }
        this.userRoles = userRole;
        return this;
    }




    public List<UserRoleEnum> getUserRoles()
    {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleEnum> userRole) throws Exception
    {
        if(userRole == null )
        {
            throw new InvalidUserDetailsException("user role cant be null");
        }
        this.userRoles = userRole;
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
        User user = (User) o;
        return Objects.equals(this.userID, user.userID) && Objects.equals(this.username, user.username) && Objects.equals(this.firstName, user.firstName) && Objects.equals(this.lastName, user.lastName) && Objects.equals(this.emailAddress, user.emailAddress) &&
//        Objects.equals(this.sex, user.sex) &&
                Objects.equals(this.dateOfBirth, user.dateOfBirth) && Objects.equals(this.mobileNumber, user.mobileNumber) && Objects.equals(this.dailyLimit, user.dailyLimit) && Objects.equals(this.transactionLimit, user.transactionLimit) &&
//            Objects.equals(this.primaryAddress, user.primaryAddress) &&
                Objects.equals(this.userRoles, user.userRoles);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(userID, username, firstName, lastName, emailAddress/*, sex*/, dateOfBirth, mobileNumber, dailyLimit, transactionLimit, /*primaryAddress,*/ userRoles);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    userID: ")
                .append(toIndentedString(userID))
                .append("\n");
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
//    sb.append("    primaryAddress: ").append(toIndentedString(primaryAddress)).append("\n");
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

