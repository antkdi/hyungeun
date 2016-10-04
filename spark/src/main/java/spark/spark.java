/**
  * @FileName : spark.java
  * @Project : spark
  * @Date : 2016. 9. 29. 
  * @작성자 : "Hyungeun.Jung"
  * @변경이력 :
  * @프로그램 설명 :
  */
package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

/**
 * @author "Hyungeun.Jung"
 *
 */
public class spark {

	/**
	  * @Method Name : main
	  * @작성일 : 2016. 9. 29.
	  * @작성자 : "Hyungeun.Jung"
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param args
	  */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String logFile = "/Users/hyungeunjung/app/apache/spark-2.0.0-bin-hadoop2.7/README.md"; // Should be some file on your system
	    SparkConf conf = new SparkConf().setAppName("Simple Application")
	    		.setMaster("spark://52.78.119.78:7077")
	    		.set("spark.ui.port", "9000")
	    		.set("spark.shuffle.service.enabled", "false")
	    		.set("spark.dynamicAllocation.enabled", "false")
	    		.set("spark.rdd.compress", "true");
	    JavaSparkContext sc = new JavaSparkContext(conf);
	    JavaRDD<String> logData = sc.textFile(logFile).cache();

	    long numAs = logData.filter(new Function<String, Boolean>() {
	      public Boolean call(String s) { 
	    	  return s.contains("a"); }
	      
	    }).count();

	    long numBs = logData.filter(new Function<String, Boolean>() {
	      public Boolean call(String s) { return s.contains("b"); }
	    }).count();

	    System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

	}

	/**
	  * @FileName : spark.java
	  * @Project : spark
	  * @Date : 2016. 9. 29. 
	  * @작성자 : "Hyungeun.Jung"
	  * @변경이력 :
	  * @프로그램 설명 :
	  */
}
