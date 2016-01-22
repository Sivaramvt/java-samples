package com.computepatterns.experiments;

import java.util.HashMap;

/**
 *
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("k1", "v1");
        hashMap.put("k2", "v2");
        System.out.println(hashMap.get(null));
    }
}
