package com.x.code.repository;

import com.x.code.entity.po.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code,Long> {

    List<Code> findByIsDel(Long isDel);

    @Modifying
    @Query("update Code c set c.isDel = 1 where  c.id=?1")
    void softDel(Long id);


    @Modifying
    @Query("update Code c set c.codeDefine = ?2 , c.codeItem = ?3 where  c.id=?1")
    void update(Long id,String codeDefine,String codeItem);
}
