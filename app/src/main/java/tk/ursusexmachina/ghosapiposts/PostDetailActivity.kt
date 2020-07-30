package tk.ursusexmachina.ghosapiposts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_post_detail.*

class PostDetailActivity : AppCompatActivity() {

    companion object {

        fun newIntent(context: Context, post: Post): Intent {
            val detailIntent = Intent(context, PostDetailActivity::class.java)

            detailIntent.putExtra("title", post.title)
            detailIntent.putExtra("url", post.url)
            detailIntent.putExtra("html", post.html)
            detailIntent.putExtra("tags", post.tags)
            detailIntent.putExtra("authors", post.authors)
            detailIntent.putExtra("published", post.published)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        textTitle.text = intent.extras?.getString("title")
        textUrl.text = intent.extras?.getString("url")
        textPublished.text = intent.extras?.getString("published")
        textTags.text = intent.extras?.getString("tags")
        textAuthors.text = intent.extras?.getString("authors")

        webviewDetails.loadData(intent.extras?.getString("html"), "text/html; charset=utf-8", "UTF-8")
    }
}
