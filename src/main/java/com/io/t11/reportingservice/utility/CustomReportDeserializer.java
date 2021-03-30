package com.io.t11.reportingservice.utility;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.io.t11.reportingservice.dto.ReportDto;

import java.io.IOException;

public class CustomReportDeserializer extends StdDeserializer<ReportDto> {

    public CustomReportDeserializer() {
        this(null);
    }

    public CustomReportDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public ReportDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ReportDto reportDto = new ReportDto();
        ObjectCodec codec = p.getCodec();
        JsonNode node = codec.readTree(p);

        System.out.println(codec.readTree(p));
        System.out.println(node.get("product"));

        try{
            JsonNode idNode = node.get("product");
            System.out.println(idNode);
            String id = idNode.asText();
            reportDto.setProduct(id);
        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
        }

        return reportDto;
    }

}
