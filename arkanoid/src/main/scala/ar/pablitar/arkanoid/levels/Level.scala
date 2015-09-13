package ar.pablitar.arkanoid.levels

import ar.pablitar.arkanoid.components.Ladrillo
import java.awt.Color
import ar.pablitar.vainilla.commons.math.Vector2D
import ar.pablitar.arkanoid.ArkanoidLevelScene

/**
 * @author pablitar
 */
abstract class Level {

  type ConstructorLadrillo = Vector2D => Ladrillo
  type FilaLadrillos = Seq[Option[ConstructorLadrillo]]
  
  implicit class ColorBrickConstructor(c: Color) {
    def *(times: Int): FilaLadrillos = {
      (1 to times).map { x => constructorLadrilloFromOption(c) }
    }
  }
  
  implicit class OptionBrickConstructor(n: Option[ConstructorLadrillo]) {
    def *(times: Int): FilaLadrillos = {
      (1 to times).map {x => n}
    }
  }

  implicit def constructorLadrilloFromOption(c: Color) = Some(new Ladrillo(c)(_))
  implicit def filaLadrillosFromOption(o: Option[ConstructorLadrillo]) = List(o)

  def filasDeLadrillos: Seq[FilaLadrillos]
  
  def borde = 53
  def spacing = 8

  def loadToScene(scene: ArkanoidLevelScene):Unit = {
    for {
      (fila, j) <- filasDeLadrillos.zipWithIndex
      (constructorOption, i) <- fila.zipWithIndex
    } yield {
      constructorOption.foreach { constructor =>
        scene.addComponent(constructor(borde + i * (Ladrillo.width + spacing), borde + j * (Ladrillo.height + spacing)))
      }
    }
  }
}