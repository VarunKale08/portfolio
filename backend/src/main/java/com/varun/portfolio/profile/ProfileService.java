package com.varun.portfolio.profile;

import com.varun.portfolio.common.NotFoundException;
import com.varun.portfolio.profile.dto.ProfileResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final SocialLinkRepository socialLinkRepository;

    public ProfileService(ProfileRepository profileRepository, SocialLinkRepository socialLinkRepository) {
        this.profileRepository = profileRepository;
        this.socialLinkRepository = socialLinkRepository;
    }

    public ProfileResponse get() {
        Profile profile = profileRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new NotFoundException("Profile not found"));

        List<SocialLink> links = socialLinkRepository.findAllByOrderByDisplayOrderAsc();

        return ProfileResponse.from(profile, links);
    }
}