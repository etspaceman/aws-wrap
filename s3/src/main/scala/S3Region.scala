package aws.s3

import scala.annotation.implicitNotFound

import aws.core.AWSRegion

@implicitNotFound("You need to import a region to specify which datacenter you want to use.")
trait S3Region extends AWSRegion

object S3Region {

  private val NAME = "s3"

  import AWSRegion._

  val US_EAST_1 = new AWSRegion(US_EAST_1_NAME, US_EAST_1_DOMAIN, NAME) with S3Region
  val US_WEST_1 = new AWSRegion(US_WEST_1_NAME, US_WEST_1_DOMAIN, NAME) with S3Region
  val US_WEST_2 = new AWSRegion(US_WEST_2_NAME, US_WEST_2_DOMAIN, NAME) with S3Region
  val EU_WEST_1 = new AWSRegion(EU_WEST_1_NAME, EU_WEST_1_DOMAIN, NAME) with S3Region
  val SA_EAST_1 = new AWSRegion(SA_EAST_1_NAME, SA_EAST_1_DOMAIN, NAME) with S3Region

  implicit val DEFAULT = US_EAST_1

}
