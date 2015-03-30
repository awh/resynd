
import org.postgresql.ds.PGSimpleDataSource

val ds = new PGSimpleDataSource

ds.setDatabaseName("awh")
val conn = ds.getConnection()
import scala.slick.session.Database
val db = Database.forDataSource(ds)


import scala.slick.driver.PostgresDriver.simple._
object User extends Table[(Int, String)]("user") {
  def u_id = column[Int]("u_id", O.PrimaryKey)
  def u_name = column[String]("u_name")
  def * = u_id ~ u_name
}
object Feed extends Table[(Int, String, Int)]("feed") {
  def f_id = column[Int]("f_id", O.PrimaryKey)
  def f_url = column[String]("f_url")
  def u_id = column[Int]("u_id")

  def * = f_id ~ f_url ~ u_id
  def user = foreignKey("fk_feed_user", u_id, User)(_.u_id)
}
val DDL = Feed.ddl ++ User.ddl
println("--- CREATE ---")

DDL.createStatements.foreach(println)





println("---- DROP ----")


DDL.dropStatements.foreach(println)





println("--------------")


val query = tableToQuery(Feed)
query.selectStatement
db withSession { implicit session: Session =>
  DDL.create
  User.insert((1, "awh"))
  Feed.insertAll(
    (1, "http://antispin.org/atom.xml", 1),
    (2, "http://example.com", 1),
    (3, "http://gnuminous.org", 1)
  )
  query.list.foreach(println)
  for(user <- User) yield { user.u_name }
  DDL.drop
}







