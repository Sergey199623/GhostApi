package tk.ursusexmachina.ghosapiposts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.btnSettings
import kotlinx.android.synthetic.main.activity_page_list.*
import kotlinx.android.synthetic.main.activity_page_list.btnPageList
import kotlinx.android.synthetic.main.activity_page_list.btnPostList
import kotlinx.android.synthetic.main.list_item_page.view.*
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread


data class Page(val title: String, val id: String, val published: String, val html: String, val url: String, val tags: String, val authors: String)

class PageListAdapter(private val context: Context,
                  private val dataSource: ArrayList<Page>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView =  convertView ?: inflater.inflate(R.layout.list_item_page, parent, false)
        val page = getItem(position) as Page
        rowView.textTitle.text = page.title
        rowView.textPublished.text = page.published
        return rowView
    }
}

class PageListActivity : AppCompatActivity() {
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_list)

        val pageList = ArrayList<Page>()
        val adapter: PageListAdapter = PageListAdapter(this, pageList)

        listviewPageList.adapter = adapter

        val prefs = this.getPreferences(Context.MODE_PRIVATE)
        val apiURL  =prefs.getString("apiURL","https://demo.ghost.io/ghost/api/v3/")
        val apiKey = prefs.getString("apiKey","22444f78447824223cefc48062&include=tags,authors")

        thread {
            val json = JSONObject(URL("${apiURL}content/pages/?key=${apiKey}").readText())
            val pages = json.getJSONArray("pages")
            pageList.clear()
            for(i in 0 until pages.length()) {
                val page = pages[i] as JSONObject

                val tagsString = StringBuilder()
                val tags = page.getJSONArray("tags")
                for(j in 0 until tags.length()){
                    val tag = tags[j] as JSONObject
                    tagsString.append(tag.getString("name"))
                    tagsString.append(" ")
                }

                val authorsString = StringBuilder()
                val authors = page.getJSONArray("authors")
                for(j in 0 until authors.length()){
                    val author = authors[j] as JSONObject
                    authorsString.append(author.getString("name"))
                    authorsString.append(" ")
                }

                pageList.add(Page(
                    title = page.getString("title"),
                    id = page.getString("id"),
                    published = page.getString("published_at"),
                    html = page.getString("html"),
                    url = page.getString("url"),
                    tags = tagsString.toString(),
                    authors = authorsString.toString()
                ))
            }
            handler?.sendEmptyMessage(0);
        }

        handler =  Handler() {
            adapter.notifyDataSetChanged()
            adapter.count > 0
        }
        val context = this
        listviewPageList.setOnItemClickListener() { _, _, position, _ ->
            val detailIntent = PageDetailActivity.newIntent(context, pageList[position])

            startActivity(detailIntent)
        }

        btnSettings.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        btnPostList.setOnClickListener{
            startActivity(Intent(this, PostListActivity::class.java))
        }
        btnPageList.setOnClickListener{
            startActivity(Intent(this, PageListActivity::class.java))
        }
    }
}
