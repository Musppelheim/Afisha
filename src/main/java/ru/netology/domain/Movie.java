 package ru.netology.domain;

 import lombok.AllArgsConstructor;
 import lombok.Data;
 import lombok.NoArgsConstructor;

 @AllArgsConstructor
 @Data
 @NoArgsConstructor
 public class Movie {
     private int id;
     private String title;
     private String genre;
}
