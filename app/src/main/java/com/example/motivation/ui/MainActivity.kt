package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var category: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        //esconder barra de navegação
        supportActionBar?.hide()

        setContentView(binding.root)

        //Eventos
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.textOla.setOnClickListener(this)

        handleFilter(R.id.image_all)


    }

    override fun onStart() {
        super.onStart()
        verifyUserName()
    }


    override fun onResume() {
        super.onResume()


        handleUserName()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }



    override fun onClick(view: View) {

         when (view.id) {
            R.id.button_new_phrase -> {
                handleNextPhrase(category)
            }
            R.id.image_all,R.id.image_happy,R.id.image_sunny -> {

               handleFilter(view.id)

            }
             R.id.text_ola -> {

             }
        }
    }


    fun handleUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.Key.USER_NAME)
        binding.textOla.text ="Olá, $name Gordão!"
    }

    fun handleFilter(id: Int){


        binding.imageAll.setColorFilter(ContextCompat.getColor(this,R.color.black))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this,R.color.black))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this,R.color.black))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this,R.color.mac2))
                category = MotivationConstants.FILTER.ALL
                handleNextPhrase(category)
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this,R.color.mac2))
                category = MotivationConstants.FILTER.HAPPY
                handleNextPhrase(category)
            }
            R.id.image_sunny ->{
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this,R.color.mac2))
                category = MotivationConstants.FILTER.SUNNY
                handleNextPhrase(category)
            }

        }
    }

    fun handleNextPhrase(categoryId: Int){
        binding.textPhrase.text = Mock().getPhrase(categoryId)
    }

    private fun verifyUserName(){
        val name = SecurityPreferences(this).getString(MotivationConstants.Key.USER_NAME)
        if (name == ""){
            startActivity(Intent(this, UserNameActivity::class.java))
        }

    }


}