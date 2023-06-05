package com.example.nplusone;

import com.example.nplusone.entity.Chat;
import com.example.nplusone.entity.Company;
import com.example.nplusone.entity.Department;
import com.example.nplusone.entity.Filial;
import com.example.nplusone.entity.User;
import com.example.nplusone.entity.UserChat;
import com.example.nplusone.repository.ChatRepository;
import com.example.nplusone.repository.CompanyRepository;
import com.example.nplusone.repository.FilialRepository;
import com.example.nplusone.repository.UserChatRepository;
import com.example.nplusone.repository.UserRepository;
import com.example.nplusone.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@SpringBootTest
public class NPlusOneTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserChatRepository userChatRepository;

    @Test
    void createEntities() {
        createCompanyAndUsers();
        createFilialesAndCompanies();
    }

    @Test
    @Transactional
    void findCompanyByIdTest() {
        companyRepository.findById(1L);
        System.out.println();
    }

    @Test
    void findUserByIdTest() {
        userRepository.findById(3L);
        System.out.println();
    }


    private void createCompanyAndUsers() {
        Company company = createCompany("yandex");
        Chat chat1 = createChat("chat1");
        Chat chat2 = createChat("chat2");
        Chat chat3 = createChat("chat3");

        createUserChats(chat1, createUser("ivan", "Ivanov Ivan", createCompany("google"), Department.QA));
        createUserChats(chat2, createUser("roman", "Romanov Roman", company, Department.BACKEND));
        createUserChats(chat3, createUser("vadim", "Vadimov Vadim", company, Department.FRONTEND));
        createUserChats(chat2, createUser("oleg", "Olegov Oleg", company, Department.BACKEND));
        createUserChats(chat3, createUser("petr", "Petrov Petr", company, Department.FRONTEND));
        createUserChats(chat2, createUser("dima", "Dimov Dima", company, Department.BACKEND));
        createUserChats(chat3, createUser("victor", "Voctorov Victor", company, Department.FRONTEND));
        createUserChats(chat2, createUser("denis", "Denisov Denis", company, Department.BACKEND));
        createUserChats(chat3, createUser("vova", "Vovin Vova", company, Department.FRONTEND));
        createUserChats(chat2, createUser("gosha", "Goshin Gosha", company, Department.BACKEND));
    }

    private void createFilialesAndCompanies() {
        Company company = createCompany("yandex");

        createFilial("Spb", 001L, company);
        createFilial("Msk", 002L, company);
        createFilial("Uhta", 003L, company);
        createFilial("Milan", 004L, company);
    }

    private User createUser(String login, String fullName, Company company, Department department) {
        User user = User.builder()
                .login(login)
                .fullName(fullName)
                .company(company)
                .department(department)
                .build();
       return userRepository.save(user);
    }

    private Company createCompany(String name) {
        Company company = Company.builder()
                .name(name)
                .createdAt(LocalDateTime.now())
                .build();
        return companyRepository.save(company);
    }

    private Filial createFilial(String name, Long code, Company company) {
        Filial filial = Filial.builder()
                .name(name)
                .code(code)
                .company(company)
                .build();
        return filialRepository.save(filial);
    }

    private Chat createChat(String name){
      Chat chat = Chat.builder()
              .chatName(name)
              .build();
      return chatRepository.save(chat);
    }

    private UserChat createUserChats (Chat chat, User user){
        UserChat userChat = UserChat.builder()
                .chat(chat)
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();
        return userChatRepository.save(userChat);
    }
}
