package mongopetv

class MongoPet {
  import com.mongodb._
  import scala.collection.JavaConversions._

  val mongo = new Mongo("localhost", 27017);
  val mongodb = mongo.getDB("pet");
  val testDataCollection = mongodb.getCollection("testdata")

  def printCollection(collectionName : String) {
    val collection = mongodb.getCollection(collectionName)
    println("Collection " + collectionName + " size: " + collection.count)
    collection.find.iterator.foreach {doc => println("Found " + doc)}
  }

  val searchByDBObject = new BasicDBObject()

  def findDocById(id : Int, collection : DBCollection) : String = {
    searchByDBObject.put("id", id)
    collection.findOne(searchByDBObject).toString
  }

  def readRandomDocs(readCount : Int, maxId : Int) : IndexedSeq[String] = 
      for(i <- 0 until readCount) yield findDocById((Math.random * maxId).toInt, testDataCollection)

  def javaDriverTest(docsToRead : Int, maxId : Int) {
    val t1 = System.currentTimeMillis
    val docs = readRandomDocs(docsToRead, maxId)
    val t2 = System.currentTimeMillis

    docs.foreach { doc =>
      println("Got an doc: " + doc)
    }

    println("Read " + docsToRead + " docs in " + (t2-t1) + " ms")
  }
}

object MongoPet extends App {
	override def main(args : Array[String]) {
		println("Starting test")
    new MongoPet().javaDriverTest(100, 10)
    println("Test finished")
	}
}