
import controllers.{Application}
import play.api
import play.api.{Logger, GlobalSettings}
import play.api.mvc._
import play.api.mvc.Results._
import play.api.Play

/**
 *
 * @author Flint O'Brien
 */
object Global extends GlobalSettings {

  override def onStart(app: api.Application) {
    super.onStart(app)
    Logger.info("onStart: Application has started")
  }

  override def onStop(app: api.Application) {
    Logger.info("Application shutdown...")
  }

  override def onError(request: RequestHeader, ex: Throwable) = {
    ex.getClass.getName
    for( element <- ex.getStackTrace ) {
      element.getClassName
    }
    InternalServerError(
      views.html.onError(ex)
    )
  }

}