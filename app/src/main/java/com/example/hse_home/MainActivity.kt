package com.example.hse_home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hse_home.adapters.MainElementsAdapter
import com.example.hse_home.databinding.ActivityMainBinding
import com.example.hse_home.models.Item
import com.example.hse_home.models.Profile
import com.example.hse_home.models.Skill

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var recyclerView:RecyclerView
    var items:ArrayList<Item> = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        recyclerView=binding.mainElementsRecycle
        fillList()
        with(recyclerView){
            layoutManager=LinearLayoutManager(context)
            adapter=MainElementsAdapter(items)
        }
        setContentView(binding.root)
    }

    private fun fillList() {
        items.add(0,Item.ProfileItem(Profile("Геннадий","Гойхман","абитуриент")))
        items.add(1,Item.ProjectInfo("Основная идея проекта заключается в реализации приложения для поиска единомышленников." +
                " Основной аудиторией разрабатываемого решения являются школьники.С помощью данного приложения они смогут находить проектные команды,в которых" +
                "будет полезен опыт и знание ребят.Для этого им просто будет необходимо указать краткую информацию о себе, навыки, которыми пользователи уже владеют и те умения," +
                "которые они хотят приобрести. "))
        items.add(2,Item.Header(""))
        val skills:ArrayList<Skill> = ArrayList<Skill>()
        skills.add(Skill("Android разработка","~1 год"))
        skills.add(Skill("Cерверная разработка","~1 год"))
        skills.add(Skill("3D моделирование",">2 лет"))
        skills.add(Skill("VR разработка","<1.5 года"))
        items.add(3,Item.Skills(skills))
    }


}