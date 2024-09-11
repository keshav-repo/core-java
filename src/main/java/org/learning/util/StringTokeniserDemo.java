package org.learning.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class StringTokeniserDemo {
    public static List<String> getTokens(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, ",", false);

        int count =  tokenizer.countTokens();
        System.out.println(count);

        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }

        return tokens;
    }

    /**
     * similar approach using java 8
     * @param str
     * @return
     */
    public static List<String>  getTokensWithCollection(String str) {
        return Collections.list(new StringTokenizer(str, ",")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String str = "Welcome,to,baeldung.com";

        List<String> tokens = getTokens(str);
        System.out.println(tokens);
    }
}
