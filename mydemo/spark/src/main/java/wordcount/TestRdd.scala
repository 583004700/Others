package wordcount

import scala.collection.mutable._

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object TestRdd extends App {
  val conf = new SparkConf().setAppName("WordCount").setMaster("local[1]")
  val sc = new SparkContext(conf)

  /*==============================================================================================================================*/
  /**
   * map处理
   */
  //test_map(sc)
  def test_map(sc: SparkContext) {
    val a = sc.parallelize(1 to 9, 3)
    val b = a.map(x => x * 2)
    a.foreach(println)
    b.foreach(println)
  }
  /**
   * 过滤
   */
  //test_filter(sc)
  def test_filter(sc: SparkContext) {
    val rdd = sc.parallelize(List(1, 2, 3, 4, 5, 6))
    val filterRdd = rdd.filter(_ > 5)
    filterRdd.foreach(println)
  }
  /**
   * 将两个数组压成一个数组处理
   */
  //test_flatmap(sc)
  def test_flatmap(sc: SparkContext) {
    val a = sc.parallelize(1 to 4, 2)
    val b = a.flatMap(x => 1 to x)
    b.foreach(println)
  }
  /**
   * 把分区中一个元素和它的下一个元素组成一个Tuple。因为分区中最后一个元素没有下一个元素了，所以(3,4)和(6,7)不在结果中。
   */
  //test_mappartition(sc)
  def test_mappartition(sc: SparkContext) {
    val a = sc.parallelize(1 to 9, 3)
    a.mapPartitions(myfunc).foreach(println)
  }

  def myfunc[T](iter: Iterator[T]): Iterator[(T, T)] = {
    var res = List[(T, T)]()
    var pre = iter.next
    while (iter.hasNext) {
      var cur = iter.next
      //向集合中追加元素
      res.::=(pre, cur)
      pre = cur
    }
    res.iterator
  }
  /**
   * rdd2将rdd1中每个分区的数字累加，并在每个分区的累加结果前面加了分区索引
   */
  //test_mapPartitionsWithIndex(sc)
  def test_mapPartitionsWithIndex(sc: SparkContext) {
    var rdd1 = sc.makeRDD(1 to 5, 2)
    //rdd1有两个分区
    var rdd2 = rdd1.mapPartitionsWithIndex {
      (x, iter) =>
        {
          var result = List[String]()
          var i = 0
          while (iter.hasNext) {
            i += iter.next()
          }
          result.::(x + "|" + i).iterator
        }
    }
    rdd2.foreach(println)
  }
  /**
   * 把partition index 乘以10加2,作为新的RDD的元素。
   */
  //test_mapwith(sc)

  def test_mapwith(sc: SparkContext) {
    val x = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3)
    x.mapWith(a => a * 10)((b, a) => (b, a + 2)).foreach(println)

  }
  /**
   * 将角标和数值一起输出
   */
  //test_flatmapwith(sc)

  def test_flatmapwith(sc: SparkContext) {
    val a = sc.parallelize(List(1, 2, 3, 4, 5, 6, 7, 8, 9), 3)
    a.flatMapWith(x => x, true)((x, y) => List(y, x)).foreach(println)
  }
  /**
   * 将角标和数值一起输出
   */
  //test_reduce(sc)

  def test_reduce(sc: SparkContext) {
    val c = sc.parallelize(1 to 10)
    val res = c.reduce((x, y) => x + y)
    println(res)
  }
  /**
   * 该函数用于将RDD进行重分区，使用HashPartitioner。
   * 第一个参数为重分区的数目，第二个为是否进行shuffle，默认为false;
   *
   */
  //test_coalesce(sc)

  def test_coalesce(sc: SparkContext) {
    var data = sc.parallelize(1 to 12, 3)

    data.foreach(println)
    println("data:" + data.partitions.size)

    var rdd1 = data.coalesce(1)
    rdd1.foreach(println)
    println("rdd1:" + rdd1.partitions.size)

    //如果重分区的数目大于原来的分区数，那么必须指定shuffle参数为true，//否则，分区数不便
    var rdd2 = data.coalesce(4)
    rdd2.foreach(println)
    println("rdd2:" + rdd2.partitions.size)

    var rdd3 = data.coalesce(4, true)
    rdd3.foreach(println)
    println("rdd3:" + rdd3.partitions.size)
  }
  /**
   * 该函数其实就是coalesce函数第二个参数为true的实现
   *
   */
  //test_repartition(sc)
  def test_repartition(sc: SparkContext) {
    var data = sc.parallelize(1 to 12, 3)

    data.foreach(println)
    println("data:" + data.partitions.size)

    var rdd1 = data.repartition(1)
    rdd1.foreach(println)
    println("rdd1:" + rdd1.partitions.size)

    var rdd2 = data.repartition(4)
    rdd2.foreach(println)
    println("rdd2:" + rdd2.partitions.size)

  }
  /**
   * 该函数根据weights权重，将一个RDD切分成多个RDD。
   * 该权重参数为一个Double数组
   * 第二个参数为random的种子，基本可忽略。
   *
   *
   */
  //test_randomSplit(sc)
  def test_randomSplit(sc: SparkContext) {
    var rdd = sc.makeRDD(1 to 12, 12)
    rdd.foreach(println)
    var splitRDD = rdd.randomSplit(Array(0.5, 0.1, 0.2, 0.2))
    //这里注意：randomSplit的结果是一个RDD数组
    println(splitRDD.size)
    //由于randomSplit的第一个参数weights中传入的值有4个，因此，就会切分成4个RDD,
    //把原来的rdd按照权重0.5, 0.1, 0.2, 0.2，随机划分到这4个RDD中，权重高的RDD划分到的几率就大一些。
    //注意，权重的总和加起来为1，否则会不正常
    println("====================")
    splitRDD(0).foreach(println)
    println("====================")
    splitRDD(1).foreach(println)
    println("====================")
    splitRDD(2).foreach(println)
    println("====================")
    splitRDD(3).foreach(println)
    println("====================")
  }
  /**
   * 该函数是将RDD中每一个分区中类型为T的元素转换成Array[T]，这样每一个分区就只有一个数组元素。
   */
  //test_glom(sc)
  def test_glom(sc: SparkContext) {
    var rdd = sc.makeRDD(1 to 10, 3)
    println(rdd.foreach(println))
    println(rdd.partitions.size)
    //glom将每个分区中的元素放到一个数组中，这样，结果就变成了3个数组
    rdd.glom().foreach(println)
    println(rdd.glom().partitions.size)
  }
  /**
   * 并集
   */
  //test_union(sc)
  def test_union(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(5, 6, 4, 3))
    val rdd2 = sc.parallelize(List(1, 2, 3, 4))
    //求并集
    val rdd3 = rdd1.union(rdd2)
    rdd3.foreach(println)
  }
  /**
   * 去重
   */
  //test_distinct(sc)
  def test_distinct(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(5, 6, 4, 3))
    val rdd2 = sc.parallelize(List(1, 2, 3, 4))
    //求并集
    val rdd3 = rdd1.union(rdd2)
    //去重输出
    rdd3.distinct.foreach(println)
  }
  /**
   * 交集
   */
  //test_intersection(sc)
  def test_intersection(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(5, 6, 4, 3))
    val rdd2 = sc.parallelize(List(1, 2, 3, 4))
    //求交集
    val rdd4 = rdd1.intersection(rdd2)
    rdd4.foreach(println)
  }
  /**
   * 该函数类似于intersection，但返回在RDD中出现，并且不在otherRDD中出现的元素，不去重。
   * 参数含义同intersection
   */
  //test_subtract(sc)
  def test_subtract(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(5, 6, 6, 4, 3))
    val rdd2 = sc.parallelize(List(1, 2, 3, 4))
    //求交集
    val rdd4 = rdd1.subtract(rdd2)
    rdd4.foreach(println)
  }
  /**
   * subtractByKey和基本转换操作中的subtract类似,只不过这里是针对K的，返回在主RDD中出现，并且不在otherRDD中出现的元素。
   * 参数numPartitions用于指定结果的分区数
   * 参数partitioner用于指定分区函数
   *
   */
  //test_subtractByKey(sc)
  def test_subtractByKey(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", "1"), ("B", "2"), ("B", "3"), ("C", "3")), 2)
    var rdd2 = sc.makeRDD(Array(("A", "a"), ("C", "c"), ("D", "d")), 2)
    rdd1.subtractByKey(rdd2).foreach(println)

  }
  /**
   * 分组
   */
  //test_groupByKey(sc)
  def test_groupByKey(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 1), ("shuke", 2)))
    //求并集
    val rdd4 = rdd1 union rdd2
    //按key进行分组
    val rdd5 = rdd4.groupByKey
    rdd5.foreach(println)
  }
  /**
   * 按key统计
   */
  //test_reduceByKey(sc)
  def test_reduceByKey(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 1), ("shuke", 2)))
    //求并集
    val rdd4 = rdd1 union rdd2
    //按key进行分组
    val rdd6 = rdd4.reduceByKey(_ + _)
    rdd6.foreach(println)
  }
  /**
   * 按key排序
   */
  //test_sortByKey(sc)
  def test_sortByKey(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2), ("shuke", 1)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 3), ("shuke", 2), ("kitty", 5)))
    val rdd3 = rdd1.union(rdd2)
    //按key进行聚合
    val rdd4 = rdd3.reduceByKey(_ + _)
    //false降序
    val rdd5 = rdd4.sortByKey(false)
    rdd5.foreach(println)
  }
  /**
   * 按任意值排序
   */
  //test_sortBy(sc)
  def test_sortBy(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2), ("shuke", 1)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 3), ("shuke", 2), ("kitty", 5)))
    val rdd3 = rdd1.union(rdd2)
    //按key进行聚合
    val rdd4 = rdd3.reduceByKey(_ + _)
    //false降序
    val rdd5 = rdd4.sortBy(_._2, false)
    rdd5.foreach(println)
  }
  /**
   * zip函数用于将两个RDD组合成Key/Value形式的RDD,这里默认两个RDD的partition数量以及元素数量都相同，否则会抛出异常。
   */
  //test_zip(sc)
  def test_zip(sc: SparkContext) {
    var rdd0 = sc.makeRDD(1 to 10, 2)
    var rdd1 = sc.makeRDD(1 to 5, 2)
    var rdd2 = sc.makeRDD(Seq("A", "B", "C", "D", "E"), 2)
    var rdd3 = sc.makeRDD(Seq("A", "B", "C", "D", "E"), 3)

    rdd1.zip(rdd2).foreach(println)
    rdd2.zip(rdd1).foreach(println)
    //如果两个RDD分区数不同，则抛出异常:Can't zip RDDs with unequal numbers of partitions
    //rdd1.zip(rdd3).foreach(println)
    // Can only zip RDDs with same number of elements in each partition
    //rdd0.zip(rdd2).foreach(println)
  }
  /**
   * zipPartitions函数将多个RDD按照partition组合成为新的RDD，该函数需要组合的RDD具有相同的分区数，但对于每个分区内的元素数量没有要求。
   */
  /*
   * 参数是一个RDD
   * 这两个区别就是参数preservesPartitioning，是否保留父RDD的partitioner分区信息
	映射方法f参数为两个RDD的迭代器。
   * */
  //test_zipPartitions1(sc)
  def test_zipPartitions1(sc: SparkContext) {
    var rdd1 = sc.makeRDD(1 to 5, 2)
    var rdd2 = sc.makeRDD(Seq("A", "B", "C", "D", "E"), 2)
    //rdd1两个分区中元素分布：
    rdd1.mapPartitionsWithIndex {
      (x, iter) =>
        {
          var result = List[String]()
          while (iter.hasNext) {
            result ::= ("part_" + x + "|" + iter.next())
          }
          result.iterator

        }
    }.foreach(println)

    //rdd2两个分区中元素分布
    rdd2.mapPartitionsWithIndex {
      (x, iter) =>
        {
          var result = List[String]()
          while (iter.hasNext) {
            result ::= ("part_" + x + "|" + iter.next())
          }
          result.iterator

        }
    }.foreach(println)

    //rdd1和rdd2做zipPartition
    rdd1.zipPartitions(rdd2) {
      (rdd1Iter, rdd2Iter) =>
        {
          var result = List[String]()
          while (rdd1Iter.hasNext && rdd2Iter.hasNext) {
            result ::= (rdd1Iter.next() + "_" + rdd2Iter.next())
          }
          result.iterator
        }
    }.foreach(println)
  }
  /*
   * 参数是一个RDD
   * 用法同上面，只不过该函数参数为两个RDD，映射方法f输入参数为两个RDD的迭代器。
   * */
  //test_zipPartitions2(sc)
  def test_zipPartitions2(sc: SparkContext) {
    var rdd1 = sc.makeRDD(1 to 5, 2)
    var rdd2 = sc.makeRDD(Seq("A", "B", "C", "D", "E"), 2)
    var rdd3 = sc.makeRDD(Seq("a", "b", "c", "d", "e"), 2)
    //rdd1两个分区中元素分布：
    rdd1.mapPartitionsWithIndex {
      (x, iter) =>
        {
          var result = List[String]()
          while (iter.hasNext) {
            result ::= ("part_" + x + "|" + iter.next())
          }
          result.iterator

        }
    }.foreach(println)

    //rdd2两个分区中元素分布
    rdd2.mapPartitionsWithIndex {
      (x, iter) =>
        {
          var result = List[String]()
          while (iter.hasNext) {
            result ::= ("part_" + x + "|" + iter.next())
          }
          result.iterator

        }
    }.foreach(println)

    rdd3.mapPartitionsWithIndex {
      (x, iter) =>
        {
          var result = List[String]()
          while (iter.hasNext) {
            result ::= ("part_" + x + "|" + iter.next())
          }
          result.iterator

        }
    }.foreach(println)

    //三个RDD做zipPartitions
    var rdd4 = rdd1.zipPartitions(rdd2, rdd3) {
      (rdd1Iter, rdd2Iter, rdd3Iter) =>
        {
          var result = List[String]()
          while (rdd1Iter.hasNext && rdd2Iter.hasNext && rdd3Iter.hasNext) {
            result ::= (rdd1Iter.next() + "_" + rdd2Iter.next() + "_" + rdd3Iter.next())
          }
          result.iterator
        }
    }
    rdd4.foreach(println)
  }
  /**
   * 该函数将RDD中的元素和这个元素在RDD中的ID（索引号）组合成键/值对。
   */
  //test_zipWithIndex(sc)
  def test_zipWithIndex(sc: SparkContext) {
    var rdd2 = sc.makeRDD(Seq("A", "B", "R", "D", "F"), 2)
    rdd2.zipWithIndex().foreach(println)
  }
  /**
   * 该函数将RDD中元素和一个唯一ID组合成键/值对，该唯一ID生成算法如下：
   * 每个分区中第一个元素的唯一ID值为：该分区索引号，
   * 每个分区中第N个元素的唯一ID值为：(前一个元素的唯一ID值) + (该RDD总的分区数)
   *
   */
  //test_zipWithUniqueId(sc)
  def test_zipWithUniqueId(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Seq("A", "B", "C", "D", "E", "F"), 2)
    rdd1.mapPartitionsWithIndex {
      (x, iter) =>
        {
          var result = List[String]()
          while (iter.hasNext) {
            result ::= ("part_" + x + "|" + iter.next())
          }
          result.iterator

        }
    }.foreach(println)
    //rdd1有两个分区，
    rdd1.zipWithUniqueId().foreach(println)
    //总分区数为2
    //第一个分区第一个元素ID为0，第二个分区第一个元素ID为1
    //第一个分区第二个元素ID为0+2=2，第一个分区第三个元素ID为2+2=4
    //第二个分区第二个元素ID为1+2=3，第二个分区第三个元素ID为3+2=5
  }
  /**
   * 该函数根据partitioner函数生成新的ShuffleRDD，将原RDD重新分区。
   */
  //test_partitionBy(sc)
  def test_partitionBy(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array((1, "A"), (2, "B"), (3, "C"), (4, "D")), 2)
    println(rdd1.partitions.size);
    //查看rdd1中每个分区的元素:(2,B),(1,A)在part_0中，(4,D),(3,C)在part_1中
    showPartition1(rdd1)
    //使用partitionBy重分区
    var rdd2 = rdd1.partitionBy(new org.apache.spark.HashPartitioner(2))
    println(rdd2.partitions.size);
    //查看rdd2中每个分区的元素：(4,D),(2,B)在part_0中，(3,C),(1,A)在part_1中
    showPartition1(rdd2)
  }
  /**
   * mapValues顾名思义就是输入函数应用于RDD中Kev-Value的Value，原RDD中的Key保持不变，与新的Value一起组成新的RDD中的元素。因此，该函数只适用于元素为KV对的RDD。
   */
  //test_mapValues(sc)
  def test_mapValues(sc: SparkContext) {
    val a = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", " eagle"), 2)
    val b = a.map(x => (x.length, x))
    //在value的前后加上"x"
    b.mapValues("x" + _ + "x").foreach(println)
  }
  /**
   * flatMapValues类似于mapValues，不同的在于flatMapValues应用于元素为KV对的RDD中Value。
   * 每一个元素的Value被输入函数映射为一系列的值，然后这些值再与原RDD中的Key组成一系列新的KV对。
   */
  //test_flatMapValues(sc)
  def test_flatMapValues(sc: SparkContext) {
    val a = sc.parallelize(List((1, 2), (3, 4), (5, 6)))
    val b = a.flatMapValues(x => 1.to(x))
    b.collect.foreach(println)
  }
  /**
   * 该函数用于将RDD[K,V]转换成RDD[K,C],这里的V类型和C类型可以相同也可以不同。
   * 其中的参数：
   * createCombiner：组合器函数，用于将V类型转换成C类型，输入参数为RDD[K,V]中的V,输出为C
   * mergeValue：合并值函数，将一个C类型和一个V类型值合并成一个C类型，输入参数为(C,V)，输出为C
   * mergeCombiners：分区合并组合器函数，用于将两个C类型值合并成一个C类型，输入参数为(C,C)，输出为C
   * numPartitions：结果RDD分区数，默认保持原有的分区数
   * partitioner：分区函数,默认为HashPartitioner
   * mapSideCombine：是否需要在Map端进行combine操作，类似于MapReduce中的combine，默认为true
   *
   */
  //test_combineByKey(sc)
  def test_combineByKey(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", 1), ("A", 2), ("B", 1), ("B", 2), ("B", 3), ("B", 4), ("C", 1)), 2)
    showPartition(rdd1)

    rdd1.combineByKey(
      (v: Int) => v + "_",
      (c: String, v: Int) => c + "@" + v,
      (c: String, c1: String) => c + "$" + c1).foreach(println)
    //将RDD[String,Int]转换为RDD[String,List[Int]]
    rdd1.combineByKey(
      (v: Int) => List(v),
      (c: List[Int], v: Int) => v :: c,
      (c1: List[Int], c2: List[Int]) => c1 ::: c2).foreach(println)

  }
  /**
   * 该函数用于RDD[K,V]根据K将V做折叠、合并处理，其中的参数zeroValue表示先根据映射函数将zeroValue应用于V,进行初始化V,再将映射函数应用于初始化后的V.
   * 在使用foldByKey算子时候，要特别注意映射函数及zeroValue的取值。
   */
  //test_foldByKey(sc)
  def test_foldByKey(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", 0), ("A", 2), ("B", 1), ("B", 2), ("C", 1)))
    //将rdd1中每个key对应的V进行累加，注意zeroValue=0,需要先初始化V,映射函数为+操
    //作，比如("A",0), ("A",2)，先将zeroValue应用于每个V,得到：("A",0+0), ("A",2+0)，即：
    //("A",0), ("A",2)，再将映射函数应用于初始化后的V，最后得到(A,0+2),即(A,2)
    rdd1.foldByKey(0)(_ + _).foreach(println)
    println("------------------------------------------")
    rdd1.foldByKey(2)(_ + _).foreach(println)
    println("------------------------------------------")
    rdd1.foldByKey(0)(_ * _).foreach(println)
    println("------------------------------------------")
    rdd1.foldByKey(1)(_ * _).foreach(println)
  }
  /**
   * 该函数将RDD[K,V]中每个K对应的V值根据映射函数来运算，运算结果映射到一个Map[K,V]中，而不是RDD[K,V]。
   */
  //test_reduceByKeyLocally(sc)
  def test_reduceByKeyLocally(sc: SparkContext) {
    //org.apache.spark.rdd.RDD[(String, Int)] = ParallelCollectionRDD[91] at makeRDD at :21
    var rdd1 = sc.makeRDD(Array(("A", 0), ("A", 2), ("A", 3), ("B", 1), ("B", 2), ("C", 1)))
    //scala.collection.Map[String,Int] = Map(B -> 3, A -> 2, C -> 1)
    rdd1.reduceByKeyLocally((x, y) => x + y).foreach(println)
  }
  /**
   * groupbykey:将所有数据的value混在一起
   * cogroup将不同数据源的value分离
   */
  //test_cogroup(sc)
  def test_cogroup(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(("tom", 1), ("tom", 2), ("jerry", 3), ("kitty", 2)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 1), ("shuke", 2)))
    //cogroup
    val rdd3 = rdd1.cogroup(rdd2)
    //groupbykey
    val rdd4 = rdd1.union(rdd2).groupByKey
    //注意cogroup与groupByKey的区别
    rdd3.foreach(println)
    rdd4.foreach(println)
  }
  /**
   * 关联
   */
  //test_join(sc)
  def test_join(sc: SparkContext) {
    val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 3), ("kitty", 2)))
    val rdd2 = sc.parallelize(List(("jerry", 2), ("tom", 1), ("shuke", 2)))
    //求jion
    val rdd3 = rdd1.join(rdd2)
    rdd3.foreach(println)
  }
  /**
   * leftOuterJoin类似于SQL中的左外关联left outer join，返回结果以前面的RDD为主，关联不上的记录为空。
   * 只能用于两个RDD之间的关联，如果要多个RDD关联，多关联几次即可。
   * 参数numPartitions用于指定结果的分区数
   * 参数partitioner用于指定分区函数
   */
  //test_leftOuterJoin(sc)
  def test_leftOuterJoin(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", "1"), ("B", "2"), ("C", "3")), 2)
    var rdd2 = sc.makeRDD(Array(("A", "a"), ("C", "c"), ("D", "d")), 2)
    //res11: Array[(String, (String, Option[String]))] = Array((B,(2,None)), (A,(1,Some(a))), (C,(3,Some(c))))
    rdd1.leftOuterJoin(rdd2).foreach(println)
  }
  /**
   * leftOuterJoin类似于SQL中的左外关联left outer join，返回结果以前面的RDD为主，关联不上的记录为空。
   * 只能用于两个RDD之间的关联，如果要多个RDD关联，多关联几次即可。
   * 参数numPartitions用于指定结果的分区数
   * 参数partitioner用于指定分区函数
   */
  //test_rightOuterJoin(sc)
  def test_rightOuterJoin(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", "1"), ("B", "2"), ("C", "3")), 2)
    var rdd2 = sc.makeRDD(Array(("A", "a"), ("C", "c"), ("D", "d")), 2)
    //res11: Array[(String, (String, Option[String]))] = Array((B,(2,None)), (A,(1,Some(a))), (C,(3,Some(c))))
    rdd1.rightOuterJoin(rdd2).foreach(println)
  }
  /**
   * first返回RDD中的第一个元素，不排序。
   */
  //test_first(sc)
  def test_first(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", "1"), ("B", "2"), ("C", "3")), 2)
    println(rdd1.first)
    var rdd2 = sc.makeRDD(Seq(10, 4, 2, 12, 3))
    println(rdd2.first)
  }
  /**
   * count返回RDD中的元素数量。
   */
  //test_count(sc)
  def test_count(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", "1"), ("B", "2"), ("C", "3")), 2)
    println(rdd1.count)
  }
  /**
   * 根据映射函数f，对RDD中的元素进行二元计算，返回计算结果。
   */
  //test_reduce2(sc)
  def test_reduce2(sc: SparkContext) {
    var rdd1 = sc.makeRDD(1 to 10, 2)
    println(rdd1.reduce(_ + _))
    var rdd2 = sc.makeRDD(Array(("A", 0), ("A", 2), ("B", 1), ("B", 2), ("C", 1)))
    println(rdd2.reduce((x, y) => {
      (x._1 + y._1, x._2 + y._2)
    }))
  }
  /**
   * take用于获取RDD中从0到num-1下标的元素，不排序。
   */
  //test_take(sc)
  def test_take(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Seq(10, 4, 2, 12, 3))
    println(rdd1.take(1)(0))
    rdd1.take(2).foreach(println)
  }
  /**
   * top函数用于从RDD中，按照默认（降序）或者指定的排序规则，返回前num个元素。
   */
  //test_top(sc)
  def test_top(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Seq(10, 4, 2, 12, 3))
    rdd1.top(1).foreach(println)
    rdd1.top(2).foreach(println)
    //指定排序规则,正序
    implicit val myOrd = implicitly[Ordering[Int]].reverse
    rdd1.top(1).foreach(println)
    rdd1.top(2).foreach(println)
  }
  /**
   * takeOrdered和top类似，只不过以和top相反的顺序返回元素
   */
  //test_takeOrdered(sc)
  def test_takeOrdered(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Seq(10, 4, 2, 12, 3))
    rdd1.top(1).foreach(println)
    rdd1.top(2).foreach(println)
    rdd1.takeOrdered(1).foreach(println)
    rdd1.takeOrdered(2).foreach(println)
  }
  /**
   * aggregate用户聚合RDD中的元素，先使用seqOp将RDD中每个分区中的T类型元素聚合成U类型，
   * 再使用combOp将之前每个分区聚合后的U类型聚合成U类型，
   * 特别注意seqOp和combOp都会使用zeroValue的值，zeroValue的类型为U。
   */
  //test_aggregate(sc)
  def test_aggregate(sc: SparkContext) {
    /*##第一个分区中包含5,4,3,2,1##第二个分区中包含10,9,8,7,6*/
    var rdd1 = sc.makeRDD(1 to 10, 2)
    showPartition2(rdd1)
    val rdd2 = rdd1.aggregate(1)({ (x: Int, y: Int) => x + y }, { (a: Int, b: Int) => a + b })
    println(rdd2)
    /*结果为什么是58，看下面的计算过程：
	先在每个分区中迭代执行 (x : Int,y : Int) => x + y 并且使用zeroValue的值1
	即：part_0中 zeroValue+5+4+3+2+1 = 1+5+4+3+2+1 = 16
 	part_1中 zeroValue+10+9+8+7+6 = 1+10+9+8+7+6 = 41
	再将两个分区的结果合并(a : Int,b : Int) => a + b ，并且使用zeroValue的值1
	即：zeroValue+part_0+part_1 = 1 + 16 + 41 = 58*/
    val rdd3 = rdd1.aggregate(2)({ (x: Int, y: Int) => x + y }, { (a: Int, b: Int) => a * b })
    println(rdd3)
  }
  /**
   * fold是aggregate的简化，将aggregate中的seqOp和combOp使用同一个函数op。
   */
  //test_fold(sc)
  def test_fold(sc: SparkContext) {
    var rdd1 = sc.makeRDD(1 to 10, 2)
    val rdd2 = rdd1.fold(1)((x, y) => x + y)
    println(rdd2)
    //结果同上面使用aggregate的第一个例子一样，即：
    val rdd3 = rdd1.aggregate(1)({ (x, y) => x + y }, { (a, b) => a + b })
    println(rdd3)
  }
  /**
   * lookup用于(K,V)类型的RDD,指定K值，返回RDD中该K对应的所有V值。
   */
  //test_lookup(sc)
  def test_lookup(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", 0), ("A", 2), ("B", 1), ("B", 2), ("C", 1)))
    println(rdd1.lookup("A"))
    println(rdd1.lookup("B"))

  }
  /**
   * countByKey用于统计RDD[K,V]中每个K的数量。
   */
  //test_countByKey(sc)
  def test_countByKey(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Array(("A", 0), ("A", 2), ("B", 1), ("B", 2), ("B", 3)))
    println(rdd1.countByKey)
  }
  /**
   * foreach用于遍历RDD,将函数f应用于每一个元素。
   * 但要注意，如果对RDD执行foreach，只会在Executor端有效，而并不是Driver端。
   * 比如：rdd.foreach(println)，只会在Executor的stdout中打印出来，Driver端是看不到的。
   * 我在Spark1.4中是这样，不知道是否真如此。
   * 这时候，使用accumulator共享变量与foreach结合，倒是个不错的选择。
   *
   */
  //test_foreach(sc)
  def test_foreach(sc: SparkContext) {
    var cnt = sc.accumulator(0)
    var rdd1 = sc.makeRDD(1 to 10, 2)
    rdd1.foreach(x => cnt += x)
    println(cnt.value)
    rdd1.collect.foreach(println)
  }
  /**
   * foreachPartition和foreach类似，只不过是对每一个分区使用f。
   */
  //test_foreachPartition(sc)
  def test_foreachPartition(sc: SparkContext) {
    var rdd1 = sc.makeRDD(1 to 10, 2)
    var allsize = sc.accumulator(0)
    rdd1.foreachPartition { x =>
      {
        allsize += x.size
      }
    }
    println(allsize.value)
    rdd1.foreachPartition { x =>
      {
        //x.foreach(println)
        allsize += x.sum
      }
    }
    println(allsize.value)

  }
  /**
   * sortBy根据给定的排序k函数将RDD中的元素进行排序。
   */
  //test_sortby(sc)
  def test_sortby(sc: SparkContext) {
    var rdd1 = sc.makeRDD(Seq(3, 6, 7, 1, 2, 0), 2)
    rdd1.sortBy(x => x).foreach(println)
    rdd1.sortBy(x => x, false).foreach(println)
    //RDD[K,V]类型
    var rdd2 = sc.makeRDD(Array(("B", 2), ("A", 1), ("B", 6), ("A", 3), ("B", 7)))
    rdd2.sortBy(x => x).foreach(println)
    //按照V进行降序排序
    rdd2.sortBy(x => x._2, false).foreach(println)
  }
  /**
   * saveAsTextFile用于将RDD以文本文件的格式存储到文件系统中。
   * codec参数可以指定压缩的类名。
   *
   */
  //test_saveAsTextFile(sc)
  def test_saveAsTextFile(sc: SparkContext) {
    var rdd1 = sc.makeRDD(1 to 10, 2)
    //-rw-r--r--   2 lxw1234 supergroup        21 2015-07-10 09:15 /tmp/lxw1234.com/part-00000
    //注意：如果使用rdd1.saveAsTextFile(“file:///tmp/lxw1234.com”)将文件保存到本地文件系统，那么只会保存在Executor所在机器的本地目录。
    rdd1.saveAsTextFile("hdfs://master1:9000/ceshi") //保存到HDFS
    //指定压缩格式保存
    //rdd1.saveAsTextFile("hdfs://cdh5/tmp/lxw1234.com/",classOf[com.hadoop.compression.lzo.LzopCodec])
    //-rw-r--r--   2 lxw1234 supergroup    71 2015-07-10 09:20 /tmp/lxw1234.com/part-00000.lzo
  }
  /**
   * 打印分区
   */
  def showPartition(rdd1: RDD[(String, Int)]) {
    rdd1.mapPartitionsWithIndex {
      (partIdx, iter) =>
        {
          var part_map = scala.collection.mutable.Map[String, List[(String, Int)]]()
          while (iter.hasNext) {
            var part_name = "part_" + partIdx;
            var elem = iter.next()
            if (part_map.contains(part_name)) {
              var elems = part_map(part_name)
              elems ::= elem
              part_map(part_name) = elems
            } else {
              part_map(part_name) = List[(String, Int)] { elem }
            }
          }
          part_map.iterator
        }
    }.foreach(println)
  }
  def showPartition1(rdd1: RDD[(Int, String)]) {
    rdd1.mapPartitionsWithIndex {
      (partIdx, iter) =>
        {
          var part_map = scala.collection.mutable.Map[String, List[(Int, String)]]()
          while (iter.hasNext) {
            var part_name = "part_" + partIdx;
            var elem = iter.next()
            if (part_map.contains(part_name)) {
              var elems = part_map(part_name)
              elems ::= elem
              part_map(part_name) = elems
            } else {
              part_map(part_name) = List[(Int, String)] { elem }
            }
          }
          part_map.iterator
        }
    }.foreach(println)
  }
  def showPartition2(rdd1: RDD[Int]) {
    rdd1.mapPartitionsWithIndex {
      (partIdx, iter) =>
        {
          var part_map = scala.collection.mutable.Map[String, List[Int]]()
          while (iter.hasNext) {
            var part_name = "part_" + partIdx;
            var elem = iter.next()
            if (part_map.contains(part_name)) {
              var elems = part_map(part_name)
              elems ::= elem
              part_map(part_name) = elems
            } else {
              part_map(part_name) = List[Int] { elem }
            }
          }
          part_map.iterator

        }
    }.foreach(println)
  }
}
