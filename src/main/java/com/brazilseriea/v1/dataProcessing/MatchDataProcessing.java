package com.brazilseriea.v1.dataProcessing;

import com.brazilseriea.v1.data.MatchInput;
import com.brazilseriea.v1.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class MatchDataProcessing implements ItemProcessor<MatchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(MatchDataProcessing.class);

    @Override
    public Match process(final MatchInput input) throws Exception {

        Match match = new Match();

        match.setId(Long.parseLong(input.getId()));
        match.setSeason(Long.parseLong(input.getSeason()));

        String dateInput = input.getDate();
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
        Date date = parser.parse(dateInput);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);

        match.setDate(LocalDate.parse(formattedDate));
        match.setTime(LocalTime.parse(input.getTime())); // possible format error
        match.setHome(input.getHome());
        match.setAway(input.getAway());
        match.setHg(Integer.parseInt(input.getHg()));
        match.setAg(Integer.parseInt(input.getAg()));
        match.setRes(input.getRes());

        return match;
    }

}
