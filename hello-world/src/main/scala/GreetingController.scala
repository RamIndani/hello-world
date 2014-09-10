/**
 * @author RamnivasIndani
 * SID : 010036507
 * Graduate Student Software Engineering 
 * San Jose State University.
 * 
 *Controller class and object for scala spring services for "Hello world" program.
 * This project uses gradle as its deployment descriptor for compilattion and execution of the project.
 */
import javax.annotation.{PostConstruct, Resource}
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot._;
import org.springframework.stereotype._;
import org.springframework.web.bind.annotation._;
import org.springframework.boot.autoconfigure._;
/*
 * Controller class with String parameter.
 */
@RestController
@EnableAutoConfiguration
@ComponentScan
class GreetingController( name : String ) {

  def this() = {
    this( "Got it working" )
  }
  /*
  * The request mapping when URI called on service contains additional parameter
  */
  @RequestMapping( value = Array("/{name}"),
                  method = Array(RequestMethod.GET) )
  def Greet(@PathVariable("name") name: String) = "Hello " + name + " Welcome to SJSU\n "
  /*
   * The request mapping when URI called with no extra parameters.
   */
  @RequestMapping( value = Array({ "/" }),
                   method = Array(RequestMethod.GET) )
  def Greet() = "Hello World!\””
}

/**
 * An object of GreetingController which is by definition of scala object a single ton class.
 * this starts the spring application service by using run method.
 */
object GreetingController {
     def main( arg: Array[String] ) {
     val configuration : Array[Object] = Array( classOf[GreetingController] )
    SpringApplication.run( configuration, arg )     
    }
}   
