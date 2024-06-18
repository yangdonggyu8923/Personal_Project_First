//package com.lawmate.personalproject.lawyer.repository;
//
//import com.lawmate.personalproject.lawyer.model.Lawyer;
//import com.lawmate.personalproject.lawyer.model.LawyerDto;
//import com.lawmate.personalproject.lawyer.model.QLawyer;
//import com.lawmate.personalproject.lawyer.model.QLawyerDto;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Repository
//public class LawyerDaoImpl implements LawyerDao{
//    private final JPAQueryFactory jpaQueryFactory;
//    private final QLawyer lawyer = QLawyer.lawyer;
//
//
//    @Override
//    public Long countAllLawyers() {
//        return jpaQueryFactory.select(lawyer.count())
//                .from(lawyer)
//                .fetchFirst();
//    }
//
//    @Override
//    public List<LawyerDto> getAllLawyers() {
//        return jpaQueryFactory.select(
//                new QLawyerDto(
//                        lawyer.id,
//                        lawyer.lawyerNo,
//                        lawyer.law,
//                        lawyer.address,
//                        lawyer.name,
//                        lawyer.office,
//                        lawyer.password,
//                        lawyer.phone,
//                        lawyer.username,
//                        lawyer.token))
//                .from(lawyer)
//                .fetch();
//    }
//
//    @Override
//    public List<?> getLawyersByLawyerId() { // id 내림차순 정렬
//        return jpaQueryFactory
//                .select(lawyer.id)
//                .from(lawyer)
//                .orderBy(lawyer.id.desc())
//                .fetch();
//    }
//
//    @Override
//    public List<?> getLawyersByNameAsc() {
//        return jpaQueryFactory
//                .select(lawyer.name)
//                .from(lawyer)
//                .orderBy(lawyer.name.desc())
//                .fetch();
//    }
//
//    @Override
//    public List<?> getLawyersByLaw형사법() {
//        return jpaQueryFactory
//                .select(lawyer.law)
//                .from(lawyer)
//                .where(lawyer.law.contains("형사법"))
//                .fetch();
//    }
//
//    @Override
//    public List<?> getLawyersByLaw건설() {
//        return jpaQueryFactory.selectFrom(lawyer)
//                .where(lawyer.law.contains("건설"))
//                .fetch();
//    }
//
//    @Override
//    public List<?> getLawyersByLaw부동산() {
//        return jpaQueryFactory.selectFrom(lawyer)
//                .where(lawyer.law.contains("부동산"))
//                .fetch();
//    }
//
//    @Override
//    public List<?> getLawyersByLaw민사법() {
//        return jpaQueryFactory.selectFrom(lawyer)
//                .where(lawyer.law.contains("민사법"))
//                .fetch();
//    }
//
//    @Override
//    public List<?> getLawyersByLaw손해배상() {
//        return jpaQueryFactory.selectFrom(lawyer)
//                .where(lawyer.law.contains("손해배상"))
//                .fetch();
//    }
//
//    @Override
//    public List<?> getLawyersByLaw가사법() {
//        return jpaQueryFactory.selectFrom(lawyer)
//                .where(lawyer.law.contains("가사법"))
//                .fetch();
//    }
//
//
//}
