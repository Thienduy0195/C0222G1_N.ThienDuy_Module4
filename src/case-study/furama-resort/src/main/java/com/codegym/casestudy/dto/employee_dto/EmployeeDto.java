package com.codegym.casestudy.dto.employee_dto;

import com.codegym.casestudy.dto.contract_dto.ContractDto;
import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.EducationDegree;
import com.codegym.casestudy.model.employee.Position;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDto implements Validator {


    private Integer id;

    @NotBlank(message = "*Not blank")
    @Pattern(regexp = "[0-9]{9,12}", message = "*id card must has 9-12 number")
    private String idCard;

    @Pattern(regexp = "[1-9]{1}[0-9]{7,}", message = "*enter number")
    @NotBlank(message = "*enter salary")
    private String salary;

    @NotBlank(message = "*enter name")
    @Pattern(regexp = "[A-Za-z ]+", message = "*Wrong format name")
    private String name;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "*day of birth is not null")
    private String birthDay;

    private String phone;

    @Email(message = "*not valid (ex: abc123@gmail.com)")
    @NotBlank(message = "*not blank")
    private String email;

    @NotBlank(message = "*enter address")
    private String address;

    @NotNull(message = "*choose position")
    private Position position;

    @NotNull(message = "*choose division")
    private Division division;

    @NotNull(message = "*choose education degree")
    private EducationDegree educationDegree;
    private List<String> phoneList;
    private List<String> idCardList;
    private List<String> emailList;

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

    public EmployeeDto() {
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        String phone = employeeDto.getPhone();

        if (!"".equals(employeeDto.getBirthDay())) {
            LocalDate date = LocalDate.parse(employeeDto.getBirthDay());
            if ((LocalDate.now().minusYears(18)).isBefore(date)) {
                errors.rejectValue("birthDay", "date.valid", "errors");
            }
        }

        if(phone.isEmpty()){
            errors.rejectValue("phone", "phone.empty", "errors");
        } else if (phone.length() > 12 || phone.length() < 10) {
            errors.rejectValue("phone", "phone.length", "errors");
        } else if (!phone.startsWith("0")) {
            errors.rejectValue("phone", "phone.startsWith", "errors");
        } else if (!phone.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phone", "phone.matches","errors");
        }
    }
}

