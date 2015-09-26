package ar.pablitar.arkanoid.levels

import ar.pablitar.arkanoid.ArkanoidLevelScene
import java.awt.Color._
import ar.pablitar.arkanoid.components.Ladrillo._
import ar.pablitar.arkanoid.components.Ladrillo
import ar.pablitar.vainilla.commons.math.Vector2D
import java.awt.Color
import ar.pablitar.vainilla.commons.inspectors.VectorInspector

/**
 * @author pablitar
 */
object Level1 extends Level {

  val filasDeLadrillos: List[FilaLadrillos] = List(
    verde * 8,
    blanco * 8,
    BLUE * 1 ++ None * 6 ++ BLUE * 1,
    blanco * 8,
    verde * 3 ++ None * 2 ++ verde * 3)

}