package com.thomas.shorturl.repository;

import com.thomas.shorturl.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUrlRepository extends JpaRepository<Url, Long> {

}
