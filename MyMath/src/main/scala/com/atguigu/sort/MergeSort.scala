package com.atguigu.sort

object MergeSort {

  def main(args: Array[String]): Unit = {

    var array = Array(4,99,8,22,15,41,412)
    var array2 = new Array[Int](array.length)
    mergeSort(array,0,6,array2)
    println(array.mkString(","))


  }

  def mergeSort(arr:Array[Int],left: Int,right: Int,temp:Array[Int]):Unit = {
    if(left<right){
      val mid = (left+right)/2
      mergeSort(arr,left,mid,temp)
      mergeSort(arr,mid+1,right,temp)
      merge(arr,left,mid,right,temp)
    }
  }
  
  def merge(arr:Array[Int],left: Int,mid:Int,right: Int,temp:Array[Int]): Unit ={
    var i = left
    var j = mid + 1
    var t = 0
    while(i<=mid && j<=right) {
      if (arr(i) <= arr(j)) {
        temp(t) = arr(i)
        i += 1
        t += 1
      } else {
        temp(t) = arr(j)
        j += 1
        t += 1
      }
    }
    while (i <= mid) {
      temp(t) = arr(i)
      i += 1
      t += 1
    }
    while(j<=right){
      temp(t) = arr(j)
      j+=1
      t+=1
    }
    t = 0
    var tempLeft = left
    while (tempLeft <= right){
      arr(tempLeft) = temp(t)
      t+=1
      tempLeft += 1
    }
  }
}
