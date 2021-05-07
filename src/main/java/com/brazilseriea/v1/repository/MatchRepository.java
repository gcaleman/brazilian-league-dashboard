package com.brazilseriea.v1.repository;

import com.brazilseriea.v1.model.Match;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByHomeOrAwayOrderBySeasonAsc(String home, String away);

    @Query("select distinct m.season from Match m where m.home = :home")
    List<Long> findDistinctBySeasonAndHome(@Param("home") String home);

//    @Query("select count(m.res) from Match m where m.home = :home and m.res = 'H' group by m.res")
//    Integer getTeamHomeVictories(@Param("home") String home);
//
//    @Query("select count(m.res) from Match m where m.away = :away and m.res = 'A' group by m.res")
//    Integer getTeamAwayVictories(@Param("away") String away);

}
