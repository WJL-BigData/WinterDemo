package com.atguigu.sort

object BinaryFind2 {

  def main(args: Array[String]): Unit = {
    var array = Array(4,5,8,15,22,99,412)
    println(binaryFinds2(array,0,6,412))

  }

  def binaryFinds2(array: Array[Int],l:Int,r:Int,findVal:Int): Int ={

    var l = 0
    var r = array.length-1
    while(l<=r){
      var mid = (l+r)/2
      if(array(mid)>findVal){
        r = mid-1
      }else if (array(mid) < findVal){
        l = mid + 1
      }else{
        return mid
      }
    }
    return -1
  }

}
