package com.gary.springboot.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
