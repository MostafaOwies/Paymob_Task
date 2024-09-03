# Movie Listing Application

This project is a movie listing application that displays a list of the best movies in 2024, utilizing **TheMovieDB API**. The application is developed for Android (Kotlin), following the MVVM architecture pattern.

## Objective

The goal of this application is to showcase a clean and well-structured implementation of a movie listing app with the following functionalities:

1. Display a list of movies from **TheMovieDB API**.
2. Show movie details upon clicking on a movie.
3. Allow users to favorite/unfavorite movies, with the favorite status being saved offline.

## Features

- **Movie List Screen**: 
  - Displays a list of movies with posters, names, ratings, release dates, and an "Add to Favorites" option.
  - Fetches data from **TheMovieDB API**.

- **Movie Details Screen**:
  - Displays detailed information about the selected movie, including an overview, vote average, original language, and favorite status.
  - Allows the user to favorite/unfavorite the movie, with changes reflecting back on the list screen.

- **Offline Support**:
  - Uses a local database to store the favoriting status, ensuring changes persist between app launches.

## Technology Stack

### Android:
- **Language**: Kotlin
- **Architecture**: MVVM
- **Minimum SDK**: API Level 21 (Android 5.0 Lollipop)
- **UI**: XML Layouts
- **Networking**: Retrofit/OkHttp
- **Image Loading**: Glide/Picasso
- **Local Database**: Room
- **Dependency Injection**: Dagger/Hilt (optional)

## API Reference

This application uses **TheMovieDB API** to fetch movie data.

- **API Documentation**: [TheMovieDB API Docs](https://developers.themoviedb.org/3)

## Setup Instructions

### Prerequisites

- **Android**: Android Studio Dolphin (or above)

## Project Structure

### Android (MVVM)

