package com.ficrew.yourbutler.Chat.infrastructure.persistence.jpa;

import com.ficrew.yourbutler.Chat.domain.entity.ChatRoom;
import com.ficrew.yourbutler.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    // 사용자 id와 입력받고 해당하는 채팅방을 모두 반환하는 메소드
    List<ChatRoom> findAllByMember(Member member);

    // 사용자 id와 아파트 id를 입력받고 해당하는 채팅방을 반환하는 메소드
    ChatRoom findByMemberAndAptId(Member member, Long aptId);


}
