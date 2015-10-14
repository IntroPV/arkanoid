package ar.pablitar.vainilla.appearances.worldspace

import com.uqbar.vainilla.appearances.Appearance
import com.uqbar.vainilla.GameComponent
import java.awt.Graphics2D
import ar.pablitar.vainilla.appearances.WorldSpaceAppearance
import ar.pablitar.vainilla.appearances.Camera
import scala.collection.mutable.AnyRefMap
import ar.pablitar.vainilla.appearances.TileSet

class MappedTileAppearance(xSize: Int, ySize: Int, tileHSize: Int, tileVSize: Int)(tileMappings: PartialFunction[(Int, Int), WorldSpaceAppearance])(implicit val camera: Camera) extends WorldSpaceAppearance {

  val tileMap = AnyRefMap[(Int, Int), WorldSpaceAppearance]()
  
  def this(xSize:Int, ySize:Int)(tileSet:TileSet)(implicit camera: Camera) = this(xSize, ySize, tileSet.tileHSize, tileSet.tileVSize)(tileSet.toPartialFunction)

  def doCopy: Appearance = {
    new MappedTileAppearance(xSize, ySize, tileHSize, tileVSize)(tileMappings)
  }

  def doRenderAt(x: Double, y: Double, graphics: Graphics2D): Unit = {
    for (
      i <- 0 to xSize - 1;
      j <- 0 to ySize - 1
    ) {
      val xPosition = x + i * tileHSize
      val yPosition = y + j * tileVSize
      tileAt(i, j).doRenderAt(xPosition, yPosition, graphics)
    }
  }

  def height: Double = {
    ySize * tileVSize
  }

  def width: Double = {
    xSize * tileHSize
  }

  def tileAt(i: Int, j: Int) = {
    tileMap.getOrElseUpdate((i, j), {
      tileMappings.apply(i, j)
    })
  }
  
  
}