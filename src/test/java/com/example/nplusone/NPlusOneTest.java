package com.example.nplusone;

import com.example.nplusone.entity.Company;
import com.example.nplusone.entity.Department;
import com.example.nplusone.entity.User;
import com.example.nplusone.repository.CompanyRepository;
import com.example.nplusone.repository.UserRepository;
import com.example.nplusone.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class NPlusOneTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserService userService;

    @Test
    void createEntities() {
        createCompanyAndUsers();
    }

    @Test
    void findUserByIdTest() {
//        createCompanyAndUsers();

        companyRepository.findById(2L);
        System.out.println();
    }

    private void createCompanyAndUsers() {
        Company company = createCompany("yandex");

        createUser("ivan", "Ivanov Ivan", createCompany("google"), Department.QA);
        createUser("roman", "Romanov Roman", company, Department.BACKEND);
        createUser("vadim", "Vadimov Vadim", company, Department.FRONTEND);
        createUser("oleg", "Olegov Oleg", company, Department.BACKEND);
        createUser("petr", "Petrov Petr", company, Department.FRONTEND);
        createUser("dima", "Dimov Dima", company, Department.BACKEND);
        createUser("victor", "Voctorov Victor", company, Department.FRONTEND);
        createUser("denis", "Denisov Denis", company, Department.BACKEND);
        createUser("vova", "Vovin Vova", company, Department.FRONTEND);
        createUser("gosha", "Goshin Gosha", company, Department.BACKEND);
    }

    private void createUser(String login, String fullName, Company company, Department department) {
        User user = User.builder()
                .login(login)
                .fullName(fullName)
                .company(company)
                .department(department)
                .build();
        userRepository.save(user);
    }

    private Company createCompany(String name) {
        Company company = Company.builder()
                .name(name)
                .createdAt(LocalDateTime.now())
                .build();
        return companyRepository.save(company);
    }
}
