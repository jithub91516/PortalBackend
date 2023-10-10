package com.example.ahnlabportal.OracleUserCRUDTest;

import com.example.ahnlabportal.Binder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OracleService {

    @Autowired
    private Binder binder;

    public List<OracleEntity> getAllUsers() {

        Map<String, String> test2 = binder.getProperty("test", Map.class);

        EmpOption test3 = binder.getProperty("test", EmpOption.class);

        return null;
    }

    public Date getDateFromat(String date)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        Date res = sdf.parse(date);
        return res;
    }

    public int getTimestampDate(Date date){
        int reVal = 0;
        Timestamp time = new Timestamp(date.getTime());
        reVal = Integer.parseInt(Long.toString(time.getTime() / 1000));

        return reVal;
    }

}