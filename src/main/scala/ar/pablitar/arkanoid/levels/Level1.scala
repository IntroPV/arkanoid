package ar.pablitar.arkanoid.levels

import ar.pablitar.arkanoid.ArkanoidLevelScene
import java.awt.Color._
import ar.pablitar.arkanoid.components.Ladrillo
import ar.pablitar.vainilla.commons.math.Vector2D
import java.awt.Color
import ar.pablitar.vainilla.commons.inspectors.VectorInspector

/**
 * @author pablitar
 */
object Level1 extends Level {

  val filasDeLadrillos: List[FilaLadrillos] = List(
    RED * 8,
    GREEN * 8,
    None * 8,
    BLACK * 8,
    WHITE * 3 ++ None * 2 ++ WHITE * 3)

}