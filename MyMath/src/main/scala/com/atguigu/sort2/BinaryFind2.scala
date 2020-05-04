package com.atguigu.sort2

object BinaryFind2 {

  def main(args: Array[String]): Unit = {

    var array = Array(4,5,8,15,22,99,242,412)

    println(binaryFind2(array,22))
  }

  def binaryFind2(array: Array[Int],findVal:Int): Int ={

    var l = 0
    var r = array.length-1
    while(l<=r){
      var mid = (l+r)/2
      if(array(mid) > findVal){
        r = mid - 1
      }else if(array(mid)<findVal){
        l = mid + 1
      }else{
        return mid
      }

    }
    return -1
  }

}
