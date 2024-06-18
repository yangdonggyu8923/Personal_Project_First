//package com.lawmate.personalproject.lawyer.repository;
//import com.lawmate.personalproject.lawyer.model.Lawyer;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface LawyerJpqlRepository extends JpaRepository<Lawyer, Long> {
//    @Query("select a from lawyers a where a.id=:id order by a.id desc")
//    List<Lawyer> getLawyersById(@Param("id") Long id);
//    @Query("select a from lawyers a order by a.name asc")
//    List<Lawyer> getLawyersByNameAsc();
//    @Query("select a from lawyers a where a.law like '%형사법%'")
//    List<Lawyer> getLawyersByLaw형사법();
//
//    @Query("select a from lawyers a where a.law like '%건설%'")
//    List<Lawyer> getLawyersByLaw건설();
//
//    @Query("select a from lawyers a where a.law like '%부동산%'")
//    List<Lawyer> getLawyersByLaw부동산();
//
//    @Query("select a from lawyers a where a.law like '%민사법%'")
//    List<Lawyer> getLawyersByLaw민사법();
//
//    @Query("select a from lawyers a where a.law like '%손해배상%'")
//    List<Lawyer> getLawyersByLaw손해배상();
//
//    @Query("select a from lawyers a where a.law like '%가사법%'")
//    List<Lawyer> getLawyersByLaw가사법();
//
//    Boolean existsByName(String name);
//
//    Optional<Lawyer> findByUsername(String username);
//
//    @Modifying
//    @Query("update lawyers set token=:token where id = :id")
//    void modifyTokenById(@Param("id") Long id, @Param("token") String token);
//
//    Boolean existsByUsername(String username);
//}