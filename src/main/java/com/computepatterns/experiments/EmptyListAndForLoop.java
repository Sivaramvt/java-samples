package com.computepatterns.experiments;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class EmptyListAndForLoop {
    public static void main(String[] args){
        List<String> dataList = Collections.EMPTY_LIST;

        for(String data: dataList){
            System.out.println(data);
        }
    }
}
