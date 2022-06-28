//package com.backend.Mock3project.filtering;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.ser.FilterProvider;
//import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
//import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class JacksonConfiguration {
//    public JacksonConfiguration(ObjectMapper objectMapper) {
//        objectMapper.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false));
//    }
//
//    public static Object customFilteringProperties(Object object, String nameFilterClass,
//                                                   SimpleBeanPropertyFilter filter) throws JsonProcessingException {
//        FilterProvider filters = new SimpleFilterProvider().setFailOnUnknownId(false).addFilter(nameFilterClass, filter);
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectWriter writer = mapper.writer(filters);
//        String writeValueAsString = writer.writeValueAsString(object);
//        return mapper.readValue(writeValueAsString, Object.class);
//    }
//    public static final SimpleBeanPropertyFilter filterBranch = SimpleBeanPropertyFilter.filterOutAllExcept
//            ("id", "name","address", "phoneNumber","note");
//
//
//}