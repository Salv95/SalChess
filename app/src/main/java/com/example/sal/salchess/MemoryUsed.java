package com.example.sal.salchess;

/**
 * Created by Sal on 2/7/18.
 */

public class MemoryUsed {

    MemoryUsed(){
    }

    public void Memory(){

        int mb = 1024*1024;

        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();

        System.out.println("START##### Heap utilization statistics [MB] ###############START");

        //Print used memory
        System.out.println("Used Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()) / mb);

        //Print free memory
        System.out.println("Free Memory:"
                + runtime.freeMemory() / mb);

        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);

        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);

        System.out.println("END##### Heap utilization statistics [MB] ###############END");
    }
}
