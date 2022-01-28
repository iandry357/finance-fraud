package financefraud

import scala.io.Source

object FinanceData {

  private[financefraud] def lines: List[String] = {
    Option(getClass.getResourceAsStream("/financefraud/financefraud.csv")) match {
      case None => sys.error("Please download the dataset as explained in the assignment instructions")
      case Some(resource) => Source.fromInputStream(resource).getLines().toList
    }
  }

  /*
  private[financefraud] def parse(line: String): WikipediaArticle = {
    val subs = "</title><text>"
    val i = line.indexOf(subs)
    val title = line.substring(14, i)
    val text  = line.substring(i + subs.length, line.length-16)
    WikipediaArticle(title, text)
  }
  */
}
