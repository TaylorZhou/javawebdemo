package com.test.zx.lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Taylor
 */
public class Test {

    public static BigInteger blockSize = BigInteger.valueOf(2);
    public static int iterationDepth = 4;
    public static int blockSizeInt = 1024;


    public static <T> String objectToJson(T obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
    }

    public static String getStringFromBigInteger(BigInteger id){
            BigInteger remainder = null;

            if(id.compareTo(BigInteger.ZERO) < 0) {
                throw new RuntimeException("ID cannot be negative");
            }

            Long[] blocks = new Long[iterationDepth];
            for(int i=0; i< iterationDepth; i++) {
                remainder = id.remainder(blockSize);
                blocks[i] = remainder.longValue();
                id = id.subtract(remainder).divide(blockSize);
            }

            if(!id.equals(BigInteger.ZERO)) {
                throw new RuntimeException("ID out of range of content storage limit: " +
                        blockSize.pow(iterationDepth).subtract(BigInteger.ONE));
            }

            StringBuffer buffer = new StringBuffer();
            for(int i=iterationDepth - 1; i>=0; i--) {
                buffer.append(blocks[i].toString()).append(File.separatorChar);
            }
            return buffer.toString();
    }
    public static void main(String[] args) throws JsonProcessingException{

        BigInteger sb = new BigInteger("11");
        System.out.println(getStringFromBigInteger(sb));
       /* Set<User> userSet = new HashSet<>();*/

/*        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        User user4 = new User("3");

        userSet.add(user1);
        userSet.add(user2);
        userSet.add(user3);
        userSet.add(user4);

        System.out.println(userSet.size());*/
    }
}
