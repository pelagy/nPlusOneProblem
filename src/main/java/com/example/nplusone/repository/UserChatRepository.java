package com.example.nplusone.repository;

import com.example.nplusone.entity.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChatRepository extends JpaRepository<UserChat, Long> {
}
