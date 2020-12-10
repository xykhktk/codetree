package com.x.code.repository;

import com.x.code.entity.po.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeRepository extends JpaRepository<Code,Long> {
}
