package streaming

import monix.reactive.Observable

import scala.concurrent.duration.DurationLong

object StreamingImpl extends Streaming {
  override def from(a: Int): Observable[String] = {
    val iterator = Iterator.from(a).map(_.toString)
    Observable.fromIterator(iterator).delayOnNext(1.second)
  }
}
