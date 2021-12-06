package sexample.study.myrocklegends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)
        bottomNavigationMenu.setOnItemSelectedListener { item->
            var fragment: Fragment? = null
            when(item.itemId){
                R.id.kc_fragment -> {
                    fragment = KurtCobainFragment()
                }
                R.id.jh_fragment -> {
                    fragment = JimiHendrixFragment()
                }
                R.id.vc_fragment -> {
                    fragment = VictorTsoyFragment()
                }
                R.id.el_fragment -> {
                    fragment = EgorLetovFragment()
                }
            }
            replaceFragment(fragment!!)
            true
        }

        bottomNavigationMenu.selectedItemId = R.id.kc_fragment

    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()
    }

}