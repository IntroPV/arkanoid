package ar.pablitar.arkanoid.components

import com.uqbar.vainilla.GameComponent
import ar.pablitar.arkanoid.ArkanoidLevelScene
import ar.pablitar.arkanoid.misc.Styles
import com.uqbar.vainilla.DeltaState

/**
 * @author pablitar
 */
abstract class Display extends GameComponent[ArkanoidLevelScene] {
  def textGetter: String

  val label = Styles.infoText(textGetter)
  this.setAppearance(label)

  this.move(10, 10)

  override def update(state: DeltaState) = {
    label.setText(textGetter)
  }
}