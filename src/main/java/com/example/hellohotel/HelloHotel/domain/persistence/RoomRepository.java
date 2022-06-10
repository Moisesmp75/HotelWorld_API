package com.example.hellohotel.HelloHotel.domain.persistence;

import com.example.hellohotel.HelloHotel.domain.model.entity.room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<room,Long> {
    Optional<room> findByRoomNumber(Long roomNumber);
    Page<room> findByRoomId(Long RoomId, Pageable pageable);
    Optional<room> findById(Long id);
}