package me.farhan.springdrop.repositories;

import me.farhan.springdrop.domain.entities.Asset;
import me.farhan.springdrop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

}
