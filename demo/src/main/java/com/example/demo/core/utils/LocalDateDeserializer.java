package com.example.demo.core.utils;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private static final long serialVersionUID = 1L;
    private static final String format1= "MM/yyyy";
    private static final String format2= "yyyy";

    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }


    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        String toParse = jp.readValueAs(String.class);
        LocalDate ld;

        try{
            YearMonth ym = YearMonth.parse(toParse, DateTimeFormatter.ofPattern(format1));
            ld = ym.atDay(1);
        }catch(DateTimeParseException dpe){
            Year y = Year.parse(toParse, DateTimeFormatter.ofPattern(format2) );
            ld = y.atDay(1);
        }finally {

        }

        return ld;
    }

}