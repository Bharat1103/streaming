package streaming

import monix.reactive.Observable

trait Streaming {
  def from(a: Int): Observable[String]
}
