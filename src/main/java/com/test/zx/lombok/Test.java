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
        User user = new User();
        user.setUserId("1");
        user.getGroups().add("111");
        System.out.println(user);
    }
}
