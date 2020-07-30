package tk.ursusexmachina.ghosapiposts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnPageList
import kotlinx.android.synthetic.main.activity_main.btnPostList
import kotlinx.android.synthetic.main.activity_main.btnSettings

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs = this.getPreferences(Context.MODE_PRIVATE)

        // Ниже указаный url и ключи для взаимодействия через GhostApi

        editUrl.setText(prefs?.getString("apiURL", "https://40.69.61.198/"))
        editKey.setText(prefs?.getString("apiKey","f268f3c2-8694-4c47-98dc-33faba16367d")) // 22444f78447824223cefc48062

        btnSave.setOnClickListener{
            with (prefs.edit()){
                putString("apiURL", editUrl.text.toString())
                putString("apiKey", editKey.text.toString())
                commit()
            }
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

