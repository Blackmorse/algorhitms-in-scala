package one.three

import java.io.File

import edu.princeton.cs.algs4.StdIn

object ListingFiles {

  private def doRec(folder: File, depth: Int, queue: Queue[(Int, String)]): Unit = {
    val files = folder.listFiles()
    for (file <- files) {
      queue.enqueue((depth, file.getName))
      if (file.isDirectory) {
        doRec(file, depth + 1, queue)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val path = StdIn.readString()

    val file = new File(path)

    val queue = new Queue[(Int, String)]()
    doRec(file, 0, queue)

    queue.foreach{case(depth, name) => println("|" + "-" * depth * 3 + " " + name)}
  }
}
