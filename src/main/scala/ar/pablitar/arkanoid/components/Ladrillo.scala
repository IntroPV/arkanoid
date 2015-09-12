package ar.pablitar.arkanoid.components

import com.uqbar.vainilla.appearances.Rectangle
import java.awt.Color
import ar.pablitar.vainilla.commons.math.Vector2D
import ar.pablitar.vainilla.commons.components.RichGameComponent
import com.uqbar.vainilla.DeltaState
import ar.pablitar.arkanoid.ArkanoidLevelScene
import com.uqbar.vainilla.colissions.CollisionDetector.{ INSTANCE => Collisions }
import ar.pablitar.vainilla.commons.math.Rect
import com.uqbar.vainilla.appearances.Rectangle
import ar.pablitar.vainilla.commons.math.PhysicsUtils
import ar.pablitar.arkanoid.Pared

/**
 * @author pablitar
 */
class Ladrillo(aPosition: Vector2D) extends RichGameComponent[ArkanoidLevelScene] {
  
  this.position = aPosition
  
  this.setAppearance(new Rectangle(Color.GREEN, 80, 40));
  
  
  override def update(state: DeltaState) = {
    this.getScene.pelotas.foreach { pelota => this.comprobarColisionCon(pelota) }
  }

  def comprobarColisionCon(pelota: Pelota) = {
    //TODO: Las colisiones quizás queremos manejarlas con una abstración del estilo Body, o algo así
    if(Collisions.collidesCircleAgainstRect(pelota.getX, pelota.getY, pelota.radius, this.getX, this.getY, width, height)) {
      this.hacerRebotar(pelota)
      this.destroy()
    }
  }

  def hacerRebotar(pelota: Pelota) = {
     pelota.speed = PhysicsUtils.rebound(pelota.speed, normalRebote(pelota))
  }
  
  def normalRebote(pelota: Pelota) = {
    if(pelota.getX >= this.position.x1 && pelota.getX <= this.bottomRight.x1) {
      if(pelota.getY  >= this.bottomLeft.x2) {
        Vector2D(0, 1)
      } else {
        Vector2D(0, -1)
      }
    } else {
      if(pelota.getX >= this.bottomRight.x1) {
        Vector2D(1, 0)
      } else {
        Vector2D(-1, 0)
      }
    }
  }
}