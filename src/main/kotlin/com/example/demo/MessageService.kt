package com.example.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class MessageService(

    @Value("\${app.message}") private val message: String,

    @Value("\${sf.con_key}") private val conKey: String,
    @Value("\${sf.url}") private val url: String,
    @Value("\${sf.user}") private val user: String,
    @Value("\${sf.jwt_token}") private val jwtToken: String,

    @Value("\${db.connection}") private val dbConnection: String,
    @Value("\${db.schema}") private val schema: String,
    @Value("\${db.table_name}") private val tableName: String

) {
    fun printMessage() {
        println("Message: $message")

        println("\n--- SF Config ---")
        println("Key: $conKey")
        println("URL: $url")
        println("User: $user")
        println("Token: $jwtToken")

        println("\n--- DB Config ---")
        println("Connection: $dbConnection")
        println("Schema: $schema")
        println("Table: $tableName")
    }

    fun showProgressBar() {
        val totalSteps = 20 // 5% each → 100% = 20 steps

        for (i in 0..totalSteps) {
            val percent = i * 5
            val progress = "#".repeat(i)
            val remaining = " ".repeat(totalSteps - i)

            print("\rProgress: [$progress$remaining] $percent%")
            Thread.sleep(5000) // 5 seconds
        }

        println("\nDone!")
    }
}