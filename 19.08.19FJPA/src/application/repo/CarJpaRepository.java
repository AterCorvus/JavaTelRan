package application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.CarEntity;

public interface CarJpaRepository extends JpaRepository<CarEntity, Integer>{}
