package com.test.zx.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Taylor
 */
public class Test {

    public static void main(String[] args) {
/*        Map<String, String>  map = new HashMap<String, String>();
        String scase = map.get("key");
        System.out.println(scase);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        JsonNode appKeyNode = node.get("appKey");
        System.out.println(appKeyNode == null);*/

        Group group = new Group();
        System.out.println(group.groupId);
    }
}
