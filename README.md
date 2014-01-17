ovrss
=====

Simple RSS feed reader

Requirements
-----

- Java (6/7)
- SpringMVC
- Maven2
- Maven Jetty plugin

Features
-----

Application reads four different RSS feeds and caches them. Cached feeds expire in 10 minutes. RSS entries are ordered by publication time.

Usage
-----

After getting all the source files navigate to the project directory (ovrss) and start the application with command

    mvn jetty:run

Open your browser and type url

    http://localhost:8080
