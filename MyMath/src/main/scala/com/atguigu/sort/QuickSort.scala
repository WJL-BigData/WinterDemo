package com.atguigu.sort

import scala.util.control.Breaks._

object QuickSort {

  def main(args: Array[String]): Unit = {
    var array = Array(9,-16,21,23,-30,-49,21)
    quickSort(0,6,array)
  }

  def quickSort(left:Int,right:Int,array: Array[Int]):Unit = {

    var l = left
    var r = right
    var pivot = array((left + right)/2)
    var temp = 0

    breakable{
      while(l<r){
        while(array(l)<pivot){
          l+=1
        }
        while(array(r)>pivot){
          r-=1
        }
        if(l>=r){
          break()
        }
        temp = array(l)
        array(l) = array(r)
        array(r) = temp
        if(array(l) == pivot){
          r-=1
        }
        if(array(r) == pivot){
          l+=1
        }
      }
    }
    if(l == r){
      l += 1
      r -= 1
    }
    if(left<r){
      quickSort(left,r,array)
    }
    if(right>l){
      quickSort(l,right,array)
    }

    println(array.mkString(","))

  }

}
