package ar.pablitar.vainilla.commons.math

import scala.util.Random

/**
 * @author pablitar
 */
object RandomUtils {
  implicit class RandomExtension(random: Random) {
    def success(p: Double) = random.nextDouble() <= p
  }
}