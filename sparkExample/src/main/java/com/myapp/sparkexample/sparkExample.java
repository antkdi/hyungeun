/**
  * @FileName : sparkExample.java
  * @Project : sparkExample
  * @Date : 2016. 10. 24. 
  * @작성자 : "Hyungeun.Jung"
  * @변경이력 :
  * @프로그램 설명 :
  */
package com.myapp.sparkexample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

/**
 * @author "Hyungeun.Jung"
 *
 */
public class sparkExample {

	/**
	  * @Method Name : main
	  * @작성일 : 2016. 10. 24.
	  * @작성자 : "Hyungeun.Jung"
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param args
	 * @throws IOException 
	  */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//spark module
        SparkConf conf = new SparkConf().setAppName("testApp").setMaster("local[2]");
	    SparkContext sc = new SparkContext(conf);
	    JavaSparkContext jsc = JavaSparkContext.fromSparkContext(sc);
	    
	    sparkExample s = new sparkExample();
	    String synPath = "README.md";
	    
	    //Line 별로 읽어서 RDD로 변환 
	    JavaRDD<String> testRDD = jsc.textFile(sparkExample.class.getResource("/README.md").getFile());
	    
	    //단어 단위로 RDD 로 변환 
	    JavaRDD<String> wordRDD = testRDD.flatMap(new FlatMapFunction<String,String>(){
			public Iterator<String> call(String t) throws Exception {
				// TODO Auto-generated method stub
				return Arrays.asList(t.split(" ")).iterator();
			}
	    });
	    
	    //단어와 단어의 길이를 페어 RDD로 변
	    JavaPairRDD<String,Integer> pairRDD = wordRDD.mapToPair(new PairFunction<String,String,Integer>(){

			@Override
			public Tuple2<String, Integer> call(String t) throws Exception {
				// TODO Auto-generated method stub
				return new Tuple2<String,Integer>(t,t.length());
			}
	    	
	    });
	    
	    //a 로시작하는 단어들의 RDD 람다식 
	    JavaRDD<String> startWithARDD = wordRDD.filter(x -> x.startsWith("a"));

	    //b 로시작하는 단어들의 RDD 이너클래스 
	    JavaRDD<String> startWithBRDD = wordRDD.filter(new Function<String,Boolean>(){
			@Override
			public Boolean call(String v1) throws Exception {
				// TODO Auto-generated method stub
				return v1.startsWith("b");
			}
	    });
	    
	    // a 가 들어가는 단어 구하기.
	    long numAs = wordRDD.filter(new Function<String, Boolean>() {
	      public Boolean call(String s) { 
	    	  return s.contains("a"); }
	      
	    }).count();

	    System.out.println("Lines with a: " + numAs );
	    

	}

}
