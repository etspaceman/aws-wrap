package aws.core.signature

import aws.core._

object V2 {

  val VERSION = "2009-04-15"
  val SIGVERSION = "2"
  val SIGMETHOD = "HmacSHA1"

  def signedUrl(method: String, params: Seq[(String, String)])(implicit region: AWSRegion): String = {

    import AWS.Parameters._
    import aws.core.SignerEncoder.encode

    val ps = Seq(
      Expires(600L),
      AWSAccessKeyId(AWS.key),
      Version(VERSION),
      SignatureVersion(SIGVERSION),
      SignatureMethod(SIGMETHOD))

    val queryString = (params ++ ps).sortBy(_._1)
      .map { p => encode(p._1) + "=" + encode(p._2) }.mkString("&")

    val toSign = "%s\n%s\n%s\n%s".format(method, region.host, "/", queryString)

    "Signature=" + encode(signature(toSign)) + "&" + queryString
  }

  private def signature(data: String) = HmacSha1.calculate(data, AWS.secret)

}
