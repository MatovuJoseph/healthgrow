package com.healthyentrepreneurs.healthgrow.data

import com.healthyentrepreneurs.healthgrow.R
import com.healthyentrepreneurs.healthgrow.data.models.Country
import com.healthyentrepreneurs.healthgrow.data.models.Language
import com.healthyentrepreneurs.healthgrow.data.models.Reward
import com.healthyentrepreneurs.healthgrow.data.models.Tool
import org.json.JSONArray

object DummyData {

    /*list of registered supported countries*/
    val countries = mutableListOf(
        Country("1", "Uganda","https://flagpedia.net/data/flags/h80/ug.png"),
        Country("2", "Kenya","https://flagpedia.net/data/flags/h80/ke.png"),
        Country("3", "Tanzania","https://flagpedia.net/data/flags/h80/tz.png"),
        Country("4", "Burundi","https://flagpedia.net/data/flags/h80/bi.png"),
    )

    /*function to provide languages registered for a country Through CountryId*/
    fun getCountryLanguages(countryId: String) : MutableList<Language>{
        return when(countryId){
            "1"-> mutableListOf(
                Language("1","English","en"),
                Language("2","Luganda","lg"),
                Language("3","Rukiga","rk"),
                Language("4","Lugbara","lgg"),
                Language("5","Swahili","sw")
            )
            "2"-> mutableListOf(
                Language("1","English","en"),
                Language("5","Swahili","sw")
            )
            "3"-> mutableListOf(
                Language("1","English","en"),
                Language("5","Swahili","sw"),
                Language("6","Arabic","rb"),
                Language("7","Chaga","cg"),
            )
            "4"-> mutableListOf(
                Language("1","English","en"),
                Language("8","Kirundi","kr"),
                Language("9","French","fr"),
            )
            else-> mutableListOf()
        }
    }

    /*list of Home menu tools*/
    val tools = mutableListOf(
        Tool(1,"Customer Registry", R.drawable.register_colored),
        Tool(2,"Product Sales", R.drawable.products),
        Tool(3,"My Products", R.drawable.my_products),
        Tool(4,"My Account", R.drawable.account),
    )

    /*list of Rewards*/
    val rewards = mutableListOf(
        Reward(1,"Free Malaria Tests","","https://cdn-icons-png.flaticon.com/512/3553/3553700.png",60,50),
        Reward(2,"Free Contraceptives For All Families","","https://cdn.iconscout.com/icon/premium/png-256-thumb/contraception-3701139-3083456.png",10,150),
        Reward(3,"Organization Health Camps","","https://thumbs.dreamstime.com/b/medical-camp-icon-clipart-image-isolated-white-background-208035239.jpg",0,500),
    )
}