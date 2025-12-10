package org.example.demosecurisationapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursesController {

    @GetMapping("/courses")
    @PreAuthorize("hasAnyRole('STUDENT', 'ADMIN')")
    public List<Map<String, Object>> getCourses(Authentication auth) {
        // Exemple statique ; remplacez par une base de données réelle
        return List.of(
                Map.of("title", "OAuth2 Basics", "description", "Introduction to OAuth2", "user", auth.getName()),
                Map.of("title", "Spring Security", "description", "Advanced Security", "user", auth.getName())
        );
    }

    @PostMapping("/courses")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, String> addCourse(@RequestBody Map<String, String> course) {
        // Logique d'ajout ; exemple statique
        return Map.of("status", "Course added: " + course.get("title"));
    }

    @GetMapping("/me")
    public Map<String, Object> getMe(@AuthenticationPrincipal Jwt jwt) {
        return jwt.getClaims(); // Renvoie les claims, incluant roles
    }
}