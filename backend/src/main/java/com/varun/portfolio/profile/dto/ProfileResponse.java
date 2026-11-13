package com.varun.portfolio.profile.dto;

import com.varun.portfolio.profile.Profile;
import com.varun.portfolio.profile.SocialLink;
import java.util.List;

public record ProfileResponse(
        String fullName,
        String title,
        String tagline,
        String about,
        String location,
        List<Link> links
) {
    // Factory method taking both Profile and Links
    public static ProfileResponse from(Profile profile, List<SocialLink> links) {
        return new ProfileResponse(
                profile.getFullName(),
                profile.getTitle(),
                profile.getTagline(),
                profile.getAbout(),
                profile.getLocation(),
                links.stream().map(l -> new Link(l.getPlatform(), l.getUrl())).toList()
        );
    }

    // Nested record for the links
    public record Link(String platform, String url) {
    }
}