package com.atguigu.sort;

import java.util.Arrays;

public class BubbleSort {

    //冒泡排序

    public static void bubbleSort(int[] data){

        int arrayLength = data.length;

        for(int i=0; i<arrayLength-1;i++){

            boolean flag = false;

            for (int j=0;j<arrayLength-1-i;j++){
                if(data[j]>data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    flag = true;
                }
            }

            if (!flag){
                break;
            }
        }

        System.out.println(Arrays.toString(data));

    }

    public static void main(String[] args) {

        int[] data = {9,-16,21,23,-30,-49,21};
        bubbleSort(data);

    }
}
