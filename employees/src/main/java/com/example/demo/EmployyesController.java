package com.example.demo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@RestController
class EmployeeController {

//    @PostMapping("/employee")
//    public EmployeeOutput calculateAge(@RequestBody EmployeeInput employeeInput) {
//        // Calculate age from Date of Birth
//        LocalDate dob = LocalDate.parse(employeeInput.getDob());
//        LocalDate currentDate = LocalDate.now();
//        int age = Period.between(dob, currentDate).getYears();
//
//        // Create output with additional age parameter
//        EmployeeOutput employeeOutput = new EmployeeOutput();
//        employeeOutput.setName(employeeInput.getName());
//        employeeOutput.setDob(employeeInput.getDob());
//        employeeOutput.setGender(employeeInput.getGender());
//        employeeOutput.setAge(age);
//
//        return employeeOutput;
//    }
	
	  @PostMapping("/employees")
	    public List<EmployeeOutput> calculateAges(@RequestBody List<EmployeeInput> employeeInputs) {
	        return employeeInputs.stream()
	                .map(this::calculateAge)
	                .toList();
	    }

	    private EmployeeOutput calculateAge(EmployeeInput employeeInput) {
	        // Calculate age from Date of Birth
	        LocalDate dob = LocalDate.parse(employeeInput.getDob());
	        LocalDate currentDate = LocalDate.now();
	        int age = Period.between(dob, currentDate).getYears();

	        // Create output with additional age parameter
	        EmployeeOutput employeeOutput = new EmployeeOutput();
	        employeeOutput.setName(employeeInput.getName());
	        employeeOutput.setDob(employeeInput.getDob());
	        employeeOutput.setGender(employeeInput.getGender());
	        employeeOutput.setAge(age);

	        return employeeOutput;
	    }
}

class EmployeeInput {
    private String name;
    private String dob;
    private String gender;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

class EmployeeOutput {
    private String name;
    private String dob;
    private String gender;
    private int age;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
