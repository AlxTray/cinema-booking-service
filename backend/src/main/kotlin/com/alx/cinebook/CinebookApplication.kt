package com.alx.cinebook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CinebookApplication

fun main(args: Array<String>) {
	runApplication<CinebookApplication>(*args)
}
