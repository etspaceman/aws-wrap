package aws.simpledb

import scala.annotation.implicitNotFound

import aws.core.AWSRegion

@implicitNotFound("You need to import a region to specify which datacenter you want to use.")
trait SDBRegion extends AWSRegion

object SDBRegion {

  import AWSRegion._

  private val NAME = "sdb"

  val US_EAST_1 = new AWSRegion(US_EAST_1_NAME, US_EAST_1_DOMAIN, NAME) with SDBRegion
  val US_WEST_1 = new AWSRegion(US_WEST_1_NAME, US_WEST_1_DOMAIN, NAME) with SDBRegion
  val US_WEST_2 = new AWSRegion(US_WEST_2_NAME, US_WEST_2_DOMAIN, NAME) with SDBRegion
  val EU_WEST_1 = new AWSRegion(EU_WEST_1_NAME, EU_WEST_1_DOMAIN, NAME) with SDBRegion
  val ASIA_SOUTHEAST_1 = new AWSRegion(ASIA_SOUTHEAST_1_NAME, ASIA_SOUTHEAST_1_DOMAIN, NAME) with SDBRegion
  val ASIA_NORTHEAST_1 = new AWSRegion(ASIA_NORTHEAST_1_NAME, ASIA_NORTHEAST_1_DOMAIN, NAME) with SDBRegion
  val SA_EAST_1 = new AWSRegion(SA_EAST_1_NAME, SA_EAST_1_DOMAIN, NAME) with SDBRegion

  implicit val DEFAULT = US_EAST_1
}
