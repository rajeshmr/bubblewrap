package bubblewrap

import org.scalatest.FlatSpec
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}

class ResponseBodySpec extends FlatSpec {
  "ResponseBody" should "keep track of number of bytes written and say if exceeds size" in {
    val body = new ResponseBody
    body.write("Hello".getBytes)

    body.exceedsSize(6) should be(false)
    body.exceedsSize(4) should be(true)

    body.write(" World".getBytes())

    body.exceedsSize(11) should be(false)
    body.exceedsSize(10) should be(true)
  }
}
