package com.test.zx.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UserUtil {

    public static User getBusinessSystemUserRepresentation(ObjectNode objectNode){
        User user = new User();
        String userId = null;
        JsonNode userIdNode = objectNode.get("userId");
        if (userIdNode != null && userIdNode.isNull() == false)
            userId = objectNode.get("userId").asText();
        else
            throw new RuntimeException("User id is required");

        user.setUserId(userId);

        JsonNode groupsNode = objectNode.get("groups");
        if (groupsNode != null && groupsNode.isArray()) {
            for (JsonNode groupNode : groupsNode){
                user.getGroups().add(groupNode.asText());
            }
        }
        return user;
    }
}
