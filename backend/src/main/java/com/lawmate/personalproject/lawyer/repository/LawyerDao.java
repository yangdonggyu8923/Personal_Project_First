//package com.lawmate.personalproject.lawyer.repository;
//
//import com.lawmate.personalproject.lawyer.model.Lawyer;
//import com.lawmate.personalproject.lawyer.model.LawyerDto;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface LawyerDao {
//
//    Long countAllLawyers();
//
//    List<LawyerDto> getAllLawyers();
//
//    List<?> getLawyersByLawyerId();
//    @Query("select a from lawyers a order by a.name asc")
//    List<?> getLawyersByNameAsc();
//    @Query("select a from lawyers a where a.law like '%형사법%'")
//    List<?> getLawyersByLaw형사법();
//
//    @Query("select a from lawyers a where a.law like '%건설%'")
//    List<?> getLawyersByLaw건설();
//
//    @Query("select a from lawyers a where a.law like '%부동산%'")
//    List<?> getLawyersByLaw부동산();
//
//    @Query("select a from lawyers a where a.law like '%민사법%'")
//    List<?> getLawyersByLaw민사법();
//
//    @Query("select a from lawyers a where a.law like '%손해배상%'")
//    List<?> getLawyersByLaw손해배상();
//
//    @Query("select a from lawyers a where a.law like '%가사법%'")
//    List<?> getLawyersByLaw가사법();
//
//
//
//}
