export type SocialLink = {
  platform: string;
  url: string;
};

export type Profile = {
  fullName: string;
  title: string;
  tagline: string;
  about: string;
  location: string;
  links: SocialLink[];
};