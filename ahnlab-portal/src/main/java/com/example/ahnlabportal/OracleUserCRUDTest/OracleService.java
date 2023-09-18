package com.example.ahnlabportal.OracleUserCRUDTest;

import com.example.ahnlabportal.Binder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

}