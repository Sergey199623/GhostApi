package tk.ursusexmachina.ghosapiposts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_page_detail.*

class PageDetailActivity : AppCompatActivity() {

    companion object {

        fun newIntent(context: Context, page: Page): Intent {
            val detailIntent = Intent(context, PageDetailActivity::class.java)

            detailIntent.putExtra("title", page.title)
            detailIntent.putExtra("url", page.url)
            detailIntent.putExtra("html", page.html)
            detailIntent.putExtra("published", page.published)
            detailIntent.putExtra("tags", page.tags)
            detailIntent.putExtra("authors", page.authors)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_detail)

        textTitle.text = intent.extras?.getString("title")
        textUrl.text = intent.extras?.getString("url")
        textPublished.text = intent.extras?.getString("published")
        textTags.text = intent.extras?.getString("tags")
        textAuthors.text = intent.extras?.getString("authors")

        webviewDetails.loadData(intent.extras?.getString("html"), "text/html; charset=utf-8", "UTF-8")
    }
}
