
package net.ladstatt.sierpinski

import android.content.Context
import android.graphics._
import android.util.AttributeSet
import android.view.View

/**
  * Implements a view which displays a sierpinski triangle.
  *
  * @param context
  * @param attrs
  */
class SierpinskiView(val context: Context, val attrs: AttributeSet) extends View(context, attrs) {

  override def onDraw(canvas: Canvas) {
    super.onDraw(canvas)


    val width: Int = canvas.getWidth
    val height: Float = (Math.sqrt(3) / 2 * width).toFloat
    val p = new Paint()
    p.setColor(Color.BLACK)
    sierp(0, height / 3, width, height, 0)


    def draw(x: Float, y: Float, wid: Float, hei: Float)
    {

      canvas.drawLine(x + wid, y, x + (wid / 2), y + hei, p)
      canvas.drawLine(x, y, x + wid, y, p)
      canvas.drawLine(x, y, x + (wid / 2), y + hei, p)
    }

    def sierp(x: Float, y: Float, wid: Float, hei: Float, depth: Int){
      draw(x,y,wid,hei)
      if (depth <= 8) {
        val nWid = wid / 2
        val nHei = hei / 2
        sierp(x, y, nWid, nHei, depth + 1)
        sierp(x + nWid / 2, y + nHei, nWid, nHei, depth + 1)
        sierp(x + nWid, y, nWid, nHei, depth + 1)
      }
    }




  }
}
