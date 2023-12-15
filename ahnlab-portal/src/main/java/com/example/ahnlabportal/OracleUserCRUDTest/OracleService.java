package com.example.ahnlabportal.OracleUserCRUDTest;

import com.example.ahnlabportal.Binder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public BufferedInputStream exportTest(Map<String, Object> hit) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        Map<String, String> fieldMap = Stream.of(LogFieldType.values()).collect(Collectors.toMap(LogFieldType::getLogFieldElasticSearch, LogFieldType::getLogFieldDesc));
        writer.write(String.join(","), fieldMap.values());
        writer.newLine();
        Locale lang = Locale.KOREA;

        String line = fieldMap.entrySet().stream().map(
                entry -> {
                    Object value = hit.get(entry.getKey());
                    String formattedValue = switch (entry.getKey()) {
                        case "1" -> "test1";
                        case "2" -> "test2";
                        case "3" -> "test3";
                    };
                    return formattedValue;
                }
        ).collect(Collectors.joining("~"));

        writer.write(line);
        writer.newLine();

        writer.flush();


        if(wafErr.contains("blind")){
            if(logType.contains("2")){
                //I want to pop up "3" if "3" is in logType
            }else{
                logType = logType.stream().map(s -> "3".equals(s) ? "2" : s).collect(Collectors.toList());
            }
        }
        return new BufferedInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
    }

}