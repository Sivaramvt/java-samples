package com.computepatterns.experiments;

import java.io.File;
import java.io.IOException;

/**
 * Finding the java temp path.
 */
public class TempFilePathFinder
{
    public static void main(String[] args)
    {

        try{

            //create a temp file
            File temp = File.createTempFile("temp-file-name", ".tmp");

            System.out.println("Temp file : " + temp.getAbsolutePath());

            //Get temporary file path
            String absolutePath = temp.getAbsolutePath();
            String tempFilePath = absolutePath.
                    substring(0,absolutePath.lastIndexOf(File.separator));

            System.out.println("Temp file path : " + tempFilePath);

        }catch(IOException e){

            e.printStackTrace();

        }

    }
}