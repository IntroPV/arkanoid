package ar.pablitar.vainilla.appearances.worldspace

import ar.pablitar.vainilla.appearances.WorldSpaceAppearance
import java.awt.Color
import ar.pablitar.vainilla.appearances.Camera
import java.awt.Graphics2D
import com.uqbar.vainilla.appearances.Appearance

case class TiledRectangle(width: Double, height: Double)(hTileCount: Int, vTileCount: Int)(tileColors: Color*)(implicit val camera: Camera) extends WorldSpaceAppearance {
  val tileWidth = width / hTileCount
  val tileHeight = height / vTileCount
  println (tileWidth, tileHeight) 
  def doRenderAt(x: Double, y: Double, graphics: Graphics2D): Unit = {
    for (
      i <- 0 to hTileCount - 1;
      j <- 0 to vTileCount - 1
    ) {
      val color = tileColors((i + j) % tileColors.size)
      graphics.setColor(color);
      graphics.fillRect((x + i * tileWidth).toInt, (y + j * tileHeight).toInt,  tileWidth.toInt, tileHeight.toInt);
    }

  }

  def doCopy = TiledRectangle(width, height)(hTileCount, vTileCount)(tileColors:_*)
}