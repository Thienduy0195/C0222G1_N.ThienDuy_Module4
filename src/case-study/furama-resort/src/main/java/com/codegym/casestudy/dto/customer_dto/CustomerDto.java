package com.codegym.casestudy.dto.customer_dto;

import com.codegym.casestudy.model.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import javax.validation.GroupSequence;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

//@GroupSequence({CustomerDto.class, BasicInfo.class, AdvanceInfo.class})
public class CustomerDto implements Validator {

    private Integer id;

    @NotBlank(message = "*Not blank")
    @Pattern(regexp = "[0-9]{9,12}",message ="*format error" )
    private String idCard;

    @NotBlank(message = "*Please input name")
    @Pattern(regexp = "[A-Za-z ]+", message = "*Wrong format name")
    private String name;

    @NotBlank(message = "*day of birth is not null")
    private String birthDay;

    private String phone;

    @Email(message = "*email is not valid")
    @NotBlank(message = "*not blank")
    private String email;

    @NotBlank(message = "*not blank")
    private String address;

    @NotNull(message = "*choose gender")
    private Integer gender;

    @NotBlank(message = "*not blank")
    private String customerCode;

    private List<String> customerCodeList;

    private List<String> phoneList;

    private List<String> idCardList;

    private List<String> emailList;

    @NotNull(message = "*choose customer type")
    private CustomerType customerType;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", customerCode='" + customerCode + '\'' +
                ", customerCodeList=" + customerCodeList +
                ", phoneList=" + phoneList +
                ", idCardList=" + idCardList +
                ", emailList=" + emailList +
                ", customerType=" + customerType +
                '}';
    }

    public CustomerDto() {
    }

    public List<String> getCustomerCodeList() {
        return customerCodeList;
    }

    public void setCustomerCodeList(List<String> customerCodeList) {
        this.customerCodeList = customerCodeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    public List<String> getIdCardList() {
        return idCardList;
    }

    public void setIdCardList(List<String> idCardList) {
        this.idCardList = idCardList;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String phone = customerDto.getPhone();

        //validate day:
        if(!"".equals(customerDto.getBirthDay())){
            LocalDate date = LocalDate.parse(customerDto.getBirthDay());
            if((LocalDate.now().minusYears(18)).isBefore(date)){
                errors.rejectValue("birthDay","date.valid","errors");
            }
        }


        //validate phone:
        //        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty","errors");
        if(phone.isEmpty()){
            errors.rejectValue("phone", "phone.empty", "errors");
        } else if (phone.length() > 12 || phone.length() < 10) {
            errors.rejectValue("phone", "phone.length", "errors");
        } else if (!phone.startsWith("0")) {
            errors.rejectValue("phone", "phone.startsWith", "errors");
        } else if (!phone.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phone", "phone.matches","errors");
        }
        if(!customerDto.getCustomerCode().matches("(^KH-[0-9]{4}$)")){
            errors.rejectValue("customerCode","code.format","errors");
        }
        //validate phone duplicate
        if(customerDto.getPhoneList().contains(customerDto.getPhone())){
            errors.rejectValue("phone","phone.duplicate","errors");
        }

        //validate code
        if(customerDto.getCustomerCodeList().contains(customerDto.getCustomerCode())){
            errors.rejectValue("customerCode","code.duplicate","errors");
        }

        //validate email
        if(customerDto.getEmailList().contains(customerDto.getEmail())){
            errors.rejectValue("email","email.duplicate","errors");
        }

        //validate idcard
        if(customerDto.getIdCardList().contains(customerDto.getIdCard())){
            errors.rejectValue("idCard","id.card.duplicate","errors");
        }
    }
}
