ovrss
=====

Simple RSS feed reader

Requirements
-----

- Java (6/7)
- Maven2
- SpringMVC
- Maven Jetty plugin

Features
-----

Application reads four different RSS feeds and caches them. Cached feeds expire in 10 minutes. RSS entries are ordered by publication time.

Usage
-----

Start application with command

    mvn jetty:run

Open your browser and type url

    http://localhost:8080
