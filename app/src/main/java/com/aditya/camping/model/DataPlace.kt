package com.aditya.camping.model

import com.aditya.camping.R
import java.util.ArrayList

object DataPlace {
    private val name = arrayOf(
            "Belitung island",
            "Mount Bromo",
            "Bunaken Island",
            "Mount Kelimutu",
            "Komodo Island",
            "Padar Island",
            "Raja Ampat Archipelago",
            "Mount Rinjani",
            "Mount Situ Gunung",
            "Toba Lake"
    )

    private val photo = intArrayOf(
            R.drawable.belitung,
            R.drawable.bromo,
            R.drawable.bunaken,
            R.drawable.kelimutu_mount,
            R.drawable.komodo,
            R.drawable.pulau_padar,
            R.drawable.raja_ampat,
            R.drawable.rinjani_mount,
            R.drawable.situ_gunung,
            R.drawable.toba
    )

    private val description = arrayOf(
            "Discover the beauty nature of Belitung Island, Belitung island has become a new favorite island-themed holiday destination among tourists located south-east off the larger island of Sumatra.  With its impeccable pristine beaches, blue waters, and natural granite rock structures, its hard not to linger on its beauty.",
            "Discover the magnificent beauty mount Bromo, the most popular tourist destination in East Java and always filled with domestic and international tourists, The name Bromo is said to derive from Brama (Brahma), a Hindu God. Until now, Mt. Bromo is still considered a holy place for Hindus, making it a location for the annual Yadnya Kasada or Kasodo ceremony. People around Mount Bromo will celebrate the Kasodo festivals annually by presenting offerings like vegetables, chickens and money dedicated to the Gods and thrown into the crater of Mount Bromo as an entity of gratitude to the Almighty.",
            "Discover the beauty nature of Bunaken Island, Bunaken Island is part of the Bunaken National Marine Park. Bunaken is located at the northern tip of the island of Sulawesi, Indonesia. It belongs administratively to the municipality of Manado. Scuba diving attracts many visitors to the island.",
            "Discover the beauty landscape of Kelimutu Mount, This mountain has three crater lakes at the peak. These lakes are known as the Three Color Lakes because it has three different colors, which are red, blue and white. Even so, these colors always change over time.",
            "Discover the exotic beauty of Komodo Island, Explore the exotic nature consisting of a mountainous hillside, tropical rain forests, grass-woodland savannah, and pristine white sandy beaches that harbor rich marine biodiversity and home of the biggest reptile in the world",
            "Find your peace at Padar Island. Padar Island is the third largest island in the Komodo National Park area after the islands of Komodo and Rinca. Padar is also accepted as a Cultural Heritage Site by UNESCO because it is stand in same location with Komodo National Park along with Komodo Island, Rinca Island and Gili Motang. Among travelers, Padar Island is popularly known as Gili Padar. It is indeed amazingly beautiful.",
            "Discover the magnificent beauty of Raja Ampat, Far from the view-blocking skyscrapers, dense and hectic concrete jungles, congested traffics, flickering electric billboards, endless annoying noises, and all the nuisances of modern cities, you will find a pristine paradise where Mother Nature and warm friendly people welcome you with all the exceptional wonders in Raja Ampat, the islands-regency in West Papua Province. With all the spectacular wonders above and beyond its waters, as well as on land and amidst the thick jungles, this is truly the place where words such as beautiful, enchanting, magnificent, and fascinating get its true physical meaning.",
            "The mighty Rinjani mountain of Gunung Rinjani is a massive volcano which towers over the island of Lombok. A climb to the top is one of the most exhilarating experiences you can have in Indonesia. At 3,726 meters tall, Gunung Rinjani is the second highest mountain in Indonesia. The climb to the top may not be easy but it’s worth it, and is widely regarded as one of the best views in the country.",
            "Satisfy your desire of calming scenery by looking at the sight of Situ Gunung Lake. Beautiful landscape of the clear water lake and the mild breeze give you the feel of looking at the exceptionally wonderful painting made by nature.",
            "Toba is a place to sit back, relax and absorb some beautiful pristine scenery. As you sit and take in the view of the picturesque mountains set against the cool clear lake, you will feel the worries of the world melt away. As the lake sits 900 meters above sea level, therefore the climate here is cooler which gives a well-needed break from the heat, humidity, and pollution of the city."
    )

    val listData: ArrayList<ModelPlace>
        get() {
            val list = arrayListOf<ModelPlace>()
            for (position in name.indices){
                val modelPlace = ModelPlace()
                modelPlace.name = name[position]
                modelPlace.photo = photo[position]
                modelPlace.description = description[position]
                list.add(modelPlace)
            }
            return list
        }
}