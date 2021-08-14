package com.africapolicy.main.repo;

import com.africapolicy.main.entity.Healthcenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Olalekan Folayan
 */
public interface HealthCenterRepo extends JpaRepository<Healthcenter,Integer > {

    Healthcenter findByHealthCenterId(long healthcenterid);


    List<Healthcenter> findByStateAndLga(String stateid, String lgaid);

    @Query(value="SELECT * FROM healthcenter u WHERE u.lga = ?1",
            nativeQuery = true)
    List<Healthcenter> findByLga(String lgaid);




    List<Healthcenter> findDistinctByState(String stateid);

    @Query(value="SELECT distinct state FROM healthcenter ORDER BY state asc ",
            nativeQuery = true)
    List<String> findDistinctAll();


    //List<Healthcenter> findByWardId(int wardid);
    //List<Healthcenter> findByStateAndLgaAndWar(int stateid, int lgaid, int wardid);
    //List<Healthcenter> findByStateIdOrWardIdOrLgaId(int stateid, int wardid, int lgaid);

}
