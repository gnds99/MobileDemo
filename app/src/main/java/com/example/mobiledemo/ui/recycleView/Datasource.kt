package com.example.mobiledemo.ui.recycleView

class Datasource {
    fun loadInformation(): List<ItemCard> {
        return listOf<ItemCard>(
            ItemCard("I shot this phoyo today. Perfect day, but I used a filter to tone it down" +
                    "anyway.", "10min"),
            ItemCard("Thanks for sharing! I got this skyline -- The usual tourist shot, but" +
                    "what a view.", "10min"),
            ItemCard("Street view of a skycraper. Love the reflections in this one." +
                    "Corporate colors.", "10min"),
            ItemCard("View from the top of mi office. I was worried about the haze," +
                    "but it worked OK.", "10min"),
            ItemCard("I was trying to make stairs look like ground: Like you could walk" +
                    "to the sky.", "10min"),
            ItemCard("I shot this phoyo today. Perfect day, but I used a filter to tone it down" +
                    "anyway.", "10min"),
            ItemCard("Thanks for sharing! I got this skyline -- The usual tourist shot, but" +
                    "what a view.", "10min"),
            ItemCard("Street view of a skycraper. Love the reflections in this one." +
                    "Corporate colors.", "10min"),
            ItemCard("View from the top of mi office. I was worried about the haze," +
                    "but it worked OK.", "10min"),
            ItemCard("I was trying to make stairs look like ground: Like you could walk" +
                    "to the sky.", "10min")
        )
    }
}