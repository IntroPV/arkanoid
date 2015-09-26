package ar.pablitar.arkanoid.components

import com.uqbar.vainilla.GameComponent
import ar.pablitar.arkanoid.Jugador
import ar.pablitar.arkanoid.ArkanoidLevelScene
import com.uqbar.vainilla.appearances.Label
import java.awt.Font
import java.awt.Color
import ar.pablitar.arkanoid.misc.Styles
import com.uqbar.vainilla.DeltaState

/**
 * @author pablitar
 */
class ScoreDisplay(j: Jugador) extends GameComponent[ArkanoidLevelScene] {
  val label = Styles.infoText(scoreAsText)
  this.setAppearance(label)

  this.move(10, 10)

  override def update(state: DeltaState) = {
    label.setText(scoreAsText)
  }
  def scoreAsText = {
    "Score: " + j.score.toString
  }
}

